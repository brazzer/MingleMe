package com.benbo.mingleme;

import javax.inject.Inject;

import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class FragmentCheckIn extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.activity_fragment_check_in, container,
				false);
		
		
	}
}
