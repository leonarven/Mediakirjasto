package mediakirjasto.mediatyyppi;

public abstract class Media {
	
	private String nimike;

	public Media(String nimike) throws NullPointerException {
		nimike(nimike);
	}
	
	public void nimike(String nimike) throws NullPointerException {
		if (nimike == null) throw new NullPointerException();
		this.nimike = nimike;
	}

	public String nimike() { return this.nimike; }

/*	public Mediatyyppi tyyppi() {
		Mediatyyppi tyyppi = 
	}*/
}
