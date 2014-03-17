package mediakirjasto;

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

	private boolean argc = false;
	private String argv = null;
	private String komento;

	private MediakirjastoKomento(String komento) {
		this(komento, false);
	}
	private MediakirjastoKomento(String komento, boolean argc) {
		this.komento = komento;
		this.argc    = argc;
	}
	
	public void argv(String argv) { this.argv = argv; }
	public String argv()          { return this.argv; }

	public boolean argc()         { return this.argc; }

	public String toString()      { return this.komento; }
	
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
