package mediakirjasto.mediatyyppi;

/**
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 * @see mediakirjasto.mediatyyppi.Media
 */
public class Aani extends Media {

	/** Haluttu Aani-median kesto */
	private int kesto;
	
	/**
	 * @param nimike Haluttu median nimike
	 * @param kesto Haluttu Aani-median kesto
	 * @throws IllegalArgumentException Jos parametri on virheellinen
	 */
	public Aani(String nimike, int kesto) throws IllegalArgumentException {
		super(nimike);
		kesto(kesto);
	}
	
	/**
	 * Setter kesto-attribuutille
	 * @param kesto Aani-muodoisen median kesto
	 * @throws IllegalArgumentException Jos haluttu arvo on negatiivinen
	 */
	public void kesto(int kesto) throws IllegalArgumentException {
		if (kesto < 0)
			throw new IllegalArgumentException();
		
		this.kesto = kesto;
	}
	
	/** Getter kesto-atribuutille */
	public int kesto() { return this.kesto; }
	
	/** Ääni-media tekstinä (datarivi) */
	public String toString() {
		/** Palautetaan String.format:lla muodostettu String, joka sisältää tiedot Aani-mediasta */
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Aani", nimike(), (kesto()+""));
	}
}
