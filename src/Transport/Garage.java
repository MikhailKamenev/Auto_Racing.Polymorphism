package Transport;

import java.util.ArrayDeque;
import java.util.Queue;

public class Garage {
    private Queue<Car> cars = new ArrayDeque<>();

    private void add(Car car) {
        cars.offer(car);
    }
    public void addAutomobile(Automobile automobile) {
        add(automobile);
    }
    public void addTruck(Truck truck) {
        add(truck);
    }

    public void service() {
        if (!cars.isEmpty()) {
            Car car = cars.poll();
            car.doCheck();
        }
    }
}
