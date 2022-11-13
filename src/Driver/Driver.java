package Driver;

import Transport.Automobile;
import Transport.Car;
import Transport.Competing;

public class Driver<D extends Automobile & Competing> {
    private String name;
    private int ageOfDriving;

    public Driver(String name, int ageOfDriving) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Петрович";
        } else {
            this.name=name;
        }
        if (ageOfDriving > 0) {
            this.ageOfDriving = ageOfDriving;
        }else {this.ageOfDriving=1;}
    }

    public void startMoving(Automobile automobile) {
        System.out.println("Занять место водителя в автомобиле "+automobile.getBrand()+" "
                +automobile.getModel()+". Запустить двигатель. По сигналу начать движение.");
    }
    public void stopMoving(Automobile automobile, Car.RingTime ringTime) {
        System.out.println("Нажать на тормоз, остановиться. Заглушить двигатель. Выйти из автомобиля "+automobile.getBrand()+" "
                +automobile.getModel()+". Посмотреть информацию:");
        System.out.println("Лучшее время круга - "+ringTime.getBestRingTime()+" секунд.");
    }
    public void FillCar() {
        System.out.println("Подъехать к заправочной станции");
        System.out.println("Остановиться");
        System.out.println("Заправить тачку");
        System.out.println("Умчать в закат");
    }

    public void printInfoDriver(Automobile automobile) {
        System.out.println("Водитель "+getName()+" управляет автомобилем "+
                automobile.getBrand()+" "+automobile.getModel());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", ageOfDriving=" + ageOfDriving +
                '}';
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
