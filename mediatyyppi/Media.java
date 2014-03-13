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
	
	public static Media parseLine(String line) {
		String argv[] = line.split("[|]");
		for(int i = 0; i < argv.length; i++) {
			argv[i] = argv[i].trim();
		}

		Mediatyyppi tyyppi = Mediatyyppi.get(argv[0]);

		switch(tyyppi) {
			case AANI:  return new  Aani(argv[1], Integer.parseInt(argv[2]));
			case VIDEO: return new Video(argv[1], Video.Genre.valueOf(argv[2].toUpperCase()));
			case KUVA:  return new  Kuva(argv[1], argv[2].equalsIgnoreCase("true")?true:false);
		}
		
		return null;
	}
}
