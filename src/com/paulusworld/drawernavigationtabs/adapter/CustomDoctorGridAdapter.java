package com.paulusworld.drawernavigationtabs.adapter;

import java.util.List;

import com.android.volley.toolbox.NetworkImageView;
import com.paulusworld.drawernavigationtabs.QuestionAnsFragment;
import com.paulusworld.drawernavigationtabs.R;
import com.paulusworld.drawernavigationtabs.TabbedActivity;
import com.paulusworld.drawernavigationtabs.bean.Doctor;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDoctorGridAdapter extends BaseAdapter
{
	private LayoutInflater layoutInflater;
	private List<Doctor> doctors;
	private FragmentActivity callbackActivity;
	public CustomDoctorGridAdapter(FragmentActivity callbackActivity,List<Doctor> doctors ) 
	{
		this.callbackActivity=callbackActivity;
		this.layoutInflater=(LayoutInflater)callbackActivity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.doctors=doctors;
	}
	@Override
	public int getCount() {
		return doctors.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	public class Holder
    {
        NetworkImageView doctorImageView;
        TextView doctorName;
        RatingBar doctorRatingBar;
    }
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		Holder holder = new Holder();
		if(convertView == null)
		{
			final Doctor doctor = doctors.get(position);
			View doctorView = layoutInflater.inflate(R.layout.doctor_grid_element,null);
			holder.doctorImageView = (NetworkImageView) doctorView.findViewById(R.id.doctor_network_image_view);
			holder.doctorName = (TextView) doctorView.findViewById(R.id.doctor_name);
			holder.doctorRatingBar = (RatingBar) doctorView.findViewById(R.id.doctor_rating_bar);
			
			holder.doctorName.setText(doctor.getName());
			holder.doctorRatingBar.setRating(doctor.getRating());
//			holder.doctorImageView.set   TODO
			
			doctorView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(v.getContext(), "You Clicked "+doctor.getName(), Toast.LENGTH_SHORT).show();
//					QuestionAnsFragment questionAnsFragment = new QuestionAnsFragment();
//					Bundle args= new Bundle();
//					args.putSerializable("doctor", doctor);
//					questionAnsFragment.setArguments(args);
					
					TabbedActivity tabbedActivity= TabbedActivity.newInstance();
					Bundle args= new Bundle();
					args.putInt("target", 1);
					tabbedActivity.setArguments(args);
					
					FragmentManager fragmentManager= callbackActivity.getSupportFragmentManager();
					FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
					fragmentTransaction.replace(R.id.content_frame, tabbedActivity, QuestionAnsFragment.TAG);
					fragmentTransaction.addToBackStack("tag");
					fragmentTransaction.commit();
				}
			});
			return doctorView;
		}
		else
		{
			return convertView;
		}
	}

}
