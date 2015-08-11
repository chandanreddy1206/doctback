package com.paulusworld.drawernavigationtabs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements OnClickListener {

	public final static String TAG = HomeFragment.class.getSimpleName();
	private Button events;
	private Button askDocter;
	private Button videoCall;
	private Button appointments;
	private FragmentActivity callbackActivity;
	public HomeFragment() {
		
	}

	public static HomeFragment newInstance() {
		return new HomeFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.activity_home, container, false);
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		callbackActivity=(FragmentActivity)activity;
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		
		super.onViewCreated(view, savedInstanceState);
		
		events=(Button)view.findViewById(R.id.home_tile_events);
		askDocter = (Button) view.findViewById(R.id.home_tile_askdocter);
		videoCall = (Button) view.findViewById(R.id.home_tile_video_call);
		appointments = (Button) view.findViewById(R.id.home_tile_apppointments);
		
		events.setOnClickListener(this);
		askDocter.setOnClickListener(this);
		videoCall.setOnClickListener(this);
		appointments.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId() == events.getId())
		{
			TabbedActivity tabbedActivity= TabbedActivity.newInstance();
			Bundle args= new Bundle();
			args.putInt("target", 2);
			tabbedActivity.setArguments(args);
			
			FragmentManager fragmentManager= callbackActivity.getSupportFragmentManager();
			FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, tabbedActivity, TabbedActivity.TAG);
			fragmentTransaction.addToBackStack("tag");
			fragmentTransaction.commit();
		}
		else if(v.getId() == askDocter.getId())
		{
			ChatActivity chatActivity= ChatActivity.newInstance();
			Bundle args= new Bundle();
			args.putInt("target", 1);
			chatActivity.setArguments(args);

			FragmentManager fragmentManager= callbackActivity.getSupportFragmentManager();
			FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, chatActivity, ChatActivity.TAG);
			fragmentTransaction.addToBackStack("tag");
			fragmentTransaction.commit();
		}
		else if(v.getId() == videoCall.getId())
		{
			ChatActivity chatActivity= ChatActivity.newInstance();
			Bundle args= new Bundle();
			args.putInt("target", 2);
			chatActivity.setArguments(args);
			

			FragmentManager fragmentManager= callbackActivity.getSupportFragmentManager();
			FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, chatActivity, ChatActivity.TAG);
			fragmentTransaction.addToBackStack("tag");
			fragmentTransaction.commit();
		}
		else if(v.getId() == appointments.getId())
		{
			TabbedActivity tabbedActivity= TabbedActivity.newInstance();
			Bundle args= new Bundle();
			args.putInt("target", 1);
			tabbedActivity.setArguments(args);

			FragmentManager fragmentManager= callbackActivity.getSupportFragmentManager();
			FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, tabbedActivity, TabbedActivity.TAG);
			fragmentTransaction.addToBackStack("tag");
			fragmentTransaction.commit();
		}
	}
}
