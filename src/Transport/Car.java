package Transport;

import java.util.Objects;

public abstract class Car {
    public class RingTime {
        private double firstRingTime;
        private double secondRingTime;
        private double thirdRingTime;
        private double bestRingTime;

        public RingTime() {
            this(230, 230, 230);
        }
        public RingTime(double firstRingTime, double secondRingTime, double thirdRingTime) {
            if (this.firstRingTime != 0 && this.firstRingTime > 0) {
                firstRingTime = this.firstRingTime;
            } else {this.firstRingTime = firstRingTime;
            }
            if (this.secondRingTime != 0 && this.secondRingTime > 0) {
                secondRingTime = this.secondRingTime;
            } else {this.secondRingTime = secondRingTime;
            }
            if (this.thirdRingTime != 0 && this.thirdRingTime > 0) {
                thirdRingTime = this.thirdRingTime;
            } else {
                this.thirdRingTime = thirdRingTime;}
            double[]ringTime = new double[]{this.firstRingTime, this.secondRingTime, this.thirdRingTime};
            for (int i = 0; i < ringTime.length; i++) {
                if (ringTime[i] < this.bestRingTime && ringTime[i] > 0) {
                    this.bestRingTime = ringTime[i];
                } else {
                    this.bestRingTime = 400;
                }
            }
        }

        public double getFirstRingTime() {
            return firstRingTime;
        }
        public double getSecondRingTime() {
            return secondRingTime;
        }
        public double getThirdRingTime() {
            return thirdRingTime;
        }
        public double getBestRingTime() {
            return bestRingTime;
        }

        public void setFirstRingTime(double firstRingTime) {
            if (this.firstRingTime != 0 && this.firstRingTime > 0) {
                firstRingTime = this.firstRingTime;
            } else {
                this.firstRingTime = firstRingTime;
            }
        }
        public void setSecondRingTime(double secondRingTime) {
            if (this.secondRingTime != 0 && this.secondRingTime > 0) {
                secondRingTime = this.secondRingTime;
            } else {
                this.secondRingTime = secondRingTime;
            }
        }
        public void setThirdRingTime(double thirdRingTime) {
            if (this.thirdRingTime != 0 && this.thirdRingTime > 0) {
                thirdRingTime = this.thirdRingTime;
            } else {
                this.thirdRingTime = thirdRingTime;
            }
        }

        public void setBestRingTime(double bestRingTime) {
            if (bestRingTime > 0 && bestRingTime < this.bestRingTime) {
                this.bestRingTime = bestRingTime;
            } else if (this.bestRingTime <= 0 && bestRingTime > 0) {
                this.bestRingTime = bestRingTime;
            } else {
                this.bestRingTime = 100000000;
            }
        }
    }
    private String brand;
    private String model;
    private final double engineVolume;
    RingTime ringTime;

    public Car(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "Unknown";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "Unknown";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0 || engineVolume > 20) {
            this.engineVolume = 2.0;
        } else {
            this.engineVolume = engineVolume;
        }
        if (ringTime == null) {
            this.ringTime = new RingTime();
        }
    }

    public void setBrand(String brand) {
        if (this.brand == "Unknown") {
            this.brand = brand;
        } else {
            System.out.println("Вы не можете изменять уже заданную марку авто. Марка авто - "+getBrand());
        }
    }
    public void setModel(String model) {
        if (this.model == "Unknown") {
            this.model = model;
        }else {
            System.out.println("Вы не можете изменять уже заданную модель авто. Модель авто - "+getModel());
        }
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public double getEngineVolume() {
        return engineVolume;
    }

    public abstract void startDriving();
    public abstract void finishDriving();
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.getEngineVolume(), getEngineVolume()) == 0 && getBrand().equals(car.getBrand()) && getModel().equals(car.getModel());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getEngineVolume());
    }

}
