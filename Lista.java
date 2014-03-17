package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

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
	 * Tyhjent‰‰ listan alkiot null-arvoisiksi
	 * 
	 * @return false jos lista on tyhj‰, true jos onnistui ja alkiot ovat ep‰-null
	 */
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
	
	/**
	 * Lis‰‰ Listaan johonkin v‰liin p halutun LinkitettyLista:n sis‰lt‰m‰t alkiot
	 * 
	 * @param l LinkitettyLista -palanen joka halutaan lis‰t‰
	 * @param p Kohta josta halutaan lis‰yksen alkavan
	 * @return true jos lis‰ys onnistui, false jos virheellinen alue tai null-arvoinen lista
	 */
	public boolean lisaa(LinkitettyLista l, int p) {
		if (l == null || p < 0 || p >= this.koko()) return false;
		
		while(l.koko()>0) this.lisaa(p, l.poistaLopusta());

		return true;
	}
	
	/**
	 * Tulostaa sis‰lt‰m‰ns‰ alkiot j‰rjestyksess‰
	 */
	public void tulosta() {
		for(int i = 0; i < this.koko(); i++)
			System.out.println(this.alkio(i));
	}
	
	public void aseta(Object alkio, int i) {
		this.korvaa(i, alkio);
	}
	
}
