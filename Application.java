import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        phoneBook myBook = new phoneBook();
        Scanner in = new Scanner(System.in);
        char option = ' '; 
        while( option != 'x' || option != 'X'){
            System.out.println("(A) to add a contact");
            System.out.println("(E) to edit a contact");
            System.out.println("(D) to delete a contact");
            System.out.println("(l) list all contact");
            System.out.println("(X) to exit the app");
        
            // getting input
            System.out.println("\nEnter an option");
            option = in.nextLine().charAt(0);

            if (option == 'A' || option == 'a'){
                myBook.createContact();
            }
            else if (option == 'E' || option == 'e'){
                myBook.editContact();
            }
            else if(option == 'D' || option == 'd'){
                myBook.deleteContact();
            }
            else if(option == 'L' || option == 'l'){
                myBook.listContacts();
            }
            else if(option == 'X' || option == 'x'){
                break;
            }
            else {
                System.out.println("Undefined Option");
            }
        }
    }
}
