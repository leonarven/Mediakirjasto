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
	
	public String toString() {
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Kuva", nimike(), (bittikartta()?"true":"false"));
	}
}
