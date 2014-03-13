package mediakirjasto.mediatyyppi;

public class Aani extends Media {

	private int kesto;
	
	public Aani(String nimike, int kesto) throws IllegalArgumentException {
		super(nimike);
		kesto(kesto);
	}
	
	public void kesto(int kesto) throws IllegalArgumentException {
		if (kesto < 0)
			throw new IllegalArgumentException();
		
		this.kesto = kesto;
	}
	
	public int kesto() { return this.kesto; }
	
	public String toString() {
		return String.format("%1$-8s|%2$-32s|%3$-8s|", "Aani", nimike(), (kesto()+""));
	}
}
