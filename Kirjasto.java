package mediakirjasto;

import java.util.ArrayList;

import mediakirjasto.mediatyyppi.Media;

/**
 * Kirjasto-luokka, joka periytet‰‰n Lista -luokasta toteutumaan linkitettyn‰ listana
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
		/** Tarkistetaan parametrin oikeellisuus; jos ep‰validi, heitet‰‰n poikkeus */
		if (mediat == null) throw new NullPointerException();
		
		/** L‰pik‰yd‰‰n parametrina annettu lista medioista */
		for(Media media : mediat)
			this.lisaaLoppuun(media);
	}
}
