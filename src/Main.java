import Driver.BusDriver;
import Driver.Driver;
import Driver.TruckDriver;
import Transport.*;
import Transport.Car.RingTime;
import Driver.WrongLicenseException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Упрощенное приложение для автогонок

        //Водители
        Driver<Automobile> petrovich = new Driver<>("Петрович", 53,"B","123456789");
        BusDriver<Bus> mihalich = new BusDriver<>("Михалыч", 56,"D","987654321");
        TruckDriver<Truck> sergeevich = new TruckDriver<>("Сергеич", 55,"CE","112233445");
       // спонсоры
        Sponsor amazon = new Sponsor("AMAZON", 200_000);
        Sponsor cocaCola = new Sponsor("Coca Cola", 500_000);
        Sponsor gillette = new Sponsor("Gillette", 300_000);
        // механики
        Mechanic<Automobile> fedya = new Mechanic<>("Федя", "Ключавто");
        Mechanic<Bus> petya = new Mechanic<>("Петя", "Рольф");
        Mechanic<Truck> vasya = new Mechanic<>("Вася", "Юг-Авто");
        //Автомобили
        Automobile honda = new Automobile("Honda", "Civic", 2.0);
        honda.addDriver(petrovich);
        honda.addMechanic(fedya);
        honda.addSponsor(amazon);
        honda.addSponsor(cocaCola);
        Automobile toyota = new Automobile("Toyota", "Corolla", 1.6, Automobile.BodyTypes.SEDAN);
        Automobile mazda = new Automobile("Mazda", "Axella", 1.5, Automobile.BodyTypes.WAGON);
        Automobile nissan = new Automobile("Nissan", "Almera", 1.6, Automobile.BodyTypes.HATCHBACK);
        //Автобусы
        Bus neoplan = new Bus("Neoplan", "Megaliner", 12);
        neoplan.addBusDriver(mihalich);
        neoplan.addMechanic(petya);
        neoplan.addSponsor(cocaCola);
        neoplan.addSponsor(gillette);
        Bus ikarus = new Bus("Ikarus", "290", 13.6, Bus.Capacity.EXTRA_LARGE);
        Bus yutong = new Bus("Yutong", "ZK6128H", 12.8,null);
        Bus scania = new Bus("Scania", "Touring", 12.8);
        //Грузовые автомобили
        Truck man = new Truck("Man", "TGX", 15.6, Truck.Capacity.N3);
        man.addTruckDriver(sergeevich);
        man.addMechanic(vasya);
        man.addSponsor(gillette);
        man.addSponsor(amazon);
        Truck mercedes = new Truck("Mercedes", "Actros", 15.6, Truck.Capacity.N3);
        Truck iveco = new Truck("Iveco", "Stralis", 16,null);
        Truck kamaz = new Truck("Kamaz", "Dakar", 15.6, Truck.Capacity.N2);
        //Время круга для разных типов транспорта
        RingTime hondaTimes = honda.new RingTime(222.22, 208.02, 219.47);
        RingTime neoplanTimes = neoplan.new RingTime(335.43, 365.76, 332.59);
        RingTime manTimes = man.new RingTime(298.78, 302.24, 300.01);
        // какие то методы
        CarList carList = new CarList();
        carList.addCar(kamaz);
        carList.addCar(honda);
        carList.addCar(honda);// Проверка что в список автомобилей нельзя добавить повторяющееся значение
        System.out.println(carList);
        SponsorList sponsorList = new SponsorList();
        sponsorList.addSponsor(cocaCola);
        sponsorList.addSponsor(amazon);
        sponsorList.addSponsor(amazon);// Проверка что в список спонсоров нельзя добавить повторяющееся значение
        System.out.println(sponsorList);
        MechanicList mechanicList = new MechanicList();
        mechanicList.addMechanic(vasya);
        mechanicList.addMechanic(vasya);// Проверка что в список механиков нельзя добавить повторяющееся значение
        System.out.println(mechanicList);

        // Все закомментировал чтобы не мешало при выводе и проверке списков
        //какие то проверки работы методов
//        honda.compareToBestRingTime(hondaTimes);
//        honda.maxSpeed();
//        System.out.println(honda);
//        System.out.println(neoplanTimes.getBestRingTime());
//        neoplan.compareToBestRingTime(neoplanTimes);
//        man.compareToBestRingTime(manTimes);
//        System.out.println(manTimes.getBestRingTime());
//
//        sergeevich.startMoving(man);
//        sergeevich.stopMoving(man,manTimes);
//        sergeevich.printInfoTruckDriver(man);
//
//        petrovich.startMoving(honda);
//        petrovich.stopMoving(honda,hondaTimes);
//        petrovich.printInfoDriver(honda);
//
//        mihalich.startMoving(neoplan);
//        mihalich.stopMoving(neoplan,neoplanTimes);
//        mihalich.printInfoDriver(neoplan);
//        //блок по enum
//        honda.identifyBodyType();
//        toyota.identifyBodyType();
//        neoplan.setCapacity(Bus.Capacity.LARGE);
//        neoplan.printCapacity();
//        ikarus.printCapacity();
//        scania.printCapacity();
//        man.printCapacity();
//        iveco.printCapacity();
//        iveco.setCapacity(Truck.Capacity.N2);
//        iveco.printCapacity();
//

        //исключения
//        checkDriverLicense(petrovich);
//        checkBusDriverLicense(mihalich);
//        checkTrackDriverLicense(sergeevich);
//        doCheck(man,honda,neoplan);
//
//        Garage garage = new Garage();
//        garage.addAutomobile(honda);
//        garage.addTruck(man);
//        garage.service();
//        garage.service();
//        automobileInfo(honda);
//        automobileInfo(neoplan);
//        automobileInfo(man);
    }

    public static void automobileInfo(Car car) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(car.getBrand() + " " + car.getModel());
        for (Driver<?> driver : car.getDrivers()) {
            System.out.println("Водитель - "+driver.getName());
        }
        System.out.println("Механики: ");
        for (Mechanic<?> mechanic : car.getMechanics()) {
            System.out.println(mechanic.getName());
        }
        System.out.println("Спонсоры: ");
        for (Sponsor sponsor : car.getSponsors()) {
            System.out.println(sponsor.getName());
        }
    }

    public static void doCheck(Car... cars) {
        for (Car car : cars) {
            car.doCheck();
        }
    }
    public static void checkDriverLicense(Driver driver) {
        try {
            driver.checkDriverLicense(driver);
        } catch (WrongLicenseException e) {
            System.out.println(e.getMessage());
        }
    }public static void checkBusDriverLicense(BusDriver busDriver) {
        try {
            busDriver.checkDriverLicense(busDriver);
        } catch (WrongLicenseException e) {
            System.out.println(e.getMessage());
        }

    }public static void checkTrackDriverLicense(TruckDriver truckDriver) {
        try {
            truckDriver.checkDriverLicense(truckDriver);
        } catch (WrongLicenseException e) {
            System.out.println(e.getMessage());
        }
    }
}