import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter;

// New class #2: Class Payment
public class Payment {
    
    // Payment attributes ==================================
    private int paymentID;
    private double paymentAmount;
    private String paymentMethod;
    private boolean paymentStatus;
    private static int paymentCounterID = 5000; 

    // Attribute untuk payment summary
    private int roomType;
    private int numDays;
    private int numRooms;
    private int customerType; // 1 - individu, 2 - corporate
    boolean isLocal;


    // Default constructor ==================================
    public Payment(){
        this.paymentID = paymentCounterID++;
        this.paymentAmount = 0.0;
        this.paymentMethod = "";
        this.paymentStatus = false;
    }

    // Normal constructor ==================================
    // 1. payment method untuk individual
    public Payment(double paymentAmount, String paymentMethod,
                   int customerType, int roomType,
                   int numDays, int numRooms,
                   boolean isLocal){
        
        this.paymentID = paymentCounterID++;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = false;
        this.customerType = customerType;
        this.roomType = roomType;
        this.numDays = numDays;
        this.numRooms = numRooms;
        this.isLocal = isLocal;
    }

    // 2. payment method untuk corporate
    public Payment(double paymentAmount, String paymentMethod,
                   int customerType, int roomType,
                   int numDays, int numRooms){
        
        this.paymentID = paymentCounterID++;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = false;
        this.customerType = customerType;
        this.roomType = roomType;
        this.numDays = numDays;
        this.numRooms = numRooms;
    }

    // Payment method
    //==================================

    // Tukar status pembayaran selepas bayar
    public void updatePaymentStatus(){
        paymentStatus = true;
        System.out.println("Payment Successful!");
    }

    // Untuk semak status pembayaran
    public boolean isPaid(){
        return paymentStatus;
    }

    // Save to file method
    //==================================

    // Simpan data ke dalam file
    public void savePayToFile(){
        try(FileWriter writer = new FileWriter("paymentRecord.txt", true)){
            writer.write("   INVOICE FOR " + paymentID);
            writer.write("============================================");
            writer.write("Payment ID     : " + paymentID);
            writer.write("Customer Type  : " + (customerType == 1 ? "Individual" : "Corporate"));
            writer.write("Room Type      : " + roomType);
            writer.write("Days           : " + numDays);
            writer.write("Rooms          : " + numRooms);
            writer.write("Amount (RM)    : " + paymentAmount);
            writer.write("Method         : " + paymentMethod);
            writer.write("Status         : " + (paymentStatus ? "Paid" : "Not Paid"));
            writer.write("------------------------------------");
        } catch(IOException e) {
            System.out.println("Error writing payment record into file.");
        }
    }

    // Display payment info ==================================
    public void displayPaymentInfo() {

        Room room = new Room();
        double basePrice = room.getPrice(roomType - 1);

        // START from base total
        double baseAmount = basePrice * numDays * numRooms;
        System.out.println("\n============================================");
        System.out.println("                BILL SUMMARY                ");
        System.out.println("============================================");
        System.out.println("Payment ID     : " + paymentID);
        System.out.println("Customer type  : " + (customerType == 1 ? "Individual" : "Corporate"));
        System.out.println("Room Type      : " + roomType);
        System.out.println("Number of Days : " + numDays);
        System.out.println("Number of Rooms: " + numRooms);
        System.out.println("--------------------------------------------");
        System.out.println("Base Price (RM): " + baseAmount);
        if(customerType == 1){
            System.out.println("Discount applied! 10% off for individual");
            if(isLocal){
                System.out.println("Discount applied! 5% off for local citizen.");
            }
        } else if(customerType == 2){
            System.out.println("Discount applied! 20% off for corporate");
        }
        System.out.println("Final Amount after discount (RM): " + paymentAmount);
        System.out.println("Payment Method : " + paymentMethod);
        System.out.println("Status         : " + (paymentStatus ? "Paid" : "Not Paid"));
        System.out.println("============================================");
    }
}

