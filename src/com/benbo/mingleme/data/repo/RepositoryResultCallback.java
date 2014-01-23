package com.benbo.mingleme.data.repo;

public abstract class RepositoryResultCallback<T> {

	public abstract void complete(RepositoryResult<T> result);

}
