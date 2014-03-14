package mediakirjasto;

public interface MediakirjastoInterface {
	
	/**
	 * 
	 * @param tiedosto sijainti jossa oleva tiedosto ladataan kirjastona
	 * @throws NullPointerException jos tiedosto on null-arvoinen
	 * @throws IllegalArgumentException jos tiedosto on virheellinen
	 */
	public abstract void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException;

	/**
	 * 
	 * @param tiedosto sijainti jossa oleva tiedosto ladataan soittolistana
	 * @throws NullPointerException jos tiedosto on null-arvoinen
	 * @throws IllegalArgumentException jos tiedosto on virheellinen
	 */
	public abstract void lataaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException;
	
	/**
	 * 
	 * @param ylaraja
	 * @throws IllegalArgumentException
	 */
	public abstract void luoSoittolista(int ylaraja) throws IllegalArgumentException;

	/**
	 * 
	 * @return
	 */
	public abstract int tulostaKirjasto();
	
	/**
	 * 
	 * @return
	 */
	public abstract int tulostaSoittolista();

	/**
	 * 
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public abstract void lisaaMedia(int index) throws IllegalArgumentException;

	/**
	 * 
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public abstract void poistaMedia(int index) throws IllegalArgumentException;

	/**
	 * 
	 */
	public abstract void taytaMedialla();

	/**
	 * 
	 */
	public abstract void lajitteleSoittolista();

	/**
	 * 
	 * @param tiedosto
	 * @throws NullPointerException
	 */
	public abstract void tallennaSoittolista(String tiedosto) throws NullPointerException;

	/**
	 * 
	 * @param tiedosto
	 * @throws NullPointerException
	 */
	public abstract void tallennaKirjasto(String tiedosto) throws NullPointerException;

}
