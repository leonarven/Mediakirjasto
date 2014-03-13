package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import mediakirjasto.mediatyyppi.Media;

public class Mediakirjasto implements MediakirjastoInterface {

	private String kirjastoTiedosto;
	private String soittolistaTiedosto;

	private Soittolista soittolista = null;
	
	private Kirjasto kirjasto = new Kirjasto();
	
	public Mediakirjasto() {
		this(null, null);
	}

	public Mediakirjasto(String kirjastoTiedosto, String soittolistaTiedosto) throws NullPointerException, IllegalArgumentException {
		if (kirjastoTiedosto != null) {
			this.kirjastoTiedosto = kirjastoTiedosto;
			lataaKirjasto(kirjastoTiedosto);
		}

		if (soittolistaTiedosto != null){
			this.soittolistaTiedosto = soittolistaTiedosto;
			lataaKirjasto(soittolistaTiedosto);
		}
	}

	/*
	 * Toteutetaan kivasti kirjastokohtaiset metodit jotka käyttävät interfacen määrittämiä
	 * */

	public void lataaSoittolista() throws NullPointerException, IllegalArgumentException {
		this.lataaSoittolista(this.soittolistaTiedosto);
	}

	public void lataaKirjasto() throws NullPointerException, IllegalArgumentException {
		this.lataaKirjasto(this.kirjastoTiedosto);
	}

	public void tallennaSoittolista() throws NullPointerException {
		this.tallennaSoittolista(this.soittolistaTiedosto);
	}
	public void tallennaKirjasto() throws NullPointerException {
		this.tallennaKirjasto(this.kirjastoTiedosto);
	}


	/*
	 * Toteutetaan interfacen määrittämät peruskomennot
	 * */
	@Override
	public void lataaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException {
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");
		
	}

	@Override
	public void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

		File file = new File(tiedosto);
		
		try {
			
			Scanner in = new Scanner(file);
			ArrayList<Media> mediat = new ArrayList<Media>();
			
			while(in.hasNextLine()) {
				Media media = Media.parseLine(in.nextLine());
				if (media != null) mediat.add(media);
			}
			
			this.kirjasto = new Kirjasto(mediat);

		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void luoSoittolista(int ylaraja) throws IllegalArgumentException {

		this.soittolista = new Soittolista(ylaraja);

	}

	@Override
	public int tulostaKirjasto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int tulostaSoittolista() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void lisaaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla epänegatiivinen ");

//		Media = kirjasto.
		
//		this.soittolista.lisaa(index, media);
	}

	@Override
	public void poistaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla epänegatiivinen ");

		this.soittolista.poista(index);
	}

	@Override
	public void taytaMedialla() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lajitteleSoittolista() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tallennaSoittolista(String tiedosto) throws NullPointerException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

	}

	@Override
	public void tallennaKirjasto(String tiedosto) throws NullPointerException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee määrittää");

	}

}
