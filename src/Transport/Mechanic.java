package Transport;

public class Mechanic <C extends Car>{
    private final String name;
    private final String company;

    public Mechanic(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void doMaintenance(C c) {
        System.out.printf("Выполнено техническое обслуживание автомобиля %s %d", c.getBrand(), c.getModel());
    }
    public void repair(C c) {
        System.out.printf("Выполнен ремонт автомобиля %s %d", c.getBrand(), c.getModel());
    }
}
