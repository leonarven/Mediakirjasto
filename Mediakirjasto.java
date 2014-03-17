package mediakirjasto;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

import mediakirjasto.mediatyyppi.Media;

/**
 * Mediakirjaston ydinluokka
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 * @version 140317
 */
public class Mediakirjasto implements MediakirjastoInterface {

	/** Nime‰‰n kantavien tiedostojen sijainnit */
	private String kirjastoTiedosto;
	private String soittolistaTiedosto;

	/** Soittolista jota k‰ytet‰‰n. Saattaa vaihtua ajon aikana */
	private Soittolista soittolista = null;
	
	/** Kirjasto jota k‰ytet‰‰n, ladataan pyydett‰essa sek‰ k‰ynnistett‰ess‰ */
	private Kirjasto kirjasto = null;
	
	/**
	 * Mediakirjaston rakentaja jolle annetaan parametreina halutun kirjaston sek‰ soittolistan tiedostot
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
	 * Metodi soittolistan lataamisen mediakirjaston oletustiedostosta
	 * @throws NullPointerException Jos tiedosto on null
	 * @throws IllegalArgumentException jos tiedosto on virheellinen
	 */
	public void lataaSoittolista() throws NullPointerException, IllegalArgumentException {
		this.lataaSoittolista(this.soittolistaTiedosto);
	}

	/**
	 * Metodi kirjaston lataamisen mediakirjaston oletustiedostosta
	 * @throws NullPointerException Jos tiedosto on null
	 * @throws IllegalArgumentException jos tiedosto on virheellinen
	 */
	public void lataaKirjasto() throws NullPointerException, IllegalArgumentException {
		this.lataaKirjasto(this.kirjastoTiedosto);
	}

	/**
	 * Tallennetaan soittolista oletustiedostoon
	 * @throws NullPointerException
	 */
	public void tallennaSoittolista() throws NullPointerException {
		this.tallennaSoittolista(this.soittolistaTiedosto);
	}
	/**
	 * Tallennetaan kirjasto oletustiedostoon
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

		if (ylaraja > this.kirjasto.koko()) throw new IllegalArgumentException("Soittolistan koon yl‰raja ei voi olla kirjaston kokoa suurempi");
		
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
		System.out.println(soittolista.koko()+" / "+soittolista.ylaraja());
		for(int i = 0; i < soittolista.koko(); i++)
			System.out.println(String.format("%1$-3s|%2$s", i, soittolista.alkio(i)));
			
		return 0;
	}

	@Override
	public void lisaaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen");
		if (index >= this.kirjasto.koko()) throw new IllegalArgumentException("Indeksin tulee olla kirjaston koon rajoissa");

		if (this.soittolista.koko() < this.soittolista.ylaraja()) {
			
			Object alkio = this.kirjasto.alkio(index);
			
			if (this.soittolista.etsi(alkio) == null) {
				this.soittolista.lisaaLoppuun((Media)alkio);
			} else throw new IllegalArgumentException("Media on jo soittolistalla");
		} else throw new IllegalArgumentException("Soittolista on jo t‰ynn‰");
	}

	@Override
	public void poistaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen, siis v‰lill‰ [0, soittolistan_koko]
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen ");
		if (index >= this.soittolista.koko()) throw new IllegalArgumentException("Indeksin tulee soittolistan koon rajoissa");

		this.soittolista.poista(index);
	}

	@Override
	public void taytaMedialla() {
		/** L‰pik‰yd‰‰n kaikki kirjaston mediat ja yritet‰‰n(HUOM!) lis‰t‰ soittolistalle */
		for(int i = 0; i < this.kirjasto.koko(); i++)
			try {
				/** Yritet‰‰n lis‰t‰. Jos virhe (media jo listalla, menn‰‰n yli rajojen) niin catch nappaa ja jatkaa */
				this.lisaaMedia(i);
			} catch(IllegalArgumentException e) { continue; }
	}

	@Override
	public void lajitteleKirjasto(String ord) throws IllegalArgumentException {
		
		int ordn, len = this.kirjasto.koko();
		Object tmp = null;

		/** Tutkitaan parametria, otetaan arvo ulos ja jos virheellinen parametri, heitet‰‰n poikkeus */
		if (ord.trim().equalsIgnoreCase("laskeva"))      ordn = -1;
		else if (ord.trim().equalsIgnoreCase("nouseva")) ordn =  1;
		else throw new IllegalArgumentException("Arvon tulee olla joko 'nouseva' tai 'laskeva'");

		/** L‰pik‰yd‰‰n alkiot */
		for(int i = 0, j = i; i < len; i++) {
			/** Etsit‰‰n seuraavaksi suurin/pienin alkio */
			for(int k = i; k < len; k++) {
				Oope2014HT.DEBUG(((Media)this.kirjasto.alkio(j)).toString());
				Oope2014HT.DEBUG(((Media)this.kirjasto.alkio(k)).toString());
				Oope2014HT.DEBUG("Vrt: "+((Media)this.kirjasto.alkio(j)).compareTo((Media)this.kirjasto.alkio(k)));
				if (((Media)this.kirjasto.alkio(j)).compareTo((Media)this.kirjasto.alkio(k)) == ordn) j = k;
			}

			if (i == j) continue;

			/** Vaihdetaan alkioiden paikkaa jos lˆydettiin suurempi/pienempi */
			tmp = this.kirjasto.alkio(i);
			this.kirjasto.aseta(this.kirjasto.alkio(j), i);
			this.kirjasto.aseta(tmp, j);
		}
		
	}

	/*public int[] selectionSort(int[] data){
  int lenD = data.length;
  int j = 0;
  int tmp = 0;
  for(int i=0;i<lenD;i++){
    j = i;
    for(int k = i;k<lenD;k++){
      if(data[j]>data[k]){
        j = k;
      }
    }
    tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }
  return data;
}*/
	
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
