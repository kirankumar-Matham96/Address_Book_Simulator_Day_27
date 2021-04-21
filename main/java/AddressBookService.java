import java.util.ArrayList;
import java.util.List;

/**
 * Program to simulate AddressBook
 */
public class AddressBookService {
    List<ContactPOJO> contactsList = new ArrayList<>();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();

    /**
     * method to add new contact from the console
     */
    public void addContact() {
        ContactPOJO contacts = new ContactPOJO();
        System.out.println("Please enter first name");
        contacts.setFirstName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter last name");
        contacts.setLastName(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter address");
        contacts.setAddress(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter city");
        contacts.setCity(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter state");
        contacts.setState(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter email");
        contacts.setEmail(scannerForAddressBook.scannerProvider().nextLine());
        System.out.println("Please enter zip");
        contacts.setZip(scannerForAddressBook.scannerProvider().nextInt());
        System.out.println("Please enter phone number");
        contacts.setPhoneNumber(scannerForAddressBook.scannerProvider().nextLine());
        contactsList.add(contacts);
        System.out.println(contactsList);
    }
}
