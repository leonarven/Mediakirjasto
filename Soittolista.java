package mediakirjasto;

/**
 * Soittolista-luokka, joka periytet‰‰n Lista -luokasta toteutumaan linkitettyn‰ listana
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public class Soittolista extends Lista {
	
	/** yl‰raja joka halutaan soittolistalle antaa */
	private int ylaraja;
	
	/**
	 * 
	 * @param ylaraja haluttu soittolistan koon yl‰raja
	 * @throws IllegalArgumentException jos yl‰raja on negatiivinen
	 */
	public Soittolista(int ylaraja) throws IllegalArgumentException {
		ylaraja(ylaraja);
		
	}
	
	/**
	 * 
	 * @param ylaraja haluttu soittolistan koon yl‰raja
	 * @throws IllegalArgumentException jos yl‰raja on negatiivinen
	 */
	public void ylaraja(int ylaraja) throws IllegalArgumentException {
		if (ylaraja <= 0) throw new IllegalArgumentException("Yl‰rajan tulee olla ep‰negatiivinen");
		
		this.ylaraja = ylaraja;
	}
	/**
	 * @return soittolistan yl‰raja
	 */
	public int ylaraja() { return this.ylaraja; }
	
}
