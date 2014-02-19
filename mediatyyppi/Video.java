package mediakirjasto.mediatyyppi;

public class Video extends Media {
	
	public static enum Genre {
		DRAAMA("draama"),
		KAUHU("kauhu"),
		KOMEDIA("komedia"),
		KOTI("koti"),
		TOIMINTA("toiminta"),
		MUU("muu");
		
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
}
