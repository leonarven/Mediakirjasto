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

	public static Mediatyyppi get(String str) {
		Mediatyyppi kohde = null;
		try {
			kohde = Mediatyyppi.valueOf(str.toUpperCase());
		} catch(Exception e) {}
		
		return kohde;
	}
};
