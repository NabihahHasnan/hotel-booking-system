public class Corporate extends Customer{
    // Attributes ==============================================
    String companyName;
    String companyRegNo;
    String contactPerson;
    int numberOfEmployees;

    //  Default constructor =====================================
    public Corporate() {
        super();
        this.companyName = "";
        this.companyRegNo = ""; 
        this.contactPerson = "";
        this.numberOfEmployees = 0;
    }
    //  Normal constructor =======================================
    public Corporate(String name, long phone, String companyName, String companyRegNo, String contactPerson, int numberOfEmployees, int room_type, int num_days, int num_rooms) {
        super(room_type, num_days, num_rooms);
        this.companyName = companyName;
        this.companyRegNo = companyRegNo;
        this.contactPerson = contactPerson;
        this.numberOfEmployees = numberOfEmployees;
        setCustomerType(2);
    }

    // Abstract method dari Customer =============================
    @Override
    public double calculateTotal() {
        Room room = new Room();
        double total = room.getPrice(room_type - 1) * num_days * num_rooms;

        // Corporate discount
        double individualDisc =  total * 0.20;
        total = total - individualDisc;
        return total;
    }

    // Display Corporate Info ======================================
    public void displayCorporateInfo() {
        displayCustomerInfo(); // from Customer
        System.out.println("Company Name     : " + companyName);
        System.out.println("Registration No  : " + companyRegNo);
        System.out.println("Contact Person  : " + contactPerson);
        System.out.println("Employees       : " + numberOfEmployees);
    }

    @Override
    public String toString() {
        return "Corporate Customer\n" +
               "Company Name    : " + companyName +
               "\nRegistration No : " + companyRegNo +
               "\nContact Person : " + contactPerson +
               "\nEmployees      : " + numberOfEmployees +
               "\nRoom Type      : " + room_type +
               "\nDays           : " + num_days +
               "\nRooms          : " + num_rooms;
    }
}