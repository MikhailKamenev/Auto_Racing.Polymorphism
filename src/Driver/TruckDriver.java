package Driver;


import Transport.Car;
import Transport.Competing;
import Transport.Truck;

public class TruckDriver <BD extends Truck& Competing>{
    private String name;
    private int ageOfDriving;

    public TruckDriver(String name, int ageOfDriving) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Петрович";
        } else {
            this.name=name;
        }
        if (ageOfDriving > 0) {
            this.ageOfDriving = ageOfDriving;
        }else {this.ageOfDriving=1;}
    }

    public void startMoving(Truck truck) {
        System.out.println("Занять место водителя в автомобиле "+truck.getBrand()+" "
                +truck.getModel()+". Запустить двигатель. По сигналу начать движение.");
    }
    public void stopMoving(Truck truck, Car.RingTime ringTime) {
        System.out.println("Нажать на тормоз, остановиться. Заглушить двигатель. Выйти из автомобиля "+truck.getBrand()+" "
                +truck.getModel()+". Посмотреть информацию:");
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
        return "TruckDriver{" +
                "name='" + name + '\'' +
                ", ageOfDriving=" + ageOfDriving +
                '}';
    }
    public void printInfoTruckDriver(Truck truck) {
        System.out.println("Водитель " + getName() + " управляет автомобилем " +
                truck.getBrand() + " " + truck.getModel());
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
