import Driver.BusDriver;
import Driver.Driver;
import Driver.TruckDriver;
import Transport.Automobile;
import Transport.Bus;
import Transport.Car;
import Transport.Car.RingTime;
import Transport.Truck;

public class Main {
    public static void main(String[] args) {
        //Упрощенное приложение для автогонок

        //Водители
        Driver<Automobile> petrovich = new Driver<>("Петрович", 53);
        BusDriver<Bus> mihalich = new BusDriver<>("Михалыч", 56);
        TruckDriver<Truck> sergeevich = new TruckDriver<>("Сергеич", 55);
        //Автомобили
        Automobile honda = new Automobile("Honda", "Civic", 2.0);
        Automobile toyota = new Automobile("Toyota", "Corolla", 1.6, Automobile.BodyTypes.SEDAN);
        Automobile mazda = new Automobile("Mazda", "Axella", 1.5, Automobile.BodyTypes.WAGON);
        Automobile nissan = new Automobile("Nissan", "Almera", 1.6, Automobile.BodyTypes.HATCHBACK);
        //Автобусы
        Bus neoplan = new Bus("Neoplan", "Megaliner", 12);
        Bus ikarus = new Bus("Ikarus", "290", 13.6, Bus.Capacity.EXTRA_LARGE);
        Bus yutong = new Bus("Yutong", "ZK6128H", 12.8,null);
        Bus scania = new Bus("Scania", "Touring", 12.8);
        //Грузовые автомобили
        Truck man = new Truck("Man", "TGX", 15.6, Truck.Capacity.N3);
        Truck mercedes = new Truck("Mercedes", "Actros", 15.6, Truck.Capacity.N3);
        Truck iveco = new Truck("Iveco", "Stralis", 16,null);
        Truck kamaz = new Truck("Kamaz", "Dakar", 15.6, Truck.Capacity.N2);
        //Время круга для разных типов транспорта
        RingTime hondaTimes = honda.new RingTime(222.22, 208.02, 219.47);
        RingTime neoplanTimes = neoplan.new RingTime(335.43, 365.76, 332.59);
        RingTime manTimes = man.new RingTime(298.78, 302.24, 300.01);

        //какие то проверки работы методов
        honda.compareToBestRingTime(hondaTimes);
        honda.maxSpeed();
        System.out.println(honda);
        System.out.println(neoplanTimes.getBestRingTime());
        neoplan.compareToBestRingTime(neoplanTimes);
        man.compareToBestRingTime(manTimes);
        System.out.println(manTimes.getBestRingTime());

        sergeevich.startMoving(man);
        sergeevich.stopMoving(man,manTimes);
        sergeevich.printInfoTruckDriver(man);

        petrovich.startMoving(honda);
        petrovich.stopMoving(honda,hondaTimes);
        petrovich.printInfoDriver(honda);

        mihalich.startMoving(neoplan);
        mihalich.stopMoving(neoplan,neoplanTimes);
        mihalich.printInfoDriver(neoplan);
        //блок по enum
        honda.identifyBodyType();
        toyota.identifyBodyType();
        neoplan.setCapacity(Bus.Capacity.LARGE);
        neoplan.printCapacity();
        ikarus.printCapacity();
        scania.printCapacity();
        man.printCapacity();
        iveco.printCapacity();
        iveco.setCapacity(Truck.Capacity.N2);
        iveco.printCapacity();
    }
}