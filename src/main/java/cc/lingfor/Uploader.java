package cc.lingfor;

public class Uploader
{
  private Storage storage;

  public Uploader(Storage storage) {
    this.storage = storage;
  }

  public UploadResult upload(User user) {
    String token = this.storage.getToken(user);
    doUpload(token);
    return new UploadResult(user.getId(), token);
  }

  private void doUpload(String token) {
    //do real upload
  }


}