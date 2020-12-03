package machine;

public class Cappuccino extends Beverage {
    private static final int water = 200;
    private static final int milk = 100;
    private static final int coffeeBeans = 12;
    private static final int cost = 6;

    Cappuccino() {
        super(water, milk, coffeeBeans, cost);
    }
}
