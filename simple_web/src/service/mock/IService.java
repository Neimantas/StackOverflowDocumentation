package service.mock;

import java.util.List;

public interface IService {
	List<Object> getListObject();
	List<Object> getListById(int id);
	List<Object> getListByName(String name);
}
