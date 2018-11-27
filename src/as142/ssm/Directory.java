package as111.ssm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({User.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Directory {
	private List<User> users = new ArrayList<User>();
	
	public Directory() {
	}
	
	public boolean addUser(User user) {
		String newId = user.getContractId();
		for(User registeredUser : users) {
			if(registeredUser.getContractId().equals(newId)) {
				return false;
			}
		}
		users.add(user);
		return true;
	}
	
	public void sort(Comparator<User> comparator) {
		Collections.sort(users, comparator);
	}
	
	public User getUser(int index) {
		if(index >= 0 && index < users.size()) {
			return users.get(index);
		}
		return null;
	}
	
	public int getUsersCount() {
		return users.size();
	}
}
