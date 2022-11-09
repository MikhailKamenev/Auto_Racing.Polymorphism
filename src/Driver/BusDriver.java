package Driver;

import Transport.Car;
import Transport.Bus;
import Transport.Competing;

public class BusDriver <BD extends Bus& Competing>{
    private String name;
    private int ageOfDriving;

    public BusDriver(String name, int ageOfDriving) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Петрович";
        } else {
            this.name=name;
        }
        if (ageOfDriving > 0) {
            this.ageOfDriving = ageOfDriving;
        }else {this.ageOfDriving=1;}
    }

    public void startMoving(Bus bus) {
        System.out.println("Занять место водителя в автомобиле "+bus.getBrand()+" "
                +bus.getModel()+". Запустить двигатель. По сигналу начать движение.");
    }
    public void stopMoving(Bus bus, Car.RingTime ringTime) {
        System.out.println("Нажать на тормоз, остановиться. Заглушить двигатель. Выйти из автомобиля "+bus.getBrand()+" "
                +bus.getModel()+". Посмотреть информацию:");
        System.out.println("Лучшее время круга - "+ringTime.getBestRingTime()+" секунд.");
    }
    public void FillCar() {
        System.out.println("Подъехать к заправочной станции");
        System.out.println("Остановиться");
        System.out.println("Заправить тачку");
        System.out.println("Умчать в закат");
    }

    @Override
    public String toString() {
        return "BusDriver{" +
                "name='" + name + '\'' +
                ", ageOfDriving=" + ageOfDriving +
                '}';
    }
    public void printInfoDriver(Bus bus) {
        System.out.println("Водитель "+getName()+" управляет автомобилем "+
                bus.getBrand()+" "+bus.getModel());
    }

    public String getName() {
        return name;
    }
    public int getAgeOfDriving() {
        return ageOfDriving;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            name=this.name;
        } else {
            this.name=name;
        }
    }
    public void setAgeOfDriving(int ageOfDriving) {
        if (ageOfDriving > 0) {
            this.ageOfDriving = ageOfDriving;
        }else {this.ageOfDriving=1;}
    }
}
