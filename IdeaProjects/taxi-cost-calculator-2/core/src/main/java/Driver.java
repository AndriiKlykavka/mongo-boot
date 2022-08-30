public class Driver {
    private String name;
    private String car;
    private float rating;
    private float getCostPerKm; /*in €*/

    public Driver(String name, String car, float rating, float taxiPerKm) {
        this.name = name;
        this.car = car;
        this.rating = rating;
        this.getCostPerKm = taxiPerKm;
    }

    public float getCostPerKm() {
        return getCostPerKm;
    }

    public void setCostPerKm(int taxiPerKm) {
        this.getCostPerKm = taxiPerKm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void takeOrder(Order order) {
        order.setOrderTaken(true);
    }

    public float getCost(Order order) {
        return order.getDistance() * getCostPerKm();
    }
}
