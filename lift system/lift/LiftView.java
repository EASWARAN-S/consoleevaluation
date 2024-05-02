package lift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiftView {
    private LiftModel liftModel;

    public LiftView() {
        liftModel = new LiftModel(this);
    }

    Scanner sc = new Scanner(System.in);

    public void init() {

        System.out.println(
                "ENter your choice \n1.Add Lift and Floors \n2. Display Position of Lift \n3. Add Maintenance Lift \n 4. Add Capacity \n 5. Add Floor Access to Lift \n 6. Assign Floor to User");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addLift();
                break;
            case 2:
                displayLiftPosition();
                break;
            case 3:
                addMaintanenceLift();
                break;
            case 4:
                addLiftcapacity();
                break;
            case 5:
                addFloorAccess();
                break;
            case 6:
                assignFloorToUser();
                break;
            default:
                System.out.println("Invalid code");
                init();
                break;
        }
    }

    private void assignFloorToUser() {
        showAlert("Enter the current Floor ");
        int currentFloor = sc.nextInt();
        showAlert("Enter the Destination Floor ");
        int destinationFloor = sc.nextInt();
        showAlert("Enter number People to travel in the lift");
        int noOfPeople = sc.nextInt();
        showAlert(liftModel.assignFloorToUser(currentFloor, destinationFloor, noOfPeople));
    }

    private void addFloorAccess() {
        showAlert("All Floor Has access to the zeroth or Ground Floor");
        int floorName = liftModel.getFloorDetails().length;
        int[] floors = liftModel.getFloorDetails();
        showAlert("Floor number start from " + floors[0] + " to " + floors[floorName - 1]);
        int noOfLifts = liftModel.getLiftName().length;
        String[] liftName = liftModel.getLiftName();
        for (int k = 0; k < noOfLifts; k++) {
            showAlert("Enter the Stopings  for  " + liftName[k]);
            showAlert("Enter the Starting stop and Ending Floor Stop one by one except zero");
            int startStop = sc.nextInt();
            int endStop = sc.nextInt();
            if (liftModel.addLiftStops(liftName[k], startStop, endStop)) {
                showAlert("Added Succefully");
            } else {
                showAlert("Start stop  is greater than end stop please re enter  for " + liftName[k]);
                k = k - 1;
                continue;
            }
        }
        init();

    }

    private void addLiftcapacity() {
        String[] lift = liftModel.getLiftName();
        if (lift.length != 0) {
            showAlert("Add the Capacity one by one");
            for (int k = 0; k < lift.length; k++) {
                showAlert("Enter the capacity for" + lift[k]);
                int capacity = sc.nextInt();
                liftModel.AddLiftcapacity(lift[k], capacity);
            }

        }

        else {
            showAlert("Add Lift First");
            init();
        }
        showAlert("Capacity added Success fully");
        init();

    }

    private void addMaintanenceLift() {
        System.out.println("Choose  the Lift Name Which is under maintanence");
        String[] lift = liftModel.getLiftName();
        if (lift.length != 0) {
            System.out.print("\nLift : ");
            for (int i = 0; i < lift.length; i++) {
                System.out.print("L" + (i + 1) + "\t");
            }
            showAlert("How Many Lifts are under maintanence...");
            int length = sc.nextInt();
            sc.nextLine();
            showAlert("Enter the Lift name one by one");
            List<String> liftName = new ArrayList<>();
            String userInput = sc.nextLine();
            for (int i = 0; i < lift.length; i++) {
                if (userInput.equalsIgnoreCase(lift[i])) {
                    liftName.add(userInput);
                }
            }

            if (liftModel.assignMaintanence(liftName)) {
                showAlert("Updated Successfully");
                init();
            } else {
                showAlert(" Not Updated Successfully");
                addMaintanenceLift();
            }
        }

        else {
            showAlert("Add Lift First");
            init();
        }

    }

    private void addLift() {
        System.out.println("Enter the number of lifts");
        int lift = sc.nextInt();
        System.out.println("Enter the number of floors");
        int floor = sc.nextInt();
        liftModel.addLift(lift, floor);
        init();
    }

    private void displayLiftPosition() {

        int[] lift = liftModel.getLift();
        if (lift.length != 0) {
            System.out.print("\nLift : ");
            for (int i = 0; i < lift.length; i++) {
                System.out.print("L" + (i + 1) + "\t");
            }
            System.out.print("\nFloor : ");
            for (int i = 0; i < lift.length; i++) {
                System.out.print(lift[i] + "\t");
            }
            System.out.println("\n");
        } else {
            showAlert("Please add Lift and Floors First  No Lift is found");
        }

        init();
    }

    public void showAlert(String alertMsg) {
        System.out.println(alertMsg);
    }
}
