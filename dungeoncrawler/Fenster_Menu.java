import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;



/** Hier wird das Spielmen� erstellt mit jeweils einem Button zum Starten und Beenden des Spiels:
 * Festlegung des Speicherorts f�r Grafiken usw
 * Gr��e/Position/Funktionsweise des Men�fensters und der Buttons
 * Einf�gen eines Hintergrundbilds
 */
 

 
public class Fenster_Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	static String speicherort = System.getProperty("user.dir");		/**  Legt Speicherort der Dateien, z.B. f�r Grafiken fest */
	public JButton starte_spiel;									/**  Erstellt die zwei oben angesprochenen Buttons */
	public JButton beende_spiel;

	Fenster_Spiel spielfenster;											/**  Erstellt den Frame f�r das Spiel */

	public Fenster_Menu() {

		this.setResizable(false);									/** Hier werden die Eigenschaften des Men�fensters festhalten */
		this.setTitle("Dungeon Crawler");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		
		try {														/** Platziert die Hintergrundgrafik oder Fehlermeldung falls keine existiert */
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					speicherort + "/src/menu.jpg")))));
		} catch (IOException a) {
			System.out.println("Hintergrundgrafik fehlt");
		}

		starte_spiel = new JButton("Los gehts!");					/** Erstellt ein Label f�r die Buttons */
		starte_spiel.setBounds(200, 350, 150, 50);
		this.add(starte_spiel);

		beende_spiel = new JButton("Raus hier!");
		beende_spiel.setBounds(600, 350, 150, 50);
		this.add(beende_spiel);
																				
		ActionListener begin = new ActionListener() {				/** Legt fest, dass beim bet�tigen eines Buttons der Game Frame ge�ffnet wird um das Spiel zu starten   */
			public void actionPerformed(ActionEvent e) {
				spielfenster = new Fenster_Spiel();
			}
		};

		ActionListener exit = new ActionListener() {				/** Beendung des Programms festlegen  */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	
		starte_spiel.addActionListener(begin);						/** Beide Buttons werden den Action Listener zugeordnet, damit sie wissen ob sie das Spiel starten oder beenden sollen */
		beende_spiel.addActionListener(exit);
	}

	public static void main(String[] args) {						/** Hier wird das Men� gestartet  */
		new Fenster_Menu();
	}
}