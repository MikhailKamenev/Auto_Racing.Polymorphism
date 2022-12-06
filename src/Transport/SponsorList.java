package Transport;

import java.util.HashSet;
import java.util.Set;

public class SponsorList {
    private Set<Sponsor> sponsors = new HashSet<>();

    public void addSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    @Override
    public String toString() {
        return "Спонсоры: "+sponsors.toString();
    }
}
