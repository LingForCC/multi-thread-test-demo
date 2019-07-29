package cc.lingfor;

public class Uploader
{
  private Storage storage;
  String token = null;

  public Uploader(Storage storage) {
    this.storage = storage;
  }

  public UploadResult upload(User user) {
    token = this.storage.getToken(user);
    doUpload(token);
    return new UploadResult(user.getId(), token);
  }

  private void doUpload(String token) {
    //do real upload
  }


}