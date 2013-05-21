/* Gewonnen, bzw. Sieg festlegen  */
	
	import stdraw.java;
	
	if ((spieler_pos_x==ende_x_Feld3) && (spieler_pos_y==ende_y_Feld3) && (level==3)) 
	{
		System.out.println ("Sie haben gewonnen");  	/* HIER m√ºsste das MEN√ú aufgerufen werden "Wollen Sie nochmal spielen?" */
		rectangle(12, 5, 3,75, 3,75);
		if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            System.out.println("Pressed");
        }
	}


	/* Niederlage, bzw. Kontakt mit Gegner aufgenommen, was zur Niederlage f√ºhrt */
	
	if ((spieler_pos_x==Gegner2_x) && (spieler_pos_y==Gegner2_y) && (level==2)) 
	{
		System.out.println ("Sie haben Verloren");		/* HIER m√ºsste das MEN√ú aufgerufen werden "Wollen Sie nochmal spielen?" */
		rectangle(12, 5, 3,75, 3,75);
		if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            System.out.println("Pressed");
        }
	}

	if ((spieler_pos_x==Gegner3_x) && (spieler_pos_y==Gegner3_y) && (level==3)) 
	{
		System.out.println ("Sie haben Verloren");		/* HIER m√ºsste das MEN√ú aufgerufen werden "Wollen Sie nochmal spielen?" */
		rectangle(12, 5, 3,75, 3,75);
		if(evt.getKeyCode() == KeyEvent.VK_ENTER)
			
        {
            System.out.println("Pressed");
        }
