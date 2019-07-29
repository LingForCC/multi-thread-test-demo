package cc.lingfor;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.concurrent.*;

public class UploaderTest {

	@Test
	public void testMultiThreadUpload() {

		Storage storage = new Storage();
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 100; i++) {
			User user = new User(i);
			users.add(user);
			storage.generateToken(user);
		}

		Uploader uploader = new Uploader(storage);

		//invoke upload in multiple thread
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("multi-thread-test").build();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(80, 80, 100, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(), threadFactory);
		threadPool.allowCoreThreadTimeOut(true);
		ArrayList<Future<UploadResult>> uploadResults = new ArrayList<Future<UploadResult>>();
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			Future<UploadResult> result = threadPool.submit(() -> uploader.upload(user));
			uploadResults.add(result);
		}

		// assert the user id and token is the same
		for (int i = 0; i < uploadResults.size(); i++) {
			Future<UploadResult> future = uploadResults.get(i);
			try {
				UploadResult result = future.get();
				assertEquals(result.getUserId(), result.getToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
