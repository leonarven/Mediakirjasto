package mediakirjasto;

/**
 * Interface jolla rakennetaan mediakirjaston toiminnallisuus
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
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
	 * Ottaa käyttöön uuden, halutun kokoisen soittolistan
	 * @param ylaraja Haluttu koon yläraja
	 * @throws IllegalArgumentException Jos parametri on virheellinen
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
	public abstract void lajitteleSoittolista(String ord) throws IllegalArgumentException;

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
