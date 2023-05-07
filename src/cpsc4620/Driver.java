package cpsc4620;

public class Driver extends Person {
    private int vehicleId;

    public Driver(int personId, String fullname, String phone, UserType userType, String userLoc, int vehicleId) {
        super(personId, fullname, phone, userType, userLoc);
        this.vehicleId = vehicleId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    // Override the toString method to print object details
    @Override
    public String toString() {
        return super.toString() + ", vehicleId=" + vehicleId;
    }
}

