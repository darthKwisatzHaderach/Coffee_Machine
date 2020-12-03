package machine;

public class Beverage {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cost;

    Beverage(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    Beverage(int water, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = 0;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return cost;
    }
}
