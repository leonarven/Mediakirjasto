package mediakirjasto;

/**
 * Enum kaikista mediakirjaston mahdollisista komennoista
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 */
public enum MediakirjastoKomento {
	
	TULOSTAKIRJASTO("kirjasto"),
	LAJITTELEKIRJASTO("lajittele", true),

	TULOSTASOITTOLISTA("soittolista"),
	LUOSOITTOLISTA("luo", true),
	TAYTASOITTOLISTA("tayta"),

	TALLENNA("tallenna"),
	LATAA("lataa"),
	LOPETA("lopeta"),

	LISAAMEDIA("lisaa", true),
	POISTAMEDIA("poista", true);
	

	/** Tieto vaatiiko komento parametreja */
	private boolean argc = false;

	/** Parametri */
	private String argv = null;

	/** String-esitys toteltavasta komennosta */
	private String komento;

	/**
	 * Enumin rakentaja, parametrinä toteltava komento
	 * @param komento Toteltava komento
	 */
	private MediakirjastoKomento(String komento) {
		this(komento, false);
	}

	/**
	 * Enumin rakentaja, parametrinä toteltava komento sekäö tieto vaaditaanko parametreja
	 * @param komento Toteltava komento
	 * @param argc Boolen, vaaditaanko parametrejä
	 */
	private MediakirjastoKomento(String komento, boolean argc) {
		this.komento = komento;
		this.argc    = argc;
	}
	
	/** Setter argv-attribuutille
	 * @param argv Komennolle annettu parametri
	 */
	public void argv(String argv) { this.argv = argv; }

	/** Getter argv-attribuutille
	 * @return Asetettu parametri jos on
	 */
	public String argv()          { return this.argv; }

	/** Getter argc-attribuutille
	 * @return Onko parametri vaadittu vai ei
	 */
	public boolean argc()         { return this.argc; }

	/** Komento String:ksi
	 * @return Komento
	 */
	public String toString()      { return this.komento; }
	
	/**
	 * Staattinen metodi jolla havaitaan haluttu MediakirjastoKomento annetun komennon perusteella
	 * @param str Annettu komento
	 * @return null jos epävalidi MediakirjastoKomento, muulloin Enum-arvo
	 */
	public static MediakirjastoKomento tunnistaKomento(String str) {

		for(MediakirjastoKomento komento : MediakirjastoKomento.values()) {
			try {
				if (komento.toString().equalsIgnoreCase(str.substring(0, komento.toString().length())))
					return komento;
			} catch(Exception e) { continue; }
		}
		return null;
	}
}
