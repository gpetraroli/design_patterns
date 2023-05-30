package proxy;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        IFileService realFileService = new FileService();

        Instant t0 = Instant.now();
        realFileService.getFile("file_name");
        Instant t1 = Instant.now();
        realFileService.getFile("file_name");
        Instant t2 = Instant.now();

        System.out.println("========== \"real\" FileService ==========\n");
        System.out.println("Time to retrieve the file the first time: " + Duration.between(t0, t1).toMillis() + " milliseconds\n");
        System.out.println("Time to retrieve the file the second time: " + Duration.between(t1, t2).toMillis() + " milliseconds\n");
        System.out.println("Total time for the 2 operations: " + Duration.between(t0, t2).toMillis() + " milliseconds\n");

        // Using the proxy version
        IFileService proxyFileService = new FileServiceProxy();

        Instant t3 = Instant.now();
        proxyFileService.getFile("file_name");
        Instant t4 = Instant.now();
        proxyFileService.getFile("file_name");
        Instant t5 = Instant.now();

        System.out.println("========== FileServiceProxy ==========\n");
        System.out.println("Time to retrieve the file the first time: " + Duration.between(t3, t4).toMillis() + " milliseconds\n");
        System.out.println("Time to retrieve the file the second time: " + Duration.between(t4, t5).toMillis() + " milliseconds\n");
        System.out.println("Total time for the 2 operations: " + Duration.between(t3, t5).toMillis() + " milliseconds\n");
    }
}
