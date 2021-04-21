import java.util.ArrayList;
import java.util.List;

public class AddressBookService {
    List<ContactPOJO> contactsList = new ArrayList<>();

    //main method
    public void addContact()
    {
        ContactPOJO contacts = new ContactPOJO();
        contacts.setFirstName("Kiran");
        contacts.setLastName("Kumar");
        contacts.setAddress("Near my home");
        contacts.setCity("My city");
        contacts.setState("My state");
        contacts.setPhoneNumber("+91 8688332960");
        contacts.setZip(102658);
        contacts.setEmail("mymail@gmail.com");
        AddressBookService addressBook = new AddressBookService();
        addressBook.contactsList.add(contacts);
        System.out.println(addressBook.contactsList);
    }
}
