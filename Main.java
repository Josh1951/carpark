import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int SPACES = 20;
        final int CARCOUNT = 1000;
        final int MAX_ARRIVAL_GAP = 100;
        int carId = 0;

        CarPark carpark = new CarPark(SPACES);

        while (carId < CARCOUNT) {
            Car car = new Car(carId++);

            carpark.queueCar(car);

            Thread.sleep(new Random().nextInt(MAX_ARRIVAL_GAP));
        }
    }

}
