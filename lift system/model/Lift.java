package model;

import java.util.ArrayList;
import java.util.List;

public class Lift {
    private String liftName;
    private int currentFloor;
    private int destinationFloor;
    private int isMaintanence;
    private int isAssigned;
    private int capacity;
    private List<Integer> accessingFloor = new ArrayList<>();

    public List<Integer> getAccessingFloor() {
        return this.accessingFloor;
    }

    public void setAccessingFloor(List<Integer> accessingFloor) {
        this.accessingFloor = accessingFloor;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Lift(String liftName, int currentFloor, int destinationFloor, int isMaintanence, int isAssigned) {
        this.liftName = liftName;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.isMaintanence = isMaintanence;
        this.isAssigned = isAssigned;
        this.capacity = 20;
    }

    public String getLiftName() {
        return this.liftName;
    }

    public void setLiftName(String liftName) {
        this.liftName = liftName;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getIsMaintanence() {
        return this.isMaintanence;
    }

    public void setIsMaintanence(int isMaintanence) {
        this.isMaintanence = isMaintanence;
    }

    public int getIsAssigned() {
        return this.isAssigned;
    }

    public void setIsAssigned(int isAssigned) {
        this.isAssigned = isAssigned;
    }

}
