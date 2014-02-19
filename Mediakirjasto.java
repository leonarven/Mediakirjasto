package mediakirjasto;

public class Mediakirjasto implements MediakirjastoInterface {

	private String kirjastoTiedosto;
	
	public Mediakirjasto() {
		this(null);
	}

	public Mediakirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		if (tiedosto != null) lataaKirjasto(tiedosto);

	}

	/*
	 * Toteutetaan interfacen määrittämät peruskomennot
	 * */
	
	@Override
	public void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

		// Tarkistetaan onko tiedosto olemassa
//		if () throw new IllegalArgumentException();
	}

	@Override
	public void luoSoittolista(int ylaraja) throws IllegalArgumentException {
		// Tarkistetaan onko yläraja oikeellinen
		if (ylaraja < 0) throw new IllegalArgumentException("Ylärajan tulee olla epänegatiivinen");

	}

	@Override
	public int tulostaKirjasto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int tulostaSoittolista() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lisaaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla epänegatiivinen ");

	}

	@Override
	public void poistaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla epänegatiivinen ");

	}

	@Override
	public void taytaMedialla() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lajitteleSoittolista() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tallennaSoittolista(String tiedosto) throws NullPointerException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

	}

	@Override
	public void tallennaKirjasto(String tiedosto) throws NullPointerException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

	}

}
