package Driver;

import Transport.Car;
import Transport.Bus;
import Transport.Competing;

public class BusDriver <BD extends Bus& Competing>{
    private String name;
    private int ageOfDriving;
    private String licenseCategory;
    private String licenseNumber;

    public BusDriver(String name, int ageOfDriving,String licenseCategory,String licenseNumber) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            this.name = "Петрович";
        } else {
            this.name=name;
        }
        if (ageOfDriving > 0) {
            this.ageOfDriving = ageOfDriving;
        }else {this.ageOfDriving=1;}
        this.licenseCategory = licenseCategory;
        this.licenseNumber = licenseNumber;
    }

    public void checkDriverLicense(BusDriver busDriver) throws WrongLicenseException {
        if (busDriver.getLicenseCategory() != null && busDriver.getLicenseCategory().matches("^[A-E]+$")
                && busDriver.getLicenseCategory().length() <= 2) {
            System.out.println("Категория прав водителя " + getName() + " соответствует стандарту.");
        } else {
            throw new WrongLicenseException("Неверно указана категория в водительском удостоверении. " +
                    "Вы можете использовать только латинские заглавные буквы А-Е. " +
                    "Длина указываемой категории не более 2 символов.");
        }
        if (busDriver.getLicenseNumber().length() == 9 && busDriver.getLicenseNumber().matches("^[0-9]+$")) {
            System.out.println("Указанный номер водительского удостоверения соответствует стандарту.");
        } else {
            throw new WrongLicenseException("Ошибка в номере водительского удостоверения. " +
                    "Номер может содержать только цифры и его длина должна быть равна 9 символам.");
        }
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

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
