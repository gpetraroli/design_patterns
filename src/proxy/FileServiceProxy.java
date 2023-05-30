package proxy;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class FileServiceProxy implements IFileService {
    private IFileService fileService;

    private List<File> cachedFiles = new ArrayList<>();

    FileServiceProxy() {
        this.fileService = new FileService();
    }

    @Override
    public File getFile(String name) {
        if (!cachedFiles.isEmpty()){
            for (File file : cachedFiles) {
                if (file.getName().equals(name)) {
                    return file;
                }
            }
        }

        // File not found in cashed, retrieve it from fileService
        File file = fileService.getFile(name);

        if (file != null) {
            cachedFiles.add(file);
        }

        return file;
    }
}
