public class AddressBookSimulator {
    public static void main(String[] args) {
        System.out.println("Welcome to address book simulator program!");
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.addContact();
    }
}
