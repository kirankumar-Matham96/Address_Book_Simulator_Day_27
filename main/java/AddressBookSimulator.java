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
                    if(!addressBookSimulator.isBookExists()){
                        addressBookSimulator.addBook();
                    } else {
                        System.out.println("Book already exists!");
                    }
                    break;
                case 2:
                    if(addressBookSimulator.isBookExists()) {
                        addressBookSimulator.accessBook();
                    } else {
                        System.out.println("Book doesn't exists!");
                    }
                    break;
                default:
                    isExit = true;
                    System.out.println("Thanks for using Address Book Simulator!");
                    addressBookSimulator.scannerForAddressBook.scannerProvider().close();//closing scanner
            }
        }
    }

    /**
     * checks if the book is exists?
     */
    public boolean isBookExists(){
        if(booksMap.containsKey(getNameOfBook())){
            return true;
        }
        return false;
    }

    /**
     * get the name of book
     */
    public String getNameOfBook(){
        System.out.println("Enter the name of the book");
        String bookName = scannerForAddressBook.scannerProvider().nextLine();
        return bookName;
    }

    /**
     * add new Book
     */
    public void addBook(){
        String bookName = getNameOfBook();
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
        Object bookName = getNameOfBook();
        if(addressBookSimulator.booksMap.containsKey(bookName)) {
            AddressBookService addressBookService = addressBookSimulator.booksMap.get(bookName);
            addressBookService.accessAddressBook();
            System.out.println("sorted contacts: "+addressBookSimulator.booksMap.toString());
        }
    }
}
