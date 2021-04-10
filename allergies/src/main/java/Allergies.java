import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class Allergies {
    private final List<Allergen> allergenList;

    public Allergies(int allergies) {
        allergenList = Arrays.stream(Allergen.values())
            .filter(allergen -> allergen.isPresent(allergies))
            .collect(toList());
    }

    public boolean isAllergicTo(Allergen allergen) {
        return allergenList.contains(allergen);
    }

    public List<Allergen> getList() {
        return allergenList;
    }
}
