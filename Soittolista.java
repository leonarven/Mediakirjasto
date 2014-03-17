package mediakirjasto;

/**
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public class Soittolista extends Lista {
	
	/** yläraja joka halutaan soittolistalle antaa */
	private int ylaraja;
	
	/**
	 * 
	 * @param ylaraja haluttu soittolistan koon yläraja
	 * @throws IllegalArgumentException jos yläraja on negatiivinen
	 */
	public Soittolista(int ylaraja) throws IllegalArgumentException {
		ylaraja(ylaraja);
		
	}
	
	/**
	 * 
	 * @param ylaraja haluttu soittolistan koon yläraja
	 * @throws IllegalArgumentException jos yläraja on negatiivinen
	 */
	public void ylaraja(int ylaraja) throws IllegalArgumentException {
		if (ylaraja <= 0) throw new IllegalArgumentException("Ylärajan tulee olla epänegatiivinen");
		
		this.ylaraja = ylaraja;
	}
	/**
	 * @return soittolistan yläraja
	 */
	public int ylaraja() { return this.ylaraja; }
	
}
