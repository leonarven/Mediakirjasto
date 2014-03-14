package mediakirjasto;

import fi.uta.csjola.oope.lista.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import mediakirjasto.mediatyyppi.Media;

public class Mediakirjasto implements MediakirjastoInterface {

	/** Nime‰‰n kantavien tiedostojen sijainnit */
	private String kirjastoTiedosto;
	private String soittolistaTiedosto;

	/** Soittolista jota k‰ytet‰‰n. Saattaa vaihtua ajon aikana */
	private Soittolista soittolista = null;
	
	/** Kirjasto jota k‰ytet‰‰n, ladataan pyydett‰essa sek‰ k‰ynnistett‰ess‰ */
	private Kirjasto kirjasto = null;
	
	/**
	 * Mediakirjaston rakentaja jolle annetaanp parametreina halutun kirjaston sek‰ soittolistan tiedostot
	 * 
	 * @param kirjastoTiedosto Halutun kirjaston sijainti
	 * @param soittolistaTiedosto Halutun soittolistan sijainti
	 * @throws NullPointerException Heitet‰‰n jos null-arvoinen paramteri
	 * @throws IllegalArgumentException Heitet‰‰n jos virheellinen tiedoston nimi
	 */
	public Mediakirjasto(String kirjastoTiedosto, String soittolistaTiedosto) throws NullPointerException, IllegalArgumentException {
		if (kirjastoTiedosto == null || soittolistaTiedosto == null) throw new NullPointerException();
		
		this.kirjastoTiedosto = kirjastoTiedosto;
		lataaKirjasto(kirjastoTiedosto);

		this.soittolistaTiedosto = soittolistaTiedosto;
		lataaSoittolista(soittolistaTiedosto);
	}

	/*
	 * Toteutetaan kivasti kirjastokohtaiset metodit jotka k‰ytt‰v‰t interfacen m‰‰ritt‰mi‰
	 * */

	/**
	 * 
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void lataaSoittolista() throws NullPointerException, IllegalArgumentException {
		this.lataaSoittolista(this.soittolistaTiedosto);
	}

	/**
	 * 
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public void lataaKirjasto() throws NullPointerException, IllegalArgumentException {
		this.lataaKirjasto(this.kirjastoTiedosto);
	}

	/**
	 * 
	 * @throws NullPointerException
	 */
	public void tallennaSoittolista() throws NullPointerException {
		this.tallennaSoittolista(this.soittolistaTiedosto);
	}
	/**
	 * 
	 * @throws NullPointerException
	 */
	public void tallennaKirjasto() throws NullPointerException {
		this.tallennaKirjasto(this.kirjastoTiedosto);
	}


	/*
	 * Toteutetaan interfacen m‰‰ritt‰m‰t peruskomennot
	 * */

	@Override
	public void lataaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		File file = new File(tiedosto);
		
		Scanner in = null;

		try {
			
			in = new Scanner(file);

			String ylaraja_str = in.nextLine().split("[|]")[0].trim();
			int ylaraja = Integer.parseInt(ylaraja_str);

			this.soittolista = new Soittolista(ylaraja);
			
			while(in.hasNextLine()) {
				Media media = Media.parseLine(in.nextLine());
				if (media != null) this.soittolista.lisaaLoppuun(media);
			}

		} catch(FileNotFoundException e) {
			
			this.soittolista = null;
			
			throw new IllegalArgumentException();
		} finally {
			if (in != null) in.close();
		}
	}

	@Override
	public void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		File file = new File(tiedosto);
		
		Scanner in = null;
		
		try {
			
			in = new Scanner(file);
			ArrayList<Media> mediat = new ArrayList<Media>();
			
			while(in.hasNextLine()) {
				Media media = Media.parseLine(in.nextLine());
				if (media != null) mediat.add(media);
			}
			
			this.kirjasto = new Kirjasto(mediat);

		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException();
		} finally {
			if (in != null) in.close();
		}
	}

	@Override
	public void luoSoittolista(int ylaraja) throws IllegalArgumentException {

		this.soittolista = new Soittolista(ylaraja);

	}

	@Override
	public int tulostaKirjasto() {
		for(int i = 0; i < kirjasto.koko(); i++)
			System.out.println(String.format("%1$-3s|%2$s", i, kirjasto.alkio(i)));
			
		return 0;
	}

	@Override
	public int tulostaSoittolista() {
		System.out.println((soittolista.koko())+" / "+(soittolista.ylaraja()));
		for(int i = 0; i < soittolista.koko(); i++)
			System.out.println(String.format("%1$-3s|%2$s", i, soittolista.alkio(i)));
			
		return 0;
	}

	@Override
	public void lisaaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen ");

//		Media = kirjasto.
		
//		this.soittolista.lisaa(index, media);
	}

	@Override
	public void poistaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen ");

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
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

	}

	@Override
	public void tallennaKirjasto(String tiedosto) throws NullPointerException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

	}

}
