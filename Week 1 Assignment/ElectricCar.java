package Week1.OOPS;

public class ElectricCar extends Car {
    private int batteryRange;

    public ElectricCar(String make, String model, int year, int batteryRange) {
        super(make, model, year);
        this.batteryRange = batteryRange;
    }

    public int getBatteryRange() {
        return batteryRange;
    }

    public void setBatteryRange(int batteryRange) {
        this.batteryRange = batteryRange;
    }

    public void chargeBattery() {
        System.out.println(Print.BATTERY_CHARGED);
    }

    @Override
    public void startEngine() {
        System.out.println(getMake() + "  " + getModel() + "  " + Print.ELECTRIC_ENGINE_STARTED);
    }

}
