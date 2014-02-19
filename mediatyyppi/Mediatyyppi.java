package mediakirjasto.mediatyyppi;

public enum Mediatyyppi {
	VIDEO("Video"),
	AANI("Aani"),
	KUVA("Kuva");
	
	String str;
	
	private Mediatyyppi(String str)
		{ this.str = str; }

	public String toString()
		{ return this.str; }
};
