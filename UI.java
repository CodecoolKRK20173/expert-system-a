import java.util.InputMismatchException;
import java.util.Scanner;

public class UI{

    public static String getUserInput(){
        
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Enter your answer ");
        return scanner.nextLine();
    }

    public static void displayMessage(String message){

        System.out.println("Perfect firearm for you is: " + message);
    }
}