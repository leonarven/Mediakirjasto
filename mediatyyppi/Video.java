package mediakirjasto.mediatyyppi;

/**
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 * @see mediakirjasto.mediatyyppi.Media
 */
public class Video extends Media {
	
	/**
	 * Video-median genre
	 * @see mediakirjasto.mediatyyppi.VideoGenre
	 */
	VideoGenre genre;
	
	/**
	 * Video-median rakentaja
	 * @param nimike Haluttu Video-median nimike
	 * @param genre Haluttu Video-median genre(Genre)
	 * @throws NullPointerException
	 * @see mediakirjasto.mediatyyppi.VideoGenre
	 */
	public Video(String nimike, VideoGenre genre) throws NullPointerException {
		super(nimike);
		genre(genre);
	}
	
	/**
	 * Video-median kuormitettu rakentaja
	 * @param nimike Haluttu Video-median nimike
	 * @param genre Haluttu Video-mediann genre tekstimuodossa
	 * @throws NullPointerException Jos nimike tai genre on null
	 * @throws IllegalArgumentException Jos genre on ep‰validi
	 */
	public Video(String nimike, String genre) throws NullPointerException, IllegalArgumentException {
		super(nimike);
		genre(genre);
	}
	
	/**
	 * Setter genre-attribuutille String-oliosta
	 * @param genrestr Genren tekstimuotoinen esitys
	 * @throws NullPointerException Jos parametri on null
	 * @throws IllegalArgumentException Jos parametri on ep‰validi
	 */
	public void genre(String genrestr) throws NullPointerException, IllegalArgumentException {
		/** Tarkistetaan onko annettu parametri null */
		if (genrestr == null) throw new NullPointerException();

		/** Koetetaan muodostaan genre(Genre) annetusta parametrista */
		VideoGenre genre = VideoGenre.valueOf(genrestr.toLowerCase());
		
		/** Jos genre on ep‰validi, heitet‰‰n poikkeus */
		if (genre == null) throw new IllegalArgumentException();
		
		/** Asetetaan Video-median genre */
		this.genre = genre;
	}

	/**
	 * Setter genre-attribuutille
	 * @param genre Haluttu genre (Genre)
	 * @throws NullPointerException Jos parametri on null
	 * @see mediakirjasto.mediatyyppi.VideoGenre
	 */
	public void genre(VideoGenre genre) throws NullPointerException {
		/** Jos genre on ep‰validi, heitet‰‰n poikkeus */
		if (genre == null) throw new NullPointerException();

		this.genre = genre;
	}
	/** Getter Genre-attribuutille
	 * @return Video-muotoisen median genre 
	 */
	public VideoGenre genre() {
		return this.genre;
	}
	/** Video-media tekstin‰ (datarivi) */
	public String toString() {
		/** Palautetaan String.format:lla muodostettu String, joka sis‰lt‰‰ tiedot Video-mediasta */
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Video", nimike(), genre());
	}
}
