package Transport;

public class Sponsor {
    private String name;
    private final int sum;

    public Sponsor(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void toSponsor() {
        System.out.printf("Спонсор %s проспонсировал заезд на сумму %d%n", name, sum);
    }
}
