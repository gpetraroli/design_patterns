package moks;

import java.io.File;

public class MockRemoteFileResource {
    public static File getFileByName(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
            // do nothing
        }

        return new File(name);
    }
}
