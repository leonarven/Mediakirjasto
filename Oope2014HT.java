package mediakirjasto;

import fi.uta.csjola.oope.In;
import mediakirjasto.mediatyyppi.*;

public class Oope2014HT {

	public static boolean DEBUG = true;

	public static void DEBUG(String str) {
		if (!Oope2014HT.DEBUG) return;
		System.out.println(str);
	}
	
	public static void DEBUG_STACK() {
		if (!Oope2014HT.DEBUG) return;
		try {
			throw new Exception();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public static void main(String ... args) {
		
		System.out.println("***************");
		System.out.println("* SOITTOLISTA *");
		System.out.println("***************");
		
		try {

			Mediakirjasto mediakirjasto = new Mediakirjasto(args[0], args[1]);
			
			boolean jatka = true;
			
			MediakirjastoKomento komento = null;
			
			do {
				
				komento = getKomento("Kirjoita komento:");
				
				if (komento == null) {
					System.out.println("Virhe!");
					continue;
				}
				
				Oope2014HT.DEBUG("Annettu komento "+komento+"("+komento.argv()+")");
				
				switch(komento) {
					case TULOSTAKIRJASTO:
						mediakirjasto.tulostaKirjasto();
						break;
					case LAJITTELEKIRJASTO:
						break;
					case TULOSTASOITTOLISTA:
						mediakirjasto.tulostaSoittolista();
						break;
					case LUOSOITTOLISTA:
						mediakirjasto.luoSoittolista(komento.argv());
						break;
					case TAYTASOITTOLISTA:
						mediakirjasto.taytaMedialla();
						break;
					case TALLENNA:
						mediakirjasto.tallennaKirjasto();
						mediakirjasto.tallennaSoittolista();
						break;
					case LATAA:
						mediakirjasto.lataaKirjasto();
						mediakirjasto.lataaSoittolista();
						break;
					case LOPETA:
						jatka = false;
						break;
					case LISAAMEDIA:
						mediakirjasto.lisaaMedia(komento.argv());
						break;
					case POISTAMEDIA:
						mediakirjasto.poistaMedia(komento.argv());
						break;
					default:
						System.out.println("Virhe!");
				}
				
			} while(jatka);
			
			System.out.println("Ohjelma lopetettu.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static MediakirjastoKomento getKomento(String str) {
		System.out.println(str);
		
		String komento = In.readString();
		
		MediakirjastoKomento cmd = MediakirjastoKomento.tunnistaKomento(komento);
		
		if (cmd == null) return null;

		try {
			if (cmd.argc()) {
				String argv_str = komento.substring(cmd.toString().length()+1);
				cmd.argv(Integer.parseInt(argv_str));
			}
		} catch(Exception e) {
			return null;
		}
		
		return cmd;
	}
}
