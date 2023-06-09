package proxy;

import moks.MockRemoteFileResource;

import java.io.File;

public class FileService implements IFileService {
    @Override
    public File getFile(String name) {
        return MockRemoteFileResource.getFileByName(name);
    }
}
