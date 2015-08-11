package com.paulusworld.drawernavigationtabs;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.paulusworld.drawernavigationtabs.bean.User;
import com.paulusworld.drawernavigationtabs.util.CustomVolleyRequestQueue;
import com.paulusworld.drawernavigationtabs.util.SharingPreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {

	private static final String TAG = LoginActivity.class.getSimpleName();

	private NetworkImageView profilePicNetworkImageView;
	private ImageLoader profilePicImageLoader;
	private EditText displayName;
	private EditText age;
	private RadioGroup gender;
	private RadioButton male;
	private RadioButton female;
	private Button register;
	private TextView email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		setTitle(R.string.registration_title);
		profilePicNetworkImageView = (NetworkImageView) findViewById(R.id.registration_profile_pic);
		displayName = (EditText) findViewById(R.id.registration_display_name);
		age = (EditText) findViewById(R.id.registration_age);
		gender = (RadioGroup) findViewById(R.id.registration_radio_group_gender);
		male = (RadioButton) findViewById(R.id.registration_radio_male);
		female = (RadioButton) findViewById(R.id.registration_radio_female);
		register = (Button) findViewById(R.id.registration_register_button);
		email = (TextView) findViewById(R.id.registration_email);
		register.setOnClickListener(this);
		
		Bundle bundle = getIntent().getExtras();
		User user = (User) bundle.getSerializable("user");
		displayUser(user);
		// setContentView(R.layout.activity_main);
		/*
		 * Intent intent = AccountPicker.newChooseAccountIntent(null, null, new
		 * String[]{"com.google"}, false, null, null, null, null);
		 * startActivityForResult(intent, SOME_REQUEST_CODE);
		 */

	}

	private void displayUser(User user) {
		displayName.setText(user.getName());
		profilePicImageLoader = CustomVolleyRequestQueue.getInstance(this.getApplicationContext()).getImageLoader();
		// Image URL - This can point to any image file supported by Android
		profilePicImageLoader.get(user.getProfilePic(), ImageLoader.getImageListener(profilePicNetworkImageView,
				android.R.drawable.ic_menu_add, android.R.drawable.ic_dialog_alert));
		profilePicNetworkImageView.setImageUrl(user.getProfilePic(), profilePicImageLoader);
		age.setText(user.getAge().toString());
		if (user.getGender().equals("male"))
			gender.check(male.getId());
		else if (user.getGender().equals("female"))
			gender.check(female.getId());
		email.setText(user.getEmail());
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == register.getId())
		{
			User user = new User();
			user.setName(displayName.getText().toString());
			user.setEmail(email.getText().toString());
//			user.setGender();
			SharingPreferences<User> sharingPreferences = new SharingPreferences<User>();
			sharingPreferences.save(this, "user", user);
		}
	}

}
