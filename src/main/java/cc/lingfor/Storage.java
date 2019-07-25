
package cc.lingfor;

import java.util.HashMap;

public class Storage {

  private HashMap<String, String> tokens;

  public Storage() {
    this.tokens = new HashMap<String, String>();
  }

  public void addToken(User user) {
    String userId = user.getId();
    this.tokens.put(userId, userId);
  }

  public String getToken(User user) {
    return this.tokens.get(user.getId());
  }

}