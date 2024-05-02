package model;

public class Floor {
    private String floorName;
    private int floor;

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Floor(String floorName, int floor) {
        this.floorName = floorName;
        this.floor = floor;
    }

}