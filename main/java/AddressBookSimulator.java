import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSimulator {
    static AddressBookSimulator addressBookSimulator = new AddressBookSimulator();
    ScannerForAddressBook scannerForAddressBook = new ScannerForAddressBook();
    private Map<String, AddressBookService> booksMap = new HashMap<>();
    private Map<String, List<List<ContactPOJO>>> cityPersonMap = new HashMap<>();
    private Map<String, List<List<ContactPOJO>>> statePersonMap = new HashMap<>();

    public static void main(String[] args) {


        System.out.println("Welcome to address book simulator!");

        boolean isExit = false;
        while(!isExit) {
            System.out.println("Select options: \n1.Add Book\n2.AccessBook\n3.Search contact by city/state\n" +
                                                  "4.Show the contacts by city\n5.Show the contacts by state\n" +
                                                  "6.Find number of contacts in a city/state\n7.Exit");
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
                case 3:
                    addressBookSimulator.searchContactByCityOrState();
                    break;
                case 4:
                    addressBookSimulator.showContactsByCity();
                    break;
                case 5:
                    addressBookSimulator.showContactByState();
                    break;
                case 6:
                    addressBookSimulator.countContactsByCityOrState();
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
     * Search contact by city/state
     */
    public void searchContactByCityOrState(){
        System.out.println("Enter the city/state name to search contact");
        String placeName = scannerForAddressBook.scannerProvider().nextLine();
        addressBookSimulator.booksMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getContactsList().stream()
                    .filter(contact -> contact.getCity().equals(placeName) ||
                            contact.getState().equals(placeName))
                    .findFirst().orElse(null));
        });
    }

    /**
     * Show the contacts by city
     */
    public void showContactsByCity(){
        System.out.println("Enter the city name to search contacts");
        String city = scannerForAddressBook.scannerProvider().nextLine();
        List<List<ContactPOJO>> listOfCityContactsList = new ArrayList<>();
        List<ContactPOJO> cityContactList;
        for(Map.Entry<String, AddressBookService> entry : addressBookSimulator.booksMap.entrySet()) {
            cityContactList = entry.getValue().getContactsList().stream()
                    .filter(contact ->
                            contact.getCity().equals(city))
                    .collect(Collectors.toList());
            listOfCityContactsList.add(cityContactList);
        }
        addressBookSimulator.cityPersonMap.put(city,listOfCityContactsList);
        System.out.println(addressBookSimulator.cityPersonMap);
    }

    /**
     * Show the contacts by state
     */
    public void showContactByState(){
        System.out.println("Enter the state name to search contacts");
        String state = scannerForAddressBook.scannerProvider().nextLine();
        List<List<ContactPOJO>> listOfStateContactsList = new ArrayList<>();
        List<ContactPOJO> stateContactList;
        for (Map.Entry<String, AddressBookService> entry : addressBookSimulator.booksMap.entrySet()) {
            stateContactList = entry.getValue().getContactsList().stream()
                    .filter(contact ->
                            contact.getState().equals(state))
                    .collect(Collectors.toList());
            listOfStateContactsList.add(stateContactList);
        }
        addressBookSimulator.statePersonMap.put(state,listOfStateContactsList);
        System.out.println(addressBookSimulator.statePersonMap);
    }

    /**
     * Find number of contacts in a city/state
     */
    public void countContactsByCityOrState(){
        System.out.println("Enter the city/state name to search number of contacts");
        String placeName2 = scannerForAddressBook.scannerProvider().nextLine();
        addressBookSimulator.booksMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println("Contacts in a city/state: " +
                    entry.getValue()
                            .getContactsList().stream()
                            .filter(contact -> contact.getCity().equals(placeName2) ||
                                    contact.getState().equals(placeName2))
                            .count());
        });
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
