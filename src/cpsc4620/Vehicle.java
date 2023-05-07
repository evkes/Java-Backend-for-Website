package cpsc4620;

public class Vehicle {
    private int vehicleId;
    private String licensePlate;
    private String make;
    private String model;
    private int mpg;
    
    public Vehicle(int vehicleId, String licensePlate, String make, String model, int mpg) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.mpg = mpg;
    }
    
    // Getters and setters
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", licensePlate=" + licensePlate + ", make=" + make + ", model="
                + model + ", mpg=" + mpg + "]";
    }

}

