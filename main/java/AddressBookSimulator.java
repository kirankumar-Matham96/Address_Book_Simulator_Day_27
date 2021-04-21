import java.util.HashMap;
import java.util.Map;

public class AddressBookSimulator {
    static AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
    private Map<Object, AddressBookService> booksMap = new HashMap<>();

    public static void main(String[] args) {


        System.out.println("Welcome to address book simulator!");

        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Exit");
            int option = addressBookSimulator.scannerForAddressBook.scannerProvider().nextInt();
            switch(option) {
                case 1:
                    addressBookSimulator.addBook();
                    break;
                case 2:
                    addressBookSimulator.accessBook();
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    addressBookSimulator.scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
    }

    /**
     * add new Book
     */
    public void addBook(){
        System.out.println("Enter the name of new book");
        String bookName = scannerForAddressBook.scannerProvider().nextLine();
        if(addressBookSimulator.booksMap.containsKey(bookName)){
            System.out.println("Book already exists!");
        } else {
            addressBookSimulator.booksMap.put(bookName, new AddressBookService());
        }
    }

    /**
     * Access existing Book
     */
    public void accessBook(){
        System.out.println("Enter the name of the book to access it");
        Object bookName1 = scannerForAddressBook.scannerProvider().nextLine();
        if(addressBookSimulator.booksMap.containsKey(bookName1)) {
            AddressBookService addressBookService = addressBookSimulator.booksMap.get(bookName1);
            addressBookService.accessAddressBook();
            System.out.println("sorted contacts: "+addressBookSimulator.booksMap.toString());
        }
    }
}
