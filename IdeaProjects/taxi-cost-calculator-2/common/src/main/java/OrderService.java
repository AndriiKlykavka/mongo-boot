
public class OrderService {
    public static void main(String[] args) {

        Driver driverJim = new Driver("Jim Raynor", "Toyota Camry Hybrid", 4.5f, 1.6f);
        Order order1 = new Order("Nancy", "Winston st.", "Square of Time", 28.9f);

        driverJim.getCost(order1);
    }

}
