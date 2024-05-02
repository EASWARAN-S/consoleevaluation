package lift;

import java.util.List;

import dataLayer.LiftDatabase;

public class LiftModel {

    private LiftView liftView;

    public LiftModel(LiftView liftView) {
        this.liftView = liftView;
    }

    public void addLift(int lift, int floor) {
        LiftDatabase.getInstance().addLift(lift, floor);
    }

    public int[] getLift() {
        return LiftDatabase.getInstance().getAllLiftCurrentPosition();
    }

    public String[] getLiftName() {
        return LiftDatabase.getInstance().getAllLiftName();
    }

    public boolean assignMaintanence(List<String> liftName) {
        return LiftDatabase.getInstance().assignMaintanence(liftName);
    }

    public void AddLiftcapacity(String liftname, int capacity) {
        LiftDatabase.getInstance().setLiftCapacity(liftname, capacity);
    }

    public int[] getFloorDetails() {
        return LiftDatabase.getInstance().getAllFloorNumber();
    }

    public boolean addLiftStops(String liftName, int startStop, int endStop) {
        return LiftDatabase.getInstance().addLiftStops(liftName, startStop, endStop);
    }

    public String assignFloorToUser(int currentFloor, int destinationFloor, int noOfPeople) {
        return LiftDatabase.getInstance().assignFloorToUser(currentFloor, destinationFloor, noOfPeople);
    }

}