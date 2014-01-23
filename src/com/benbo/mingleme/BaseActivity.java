package com.benbo.mingleme;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

	@Override protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    // Perform injection so that when this call returns all dependencies will be available for use.
	    ((MingleMeApplication) getApplication()).inject(this);
	  }
}
