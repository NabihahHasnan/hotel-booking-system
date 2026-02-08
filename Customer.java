public abstract class Customer{
    protected String name; 
    protected long phone;
    protected int room_type, num_days, num_rooms;
    protected String email; // New attribute
    protected boolean paymentStatus; //New attribute
    protected int customerType; // New attribute    
    private static int customerIDCounter = 1000; // Untuk customerID
    protected int customerID; // New attribute

    //  Default constructor
    //==============================================
    public Customer() {
        this.name = "";
        this.phone = 0;        
        this.email = ""; // New attribute
        this.room_type = 0;
        this.num_days = 0;
        this.num_rooms = 0;
        this.paymentStatus = false; // Default payment status
        this.customerType = 0; // New attribute
        this.customerID = customerIDCounter++;
    }
    //  Normal constructor
    //==============================================
    public Customer(String name, long phone, int room_type, int num_days, int num_rooms) {
        this.name = name;
        this.phone = phone;
        this.room_type = room_type;
        this.num_days = num_days;
        this.num_rooms = num_rooms;
        this.paymentStatus = false; // Default payment status
        this.customerType = 0; // New attribute
        this.customerID = customerIDCounter++;
    }

    //2. untuk corporate
    public Customer(int room_type, int num_days, int num_rooms){
        this.room_type = room_type;
        this.num_days = num_days;
        this.num_rooms = num_rooms;
        this.paymentStatus = false; // Default payment status
        this.customerID = customerIDCounter++;    
    }

    //  Abstract method
    //==============================================
    public abstract double calculateTotal();


    // Added methods
    //==============================================
    //Getter and Setter for paymentStatus
    public void setPaymentStatus() {
        this.paymentStatus = true;
        System.out.println("Payment completed for Customer ID: " + customerID);
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    // Getter and Setter for customerType
    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public int getCustomerType() {
        return customerType;
    }

    //Print customer info
    public void displayCustomerInfo() {
        System.out.println("Name          : " + name);
        System.out.println("Phone         : " + phone);
        System.out.println("Room Type     : " + room_type);
        System.out.println("Days          : " + num_days);
        System.out.println("Rooms         : " + num_rooms);
        System.out.println("Customer Type : " + customerType);
        System.out.println("Payment       : " + (paymentStatus ? "Paid" : "Not Paid"));
    }

}