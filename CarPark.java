import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CarPark {
    public Semaphore freeSpace;
    int capacity;
    ArrayList<Car> cars = new ArrayList<Car>();

    public CarPark(int capacity) {
        this.capacity = capacity;
        freeSpace = new Semaphore(capacity);
    }

    public void queueCar(Car car) {
        car.park(this);
        cars.add(car);
    }

    public void admitCar(Car car) {
        try {
            synchronized (this.freeSpace) {
                System.out.println("Admitting car: " + car.id + " Free spaces: " + freeSpace.availablePermits());
                this.freeSpace.acquire(1);

                this.displayCars();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void evictCar(Car car) {
        System.out.println("Evicting car: " + car.id +
                " Entry time: " + car.entryTime + ", Exit time: " + car.exitTime);

        this.freeSpace.release(1);

        cars.remove(car);

        this.displayCars();
    }

    protected void displayCars() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf(cars.get(i).getStatus());
        }
        System.out.println();

    }
}
