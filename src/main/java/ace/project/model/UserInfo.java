package ace.project.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
	private List<User>userList = new ArrayList<>();
	
	public void addUser(User user) {
		this.userList.add(user);
	}
}
