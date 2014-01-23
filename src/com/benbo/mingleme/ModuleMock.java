package com.benbo.mingleme;

import com.benbo.mingleme.data.repo.IUserRepository;
import com.benbo.mingleme.data.repo.mock.MockUserRepository;

import dagger.Module;
import dagger.Provides;

@Module(
	    injects = MainActivity.class,
	    complete = false
	)
public class ModuleMock {

	@Provides IUserRepository provideUserRepository(){
		return new MockUserRepository();
	}
	
}
