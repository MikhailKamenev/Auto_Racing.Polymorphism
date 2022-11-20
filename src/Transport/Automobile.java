package Transport;

import Driver.Driver;

public class Automobile extends Car implements Competing{
    //добавлен блок по enum
    public enum BodyTypes {
        SEDAN("седан"), COUPE("купе"), HATCHBACK("хетчбэк"), WAGON("универсал"), SUV("внедорожник"),
        CROSSOVER("кроссовер"), PICKUP("пикап"), VAN("фургон"), MINIVAN("минивен");

        public static BodyTypes identityBodyType(String bodyType) {
            for (BodyTypes types : values()) {
                if (types.getBodyType().equals(bodyType)) {
                    return types;
                }
            }
            return null;
        }
        private final String bodyType;

        BodyTypes(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }
    }

    private BodyTypes bodyType;

    public Automobile(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public Automobile(String brand, String model, double engineVolume, BodyTypes bodyType) {
        super(brand, model, engineVolume);
            this.bodyType = bodyType;
    }

    @Override
    public void doCheck() {
        super.doCheck();
    }

    public void identifyBodyType() {
        if (getBodyType() == null) {
            System.out.println("У автомобиля "+getBrand()+" "+getModel()+" отсутствуют данные о типе кузова");
        } else {
            System.out.println("У автомобиля "+getBrand()+" "+getModel()+" тип кузова - "+bodyType.getBodyType());
        }
    }

    private BodyTypes getBodyType() {
        return bodyType;
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
                System.out.println("Новый рекорд круга автомобиля "+getBrand()+" "+getModel()+
                        " - "+ringTime.getBestRingTime()+" секунд.");
            } else {
                System.out.println("Рекорд круга не побит. время круга - "+ringTimes[i]+" секунд.");
            }
        }
    }

    @Override
    public void maxSpeed() {
        int[] maxSpeed=new int[3];
        for (int i = 0; i < maxSpeed.length; i++) {
            maxSpeed[i]=((int)(Math.random()*30)+220);
            System.out.println("Максимальная скорость автомобиля "+getBrand()+" "+ getModel()
                    +" на "+(i+1)+" круге - "+maxSpeed[i]+" км/ч.");
        }
    }

}