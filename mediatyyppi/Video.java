package mediakirjasto.mediatyyppi;

public class Video extends Media {
	
	public static enum Genre {
		DRAAMA("Draama"),
		KAUHU("Kauhu"),
		KOMEDIA("Komedia"),
		KOTI("Koti"),
		TOIMINTA("Toiminta"),
		MUU("Muu");
		
		String str;
		
		private Genre(String str)
			{ this.str = str; }

		public String toString()
			{ return this.str; }
	};
	
	Genre genre;
	
	public Video(String nimike, Genre genre) throws NullPointerException {
		super(nimike);
		genre(genre);
	}
	public Video(String nimike, String genre) throws NullPointerException, IllegalArgumentException {
		super(nimike);
		genre(genre);
	}
	
	public void genre(String genrestr) throws NullPointerException, IllegalArgumentException {
		if (genrestr == null)
			throw new NullPointerException();

		Genre genre = Genre.valueOf(genrestr.toLowerCase());
		
		if (genre == null)
			throw new IllegalArgumentException();
		
		this.genre = genre;
	}
	public void genre(Genre genre) throws NullPointerException {
		if (genre == null)
			throw new NullPointerException();

		this.genre = genre;
	}
	public Genre genre() {
		return this.genre;
	}
	public String toString() {
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Video", nimike(), genre());
	}
}
