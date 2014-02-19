package mediakirjasto.mediatyyppi;

public class Kuva extends Media {

	private boolean bittikartta;
	
	public Kuva(String nimike, boolean bittikartta) {
		super(nimike);
		bittikartta(bittikartta);
	}
	
	public void bittikartta(boolean bittikartta){
		this.bittikartta = bittikartta;
	}
	
	public boolean bittikartta() { return this.bittikartta; }
	
}
