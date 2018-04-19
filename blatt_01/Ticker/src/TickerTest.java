
public class TickerTest {

    public static void main(String[] argv) {

        Company C = new Company("Apple ");
        Company A = new Company("SAP ");
        Company D = new Company("Microsoft");
        C.changeStockPrice(30 * 2);
        A.changeStockPrice(50);

	    D.insolvent();
    }
}
