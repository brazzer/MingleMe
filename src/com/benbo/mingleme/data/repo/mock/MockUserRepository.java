package com.benbo.mingleme.data.repo.mock;

import java.util.ArrayList;
import java.util.List;

import com.benbo.mingleme.data.model.User;
import com.benbo.mingleme.data.repo.IUserRepository;
import com.benbo.mingleme.data.repo.RepositoryResult;
import com.benbo.mingleme.data.repo.RepositoryResultCallback;

public class MockUserRepository implements IUserRepository {

	@Override
	public List<User> getActiveUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		
		users.add(new User("KinkyBird","test@Test.com"));
		users.add(new User("up4It","test@Test2.com"));
		users.add(new User("KinkyBird","test@Test3.com"));
		users.add(new User("FilthyB1tch","test@Test4.com"));
		return users;
	}

	@Override
	public void getActiveUsersInBackground(
			RepositoryResultCallback<User> callback) {
		
		List<User> results = getActiveUsers();
		callback.complete(new RepositoryResult<User>(results));
		
	}

}
