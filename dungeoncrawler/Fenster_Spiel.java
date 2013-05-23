import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**  
 * Hier wird der Frame fuer das Spiel erstellt:
 * Festlegung von Variablen fuer Position des Spielers, Raume
 * Festlegung des Speicherorts fuer Grafiken usw
 * Es wird angegeben, welche Grafiken wo eingebunden werden sollen
 * Ein KeyListener wird eingefuet, der festlegt, welche Taste was bewirkt
 * Festlegung von drei Arrays, die als Raeume im Spiel dienen
 * Eigenschaften der Raeume
 * Immer, wenn die Spielfigur bewegt wird, wird der Raum neu ausgegeben, um dessen aktuellen Zustand anzuzeigen
 * Wechseln zwischen Raeumen
 * Festlegung der Dialogfenster, die bei Sieg oder Niederlage erscheinen	*/
 
public class Fenster_Spiel extends JFrame implements KeyListener {

	
	private static final long serialVersionUID = 1L;

	int spieler_pos_x;													/** F�r die X- und Y-Koordinate der Spielfigur, um sie im Array zu finden werden Variabeln erstellt  */
	int spieler_pos_y;	
	int[][] raum_jetzt;													/** Jetzt wird der momentane Raum deklariert */
	int raum;															/** Und ihm eine Variable gegeben */

	static String speicherort = System.getProperty("user.dir");
	
	static Icon hintergrund = new ImageIcon(speicherort						/** Hier werden Icons erstellt und ihren Grafiken zugewiesen  */
			+ "/src/leer.jpg");
	static Icon mauer = new ImageIcon(speicherort							/** z.B. Mauer wird mauer.jpg zugewiesen + Angabe des Speicherortes von mauer.jpg  */		
			+ "/src/mauer.jpg");
	static Icon figur = new ImageIcon(speicherort
			+ "/src/figur.jpg");
	static Icon gegner = new ImageIcon(speicherort
			+ "/src/gegner.jpg");
	static Icon ziel = new ImageIcon(speicherort
			+ "/src/ziel.jpg");
	
	public void keyTyped(KeyEvent arg0) {								/** Hier werden die Nutzereingaben bzw. die Steuerung festgelegt. Steuerung durch Pfeiltasten */
	}																	/** Ist das neue Feld=0 wird das alte von dem der Spieler kommt, mit Wert 0 versehen, die neue mit Wert 2 */
																		/** Ist das Feld auf das sich die Spielfigur bewegt dank einer Nutzereingabe mit einem Gegner besetzt, also hat den Wert 3, erscheint das "Niederlagen"-Fenster auf dem Bildschirm */			
																		/** Bei dem Wert=4 erscheint der n�chste Level */	
																		/** Wert=5 steht f�r das "Sieg"-Fenster */																						
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (raum_jetzt[spieler_pos_x][spieler_pos_y - 1] == 3) {
				niederlage();
			}
			else if (raum_jetzt[spieler_pos_x][spieler_pos_y - 1] == 4) {
				NextLevel();
			}
			else if (raum_jetzt[spieler_pos_x][spieler_pos_y - 1] == 5) {
				sieg();
			} else if (raum_jetzt[spieler_pos_x][spieler_pos_y - 1] == 0) {
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 0;
				spieler_pos_y--;
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 2;
				Levelaufruf(raum_jetzt);
				LevelAktualisieren();
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (raum_jetzt[spieler_pos_x - 1][spieler_pos_y] == 3) {
				niederlage();
			} else if (raum_jetzt[spieler_pos_x - 1][spieler_pos_y] == 4) {
				NextLevel();
			} else if (raum_jetzt[spieler_pos_x - 1][spieler_pos_y] == 5) {
				sieg();
			} else if (raum_jetzt[spieler_pos_x - 1][spieler_pos_y] == 0) {
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 0;
				spieler_pos_x--;
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 2;
				Levelaufruf(raum_jetzt);
				LevelAktualisieren();
			}
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (raum_jetzt[spieler_pos_x - 1][spieler_pos_y + 1] == 3) {
				niederlage();
			} else if (raum_jetzt[spieler_pos_x][spieler_pos_y + 1] == 4) {
				NextLevel();
			} else if (raum_jetzt[spieler_pos_x][spieler_pos_y + 1] == 5) {
				sieg();
			} else if (raum_jetzt[spieler_pos_x][spieler_pos_y + 1] == 0) {
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 0;
				spieler_pos_y++;
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 2;
				Levelaufruf(raum_jetzt);
				LevelAktualisieren();
			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (raum_jetzt[spieler_pos_x + 1][spieler_pos_y] == 3) {
				niederlage();
			} else if (raum_jetzt[spieler_pos_x + 1][spieler_pos_y] == 4) {
				NextLevel();
			} else if (raum_jetzt[spieler_pos_x + 1][spieler_pos_y] == 5) {
				sieg();
			} else if (raum_jetzt[spieler_pos_x + 1][spieler_pos_y] == 0) {
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 0;
				spieler_pos_x++;
				raum_jetzt[spieler_pos_x][spieler_pos_y] = 2;
				Levelaufruf(raum_jetzt);
				LevelAktualisieren();
			}
		}
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	static final int[][][] levels = {										/** Diese Arrays stehen f�r die, zun�chst 3, R�ume bzw. Spielfelder  */
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 2, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 0, 1, 0, 0, 4 }, { 1, 0, 0, 1, 0, 0, 1, 0, 0, 1 },		/** Die einzelnen Werte bedeuten: 0= betretbar 1=Mauer 2=Eingang 3=Gegner */
					{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } },

			{ { 1, 1, 1, 1, 1, 1, 1, 1, 4, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 3, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } },

			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 5, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 1, 1, 1, 3, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 } } };

	public JButton beenden;
	
	public Fenster_Spiel() {											/** Hier werden die Eigenschaftes des Raumes, z.B. die Aufl�sung, festgelegt    */
		addKeyListener(this);
		this.setResizable(false);
		this.setTitle("Dungeon Crawler");
		this.setSize(1000, 630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		raum = -1;												/** Damit das Array das f�r die Level zust�ndig ist bei 0 starten kann, wird der Anfangswert auf -1 gelegt  */
		NextLevel();
	}
	
	public void Levelaufruf(int[][] pos) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel[] labels = new JLabel[60];									/** Hier werden 60 Labels, weil 10x6 Felder, f�r das Array generiert  */								
		
		for (int i = 0; i < pos.length; i++) {									/** Die For-Schleife geht durch das gesamte Array und wei�t jeder oben definierten Einzelwert die passende Grafik zu. Also ist ein Feld z.B. =1, bekommt es mauer.jpg zugewiesen */
			for (int j = 0; j < pos[i].length; j++) {	
				if (pos[i][j] == 0) {
					labels[i] = new JLabel(hintergrund);
					panel.add(labels[i]);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
				} else if (pos[i][j] == 1) {
					labels[i] = new JLabel(mauer);
					labels[i].setBounds(j * 100, i * 100, 100, 100);								
					panel.add(labels[i]);
				} else if (pos[i][j] == 2) {								/** Hier wird z.B. die Position des Spielers festgehalten */
					spieler_pos_x = i;
					spieler_pos_y = j;
					labels[i] = new JLabel(figur);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (pos[i][j] == 3) {
					labels[i] = new JLabel(gegner);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (pos[i][j] == 4) {
					labels[i] = new JLabel(hintergrund);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (pos[i][j] == 5) {
					labels[i] = new JLabel(ziel);							/** Hier wird z.B. das Ziel festgehalten */
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				}
				this.setContentPane(panel);								/** Hier wird der Befehl gegeben das Spielfenster mit Bildern aus dem Panel zu bef�llen  */
			}
		}
	}

	protected void LevelAktualisieren() {										/** Der Raum wird immer neu gezeichnet nach jeder Bewegung  */
		validate();
		repaint();
	}

	protected void NextLevel() {											/** NextLevel() geh�rt zum Java GameFrame und z�hlt hoch um ins n�chste Level gehen zu k�nnen  */
		raum++;
		int[][] reference = levels[raum];
		raum_jetzt = new int[reference.length][reference[0].length];
		for (int x = 0; x < reference.length; x++) {
			for (int y = 0; y < reference[0].length; y++) {
				raum_jetzt[x][y] = reference[x][y];
			}
		}
		/* das neue aktuelle Level wird aufgerufen und erzeugt */
		Levelaufruf(raum_jetzt);										/** Ein neues Level wird angesprochen */
		LevelAktualisieren();											/** und dann generiert*/
	}
	
	
	
	public void sieg() {												/** An dieser Stelle wird das Sieg-Fenster generiert */

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					speicherort + "/src/sieg.jpg")))));
		} catch (IOException a) {
			System.out.println("Hintergrundgrafik fehlt");
		}

		this.setResizable(false);
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		beenden = new JButton("Zur�ck zum Men�");
		beenden.setBounds(300, 400, 150, 50);
		this.add(beenden);

		ActionListener fensterzu = new ActionListener() {							/** Hier wird die  M�glichkeit das Fenster mit einem Button zu schlie�en erstellt  */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		beenden.addActionListener(fensterzu);
	}

	public void niederlage() {											/**  Hier wird das Niederlagen-Fenster generiert*/

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					speicherort + "/src/tot.jpg")))));
		} catch (IOException a) {
			System.out.println("Hintergrundgrafik fehlt");							/**  Ebenfalls mit einer Meldung f�r den Fall, dass eine Grafik fehlen sollte*/
		}

		this.setResizable(false);
		this.setSize(1000, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		beenden = new JButton("Zur�ck zum Men�");								/** Wenn das Spielfenster geschlossen wird, muss das Men� Fenster noch da sein. Das geschieht hier */
		beenden.setBounds(300, 400, 150, 50);
		this.add(beenden);

		ActionListener fensterzu = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		beenden.addActionListener(fensterzu);
	}
																											

	

}
