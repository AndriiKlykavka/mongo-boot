public class Order {
    private String name;
    private String startPoint;
    private String finishPoint;
    private float distance; /*in km*/
    private boolean orderTaken = false;
    public Order(String name, String startPoint, String finishPoint, float distance) {
        this.name = name;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
        this.distance = distance;
    }


    public boolean isOrderTaken() {
        return orderTaken;
    }

    public void setOrderTaken(boolean orderTaken) {
        this.orderTaken = orderTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(String finishPoint) {
        this.finishPoint = finishPoint;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
