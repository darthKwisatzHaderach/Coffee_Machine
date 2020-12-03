package machine;

public class Espresso extends Beverage {
    private static final int water = 250;
    private static final int coffeeBeans = 16;
    private static final int cost = 4;

    Espresso() {
        super(water, coffeeBeans, cost);
    }
}
