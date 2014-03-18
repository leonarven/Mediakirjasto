package mediakirjasto;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void lataaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		/** Alustetaan tiedosto josta halutaan lukea */
		File file = new File(tiedosto);
		
		/** Muuttuja Scannerille */
		Scanner in = null;
		
		try {
			
			/** Alustetaan scanner ja tyhj‰ Media-tyyppinen ArrayList */
			in = new Scanner(file);

			/** Parsitaan ensimm‰isen rivin ensimm‰isest‰ sarakkeesta numeroarvo joka on soittolistan koon yl‰raja */
			String ylaraja_str = in.nextLine().split("[|]")[0].trim();
			int ylaraja = Integer.parseInt(ylaraja_str);

			/** Luodaan uusi, oikean kokoinen soittolista */
			this.luoSoittolista(ylaraja);

			/** L‰pik‰yd‰‰n tiedosto rivi rivilt‰ loppuun asti */
			while(in.hasNextLine()) {
				/** Koetetaan muodostaa oikean tyyppinen media datarivin sis‰llˆn perusteella */
				Media media = Media.getMedia(in.nextLine());
				/** Jos muodotetettiin oikean tyyppinen media (ei null), pˆkk‰ist‰‰n se listan per‰lle */
				if (media != null) this.soittolista.lisaaLoppuun(media);
			}

		} /** Poikkeuksen k‰sittely, jos ei tiedostoa lˆytynyt */
		catch(FileNotFoundException e) {
			this.soittolista = null;
			
			/** Jatketaan heittely‰, mutta k‰sitellen se virheellisen tyyppisen‰ parametrina */
			throw new IllegalArgumentException("Tiedostoa ei lˆydy");
		} /** Lopuksi jos Scanner on alustettu, suljetaan se */
		finally {
			if (in != null) in.close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void lataaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		/** Alustetaan tiedosto josta halutaan lukea */
		File file = new File(tiedosto);
		
		/** Muuttuja Scannerille */
		Scanner in = null;
		
		try {
			
			/** Alustetaan scanner ja tyhj‰ Media-tyyppinen ArrayList */
			in = new Scanner(file);
			ArrayList<Media> mediat = new ArrayList<Media>();

			/** L‰pik‰yd‰‰n tiedosto rivi rivilt‰ loppuun asti */
			while(in.hasNextLine()) {
				/** Koetetaan muodostaa oikean tyyppinen media datarivin sis‰llˆn perusteella */
				Media media = Media.getMedia(in.nextLine());
				/** Jos muodotetettiin oikean tyyppinen media (ei null), pˆkk‰ist‰‰n se listan per‰lle */
				if (media != null) mediat.add(media);
			}
			
			/** Muodostetaan attribuuttiin uusi kirjasto tiedoston medioiden pohjalta */
			this.kirjasto = new Kirjasto(mediat);

		} /** Poikkeuksen k‰sittely, jos ei tiedostoa lˆytynyt */
		catch(FileNotFoundException e) {
			/** Jatketaan heittely‰, mutta k‰sitellen se virheellisen tyyppisen‰ parametrina */
			throw new IllegalArgumentException("Tiedostoa ei lˆydy");
		} /** Lopuksi jos Scanner on alustettu, suljetaan se */
		finally {
			if (in != null) in.close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void luoSoittolista(int ylaraja) throws IllegalArgumentException {

		/** Jos soittolistan koko on kirjaston kokoa suurempi, heitet‰‰n virhe (teht‰v‰nanto) */
		if (ylaraja > this.kirjasto.koko()) throw new IllegalArgumentException("Soittolistan koon yl‰raja ei voi olla kirjaston kokoa suurempi");
		
		/** Sijoitetaan attribuuttiin halutun kokoinen soittolista */
		this.soittolista = new Soittolista(ylaraja);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tulostaKirjasto() {
		/** L‰pik‰yd‰‰n kirjasto media medialta */
		for(int i = 0; i < kirjasto.koko(); i++)
			/** Tulostetaan String.format:lla muodostettu rivi, kirjaston alkion toString-muunnos sek‰ alussa kolmen merkin kokoinen sarake johon sijoitetaan indeksi */
			System.out.println(String.format("%1$-3s|%2$s", i, kirjasto.alkio(i)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tulostaSoittolista() {
		/** Ensimm‰iselle riville kirjaston nykyinen koko sek‰ yl‰raja */
		System.out.println(soittolista.koko()+" / "+soittolista.ylaraja());
		/** L‰pik‰yd‰‰n soittolista media medialta */
		for(int i = 0; i < soittolista.koko(); i++)
			/** Tulostetaan String.format:lla muodostettu rivi, soittolistan alkion toString-muunnos sek‰ alussa kolmen merkin kokoinen sarake johon sijoitetaan indeksi */
			System.out.println(String.format("%1$-3s|%2$s", i, soittolista.alkio(i)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void lisaaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen");
		if (index >= this.kirjasto.koko()) throw new IllegalArgumentException("Indeksin tulee olla kirjaston koon rajoissa");

		/** Jatketaan vain jos soittolista ei ole viel‰ kohdannut yl‰rajaansa */
		if (this.soittolista.koko() < this.soittolista.ylaraja()) {
			
			/** Noudetaan kirjaston alkio indeksill‰ */
			Object alkio = this.kirjasto.alkio(index);
			
			/** Jos alkiota ei viel‰ lˆydy soittolistalta, lis‰t‰‰n se */
			if (this.soittolista.etsi(alkio) == null) {
				this.soittolista.lisaaLoppuun((Media)alkio);
			} /** Jos alkio lˆytyy, heitet‰‰n 'Virhe!' */
			else throw new IllegalArgumentException("Media on jo soittolistalla");
		} /** Jos soittolista on kooltaan yl‰rajansa, heitet‰‰n 'Virhe!' */
		else throw new IllegalArgumentException("Soittolista on jo t‰ynn‰");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void poistaMedia(int index) throws IllegalArgumentException {
		// Tarkistetaan onko indeksi oikeellinen, siis v‰lill‰ [0, soittolistan_koko]
		if (index < 0) throw new IllegalArgumentException("Indeksin tulee olla ep‰negatiivinen ");
		if (index >= this.soittolista.koko()) throw new IllegalArgumentException("Indeksin tulee soittolistan koon rajoissa");

		/** K‰ytet‰‰n AbstraktiLista:n maanmainiota poista-metodia alkion poistamiseen indeksill‰ */
		if (this.soittolista.poista(index) == null)
			/** Jos poista-metodi palauttaa null:n, jotain k‰vi hassusti */
			throw new IllegalArgumentException("Virheellinen indeksi");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void taytaMedialla() {
		/** L‰pik‰yd‰‰n kaikki kirjaston mediat ja yritet‰‰n(HUOM!) lis‰t‰ soittolistalle */
		for(int i = 0; i < this.kirjasto.koko(); i++)
			try {
				/** Yritet‰‰n lis‰t‰. Jos virhe (media jo listalla, menn‰‰n yli rajojen) niin catch nappaa ja jatkaa */
				this.lisaaMedia(i);
			} /** Jos mediaa ei voitu lis‰t‰ (soittolista t‰ynn‰ tai media on jo listalla), j‰tet‰‰n huomiotta ja jatketaan */
			catch(IllegalArgumentException e) { continue; }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void lajitteleKirjasto(String ord) throws IllegalArgumentException {

		/** Tutkitaan parametria, otetaan vertailun arvo ulos ja jos virheellinen parametri, heitet‰‰n poikkeus */
		if (ord.trim().equalsIgnoreCase("laskeva"))      this.kirjasto.lajittele(1);
		else if (ord.trim().equalsIgnoreCase("nouseva")) this.kirjasto.lajittele(-1);
		else throw new IllegalArgumentException("Arvon tulee olla joko 'nouseva' tai 'laskeva'");
	}

/*	public int[] selectionSort(int[] data){
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tallennaSoittolista(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		/** Alustetaan muuttujat kirjoitin sek‰ tiedosto */
		PrintWriter out = null;
		File file = new File(tiedosto);

		/** Try-lause k‰sittelem‰‰n poikkeukset */
		try {
			
			if (Oope2014HT.DEBUG) {
				Oope2014HT.DEBUG("Aiotaan tallentaa soittolista tiedostoon "+tiedosto);
				Oope2014HT.DEBUG(String.format("%1$-8s|", this.soittolista.ylaraja()));
				for(int i = 0; i < this.soittolista.koko(); i++)
					Oope2014HT.DEBUG(this.soittolista.alkio(i).toString());
			} else {
				/** Alustetaan kirjoitin tiedoston perusteella */
				out = new PrintWriter(file);
				/** Ensimm‰iselle riville 8-merkkinen sarake jossa soitotlistan koon yl‰raja */
				out.println(String.format("%1$-8s|", this.soittolista.ylaraja()));
				/** L‰pik‰yd‰‰n koko soittolista */
				for(int i = 0; i < this.soittolista.koko(); i++)
					/** Tulostetaan tiedostoon media-alkio merkkijonomuodossaan */
					out.println(this.soittolista.alkio(i).toString());
			} 
		} /** Jos tiedosto on virheellinen */
		catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Virheellinen tiedosto");
		} /** Lopuksi suljetaan */
		finally {
			if (out != null) out.close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tallennaKirjasto(String tiedosto) throws NullPointerException, IllegalArgumentException {
		// Tarkistetaan null-Stringien varalta
		if (tiedosto == null) throw new NullPointerException("Tiedoston nimi tulee m‰‰ritt‰‰");

		/** Alustetaan muuttujat kirjoitin sek‰ tiedosto */
		PrintWriter out = null;
		File file = new File(tiedosto);

		/** Try-lause k‰sittelem‰‰n poikkeukset */
		try {
			
			if (Oope2014HT.DEBUG) {
				Oope2014HT.DEBUG("Aiotaan tallentaa kirjasto tiedostoon "+tiedosto);
				for(int i = 0; i < this.kirjasto.koko(); i++)
					Oope2014HT.DEBUG(this.kirjasto.alkio(i).toString());
			} else {
				/** Alustetaan kirjoitin tiedoston perusteella */
				out = new PrintWriter(file);

				/** L‰pik‰yd‰‰n koko kirjasto */
				for(int i = 0; i < this.kirjasto.koko(); i++)
					/** Tulostetaan tiedostoon media-alkio merkkijonomuodossaan */
					out.println(this.kirjasto.alkio(i).toString());
			} 
		} /** Jos tiedosto on virheellinen */
		catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Virheellinen tiedosto");
		} /** Lopuksi suljetaan */
		finally {
			if (out != null) out.close();
		}
	}

}
