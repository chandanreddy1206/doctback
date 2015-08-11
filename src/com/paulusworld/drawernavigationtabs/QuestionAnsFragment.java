package com.paulusworld.drawernavigationtabs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.paulusworld.drawernavigationtabs.adapter.CustomChatVoiceMessageListAdapter;
import com.paulusworld.drawernavigationtabs.bean.Doctor;
import com.paulusworld.drawernavigationtabs.bean.User;
import com.paulusworld.drawernavigationtabs.bean.VoiceMessage;
import com.paulusworld.drawernavigationtabs.util.AudioUtil;
import com.paulusworld.drawernavigationtabs.util.SharingPreferences;

public class QuestionAnsFragment extends Fragment implements OnClickListener {
	public static final String TAG = QuestionAnsFragment.class.getSimpleName();

	private TextView location;
	private TextView gender;
	private TextView age;
	private TextView doctorCategory;
	private ListView questionAnsListView;
	private ToggleButton record;
	private ToggleButton play;
	private Button send;
	private MediaPlayer mPlayer = null;
	private MediaRecorder mRecorder = null;

	public static QuestionAnsFragment newInstance() {
		return new QuestionAnsFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Bundle args = getArguments();
		Doctor doctor = (Doctor) args.getSerializable("doctor");
		SharingPreferences<User> sharingPreferences = new SharingPreferences<User>();
		User user = sharingPreferences.get(getActivity(), "user", User.class);

		View view = inflater.inflate(R.layout.fragment_question_ans, null);

		location = (TextView) view.findViewById(R.id.question_ans_location);
		gender = (TextView) view.findViewById(R.id.question_ans_gender);
		age = (TextView) view.findViewById(R.id.question_ans_age);
		doctorCategory = (TextView) view
				.findViewById(R.id.question_ans_doctor_catogery);
		questionAnsListView = (ListView) view
				.findViewById(R.id.question_ans_listview);
		record = (ToggleButton) view.findViewById(R.id.question_ans_record);
		play = (ToggleButton) view.findViewById(R.id.question_ans_play);
		send = (Button) view.findViewById(R.id.question_ans_send);

		record.setOnClickListener(this);
		play.setOnClickListener(this);
		send.setOnClickListener(this);

		location.setText("Hyd");
		doctorCategory.setText("abc");
		gender.setText("M");
		// gender.setText(user.getGender());
		// doctorCategory.setText(doctor.getCategory());
		List<VoiceMessage> voiceMessages = new ArrayList<VoiceMessage>();
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage.setLocalFileUlr("doctorquestion.3gp");
		voiceMessages.add(voiceMessage);
		questionAnsListView.setAdapter(new CustomChatVoiceMessageListAdapter(
				getActivity(),voiceMessages));
		return view;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == record.getId()) {
			if (record.isChecked()) {
				AudioUtil.startRecording("doctorquestion.3gp");
			} else {
				AudioUtil.stopRecording();
			}
		} else if (v.getId() == play.getId()) {
			if(play.isChecked())
			{
				AudioUtil.startPlaying("doctorquestion.3gp");
			}
			else
			{
				AudioUtil.stopPlaying();
			}

		} else if (v.getId() == send.getId()) {

		}
	}

}
