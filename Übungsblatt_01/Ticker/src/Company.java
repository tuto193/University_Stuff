
public class Company {

	// name der Company
	public static String name;

	// parameter für company
	//constructor
	public Company(String cName) {
		this.name = cName;
	}

	// getter
	public String getName(String string) {
		return this.name;
	}
	
	//Ausgabe Name + Preis
	public void changeStockPrice(double d) {
		Ticker.getInstance().print(this.name + d);

	}
	
	//Falls insolvent Ausgabe
	public void insolvent() {
		Ticker.getInstance().print(this.name + " ist insolvent");

	}
}
