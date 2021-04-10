import org.json.JSONPropertyName;

import java.util.*;

import static java.util.Collections.unmodifiableMap;

/** POJO representing a User in the database. */
public class User {
    private final String name;
    private final Map<String, Double> owes;
    private final Map<String, Double> owedBy;
    private final double balance;

    private User(String name, Map<String, Double> owes, Map<String, Double> owedBy, double balance) {
        this.name = name;
        this.owes = new HashMap<>(owes);
        this.owedBy = new HashMap<>(owedBy);
        this.balance = balance;
    }

    @JSONPropertyName("name")
    public String name() {
        return name;
    }

    /** IOUs this user owes to other users. */
    @JSONPropertyName("owes")
    public Map<String, Double> owes() {
        return unmodifiableMap(owes);
    }

    /** IOUs other users owe to this user. */
    @JSONPropertyName("owedBy")
    public Map<String, Double> owedBy() {
        return unmodifiableMap(owedBy);
    }

    @JSONPropertyName("balance")
    public double balance() {
        return this.balance;
    }

    public static Builder builder() {
        return new Builder();
    }

    public User addOwedBy(String name, double amount) {
        return toBuilder().owedBy(name, amount).build();
    }

    public User addOwes(String name, double amount) {
        return toBuilder().owes(name, amount).build();
    }

    private Builder toBuilder() {
        return new Builder(this.name, this.owes, this.owedBy, this.balance);
    }

    public static class Builder {
        private String name;
        private final Map<String, Double> owes = new HashMap<>();
        private final Map<String, Double> owedBy = new HashMap<>();
        private double balance = 0d;

        private Builder() {
            super();
        }

        private Builder(String name, Map<String, Double> owes, Map<String, Double> owedBy, double balance) {
            this.name = name;
            this.owes.putAll(owes);
            this.owedBy.putAll(owedBy);
            this.balance = balance;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder owes(String name, double amount) {
            owes.put(name, owes.getOrDefault(name, 0d) + amount);
            balance -= amount;
            return this;
        }

        public Builder owedBy(String name, double amount) {
            owedBy.put(name, owedBy.getOrDefault(name, 0d) + amount);
            balance += amount;
            return this;
        }

        public User build() {
            Set<String> names = new HashSet<>();
            names.addAll(owes.keySet());
            names.addAll(owedBy.keySet());
            for (String name : names) {
                double owedBy = this.getOwedBy(name);
                double owes = this.getOwes(name);
                double balancePerName = Math.abs(owedBy - owes);
                if (owedBy > owes) {
                    this.owedBy.put(name, balancePerName);
                    this.owes.remove(name);
                } else if (owedBy == owes) {
                    this.owedBy.remove(name);
                    this.owes.remove(name);
                } else {
                    this.owes.put(name, balancePerName);
                    this.owedBy.remove(name);
                }
            }
            return new User(name, owes, owedBy, balance);
        }

        private double getOwedBy(String name) {
            return owedBy.getOrDefault(name, 0d);
        }

        private double getOwes(String name) {
            return owes.getOrDefault(name, 0d);
        }
    }
}