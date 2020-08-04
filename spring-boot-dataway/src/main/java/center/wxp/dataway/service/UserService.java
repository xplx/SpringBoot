package center.wxp.dataway.service;



import center.wxp.dataway.entity.User;

import java.util.List;

public interface UserService {
	public List<User> allUser();
	public User getUserById(Long id);
	public void updateUser(Long id, Integer type);
}
