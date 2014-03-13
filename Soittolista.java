package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

public class Soittolista extends LinkitettyLista {
	
	public Soittolista(int ylaraja) throws IllegalArgumentException {
		// Tarkistetaan onko yläraja oikeellinen
		if (ylaraja < 0) throw new IllegalArgumentException("Ylärajan tulee olla epänegatiivinen");
		
	}
}
