public class CostCalculator {

    private double patrolCost; /*€ per litter*/
    private double distance;   /*in km*/
    private double carConsumption; /*litters per 100km*/
    private double markup; /*in %*/

    public CostCalculator(double patrolCost, double distance, double carConsumption, double markup) {
        this.patrolCost = patrolCost;
        this.distance = distance;
        this.carConsumption = carConsumption / 100; /*Making consumption in litters per 1 km*/
        this.markup = markup;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public double getPatrolCost() {
        return patrolCost;
    }

    public void setPatrolCost(int patrolCost) {
        this.patrolCost = patrolCost;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getCarConsumption() {
        return carConsumption;
    }

    public void setCarConsumption(int carConsumption) {
        this.carConsumption = carConsumption;
    }

    public double calculateCost() { /*in €*/
        return (getPatrolCost() * getCarConsumption() * getDistance()) * ((100 + getMarkup()) * 0.01) ;
    }
}
