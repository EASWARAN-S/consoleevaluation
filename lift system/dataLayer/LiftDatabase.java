package dataLayer;

import java.util.ArrayList;
import java.util.List;
import model.Floor;
import model.Lift;

public class LiftDatabase {
    private static LiftDatabase liftDb;
    List<Lift> ls = new ArrayList();
    List<Floor> floorList = new ArrayList();

    public static LiftDatabase getInstance() {
        if (liftDb == null) {
            liftDb = new LiftDatabase();
        }
        return liftDb;
    }

    public void addLift(int lift, int floor) {

        for (int i = 1; i <= lift; i++) {
            String liftName = "L" + i;
            Lift l1 = new Lift(liftName, 0, 0, 0, 0);
            ls.add(l1);
        }

        for (int i = 1; i <= floor; i++) {
            String floorName = "F" + i;
            Floor f1 = new Floor(floorName, i);
            floorList.add(f1);
        }
    }

    public int[] getAllLiftCurrentPosition() {
        int[] currentPosAllLift = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            currentPosAllLift[i] = ls.get(i).getCurrentFloor();
        return currentPosAllLift;
    }

    public String[] getAllLiftName() {
        String[] allLiftName = new String[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            allLiftName[i] = ls.get(i).getLiftName();
        return allLiftName;
    }

    public boolean assignMaintanence(List<String> liftName) {
        try {
            for (int i = 0; i < liftName.size(); i++) {
                for (int j = 0; j < ls.size(); j++) {
                    if (ls.get(j).getLiftName().equalsIgnoreCase(liftName.get(i))) {
                        ls.get(i).setIsMaintanence(-1);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setLiftCapacity(String liftname, int capacity) {
        for (int j = 0; j < ls.size(); j++) {
            if (ls.get(j).getLiftName().equalsIgnoreCase(liftname)) {
                ls.get(j).setCapacity(capacity);
            }
        }
    }

    public int[] getAllFloorNumber() {
        int[] floor = new int[floorList.size()];
        for (int k = 0; k < floorList.size(); k++) {
            floor[k] = floorList.get(k).getFloor();
        }
        return floor;
    }

    public boolean addLiftStops(String liftName, int startStop, int endStop) {
        if (startStop > endStop) {
            return false;
        }
        List<Integer> accessingFloor = new ArrayList<>();
        for (int j = 0; j < ls.size(); j++) {
            if (ls.get(j).getLiftName().equalsIgnoreCase(liftName)) {
                accessingFloor.add(0);
                for (int i = startStop; i <= endStop; i++) {

                    accessingFloor.add(i);
                }
                ls.get(j).setAccessingFloor(accessingFloor);
            }
        }
        return true;
    }

    public String assignFloorToUser(int currentFloor, int destinationFloor, int noOfPeople) {
        List<String> lsName = new ArrayList();
        // Checking Lift Capacity and adding the Lift Name
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getCapacity() >= noOfPeople) {
                lsName.add(ls.get(i).getLiftName());

            }
        }
        // Checking whether Available Lift is under maintenance if so remove it from the
        // List
        for (int k = 0; k < lsName.size(); k++) {
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).getLiftName().equals(lsName.get(k))) {
                    if (ls.get(i).getIsMaintanence() < 0) {
                        lsName.remove(k);
                        break;
                    }

                }
            }
        }

        // Checking Whether the Destination Floor is accessed by the Lifts

        for (int k = 0; k < lsName.size(); k++) {
            boolean isStop = false;
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).getLiftName().equals(lsName.get(k))) {
                    for (int l = 0; l < ls.get(i).getAccessingFloor().size(); l++) {
                        if (ls.get(i).getAccessingFloor().get(l) == destinationFloor) {
                            isStop = true;
                        }
                    }

                }
            }
            if (!isStop) {
                lsName.remove(k);
            }
        }
        // checking whether the lift is less than or equal to the current Floor
        for (int k = 0; k < lsName.size(); k++) {
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).getLiftName().equals(lsName.get(k))) {
                    if (ls.get(i).getCurrentFloor() > currentFloor)
                        lsName.remove(k);
                }
            }
        }

        if (lsName.size() == 0)
            return "zero Lift Available ";
        for (int m = 0; m < lsName.size(); m++)
            System.out.println(lsName.get(m));
        return (lsName.get(0) + "is Assigned");
    }

}