public class Main {

    public static void main(String[] args) {
        CostCalculator costCalculator = new CostCalculator(1.72, 30.3, 9.5, 110);
        System.out.println(costCalculator.calculateCost());
    }
}
