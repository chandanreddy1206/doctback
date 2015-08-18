package com.paulusworld.drawernavigationtabs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.paulusworld.drawernavigationtabs.adapter.CustomChatVoiceMessageListAdapter;
import com.paulusworld.drawernavigationtabs.bean.Doctor;
import com.paulusworld.drawernavigationtabs.bean.User;
import com.paulusworld.drawernavigationtabs.bean.VoiceMessage;
import com.paulusworld.drawernavigationtabs.util.AudioUtil;
import com.paulusworld.drawernavigationtabs.util.CustomVolleyRequestQueue;
import com.paulusworld.drawernavigationtabs.util.SharingPreferences;

public class QuestionAnsFragment extends Fragment implements OnClickListener {
	public static final String TAG = QuestionAnsFragment.class.getSimpleName();

	private NetworkImageView doctorImageView;
	private TextView doctorName;
	private TextView doctorCategory;
	private RatingBar doctorRating;
	private ListView questionAnsListView;
	private ToggleButton record;
	private ToggleButton play;
	private Button send;
	private MediaPlayer mPlayer = null;
	private MediaRecorder mRecorder = null;

	private FragmentActivity callbackActivity;
	
	public static QuestionAnsFragment newInstance() {
		return new QuestionAnsFragment();
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		callbackActivity=(FragmentActivity)activity;
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

		doctorImageView = (NetworkImageView) view
				.findViewById(R.id.question_ans_doctor_network_image_view);
		doctorName = (TextView) view
				.findViewById(R.id.question_ans_doctor_name);
		doctorCategory = (TextView) view
				.findViewById(R.id.question_ans_doctor_category);
		doctorCategory = (TextView) view
				.findViewById(R.id.question_ans_doctor_category);
		doctorRating = (RatingBar) view
				.findViewById(R.id.question_ans_doctor_rating_bar);
		questionAnsListView = (ListView) view
				.findViewById(R.id.question_ans_listview);
		
		record = (ToggleButton) view.findViewById(R.id.question_ans_record);
		play = (ToggleButton) view.findViewById(R.id.question_ans_play);
		send = (Button) view.findViewById(R.id.question_ans_send);

		record.setOnClickListener(this);
		play.setOnClickListener(this);
		send.setOnClickListener(this);

		ImageLoader imageLoader = CustomVolleyRequestQueue.getInstance(callbackActivity.getApplicationContext()).getImageLoader();
		// Image URL - This can point to any image file supported by Android
		imageLoader.get("http://cliparts101.com/files/828/444D99AD3598558DAE6CAC3676A3A97D/Doctor_01.png", ImageLoader.getImageListener(doctorImageView,
				R.drawable.doctor, R.drawable.doctor));
		doctorImageView.setImageUrl("http://cliparts101.com/files/828/444D99AD3598558DAE6CAC3676A3A97D/Doctor_01.png", imageLoader);
		
		doctorName.setText("Name");
		doctorCategory.setText("Category");
		doctorRating.setRating(2);
		
		
		// gender.setText(user.getGender());
		// doctorCategory.setText(doctor.getCategory());
		List<VoiceMessage> voiceMessages = new ArrayList<VoiceMessage>();
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage.setLocalFileUlr("doctorquestion.3gp");
		voiceMessages.add(voiceMessage);
		VoiceMessage voiceMessage2 = new VoiceMessage();
		voiceMessage.setLocalFileUlr("doctorquestion.3gp");
		voiceMessages.add(voiceMessage2);
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
