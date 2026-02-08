import java.util.Scanner;

/**
 * NAME         : SITI NABIHAH BINTI HASNAN
 * STUDENT ID   : 2024689728
 * PROJECT NAME : HOTEL BOOKING SYSTEM
 */
public class Booking_System {
    Individual ind;
    Corporate cor;
    Booking_Record record;
    Customer customer;
    int jenis = 0; //1 - individual, 2 - corporate
    boolean isLocal = false;

    Scanner scanner = new Scanner(System.in);
    public static void main (String [] args) {
        
        Booking_System obj = new Booking_System(); 
        Scanner scanner = new Scanner(System.in);
        Room room = new Room();
        
        System.out.println("===========================================");
        System.out.println("|       Welcome to Hotel Seri Malaysia      |");
        System.out.println("|   Booking/Reservation Management System   |");
        System.out.println("===========================================");
        
        //  MAIN MENU ======================================================
        int menu = 99;
        do {
            System.out.println("\n\n============================================");
            System.out.println("|                  MAIN MENU               |");
            System.out.println("============================================");
            System.out.println("1. About Us");
            System.out.println("2. View Room");
            System.out.println("3. Room booking");
            System.out.println("4. View and Print Booking Details");
            System.out.println("5. Make Payment");
            System.out.println("0. Exit");
            System.out.println("* * * * * * * * * * * *");
            System.out.print("- Choose your menu (0-5): ");
            menu = scanner.nextInt();
            if(menu == 0) { // 0. exit
                obj.ucap_terima_kasih();
                System.out.println("Thank you please come again!");
            }
            else if(menu == 1) // 1. about us
                obj.about_us();
            else if(menu == 2) // 2. view room
                room.displayRooms();
            else if(menu == 3)  { // 3. room booking
                obj.booking();
            }
            else if(menu == 4) // 4. view booking details
                obj.viewDetails();
            else if(menu == 5) // 5. make payment
                obj.makePayment();
            else
                System.out.println("Invalid menu! Please try again.");
        } while (menu != 0);

        scanner.close();
    }
    
    // 1. About us =====================================================
    public void about_us() {
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("Hotel Seri Malaysia mempunyai lebih 30 cawangan di seluruh Malaysia.");
        System.out.println("Kami menyediakan pelbagai jenis bilik untuk keselesaan anda.");
        System.out.println("Tempahan bilik boleh dibuat melalui sistem tempahan dalam talian kami 24/7.");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }
    public void ucap_terima_kasih() {
        System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("* Kalau ada sumur di ladang,\nBolehlah kita menumpang mandi.");
        System.out.println("* Kalau ada umur yang panjang,\nBolehlah kita berjumpa lagi.");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
    }

    // 3. Room booking =====================================================
    public void booking() {
        Scanner input = new Scanner(System.in);
        Room room = new Room();
        
        System.out.println("\n\n============================================");
        System.out.println("|                BOOKING PAGE               |");
        System.out.println("============================================");
        System.out.println("Sila lengkapkan maklumat berikut.");
        System.out.println("Sila nyatakan jenis tempahan:");
        System.out.println("1. Individu");
        System.out.println("2. Korporat");
        jenis = input.nextInt();

        // Maklumat individu yang booking
        System.out.print("- Nama            : ");
        input.nextLine(); 
        String name = input.nextLine();
        System.out.print("- No Telefon      : ");
        long phone = input.nextLong();
        System.out.print("- Email           : ");
        String email = input.next();

        //Maklumat tempahan bilik
        room.displayRooms();
        System.out.print("Pilih:\n- Jenis bilik     : ");
        int room_type = input.nextInt();
        System.out.print("- Bilangan hari   : ");
        int num_days = input.nextInt();
        System.out.print("- Bilangan bilik  : ");
        int num_rooms = input.nextInt();

        if(jenis == 1) { 
            // Tempahan untuk individu ---------------------------
            System.out.print("- IC              : ");
            long ic = input.nextLong();

            System.out.print("- Nationality     : ");
            String nationality = input.next();

            System.out.print("- Check-in date   : ");
            String checkIn = input.next();

            System.out.print("- Check-out date  : ");
            String checkOut = input.next();
            double baseTotal = room.getPrice(room_type -  1) * num_days * num_rooms;
            System.out.println("Base total (before discount): RM " + baseTotal);
            System.out.println("Proceed to payment to apply discounts.");
            ind = new Individual(name, phone, email, ic, nationality, room_type, num_days, num_rooms, checkIn, checkOut);
            record = new Booking_Record(name, 1, room_type, num_days, num_rooms, baseTotal);
            customer = ind;
        }
        else if (jenis == 2){
            // Tempahan untuk syarikat  --------------------------
            System.out.print("Company name: ");
            String companyName = input.next();
            
            System.out.print("Company registration number: ");
            String companyRegNo = input.next();
            
            System.out.print("Contact person name: ");
            String contactPerson = input.next();

            System.out.print("Total number of employees: ");
            int numberOfEmployees = input.nextInt();

            double baseTotal = room.getPrice(room_type -  1) * num_days * num_rooms;
            System.out.println("Base total (before discount): RM " + baseTotal);
            System.out.println("Proceed to payment to apply discounts.");
            cor = new Corporate(name, phone, companyName, companyRegNo, contactPerson, numberOfEmployees, room_type, num_days, num_rooms);
            record = new Booking_Record(2, companyName, contactPerson, room_type, num_days, num_rooms, baseTotal);
            customer = cor;
        }
    }

    // 4. View booking =====================================================
    public void viewDetails(){
        if(record == null){
            System.out.println("ERROR. Sorry, No booking found!");
            return;
        }

        System.out.println("\n\n============================================");
        System.out.println("|              BOOKING DETAILS              |");
        System.out.println("============================================");
        if(jenis == 1 && ind != null){
            ind.displayIndividualInfo();
        } else if(jenis == 2 && cor != null){
            cor.displayCorporateInfo();
        }
        // Option to save invoice into file
        System.out.print("\nDo you want to save the invoice? (Y/N) : ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")){
            record.saveBookToFile();
            System.out.println("Booking has been saved successfully!");
        } else {
            System.out.println("Invoice not saved. Returning to main menu.");
        }
    }

    // 5. Payment method ===================================================
    public void makePayment(){
        if(record == null){
            System.out.println("No booking available for payment.");
            return;
        }
        System.out.println("\n\n============================================");
        System.out.println("|                PAYMENT PAGE               |");
        System.out.println("============================================");
        System.out.print("- Enter payment method (Cash/Card/Online): ");
        String payMethod = scanner.next();
        boolean isLocal = (jenis == 1 && ind.getIsLocal());
        double finalAmount = customer.calculateTotal();
        Payment payment = new Payment(finalAmount, payMethod, jenis, record.getRoomType(), record.getNumDays(), record.getNumRooms(), isLocal);
        payment.displayPaymentInfo();

        System.out.print("Proceed with payment? (Y/N): ");
        String choicePay = scanner.next();

        if (!choicePay.equalsIgnoreCase("Y")) {
            System.out.println("Payment cancelled. Returning to main menu.");
            return;
        }
        payment.updatePaymentStatus(); // from "not paid" to "paid"
        payment.displayPaymentInfo();
        System.out.print("Proceed with printing payment? (Y/N): ");
        String printPay = scanner.next();
        if (printPay.equalsIgnoreCase("Y")) {
            payment.savePayToFile();
            System.out.println("Payment recorded successfully!");
        }
    }
        
}
