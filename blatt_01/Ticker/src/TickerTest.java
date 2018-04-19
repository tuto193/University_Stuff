
public class TickerTest {

    public static void main(String[] argv) {

        Company C = new Company("Apple ");
        for (int i = 1 ; i < 3; i++) {
            C.changeStockPrice(30 * i);
            Company D = new Company("SAP ");
        }
	    Company D = new Company("Microsoft");
	    D.insolvent();
    }
}
