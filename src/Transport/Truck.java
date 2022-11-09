package Transport;

public class Truck extends Car implements Competing{
    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startDriving() {
        System.out.println("Попытаться залезть в кабину.");
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
        System.out.println("Попытаться вылезти из кабины.");
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
        int [] maxSpeed=new int[3];
        for (int i = 0; i < maxSpeed.length; i++) {
            maxSpeed[i]=((int)(Math.random()*30)+220);
            System.out.println("Максимальная скорость автомобиля "+getBrand()+" "+ getModel()
                    +" на "+(i+1)+" круге - "+maxSpeed[i]+" км/ч.");
        }
    }
}
