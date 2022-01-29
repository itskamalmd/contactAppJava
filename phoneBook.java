import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;
public class phoneBook {
    // creating HashMap for contacts in which String(contact name) is a Key and the value is contact object
    private HashMap<String,Contact> contacts = new HashMap<>();
    Scanner in = new Scanner(System.in);

    // createContact method created a contact and returns the created contact 
    public Contact createContact(){
        System.out.println("Enter the contact name");
        String name = in.nextLine();
        String number ;
        String mailId ;
        if (contacts.containsKey(name)){
            System.out.println("this contact name has been already created");
            return null;
        }
        else {
        // Using nextline() method cuz of next() methods doesnt move the cursor,that causes skipping of input
        System.out.println("Enter the contactNumber");
        number = in.nextLine().split(" ")[0];// getting a line input ,but storing only the first word before spaces, this moves the cursor to nextLine
        System.out.println("Enter the mail id");
        mailId = in.nextLine().split(" ")[0];
        System.out.println("Contact created succesfully!\n");
        }
        return contacts.put(name,new Contact(name,number,mailId)); 
    }
    // get contact inputs a name and finds the contacts thorough the contacts hashmap and return the contact
    public Contact findContact(){
        System.out.println("Enter the contact name");
        String name = in.nextLine();
        return contacts.get(name);
    }
    // detetes a contact and return the deleted contact 
    public Contact deleteContact(){
        System.out.println("Enter the contact name to be removed");
        String name = in.nextLine();
        if (contacts.containsKey(name)){
            System.out.println("Contact deleted succesfully!\n");
            return contacts.remove(name);
        }
        else {
            System.out.println("No contact found\n");
        }
        return null;
    }
    public void listContacts(){
        System.out.println("{");
        for (String contactKey : contacts.keySet()){
            System.out.println("\t"+contacts.get(contactKey));
        }
        System.out.println("}\n");
    }
    public void editContact(){
        //gettin old contact name to edit 
        System.out.println("Enter the contact name to Edit");
        String previousName = in.nextLine();
        // Storing the currently working contact in contact varaible 
        Contact contact = contacts.get(previousName);
        String name = "";
        String number = "";
        String mailId = "";

        if (contacts.containsKey(previousName)){
            // geting new details to update
            System.out.println("Enter hyphen(-) on the fields to maintain previous value");
            System.out.println("Enter the new contact name");
            name = in.nextLine();
            System.out.println("Enter the new contact Number");
            number = in.nextLine().split(" ")[0];
            System.out.println("Enter the new mail id");
            mailId = in.nextLine().split(" ")[0];


            if (previousName.compareTo(name) == 0 || name.equals("-")){
                // the name of the contact same , so we can set the new values
                // if the new values are diffrent , changing it wiht setName
                // if the value entered is "-" then no change is made as the used want to maintain the old value
                if (!number.equals("-")){
                    contact.setNumber(number);
                }
                if (!mailId.equals("-")){
                    contact.setMailId(mailId);
                }
                
            }
            else {
                // here the contact name gets changed as name being the key,clswe have to create a new key
                contacts.put(
                    name,contact.editContact(name.equals("-") ?  contact.getName() : name,
                                            number.equals("-") ? contact.getNumber() : number,
                                            mailId.equals("-") ? contact.getMailId() : mailId)
                                            );
                contacts.remove(previousName);
            }
            System.out.println("contact updated!\n");
        }
        else if (!contacts.containsKey(previousName)){
            System.out.println("No contact found \n");
        }
    }
}
