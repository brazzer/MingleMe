package com.benbo.mingleme.data.repo;

import java.util.List;

public class RepositoryResult<T> {
	private final T _result;
	private final List<T> _results;
	private final Exception _error;
	
	public RepositoryResult(T result){
		_result = result;
		_results = null;
		_error = null;
	}
	public RepositoryResult(List<T> results){
		_results = results;
		_result = null;
		_error = null;
	}
	public RepositoryResult(Exception error){
		_error = error;
		_result = null;
		_results = null;
	}
	
	public T getResult() {
		return _result;
	}
	
	public List<T> getResults() {
		return _results;
	}
	
	public Exception getError() {
		return _error;
	}
	
}
