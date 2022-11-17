package Driver;

import Transport.Automobile;
import Transport.Car;
import Transport.Competing;

public class Driver<D extends Automobile & Competing> {
    private String name;
    private int ageOfDriving;
    private String licenseCategory;
    private String licenseNumber;


    public Driver(String name, int ageOfDriving, String licenseCategory, String licenseNumber) {
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

    public void checkDriverLicense(Driver driver) throws WrongLicenseException {
        if (driver.getLicenseCategory() != null && driver.getLicenseCategory().matches("^[A-E]+$")
                && driver.getLicenseCategory().length() <= 2) {
            System.out.println("Категория прав водителя " + getName() + " соответствует стандарту.");
        } else {
            throw new WrongLicenseException("Неверно указана категория в водительском удостоверении. " +
                    "Вы можете использовать только латинские заглавные буквы А-Е. " +
                    "Длина указываемой категории не более 2 символов.");
        }
        if (driver.getLicenseNumber().length() == 9 && driver.getLicenseNumber().matches("^[0-9]+$")) {
            System.out.println("Указанный номер водительского удостоверения соответствует стандарту.");
        } else {
            throw new WrongLicenseException("Ошибка в номере водительского удостоверения. " +
                    "Номер может содержать только цифры и его длина должна быть равна 9 символам.");
        }
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

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
