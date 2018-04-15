
public class Company {

	// name der Company
	private String name;
	private double stock;

	// parameter f�r company
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
		this.stock += d;
		Ticker.getInstance().print(this.name + this.stock);

	}

	//Falls insolvent Ausgabe
	public void insolvent() {
		Ticker.getInstance().print(this.name + " ist insolvent");

	}
}
