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
	 * Tulostetaan kirjaston sisältö datalistana
	 */
	public abstract void tulostaKirjasto();
	
	/**
	 * Tulostetaan soittolistan sisältö datalistana sekä soittolistan koko ja yläraja
	 */
	public abstract void tulostaSoittolista();

	/**
	 * Lisätään soittolistalle media kirjastosta indeksillä index
	 * @param index Median indeksi kirjastossa
	 * @throws IllegalArgumentException Jos index on virheellinen
	 */
	public abstract void lisaaMedia(int index) throws IllegalArgumentException;

	/**
	 * Poistetaan media soittolistalta indeksillä index
	 * @param index Median indeksi soittolistassa
	 * @throws IllegalArgumentException Jos index on virheellinen
	 */
	public abstract void poistaMedia(int index) throws IllegalArgumentException;

	/**
	 * Täytetään soittolistan tyhjä loppuosa medialla kirjaston alusta
	 * <p>
	 * Toimintaperiaate:<br>
	 * Läpikäydään kukin kirjaston alkio alusta lähtien ja yritetään lisätä soittolistalle.<br>
	 * Virhetilanteita syntyy kun soittolista on täynnä tai alkio on jo listalla.<br>
	 * Nämä virheet ohitetaan.
	 */
	public abstract void taytaMedialla();

	/**
	 * Lajitellaan kirjasto
	 * @param ord "nouseva" tai "laskeva", muulloin heitetään poikkeus
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
