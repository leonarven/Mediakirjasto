package mediakirjasto.mediatyyppi;

/**
 * Videolle sopiva genre
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public enum VideoGenre {
	DRAAMA("draama"),
	KAUHU("kauhu"),
	KOMEDIA("komedia"),
	KOTI("koti"),
	TOIMINTA("toiminta"),
	MUU("muu");
	
	/** Tekstimuodossa oleva tieto genrestä */
	String str;
	
	/**
	 * Genren privaatti rakentaja
	 * @param str tekstimuoto genrestä
	 */
	private VideoGenre(String str)
		{ this.str = str; }

	/** Palauttaa tekstimuodon genrestä */
	public String toString()
		{ return this.str; }
};