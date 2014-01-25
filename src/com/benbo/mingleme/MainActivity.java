package com.benbo.mingleme;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.benbo.mingleme.data.model.User;
import com.benbo.mingleme.data.repo.IUserRepository;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {
	private String[] mMenuRight;
	private String[] mMenuLeft;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerListLeft;
	private ListView mDrawerListRight;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	@Inject IUserRepository _userRepository;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		((MingleMeApplication) getApplication()).inject(this);

		mMenuLeft = getResources().getStringArray(R.array.menu_left);
		mMenuRight = getResources().getStringArray(R.array.menu_right);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerListLeft = (ListView) findViewById(R.id.left_drawer);
		mDrawerListRight = (ListView) findViewById(R.id.right_drawer);
		
		setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);

		// Set the adapter for the list view
		mDrawerListLeft.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mMenuLeft));
		// Set the list's click listener
		mDrawerListLeft.setOnItemClickListener(new DrawerItemClickListener());

//		mDrawerListRight.setAdapter(new ArrayAdapter<String>(this,
//				R.layout.drawer_list_item, mMenuRight));
		
		populateRightMenu();

		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActionBar().setTitle("Mingle Me");
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle("Inbox");
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

	}
	public void onSearchRequested(View view){
		onSearchRequested();
	}


	private void populateRightMenu() {
		List<User> users = _userRepository.getActiveUsers();
		
		List<String> names = new ArrayList<String>();
		
		for (User user : users) {
			names.add(user.getUsername());
		}
		
		mDrawerListRight.setAdapter(new ArrayAdapter<String>(this,
		R.layout.drawer_list_item, names));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
		// Create a new fragment and specify the planet to show based on
		// position
		Fragment fragment;

		switch (position) {

		case 0:
			fragment = new FragmentCheckIn();
			break;
		case 1:
			fragment = new FragmentMatches();
			break;
		default:
			fragment = new FragmentCheckIn();
		}

		// Bundle args = new Bundle();
		// args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		// fragment.setArguments(args);
		// Insert the fragment by replacing any existing fragment
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// Highlight the selected item, update the title, and close the drawer
		mDrawerListLeft.setItemChecked(position, true);
		// setTitle(mPlanetTitles[position]);
		mDrawerLayout.closeDrawer(mDrawerListLeft);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

}
