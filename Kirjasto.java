package mediakirjasto;

import java.util.ArrayList;

import mediakirjasto.mediatyyppi.Media;

public class Kirjasto extends Lista {
	
	public Kirjasto(ArrayList<Media> mediat) {
		for(Media media : mediat) {
			this.lisaaAlkuun(media);
		}
		Oope2014HT.DEBUG("koko:"+this.koko());
		Oope2014HT.DEBUG_STACK();
	}
}
