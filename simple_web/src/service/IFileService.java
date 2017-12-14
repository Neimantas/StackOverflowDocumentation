package service;

import java.io.IOException;

public interface IFileService {

	public String getFileContent(String path) throws IOException;
}
