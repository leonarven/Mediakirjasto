package mediakirjasto.mediatyyppi;

/**
 * Mahdollinen mediatyyppi
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public enum Mediatyyppi {
	VIDEO("Video"),
	AANI("Aani"),
	KUVA("Kuva");
	
	String str;
	
	/** 
	 * Mediatyyppi-enumin privaatti rakentaja
	 * @param str 
	 */
	private Mediatyyppi(String str)
		{ this.str = str; }

	public String toString()
		{ return this.str; }

	/**
	 * Staattinen metodi, jolla saadaan merkkijonon perusteella Mediatyyppi-enum
	 * @param str etsittävä median arvo
	 * @return null jos epävalidi parametri, muulloin oikea Mediatyyppi
	 */
	public static Mediatyyppi getMediatyyppi(String str) {
		Mediatyyppi kohde = null;
		try {
			/** Koetetaan muodostaa kohde-muuttujaan Mediatyyppi-enumin arvo */
			kohde = Mediatyyppi.valueOf(str.toUpperCase());
		} catch(Exception e) {}
		
		return kohde;
	}
};
