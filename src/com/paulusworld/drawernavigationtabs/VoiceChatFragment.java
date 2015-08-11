package com.paulusworld.drawernavigationtabs;

import java.util.ArrayList;
import java.util.List;

import com.paulusworld.drawernavigationtabs.adapter.CustomDoctorGridAdapter;
import com.paulusworld.drawernavigationtabs.bean.Doctor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
	 * A fragment representing Voice Chat. Facilitates text and voice chat.
	 */
	public class VoiceChatFragment extends Fragment {

		private ArrayAdapter<String> listAdapter;

		private TextView location;
		private TextView gender;
		private TextView age;
		private RadioGroup doctorCategory;
		private RadioButton doctorGP;
		private RadioButton doctorExpert;
		private GridView doctorGridView;
		
		private FragmentActivity callbackActivity;
		
		public VoiceChatFragment() {
		}

		@Override
		public void onAttach(Activity activity) {
			// TODO Auto-generated method stub
			super.onAttach(activity);
			callbackActivity=(FragmentActivity)activity;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_tabbed_chat_voice, container, false);
			/*ListView listView = (ListView) rootView.findViewById(R.id.chat_voice_list_view);
			List<String> strings = new ArrayList<String>();
			for (int i = 0; i < 100; i++) {
				strings.add(i + "");
			}
			listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.drawer_list_item, strings);
			listView.setAdapter(listAdapter);
			listView.setOnScrollListener(new AbsListView.OnScrollListener() {
				private int mLastFirstVisibleItem;

				@Override
				public void onScrollStateChanged(AbsListView view, int scrollState) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
					TypedValue tv = new TypedValue();
					if (mLastFirstVisibleItem < firstVisibleItem) {
						getActivity().getActionBar().hide();
						
					}
					if (mLastFirstVisibleItem > firstVisibleItem) {

						if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
						{
						    System.out.println(TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics()));
						}
						getActivity().getActionBar().show();
					}
					mLastFirstVisibleItem = firstVisibleItem;
				}
			});*/
			
			location = (TextView) rootView.findViewById(R.id.chat_voice_location);
			gender = (TextView) rootView.findViewById(R.id.chat_voice_gender);
			age = (TextView) rootView.findViewById(R.id.chat_voice_age);
			doctorCategory = (RadioGroup) rootView.findViewById(R.id.chat_voice_doctor_category);
			doctorGP = (RadioButton) rootView.findViewById(R.id.chat_voice_gp);
			doctorExpert = (RadioButton) rootView.findViewById(R.id.chat_voice_expert);
			doctorGridView = (GridView) rootView.findViewById(R.id.chat_voice_doctor_grid_view);
			
			List<Doctor> doctors= new ArrayList<Doctor>();
			for(int i =0;i<10;i++)
			{
				Doctor doctor = new Doctor();
				doctor.setName("D: "+i);
				doctor.setRating(i%5);
				doctors.add(doctor);
			}
			
			doctorGridView.setAdapter(new CustomDoctorGridAdapter(callbackActivity, doctors));
			return rootView;
		}
	}
