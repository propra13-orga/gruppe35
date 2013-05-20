import java.io.*;                        	 /* Notwendig für Nutzer Input*/



	
public static void main (String [] args)			/* Fordert Nutzer zu einer Eingabe auf um die Figur zu steuern*/
{		
	{
	int spieler_pos_x;								/* Definiert die Variable für die aktuelle Position der Spielfigur in X- und Y- Koordinate */
	int spieler_pos_y;

	
	spieler_pos_x = feld1[0][4];					/* Spielfigur auf Start setzen */
	feld1[0][4] = 2;								/* Startpunkt mit Spielfigur Wert "2" belegen */									
		
		
	  
		Scanner sc = new Scanner(System.in);		/*Nutzer Eingabe Aufforderunge */
    	System.out.print("Steuern Sie ihre Spielfigur mit W für Oben,A für Links,S für Unten,D für Rechts");
    	String eingabe = sc.next();
			
			
			
			
		/* ENDLOSSCHLEIFE erstellen, damit der Nutzer die Figur immer weiter steuern kann bis zum Ziel*/
		
		int z;
		z = 1;
		while (z <= 100) {
		
		/* Die ENDLOSSCHLEIFE soll nur beendet werden, wenn der Spieler das Ziel erreicht oder einen Gegner berührt und sich somit das MENÜ öffnet */
		
		
		if (((eingabe == "W") && (feld1 [spieler_pos_x][spieler_pos_y + 1] == 0)))   		/* Legt fest das bei "W" Eingabe die Figur ein Feld nach Oben geht */
			{
			Feld[spieler_pos_x][spieler_pos_y+1] = 2;
 			Feld[spieler_pos_x][spieler_pos_y] = 0;
			}
		
		else if (((eingabe == "A") && (feld1 [spieler_pos_x - 1][spieler_pos_y] == 0)))	/* Bei "A" geht es nach links */
			{
			Feld[spieler_pos_x - 1][spieler_pos_y] = 2;
 			Feld[spieler_pos_x][spieler_pos_y] = 0;
			}
			
		else if	(((eingabe == "S") && (feld1 [spieler_pos_x][spieler_pos_y - 1] == 0)))	/* Bei "S" nach unten */
			{
			Feld[spieler_pos_x][spieler_pos_y-1] = 2;
 			Feld[spieler_pos_x][spieler_pos_y] = 0;
			}
			
		else if	(((eingabe == "D") && (feld1 [spieler_pos_x +1][spieler_pos_y] == 0)))	/*bei "D" nach rechts */
			{
			Feld[spieler_pos_x + 1][spieler_pos_y] = 2;
 			Feld[spieler_pos_x][spieler_pos_y] = 0;
			}
			
			
			
			
		/* Jetzt Übergänge der Level definieren */
		
		if ((spieler_pos_x==ende_x_Feld1) &&  (spieler_pos_y==ende_y_Feld1) && (level==1)) 
		{
			level=2;																	/* Setzt das Level=2 damit Figur in Level 2 landet */																			
			feld2[start_x_feld2][start_y_feld2]=2;										/* Setze den Spielfigurwert "2" auf Start des Feld2 */
		}
		
		if ((spieler_pos_x==ende_x_Feld2) &&  	(spieler_pos_y==ende_y_Feld2) && (level==2)) 
		{
			level=3;																	/* Das gleiche wie gerade bei Feld 2 */
			feld3[start_x_feld3][start_y_feld3]=2;
		}
			
			
			
			
		
		/* Gewonnen, bzw. Sieg festlegen	*/
		
		if ((spieler_pos_x==ende_x_Feld3) && (spieler_pos_y==ende_y_Feld3) && (level==3)) 
		{
			System.out.println ("Sie haben gewonnen");  	/* HIER müsste das MENÜ aufgerufen werden "Wollen Sie nochmal spielen?" */
		}


		/* Niederlage, bzw. Kontakt mit Gegner aufgenommen, was zur Niederlage führt */
		
		if ((spieler_pos_x==Gegner2_x) && (spieler_pos_y==Gegner2_y) && (level==2)) 
		{
			System.out.println ("Sie haben Verloren");		/* HIER müsste das MENÜ aufgerufen werden "Wollen Sie nochmal spielen?" */
		}

		if ((spieler_pos_x==Gegner3_x) && (spieler_pos_y==Gegner3_y) && (level==3)) 
		{
			System.out.println ("Sie haben Verloren");		/* HIER müsste das MENÜ aufgerufen werden "Wollen Sie nochmal spielen?" */
		}
			
			
		}
	} 	
}	
					
