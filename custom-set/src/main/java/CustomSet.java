import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class CustomSet<T> {
    private final HashSet<T> set;

    public CustomSet(List<T> set) {
        this(new HashSet<>(set));
    }

    private CustomSet(HashSet<T> set) {
        if (set == null) throw new IllegalArgumentException();
        this.set = set;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(T s) {
        return set.contains(s);
    }

    public boolean isSubset(CustomSet<T> set) {
        return this.set.containsAll(set.set);
    }

    public boolean isDisjoint(CustomSet<T> set) {
        return this.set.stream().noneMatch(set::contains);
    }

    public void add(T element) {
        set.add(element);
    }

    public CustomSet<T> getIntersection(CustomSet<T> set) {
        var result = new HashSet<T>();

        for (var t : this.set) {
            if (set.contains(t))
                result.add(t);
        }

        return new CustomSet<>(result);
    }

    public CustomSet<T> getDifference(CustomSet<T> set) {
        var result = new HashSet<T>();

        for (var t : this.set) {
            if (!set.contains(t))
                result.add(t);
        }

        return new CustomSet<T>(result);
    }

    public CustomSet<T> getUnion(CustomSet<T> set) {
        var result = new HashSet<T>(this.set);
        result.addAll(set.set);
        return new CustomSet<>(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSet<?> customSet = (CustomSet<?>) o;
        return set.equals(customSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
