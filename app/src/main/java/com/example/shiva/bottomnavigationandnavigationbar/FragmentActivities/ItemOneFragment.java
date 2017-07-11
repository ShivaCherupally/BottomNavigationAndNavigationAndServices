package com.example.shiva.bottomnavigationandnavigationbar.FragmentActivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shiva.bottomnavigationandnavigationbar.DetailsActvity;
import com.example.shiva.bottomnavigationandnavigationbar.MainActivity;
import com.example.shiva.bottomnavigationandnavigationbar.MenuBasedActivity;
import com.example.shiva.bottomnavigationandnavigationbar.MyService;
import com.example.shiva.bottomnavigationandnavigationbar.R;

import butterknife.BindView;

/**
 * Created by Shiva on 7/11/2017.
 */

public class ItemOneFragment extends Fragment
{
	/*@BindView(R.id.startBtn)
	Button startBtn;
	@BindView(R.id.stopBtn)
	Button stopBtn;*/
	public static ItemOneFragment newInstance()
	{
		ItemOneFragment fragment = new ItemOneFragment();
		return fragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
//		return inflater.inflate(R.layout.first_fragment, container, false);
		View view = inflater.inflate(R.layout.first_fragment, container, false);
		final Button startBtn = (Button) view.findViewById(R.id.startBtn);
		Button stopBtn = (Button) view.findViewById(R.id.stopBtn);
		startBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(final View view)
			{
				getActivity().startService(new Intent(getActivity(), MyService.class));
				/*Intent i = new Intent(getActivity(), DetailsActvity.class);
				startActivity(i);*/
			}
		});

		stopBtn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(final View view)
			{
				getActivity().stopService(new Intent(getActivity(), MyService.class));
			}
		});

		return view;
	}
/*
	@Override
	public void onAttach(Activity activity)
	{
		MenuBasedActivity mListener = (MenuBasedActivity) activity;
		super.onAttach(mListener);
	}*/
}
