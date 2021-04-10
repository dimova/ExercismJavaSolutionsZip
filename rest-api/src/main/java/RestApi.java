import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

class RestApi {

  private IouLogic iouLogic;

  public RestApi(User... users) {
    this.iouLogic = new IouLogic(Arrays.asList(users));
  }

  String get(String url) {
    return doGet(url, null);
  }

  String get(String url, JSONObject payload) {
    return doGet(url, payload);
  }


  String post(String url, JSONObject payload) {
    if ("/add".equals(url)) return addUser(payload);
    else if("/iou".equals(url)) return addIou(payload);
    throw new NoSuchMethodError("Not yet impl.");
  }

  private String doGet(String url, JSONObject payload) {
    if ("/users".equals(url)) {
      if (payload == null) return getUsers(Collections.emptySet());
      else return getUsers(parseUserNames(payload));
    }
    throw new NoSuchMethodError("Url is not supported");
  }

  private String addUser(JSONObject payload) {
    String userName = payload.getString("user");
    return new JSONObject(this.iouLogic.addUser(userName)).toString();
  }

  private String addIou(JSONObject payload) {
    Iou iou = parseIou(payload);

    this.iouLogic.addIou(iou);
    return getUsers(Set.of(iou.lender, iou.borrower));
  }

  private Iou parseIou(JSONObject payload) {
    String lender = payload.getString("lender");
    String borrower = payload.getString("borrower");
    double amount = payload.getDouble("amount");
    return new Iou(lender, borrower, amount);
  }

  private String getUsers(Set<String> userNames) {
    List<User> users = this.iouLogic.getUsers(userNames);
    return new JSONObject().put("users", new JSONArray(users)).toString();
  }

  private Set<String> parseUserNames(JSONObject payload) {
    Set<String> userNames = new HashSet<>();
    for (Object userName : payload.getJSONArray("users")) {
      if (userName instanceof String) {
        userNames.add((String) userName);
      }
    }
    return Collections.unmodifiableSet(userNames);
  }
}