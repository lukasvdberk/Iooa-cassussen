//Hamburger restaurant door Evert Verduin
package com.company;

import java.util.concurrent.TimeUnit;

public class Kok implements Runnable {

	private String id;
	private Balie balie = null;

	public Kok(String id, Balie balie) {					// constructor
		this.id = id;
		this.balie = balie;
	}

	public void bereidMaaltijden() {
		while (balie.erZijnNogBestellingen()) {				// zijn er nog bestellingen ?
			Bestelling bestelling = balie.pakBestelling();	// Ja, pak er 1
			Maaltijd maaltijd = bereidMaaltijd(bestelling); // Bereid deze 
			balie.plaatsMaaltijd(maaltijd);					// Zet deze op de balie.
		}
	}

	private Maaltijd bereidMaaltijd(Bestelling b) {
		try {
			TimeUnit.MILLISECONDS.sleep(b.getBereidingstijd());
			System.out.println("Kok " + this.id + " bereidt bestelling voor tafel " + b.getTafelnummer());
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Maaltijd(b.getTafelnummer());
	}

	@Override
	public void run() {
		this.bereidMaaltijden();
	}
}
