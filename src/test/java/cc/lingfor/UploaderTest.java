package cc.lingfor;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class UploaderTest {

    @Test public void testMultiThreadUpload() {

      Storage storage = new Storage();

      ArrayList<User> users = new ArrayList<User>();
      for(int i = 0; i< 100; i++){
          User user = new User(i);
          users.add(user);
          storage.addToken(user);
      }

      Uploader uploader = new Uploader(storage);
      //invoke upload in multiple thread

      

      //assert the user id and token is correct

        //assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
