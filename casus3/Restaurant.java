//Hamburger restaurant door Evert Verduin
package com.company;

public class Restaurant {

	private Kok Kok = null;
	private Ober Ober = null;
	public static final int AANTALTAFELS = 10;				// Er zijn 10 tafels in dit restaurant.
	public static final int AANTALBESTELLINGEN = 5;		// Max aantal gedane bestellingen
	public static final int MINIMALE_BEREIDINGSTIJD = 750;  // Om de casus wat echter te laten lijken.
	public static final int MAXIMALE_BEREIDINGSTIJD = 1500;	// Om de casus wat echter te laten lijken.

	public Restaurant() {
	}

	public void start(){


		Balie balie = new Balie();
		balie.genereerBestellingen();
		Kok = new Kok("1", balie);
		Kok kok2 = new Kok("2", balie);
		Ober = new Ober("1", balie);
		Ober ober2 = new Ober("2", balie);

		Thread kokThread = new Thread(Kok);
		kokThread.start();
		Thread kokThread2 = new Thread(kok2);
		kokThread2.start();

		Thread oberThread = new Thread(Ober);
		oberThread.start();
	}

}
