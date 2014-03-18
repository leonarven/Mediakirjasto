package mediakirjasto.mediatyyppi;

/**
 * Abstrakti Media -yliluokka eri mediatyypeille
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public abstract class Media implements Comparable<Media>  {
	
	/** Yhteinen attribuutti kaikille mediatyypeille */
	private String nimike;

	/**
	 * @param nimike Haluttu median nimike
	 * @throws NullPointerException Jos nimike on null
	 * @throws IllegalArgumentException Jos nimike on ep‰validi(tyhj‰) merkkijono
	 */
	public Media(String nimike) throws NullPointerException, IllegalArgumentException {
		/** K‰ytet‰‰n attribuutin setteri‰ oikeellisuuden varmistamiseksi */
		nimike(nimike);
	}
	
	/**
	 * Setter nimike-attribuutille
	 * 
	 * @param nimike Haluttu nimike
	 * @throws NullPointerException Jos nimike on null
	 * @throws IllegalArgumentException Jos nimike on ep‰validi(tyhj‰) merkkijono
	 */
	public void nimike(String nimike) throws NullPointerException, IllegalArgumentException {
		/** Joss nimike on null, heitet‰‰n NullPointerException */
		if (nimike == null) throw new NullPointerException();
		/** Jos tyhj‰ merkkijono nimikkeen‰ */
		if (nimike.trim().length() == 0) throw new IllegalArgumentException();
		this.nimike = nimike;
	}

	/**
	 * Gettet nimike-attribuutille
	 * @return Median nimike
	 */
	public String nimike() { return this.nimike; }

	/**
	 * Parsii tiedostosta ladatessa datasta (tiedoston rivist‰) tiedot ja palauttaa uuden oikean tyyppisen median
	 * @param line Datarivi, joka paristaan
	 * @return Uusi oikean tyyppinen media-luokan perinyt olio
	 */
	public static Media getMedia(String line) {
		/** Parsitaan rivin kent‰t, erotinmerkkin‰ putkimerkki */
		String argv[] = line.split("[|]");
		/** Siistit‰‰bn v‰h‰n kentti‰. Whitespacet pois */
		for(int i = 0; i < argv.length; i++) {
			argv[i] = argv[i].trim();
		}

		/** K‰ytet‰‰n staattista Mediatyyppi-luokan get-metodia selvitt‰m‰‰n mink‰ tyyppinen kyseisen rivin media on */
		Mediatyyppi tyyppi = Mediatyyppi.getMediatyyppi(argv[0]);

		/** Tutkitaan kukin mediatyyppi.
		 * Parsitaan haluttu atribuutti ja syˆtet‰‰n se median rakentajalle nimikkeen kera. */
		switch(tyyppi) {
			case AANI:  return new  Aani(argv[1], Integer.parseInt(argv[2])); /** Attribuuttina kesto, muutetaan String Integerill‰ intiksi */
			case VIDEO: return new Video(argv[1], VideoGenre.valueOf(argv[2].toUpperCase())); /** Attribuuttina genre, selvitet‰‰n oikea genre Video.Genre-enumin valueOf-metodilla */
			case KUVA:  return new  Kuva(argv[1], argv[2].equalsIgnoreCase("true")?true:false); /** Atribuuttina onko bittikartta vai ei; ehtolauseella tarkastetaan onko arvo "true" */
		}
		
		return null;
	}
	
	/**
	 * Koska implementoidaan Comparable<Media>-rajapinta, pit‰‰ toteuttaa compareTo-metodi
	 * @param toinen Media, johon verrataan
	 * @return vertailun tulos int-muodossa. 1 jos suurempi, 0 jos samat, -1 jos pienempi
	 */
	@Override public int compareTo(Media toinen) {
		/** K‰ytet‰‰n String-luokan compareTo-metodia vertailemaan nimikkeit‰ */
		int ordn = this.nimike().toLowerCase().compareTo(toinen.nimike().toLowerCase());
		return ordn == 0 ? 0 : (ordn < 0 ? -1 : 1);
	}
}
