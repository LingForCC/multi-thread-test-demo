package cc.lingfor;

public class UploadResult {

  private String userId;
  private String token;

  public UploadResult(String userId, String token) {
    this.userId = userId;
    this.token = token;
  }

  public String getUserId() {
    return this.userId;
  }

  public String getToken() {
    return this.token;
  }
}