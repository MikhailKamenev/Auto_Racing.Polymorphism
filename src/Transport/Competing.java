package Transport;

public interface Competing {

    //«Пит-стоп»,
    //«Лучшее время круга»,
    //«Максимальная скорость».
    String doPitStop();

    void compareToBestRingTime(Car.RingTime ringTime);

    void maxSpeed();
}