public class Room{
    // Room attributes ==============================================
    private String [] room_type = {"Single","Twin", "Family"};
    private double [] pricePerNight = {150.00,350.00,500.00};
    private int[] capacity = {1, 2, 4}; 
    private int[] totalRooms = {5, 5, 3};
    private boolean available = true;
    String [] amenities = {
        "Free Wi-Fi, Air Conditioning, Flat-screen TV, Mini-bar",
        "Free Wi-Fi, Air Conditioning, Two Single Beds, Flat-screen TV, Mini-bar",
        "Free Wi-Fi, Air Conditioning, Flat-screen TV, Mini-bar, Kitchenette"
    };

    // Getter untuk harga bilik ======================================
    public double getPrice(int index) {
        return pricePerNight[index];
    }

    public String getRoomType(int index) {
        return room_type[index];
    }

    public int getCapacity(int index) {
        return capacity[index];
    }

    public String getAmenities(int index) {
        return amenities[index];
    }

    // Display all rooms
    public void displayRooms(){
        System.out.println("\n\n============================================");
        System.out.println("|                  VIEW ROOMS               |");
        System.out.println("============================================");
        System.out.println("No.\tType\tPrice(RM)\tCapacity");
        System.out.println("---\t----\t---------\t--------");
        for(int i = 0; i < room_type.length; i++) {
            System.out.println((i+1)+ ".\t" 
                            + room_type[i] 
                            + "\tRM" + pricePerNight[i] 
                            + "\t\t" + capacity[i]);
        }
        System.out.println("============================================");
    }

    // Jumlah harga keseluruhan
    public double totalPrice(int num_type, int num_days, int num_rooms) {
        int index = num_type - 1;
        double total = pricePerNight[index] * num_days * num_rooms;
        return total;
    }

    // Semak room availability
    public boolean isAvailable(int room_TypeNo, int room_requested){
        int index = room_TypeNo - 1;
        return available && room_requested <= totalRooms[index];
    }
    
    // Kurangkan jumlah bilik selepas ada booking
    public void reduceRoomAvailable(int room_TypeNo, int room_booked){
        int index = room_TypeNo - 1;
        totalRooms[index] = totalRooms[index] - room_booked;
        if (totalRooms[index] <= 0){
            available = false;
        }
    }
    
}