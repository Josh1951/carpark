import java.time.LocalTime;
import java.util.Random;

public class Car implements Runnable {
    final int MAX_STAY_TIME = 2000;
    int id;
    CarPark carPark = null;
    int stayTime = new Random().nextInt(MAX_STAY_TIME);
    LocalTime entryTime;
    LocalTime exitTime;
    String status = "Q";

    public Car(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void park(CarPark carPark) {
        this.carPark = carPark;

        new Thread(this).start();
    }

    public void run() {
        try {
            if (this.carPark != null) this.carPark.admitCar(this);

            this.status = "P";

            this.entryTime = LocalTime.now();

            Thread.sleep(stayTime);

            this.exitTime = LocalTime.now();

            if (this.carPark != null) this.carPark.evictCar(this);

            this.status = "L";

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
