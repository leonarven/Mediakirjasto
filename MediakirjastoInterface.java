package mediakirjasto;

public interface MediakirjastoInterface {
	
	public abstract void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException;
	
	public abstract void luoSoittolista(int ylaraja) throws IllegalArgumentException;

	public abstract int tulostaKirjasto();
	
	public abstract int tulostaSoittolista();

	public abstract void lisaaMedia(int index) throws IllegalArgumentException;

	public abstract void poistaMedia(int index) throws IllegalArgumentException;

	public abstract void taytaMedialla();

	public abstract void lajitteleSoittolista();

	public abstract void tallennaSoittolista(String tiedosto) throws NullPointerException;

	public abstract void tallennaKirjasto(String tiedosto) throws NullPointerException;

}
