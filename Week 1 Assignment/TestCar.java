package Week1.OOPS;

public class TestCar {
    public static void main(String[] args) {
        Car[] car = new Car[7];
        car[0] = new Car("Maserati", "GHIBLI", 2024);
        car[1] = new ElectricCar("Mahindra", "XEV9E", 2025, 70);
        car[2] = new Car("LAMBORGHINI", "REVUETTO", 2024);
        car[3] = new ElectricCar("KIA", "EV6", 2025, 80);
        car[4] = new Car("PORSCHE", "911", 2024);
        car[5] = new ElectricCar("BMW", "i4", 2024, 75);
        car[6] = new Car("FORD", "MUSTANGGT", 2024);
        for (Car cars : car) {
            cars.startEngine();
        }


    }
}
