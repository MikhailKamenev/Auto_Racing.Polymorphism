package Transport;

public class Bus extends Car implements Competing {
    //добавлен блок по enum
    public enum Capacity{
        EXTRA_LOW("до 10 мест"),LOW("до 25 мест"),MIDDLE("40-50 мест"),
        LARGE("60-80 мест"),EXTRA_LARGE("100-120 мест");
        private final String capacity;

        Capacity(String capacity) {
            this.capacity = capacity;
        }

        public static Capacity identifyCapacity(String capacity) {
            for (Capacity value : values()) {
                if (value.getCapacity().equals(capacity)) {
                    return value;
                }
            }
            return null;
        }
        public String getCapacity() {
            return capacity;
        }
    }
    private Capacity capacity;
    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public void printCapacity() {
        if (getCapacity() == null) {
            System.out.println("У автомобиля "+getBrand()+" "+getModel()+" отсутствуют данные об пассажировместимости.");

        } else {
            System.out.println("В автобусе "+getBrand()+" "+getModel()+" "+capacity.getCapacity());
        }
    }
    private Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void startDriving() {
        System.out.println("Сесть на водительское место. Пристегнуться");
        System.out.println("Запустить двигатель");
        System.out.println("Выбрать передачу. Оценить дорожную ситуацию. Начать движение");
    }

    @Override
    public void finishDriving() {
        System.out.println("Припарковаться.");
        System.out.println("Выбрать правильное пложение селектора КПП в зависимости от типа КПП. " +
                "Активировать стояночный тормоз.");
        System.out.println("Заглушить двигатель. Отстегнуть ремень безопасности.");
        System.out.println("Проверить не остались ли бомжи ночевать в автобусе");
    }

    @Override
    public String doPitStop() {
        return "Заехать на пит-стоп. Выполнить обслуживание. Уехать с пит-стопа.";
    }

    @Override
    public void compareToBestRingTime(RingTime ringTime) {
        double[] ringTimes = new double[]{ringTime.getFirstRingTime(), ringTime.getSecondRingTime(),
                ringTime.getThirdRingTime()};
        for (int i = 0; i < ringTimes.length; i++) {
            if (ringTimes[i] < ringTime.getBestRingTime() && ringTimes[i] > 0) {
                ringTime.setBestRingTime(ringTimes[i]);
                System.out.println("Новый рекорд круга автомобиля " + getBrand() + " " + getModel() +
                        " - " + ringTime.getBestRingTime() + " секунд.");
            } else {
                System.out.println("Рекорд круга не побит. время круга - " + ringTimes[i] + " секунд.");
            }
        }
    }

    @Override
    public void maxSpeed() {
        int[] maxSpeed = new int[3];
        for (int i = 0; i < maxSpeed.length; i++) {
            maxSpeed[i] = ((int) (Math.random() * 30) + 220);
            System.out.println("Максимальная скорость автомобиля " + getBrand() + " " + getModel()
                    + " на " + (i + 1) + " круге - " + maxSpeed[i] + " км/ч.");
        }
    }
}
