package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

public class Lista extends LinkitettyLista {

	public Object etsi(Object alkio) {
		for(int i = 0; i < this.koko(); i++) {
			Object a = this.alkio(i);
			if (a.equals(alkio)) return a;
		}
		return null;
	}
	
	public boolean tyhjenna() {
		if (this.onkoTyhja()) return false;

		Solmu s = this.paa();
		boolean ret = false;
		do {
			if (!ret && s.alkio() != null) ret = true;
			s.alkio(null);
		} while((s = s.seuraava()) != null);
		return ret;
	}
	
	public boolean lisaa(LinkitettyLista l, int p) {
		if (l == null || p < 0 || p >= this.koko()) return false;
		
		while(l.koko()>0) this.lisaa(p, l.poistaLopusta());

		return true;
	}
	
	public void tulosta() {
		for(int i = 0; i < this.koko(); i++)
			System.out.println(this.alkio(i));
	}
	
}
