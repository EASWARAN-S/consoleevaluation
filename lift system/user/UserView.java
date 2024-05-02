package user;

import java.util.Scanner;

import lift.LiftView;

public class UserView {
    private UserModel userModel;

    public UserView() {
        userModel = new UserModel(this);
    }

    Scanner sc = new Scanner(System.in);

    public void init() {

        System.out.println("ENter your choice \n1. Lift Operations \n2. Logout ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                LiftView liftView = new LiftView();
                liftView.init();

                break;
            case 2:
                System.out.println("Thank You For Using Lift System");

                break;
            default:
                System.out.println("Invalid code");
                init();
                break;
        }
    }

    private void mainMenu() {
        System.out.println("This site is under construction");
    }

}
