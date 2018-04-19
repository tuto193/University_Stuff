
public class Ticker {

	 // Eine (versteckte) Klassenvariable vom Typ der eigene Klasse
	//börsenticker Instanz
	  private static Ticker börsenticker;
	  // Verhindere die Erzeugung des Objektes über andere Methoden
	  private Ticker() {}

	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes
	  // Objekt erzeugt und dieses zurückliefert.
	  // nur ein Objekt kann man erzeugen!
	  // static damit wir nicht nur auf methoden sondern auch auf Klassen aufrufbar
	  public static Ticker getInstance() {
	    if (Ticker.börsenticker == null) {
	      Ticker.börsenticker = new Ticker();
	    }
	    return Ticker.börsenticker;
	  }

	  // %s Platzhalter fuer den String
	  // \n new line
	  public void print(String text) {
		   String ausgabe=text.replaceAll("\n", "");

		    System.out.printf(" %s +++", ausgabe);
	  }
	}
