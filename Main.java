import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        //Declare carpark capacity, cars to be generated for simulation, max arrival gap
        final int SPACES = 20;
        final int CARCOUNT = 1000;
        final int MAX_ARRIVAL_GAP = 100;
        
        //Instantiate carId variable for Car constructor
        int carId = 0;

        //Create new instance of carpark with set capacity
        CarPark carpark = new CarPark(SPACES);

        //Create cars until specified amount (CARCOUNT) for simulation is met
        while (carId < CARCOUNT) {
            //Create instance of Car
            Car car = new Car(carId++);
            //Car arrives in queue
            carpark.queueCar(car);
            //Sleep for random amount of time (within max arrival gap)
            Thread.sleep(new Random().nextInt(MAX_ARRIVAL_GAP));
        }
    }

}
