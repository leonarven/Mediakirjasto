package mediakirjasto;

import java.util.ArrayList;

import mediakirjasto.mediatyyppi.Media;

/**
 * Kirjasto-luokka, joka periytetään Lista -luokasta toteutumaan linkitettynä listana
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public class Kirjasto extends Lista {
	
	/**
	 * Rakentaja Kirjasto-luokalle.
	 * 
	 * @param mediat ArrayList medioista joilla halutaan kirjasto alustaa
	 * @throws NullPointerException jos parametri on null
	 */
	public Kirjasto(ArrayList<Media> mediat) throws NullPointerException {
		for(Media media : mediat)
			this.lisaaAlkuun(media);
	}
}
