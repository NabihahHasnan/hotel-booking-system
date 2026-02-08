import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//New class #2: Book
public class Booking_Record {
    // Booking record attributes
    //==================================
    private int bookingID;
    private static int bookingIDcounter = 3000;
    double totalPrice;
    String customerName;
    int customerType;
    int roomType, numDays, numRooms;
    String companyName;
    String companyRegNo;
    String contactPerson;
    long phone;
    int numberOfEmployees;

    // Default constructor
    //==================================
    public Booking_Record(){
        this.bookingID = bookingIDcounter++;
    }
    
    // Normal constructor
    //==================================
    // 1. untuk individual
    public Booking_Record(String customerName, int customerType,
                         int roomType, int numDays, int numRooms,
                         double totalAmount) {
        this.bookingID = bookingIDcounter++;
        this.customerName = customerName;
        this.customerType = customerType;
        this.roomType = roomType;
        this.numDays = numDays;
        this.numRooms = numRooms;
        this.totalPrice = totalAmount;
    }
    // 2. untuk company
    public Booking_Record(int customerType, String companyName,
                         String contactPerson, int roomType, 
                         int numDays, int numRooms, double totalAmount) {
        this.bookingID = bookingIDcounter++;
        this.customerType = customerType;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.roomType = roomType;
        this.numDays = numDays;
        this.numRooms = numRooms;
        this.totalPrice = totalAmount; 
    }

    // Getter
    //==================================
    public int getRoomType() {
        return roomType;
    }

    public int getNumDays() {
        return numDays;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Save booking to file
    //==================================
    public void saveBookToFile(){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("bookingRecord.txt", true));
            writer.println("Booking ID   : " + bookingID);
            writer.println("Customer     : " + customerName);
            writer.println("Customer Type: " + (customerType == 1 ? "Individual" : "Corporate"));
            writer.println("Room Type    : " + roomType);
            writer.println("Days         : " + numDays);
            writer.println("Rooms        : " + numRooms);
            writer.println("Total (RM)   : " + totalPrice);
            writer.println("----------------------------------");
            writer.close();
        } catch(IOException e){
            System.out.println("Error writing booking file.");
        }
    }
}
