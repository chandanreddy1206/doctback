package com.paulusworld.drawernavigationtabs.adapter;

import com.android.volley.toolbox.NetworkImageView;
import com.paulusworld.drawernavigationtabs.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class CustomChatVoiceMessageListAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private FragmentActivity callbackActivity;

	public CustomChatVoiceMessageListAdapter(FragmentActivity callbackActivity) {
		this.callbackActivity = callbackActivity;
		this.inflater = (LayoutInflater) callbackActivity
				.getApplicationContext().getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class Holder {
		ImageButton play;
		TextView time;
		SeekBar seekBar;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			Holder holder = new Holder();
			View view = inflater
					.inflate(R.layout.chat_voice_user_message, null);
			
			holder.play = (ImageButton) view
					.findViewById(R.id.chat_voice_user_msg_play);
			holder.time = (TextView) view.findViewById(R.id.chat_voice_user_msg_time);
			holder.seekBar = (SeekBar) view.findViewById(R.id.chat_voice_user_seekbar);
			return view;
		} else {
			return convertView;
		}
	}

}
