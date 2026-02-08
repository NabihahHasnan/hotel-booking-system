public class Individual extends Customer{
    // Individual specific attributes =====================
    private long ic;
    private String nationality; // New attribute
    private boolean isLocal; // New attribute
    private String checkInDate; // New attribute
    private String checkOutDate; // New attribute


    //  Default constructor ===============================
    public Individual() {
        super();
        this.ic = 0;
        this.nationality = "";
        this.isLocal = nationality.equalsIgnoreCase("Malaysia");
        this.checkInDate = "";
        this.checkOutDate = "";
        setCustomerType(1);
    }

    //  Normal constructor =================================
    public Individual(String name, long phone, String email, long ic, String nationality, int room_type, int num_days, int num_rooms, String checkInDate, String checkOutDate) {
        super(name, phone, room_type, num_days, num_rooms);
        this.ic = ic;
        this.nationality = nationality;
        this.isLocal = nationality.equalsIgnoreCase("Malaysia"); // New attribute
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        setCustomerType(1);
    }

    // Abstract method dari Customer =======================
    @Override
    public double calculateTotal() {
        Room room = new Room();
        double total = room.getPrice(room_type - 1) * num_days * num_rooms;

        // Individu discount
        double individualDisc =  total * 0.10;
        total = total - individualDisc;

        if (isLocal){
            double localDisc = total * 0.05;
            total = total - localDisc;
        }
        return total;
    }

    //Getter ================================================
    public boolean getIsLocal(){
        return isLocal;
    }


    // Display Individual Info ==============================
    public void displayIndividualInfo() {
        displayCustomerInfo(); // from Customer
        System.out.println("IC/Passport No : " + ic);
        System.out.println("Nationality    : " + nationality);
        System.out.println("Local Person   : " + (isLocal ? "Yes" : "No"));
        System.out.println("Check-in       : " + checkInDate);
        System.out.println("Check-out      : " + checkOutDate);
    }

    public String toString() {
        Room room = new Room();
        int index = room_type - 1;
        return ("Individual Customer\n"
            + "Name                 : " + name
            + "\nPhone              : " + phone
            + "\nIC/Passport No     : " + ic 
            + "\nRoom Type          : " + room.getRoomType(index) 
            + "\nNumber of Days     : " + num_days
            + "\nNumber of Rooms    : "+ num_rooms
            + "\nTotal Price        : RM" + String.format("%.2f", calculateTotalPrice()) 
            + "\nPayment Status     : " + (getPaymentStatus() ? "Paid" : "Not Paid"));
    }
}