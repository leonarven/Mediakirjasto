package mediakirjasto;

import mediakirjasto.mediatyyppi.Media;
import fi.uta.csjola.oope.lista.LinkitettyLista;

/**
 * Lista joka periytet‰‰n fi.uta.csjola.oope.lista -pakkauksen LinkitettyLista-luokasta
 * K‰ytt‰‰ periytynytt‰ tyhj‰‰ rakentajaa
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public class Lista extends LinkitettyLista {

	/**
	 * Etsii halutun alkion
	 * 
	 * @param alkio Etsitt‰v‰ alkio
	 * @return Alkio jota etsittiin
	 */
	public Object etsi(Object alkio) {
		for(int i = 0; i < this.koko(); i++) {
			Object a = this.alkio(i);
			if (a.equals(alkio)) return a;
		}
		return null;
	}
	
	/**
	 * Lis‰‰ Listaan johonkin v‰liin p halutun LinkitettyLista:n sis‰lt‰m‰t alkiot
	 * 
	 * @param l LinkitettyLista -palanen joka halutaan lis‰t‰
	 * @param p Kohta josta halutaan lis‰yksen alkavan
	 * @return true jos lis‰ys onnistui, false jos virheellinen alue tai null-arvoinen lista
	 * @see fi.uta.csjola.oope.lista.LinkitettyLista
	 */
	public boolean lisaa(LinkitettyLista l, int p) {
		if (l == null || p < 0 || p >= this.koko()) return false;
		
		/** L‰pik‰yd‰‰n lis‰tt‰v‰ LinkitettyLista ja sijoitetaan se keskelle t‰t‰ Lista:a */
		while(l.koko()>0) this.lisaa(p, l.poistaLopusta());

		return true;
	}
	
	/**
	 * Vaihdetaan kaksi listan alkiota p‰ikseen
	 * @param i toinen alkio
	 * @param j toinen alkio
	 * @return true jos onnistui, false jos ep‰onnistui
	 */
	public boolean vaihda(int i, int j) {
		if (i == j) return false;

		/** Korvataan alkiot toisillaan, tarkastellen paluuarvoa */
		Object old = this.korvaa(i, this.alkio(j));
		if (old == null) return false;
		if (this.korvaa(j, old) == null) return false;
		
		return true; // Onnistuttiin!
	}
	
	/**
	 * Tulostaa sis‰lt‰m‰ns‰ alkiot j‰rjestyksess‰
	 */
	public void tulosta() {
		for(int i = 0; i < this.koko(); i++)
			System.out.println(this.alkio(i));
	}
	
	public void lajittele(int ord) throws IllegalArgumentException {
		if (!(ord == -1 || ord == 1)) throw new IllegalArgumentException("Arvon tulee olla -1 (laskeva) tai 1 (nouseva)");

		int j, len = this.koko();

		/** L‰pik‰yd‰‰n alkiot */
		for(int i = len-1; i > 0; i--) {
			j = 0;
			/** Etsit‰‰n seuraavaksi suurin/pienin alkio */
			for(int k = 1; k <= i; k++)
				/** Vertaillaa Comparable-rajapinnan compareTo-metodilla alkioita */
				if (((Media)this.alkio(j)).compareTo((Media)this.alkio(k)) == ord) j = k;

			/** Vaihdetaan alkioiden paikkaa jos lˆydettiin suurempi/pienempi */
			this.vaihda(i, j);
		}
	}
	
}
