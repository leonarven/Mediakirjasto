package mediakirjasto;

import fi.uta.csjola.oope.In;

/**
 * Ajoluokka, sisältää arvot debuggauksesta, käsittelee käyttäjien syötteet ja komentelee Mediakirjasto:a
 * 
 * @author Miro Nieminen (leonarven+oope@gmail.com), op 98297
 * @version 140317
 */
public class Oope2014HT {

	public static boolean DEBUG = true;

	public static void DEBUG(String str) {
		if (!Oope2014HT.DEBUG) return;
		System.out.println("DEBUG :: "+str);
	}

	public static void DEBUG(Exception e) {
		if (!Oope2014HT.DEBUG) return;
		System.out.println("DEBUG :: ");
		e.printStackTrace();
	}

	public static void DEBUG_STACK() {
		if (!Oope2014HT.DEBUG) return;
		System.out.print("DEBUG :: ");
		try { throw new Exception();
		} catch(Exception e) { Oope2014HT.DEBUG(e); }
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
				
				
				try {

					if (komento == null) throw new NullPointerException();
					
					Oope2014HT.DEBUG("Annettu komento "+komento+"("+komento.argv()+")");
					
					switch(komento) {
						case TULOSTAKIRJASTO: // DONE
							mediakirjasto.tulostaKirjasto();
							break;
						case LAJITTELEKIRJASTO:
							mediakirjasto.lajitteleKirjasto(komento.argv());
							break;
						case TULOSTASOITTOLISTA: // DONE
							mediakirjasto.tulostaSoittolista();
							break;
						case LUOSOITTOLISTA: // DONE
							mediakirjasto.luoSoittolista(Integer.parseInt(komento.argv()));
							break;
						case TAYTASOITTOLISTA:
							mediakirjasto.taytaMedialla();
							break;
						case TALLENNA:
							mediakirjasto.tallennaKirjasto();
							mediakirjasto.tallennaSoittolista();
							break;
						case LATAA: // DONE
							mediakirjasto.lataaKirjasto();
							mediakirjasto.lataaSoittolista();
							break;
						case LOPETA: // DONE
							jatka = false;
							break;
						case LISAAMEDIA:
							mediakirjasto.lisaaMedia(Integer.parseInt(komento.argv()));
							break;
						case POISTAMEDIA: // DONE
							mediakirjasto.poistaMedia(Integer.parseInt(komento.argv()));
							break;
						default:
							throw new NullPointerException();
					}
					
				} catch(Exception e) {
					System.out.println("Virhe!");
					DEBUG(e);
					continue;
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
			if (cmd.argc())
				cmd.argv(komento.substring(cmd.toString().length()+1));
		} catch(Exception e) {
			return null;
		}
		
		return cmd;
	}
}
