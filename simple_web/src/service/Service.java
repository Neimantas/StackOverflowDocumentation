package service;

import java.util.ArrayList;
import java.util.List;

public class Service implements IService{

	@Override
	public List<Object> getListObject() {
		// TODO Auto-generated method stub
		List<Object> listOfObject = new ArrayList();
		return listOfObject;
	}
	
	@Override
	public List<Object> getListById(int id) {
		// TODO Auto-generated method stub
		Service srvcList = new Service();
		List<Object> listById = new ArrayList(); 
//		for(Object lst: srvcList.getListObject()) {
//			if(lst.getId() == id) {
//				listById.add(lst);
//			}
//		}
		
		srvcList.getListObject().forEach(s -> {
//			int idChosen = s.getId();
			int idChosen = 0;
			if(idChosen == id) {
				listById.add(listById);
			}
		});
	
		return listById;
	}

	@Override
	public List<Object> getListByName(String name) {
		// TODO Auto-generated method stub
		List<Object> listByName = new ArrayList();
		Service srvcList = new Service();
		for(Object lst: srvcList.getListObject()) {
//			String chosenName = lst.getName();
			String chosenName = null;
			if(chosenName == name) {
				listByName.add(lst);
			}
		}
		return listByName;
	}

}
