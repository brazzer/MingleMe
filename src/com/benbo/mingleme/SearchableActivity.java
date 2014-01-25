package com.benbo.mingleme;

import javax.inject.Inject;

import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class SearchableActivity extends ListActivity {

	@Inject 
	LocationManager _locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchable);
		
		 // Get the intent, verify the action and get the query
	    Intent intent = getIntent();
	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
	      String query = intent.getStringExtra(SearchManager.QUERY);
	      doMySearch(query);
	    }
	}

	private void doMySearch(String query) {
		String[] results = {query};
		
	setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,results));
	
//	_locationManager.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.searchable, menu);
		return true;
	}

}
