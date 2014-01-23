package com.benbo.mingleme.data.repo;

import java.util.List;
import com.benbo.mingleme.data.model.User;

public interface IUserRepository {

	List<User> getActiveUsers();
	void getActiveUsersInBackground(RepositoryResultCallback<User> callback);
}
