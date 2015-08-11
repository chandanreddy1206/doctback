package com.paulusworld.drawernavigationtabs;

import com.paulusworld.drawernavigationtabs.adapter.CustomChatVoiceMessageListAdapter;
import com.paulusworld.drawernavigationtabs.bean.Doctor;
import com.paulusworld.drawernavigationtabs.bean.User;
import com.paulusworld.drawernavigationtabs.util.SharingPreferences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionAnsFragment extends Fragment
{
	public static final String TAG = QuestionAnsFragment.class.getSimpleName();
	
	private TextView location;
	private TextView gender;
	private TextView age;
	private TextView doctorCategory;
	private ListView questionAnsListView;
	private EditText questionAnsEditText;
	
	public static QuestionAnsFragment newInstance()
	{
		return new QuestionAnsFragment();
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Toast.makeText(getActivity(), "onCreateViewQAF", Toast.LENGTH_SHORT).show();
		
		Bundle args= getArguments();
		Doctor doctor = (Doctor) args.getSerializable("doctor");
		SharingPreferences<User> sharingPreferences = new SharingPreferences<User>();
		User user = sharingPreferences.get(getActivity(), "user", User.class);
		
		View view = inflater.inflate(R.layout.fragment_question_ans, null); 

		location = (TextView) view.findViewById(R.id.question_ans_location);
		gender = (TextView) view.findViewById(R.id.question_ans_gender);
		age = (TextView) view.findViewById(R.id.question_ans_age);
		doctorCategory = (TextView) view.findViewById(R.id.question_ans_doctor_catogery);
		questionAnsListView = (ListView) view.findViewById(R.id.question_ans_listview);
		
		location.setText("Hyd");
		doctorCategory.setText("abc");
		gender.setText("M");
//		gender.setText(user.getGender());
//		doctorCategory.setText(doctor.getCategory());
		questionAnsListView.setAdapter(new CustomChatVoiceMessageListAdapter(getActivity()));
		return view;
	}
}
