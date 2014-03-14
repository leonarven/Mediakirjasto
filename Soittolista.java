package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

public class Soittolista extends LinkitettyLista {
	
	private int ylaraja;
	
	public Soittolista(int ylaraja) throws IllegalArgumentException {
		ylaraja(ylaraja);
		
	}
	
	public void ylaraja(int ylaraja) throws IllegalArgumentException {
		if (ylaraja < 0) throw new IllegalArgumentException("Ylärajan tulee olla epänegatiivinen");
		
		this.ylaraja = ylaraja;
	}
	public int ylaraja() { return this.ylaraja; }
	
}
