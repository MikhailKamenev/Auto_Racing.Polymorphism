package Transport;

import java.util.HashSet;
import java.util.Set;

public class CarList {
    private Set<Car> cars = new HashSet<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
