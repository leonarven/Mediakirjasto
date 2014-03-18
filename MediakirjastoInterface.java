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
	 * Ottaa k�ytt��n uuden, halutun kokoisen soittolistan
	 * @param ylaraja Haluttu koon yl�raja
	 * @throws IllegalArgumentException Jos parametri on virheellinen
	 */
	public abstract void luoSoittolista(int ylaraja) throws IllegalArgumentException;

	/**
	 * Tulostetaan kirjaston sis�lt� datalistana
	 */
	public abstract void tulostaKirjasto();
	
	/**
	 * Tulostetaan soittolistan sis�lt� datalistana sek� soittolistan koko ja yl�raja
	 */
	public abstract void tulostaSoittolista();

	/**
	 * Lis�t��n soittolistalle media kirjastosta indeksill� index
	 * @param index Median indeksi kirjastossa
	 * @throws IllegalArgumentException Jos index on virheellinen
	 */
	public abstract void lisaaMedia(int index) throws IllegalArgumentException;

	/**
	 * Poistetaan media soittolistalta indeksill� index
	 * @param index Median indeksi soittolistassa
	 * @throws IllegalArgumentException Jos index on virheellinen
	 */
	public abstract void poistaMedia(int index) throws IllegalArgumentException;

	/**
	 * T�ytet��n soittolistan tyhj� loppuosa medialla kirjaston alusta
	 * <p>
	 * Toimintaperiaate:<br>
	 * L�pik�yd��n kukin kirjaston alkio alusta l�htien ja yritet��n lis�t� soittolistalle.<br>
	 * Virhetilanteita syntyy kun soittolista on t�ynn� tai alkio on jo listalla.<br>
	 * N�m� virheet ohitetaan.
	 */
	public abstract void taytaMedialla();

	/**
	 * Lajitellaan kirjasto
	 * @param ord "nouseva" tai "laskeva", muulloin heitet��n poikkeus
	 * @throws IllegalArgumentException Jos parametri on virheellinen
	 */
	public abstract void lajitteleKirjasto(String ord) throws IllegalArgumentException;

	/**
	 * Tallennetaan soittolista tiedostoon
	 * @param tiedosto Tiedosto, johon halutaan tallentaa
	 * @throws NullPointerException Jos tiedosto on null
	 */
	public abstract void tallennaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException;

	/**
	 * Tallennetaan kirjasto tiedostoon
	 * @param tiedosto Tiedosto, johon halutaan tallentaa
	 * @throws NullPointerException Jos tiedosto on null
	 */
	public abstract void tallennaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException;

}
