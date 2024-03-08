package view;

import controller.UserController;
import model.User;
import util.Menu;

import java.util.Scanner;

public class View {
    private final static UserController userController = new UserController();
    public int option(){
        return new Scanner(System.in).nextInt();
    }
    public static int ui(){
        System.out.println("=".repeat(100));
        System.out.println("1. Display All Users");
        System.out.println("2. Create User ");
        System.out.println("3. Search User By ID");
        System.out.println("=".repeat(100));
        System.out.print("Insert Option: " );
        return new Scanner(System.in).nextInt();
    }
}
