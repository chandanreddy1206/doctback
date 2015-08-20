package com.paulusworld.drawernavigationtabs;

import java.util.Calendar;

import com.paulusworld.drawernavigationtabs.widget.CustomTimePickerDialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class BookAppointmentCalenderFragment extends Fragment implements OnClickListener,OnTimeSetListener, OnDateSetListener
{

	public static final String TAG = BookAppointmentCalenderFragment.class.getSimpleName();
	private FragmentActivity callbackActivity;
	private Button dateButton;
	private Button timeButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_book_appointment, null);

		
		dateButton = (Button) view.findViewById(R.id.fragment_book_appointment_date_button);
		timeButton = (Button) view.findViewById(R.id.fragment_book_appointment_time_button);
		dateButton.setOnClickListener(this);
		timeButton.setOnClickListener(this);
		
		return view;
	}
	public static BookAppointmentCalenderFragment newInstance()
	{
		return new BookAppointmentCalenderFragment();
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		callbackActivity=(FragmentActivity)activity;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == timeButton.getId())
		{
			CustomTimePickerDialog customTimePickerDialog = new CustomTimePickerDialog(callbackActivity, this, 12, 30, false);
			customTimePickerDialog.show();
		}
		else if(v.getId() == dateButton.getId())
		{
			DatePickerDialog datePickerDialog = new DatePickerDialog(callbackActivity, this, 2015,8, 21);
			DatePicker datePicker = datePickerDialog.getDatePicker();
			datePicker.setCalendarViewShown(false);
			datePicker.setSpinnersShown(true);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 1);
			datePicker.setMinDate(calendar.getTimeInMillis());
			calendar.add(Calendar.DATE, 5);
			datePicker.setMaxDate(calendar.getTimeInMillis());
			datePickerDialog.show();
		}
	}
	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		// TODO Auto-generated method stub
		
	}
}
