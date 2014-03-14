package mediakirjasto;

public enum MediakirjastoKomento {
	
	TULOSTAKIRJASTO("kirjasto"),
	LAJITTELEKIRJASTO("lajittele"),

	TULOSTASOITTOLISTA("soittolista"),
	LUOSOITTOLISTA("luo", true),
	TAYTASOITTOLISTA("tayta"),

	TALLENNA("tallenna"),
	LATAA("lataa"),
	LOPETA("lopeta"),

	LISAAMEDIA("lisaa", true),
	POISTAMEDIA("poista", true);

	private boolean argc = false;
	private int argv = -1;
	private String komento;

	private MediakirjastoKomento(String komento) {
		this(komento, false);
	}
	private MediakirjastoKomento(String komento, boolean argc) {
		this.komento = komento;
		this.argc    = argc;
	}
	
	public void argv(int argv) { this.argv = argv; }
	public int argv()          { return this.argv; }

	public boolean argc()      { return this.argc; }

	public String toString()   { return this.komento; }
	
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
