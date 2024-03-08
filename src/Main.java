import controller.UserController;
import repository.UserRepository;
import util.Menu;
import view.View;

import java.util.Scanner;

public class Main {
    private final static UserController userController = new UserController();
    public static void main(String[] args) {
        Menu.displayMenu();
        while (true){
            switch (View.ui()){
                case 1 -> {
                    userController.getAllUsers().forEach(System.out::println);
                }
                case 2->{
                    userController.createUser();
                }
                case 3->{
                    System.out.print("Insert ID : ");
                    System.out.println(userController.searchById(new Scanner(System.in).nextInt()));
                }
                case 6 -> {
                    System.exit(0);
                }
            }
        }
    }
}