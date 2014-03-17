package mediakirjasto.mediatyyppi;

/**
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 * @see mediakirjasto.mediatyyppi.Media
 */
public class Kuva extends Media {

	/** Onko Kuva-media bittikartta */
	private boolean bittikartta;
	
	/** Kuva-median rakentaja
	 * @param nimike Haluttu kuva-median rakentaja
	 * @param bittikartta Tieto, onko Kuva-media bittikartta vai ei
	 * @throws NullPointerException Jos nimike on null
	 */
	public Kuva(String nimike, boolean bittikartta) throws NullPointerException {
		super(nimike);
		bittikartta(bittikartta);
	}
	
	/**
	 * Setter bittikartta-attribuutille
	 * @param bittikartta tiedo, onko Kuva-media bittikartta vai ei
	 */
	public void bittikartta(boolean bittikartta){
		this.bittikartta = bittikartta;
	}
	
	/** Getter bittikartta-attribuutille */
	public boolean bittikartta() { return this.bittikartta; }
	
	/** Kuva-media tekstin‰ (datarivi) */
	public String toString() {
		/** Palautetaan String.format:lla muodostettu String, joka sis‰lt‰‰ tiedot Kuva-mediasta */
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Kuva", nimike(), (bittikartta()?"true":"false"));
	}
}
