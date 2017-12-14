package service;

import java.io.IOException;

public interface FileService {

	public String getFileContent(String path) throws IOException;
}
