import java.io.*;                      		 /* Notwendig für Nutzer Input*/

public class spielfeld

/**
 * Diese Klasse definiert das Spielfeld, also den Aufbau und die Funktion der drei
 * Räume des Spiels. Zunächst werden 3 Spielfelder als Arrays der Größe 10x6 Felder erstellt.
 * Als nächstes werden die Werte aller Felder auf 0 gesetzt, anschließend bekommen Felder,
 * die Teil einer Mauer sind, den Wert 1 zugewiesen.
 * Zum Schluss werden die Koordinaten der Felder, in denen sich Ein-/Ausgänge oder Gegner
 * befinden, festgelegt und es wird der Raum festgelegt, in dem der Spieler startet.
 */
{
	public static int mauer = 1;
	
		private ImageIcon Bildmauer;
		private ImageIcon hintergrund;
		private ImageIcon Gegner;
	
	public static void main(String[] args)
	{
		int[][] feld1 = int[10][6];					/* Spielfelder werden erstellt, mit der Größe 10 x 6 Felder (x-Achse / y-Achse)*/ 
		int[][] feld2 = int[10][6];
		int[][] feld3 = int[10][6]; 										

		for (int j=0, j <= 6,j++)					/* Füllt zunächst alle Felder des Spielfeldes 1 mit dem Wert 0, für betretbar */
		{
			for ( int i=0; i <= 10; i++ )
				feld1[i][j]=1;	
		}
			
		feld1[0][0] = mauer;						/* Weist jetzt den einzelnen Feldern, ihre einzelnen Mauern/Grenzen zu, hier Feld1 */
		feld1[0][0] = mauer;
		feld1[0][1] = mauer;
		feld1[0][2] = mauer;
		feld1[0][3] = mauer;
		feld1[0][5] = mauer;
		feld1[1][0] = mauer;
		feld1[1][5] = mauer;
		feld1[2][1] = mauer;
		feld1[2][5] = mauer;
		feld1[3][0] = mauer;
		feld1[3][1] = mauer;
		feld1[3][2] = mauer;
		feld1[3][3] = mauer;
		feld1[3][5] = mauer;
		feld1[4][0] = mauer;
		feld1[4][5] = mauer;
		feld1[5][0] = mauer;
		feld1[5][5] = mauer;
		feld1[6][0] = mauer;
		feld1[6][2] = mauer;
		feld1[6][3] = mauer;
		feld1[6][4] = mauer;
		feld1[6][5] = mauer;
		feld1[7][0] = mauer;
		feld1[7][5] = mauer;
		feld1[8][0] = mauer;
		feld1[8][5] = mauer;
		feld1[9][0] = mauer;
		feld1[9][1] = mauer;
		feld1[9][2] = mauer;
		feld1[9][4] = mauer;
		feld1[9][5] = mauer;
		
		System.out.print(feld1);
		
		for (int j=0, j <= 6,j++)					/* Füllt zunächst alle Felder des Spielfeldes 2 mit dem Wert 0, für betretbar */
		{
			for ( int i=0; i <= 10; i++ )
				feld2[i][j]=1;							/* i und j können hier erneut verwendet werden, da es nur lokale variabeln sind */
		}
		
		
		feld2[0][0] = mauer;						/* Weisst jetzt den einzelnen Feldern, ihre einzelnen Mauern/Grenzen zu, hier Feld2 */
		feld2[0][1] = mauer;
		feld2[0][2] = mauer;
		feld2[0][4] = mauer;
		feld2[0][5] = mauer;
		feld2[1][0] = mauer;
		feld2[1][5] = mauer;
		feld2[2][0] = mauer;
		feld2[2][5] = mauer;
		feld2[3][0] = mauer;
		feld2[3][5] = mauer;
		feld2[4][0] = mauer;
		feld2[4][5] = mauer;
		feld2[5][0] = mauer;
		feld2[5][5] = mauer;
		feld2[6][0] = mauer;
		feld2[6][5] = mauer;
		feld2[7][0] = mauer;
		feld2[7][5] = mauer;
		feld2[8][0] = mauer;
		feld2[9][0] = mauer;
		feld2[9][1] = mauer;
		feld2[9][2] = mauer;
		feld2[9][3] = mauer;
		feld2[9][4] = mauer;
		feld2[9][5] = mauer;
		
	
		for (int j=0, j <= 6,j++)						/* Füllt zunächst alle Felder des Spielfeldes 3 mit dem Wert 0, für betretbar */
		{
			for ( int i=0; i <= 10; i++ )
				feld1[i][j]=1;	
		}	
		
		feld3[0][0] = mauer;							/* Weisst jetzt den einzelnen Feldern, ihre einzelnen Mauern/Grenzen zu, hier Feld3 */
		feld3[0][0] = mauer;
		feld3[0][1] = mauer;
		feld3[0][2] = mauer;
		feld3[0][3] = mauer;
		feld3[0][5] = mauer;
		feld3[1][0] = mauer;
		feld3[1][5] = mauer;
		feld3[2][0] = mauer;
		feld3[2][3] = mauer;
		feld3[2][4] = mauer;
		feld3[2][5] = mauer;
		feld3[3][0] = mauer;
		feld3[3][3] = mauer;
		feld3[3][4] = mauer;
		feld3[3][5] = mauer;
		feld3[4][0] = mauer;
		feld3[4][3] = mauer;
		feld3[4][4] = mauer;
		feld3[4][5] = mauer;
		feld3[5][0] = mauer;
		feld3[5][3] = mauer;
		feld3[5][4] = mauer;
		feld3[5][5] = mauer;
		feld3[6][0] = mauer;
		feld3[6][4] = mauer;
		feld3[6][5] = mauer;
		feld3[7][0] = mauer;
		feld3[7][1] = mauer;
		feld3[7][4] = mauer;
		feld3[7][5] = mauer;
		feld3[8][4] = mauer;
		feld3[8][5] = mauer;
		feld3[9][0] = mauer;
		feld3[9][1] = mauer;
		feld3[9][2] = mauer;
		feld3[9][3] = mauer;
		feld3[9][4] = mauer;
		feld3[9][5] = mauer;
		
		int start_x_Feld1 = 0;							/* Legt die X- und Y-Koordinate der Start und Ausgangsfelder der drei Spielfelder fest   */
		int start_y_Feld1 = 4;
		int ende_x_Feld1 = 9;
		int ende_y_Feld1 = 3;

		int start_x_Feld2 = 0;
		int start_y_Feld2 = 3;
		int ende_x_Feld2 = 8;
		int ende_y_Feld2 = 5;

		int start_x_Feld3 = 8;
		int start_y_Feld3 = 0;
		int ende_x_Feld3 = 0;
		int ende_y_Feld3 = 4;
		
		int Gegner2_x = 4;								/*Legt Position der Gegner Felder fest. Gegner bedeutet hier, dass wenn die Spielfigur das Feld nur betritt, hat sie schon verloren  */
		int Gegner2_y = 3;
		int Gegner3_x = 7;
		int Gegner3_y = 2;
	
		int level=1;									/*Legt aktuellen Level bzw. Spiefeld 1, 2 oder 3 Fest.(Wichtig für Abfrage unten) Spielfigur startet in Feld 1. */
	}
	
	private void loadContentImages() {
		Bildmauer = new ImageIcon("Images/Bildmauer.jpg");
		hintergrund = new ImageIcon("Images/hintergrund.jpg");
		Gegner = new ImageIcon("Images/bild1.jpg");

	}
}
