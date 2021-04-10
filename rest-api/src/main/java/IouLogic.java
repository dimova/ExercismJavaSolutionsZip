import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IouLogic {
  private Map<String, User> users = new ConcurrentHashMap<>();

  public IouLogic(List<User> users) {
    for(User user : users) {
      this.users.putIfAbsent(user.name(), user);
    }
  }

  public List<User> getUsers(Set<String> userNames) {
    return this.users.values().stream()
      .filter(usersPredicate(userNames))
      .sorted(Comparator.comparing(User::name))
      .collect(Collectors.toList());
  }

  public List<User> addIou(Iou iou) {
    User lender = this.users.get(iou.lender);
    User borrower = this.users.get(iou.borrower);
    User lenderUpdated = lender.addOwedBy(borrower.name(), iou.amount);
    User borrowerUpdated = borrower.addOwes(lender.name(), iou.amount);
    this.users.put(lenderUpdated.name(), lenderUpdated);
    this.users.put(borrowerUpdated.name(), borrowerUpdated);
    return getUsers(Set.of(lender.name(), borrower.name()));
  }

  public User addUser(String userName) {
    User newUser = User.builder().setName(userName).build();
    users.put(userName, newUser);
    return newUser;
  }

  private Predicate<User> usersPredicate(Set<String> userNames) {
    if (userNames.isEmpty()) return user -> true;
    else return user -> userNames.contains(user.name());
  }
}