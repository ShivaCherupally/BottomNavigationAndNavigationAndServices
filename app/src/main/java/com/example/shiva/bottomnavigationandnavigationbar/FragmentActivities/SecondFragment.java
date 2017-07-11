package com.example.shiva.bottomnavigationandnavigationbar.FragmentActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shiva.bottomnavigationandnavigationbar.R;

/**
 * Created by Shiva on 7/11/2017.
 */

public class SecondFragment extends Fragment
{
	@Override
	public void onCreate(@Nullable final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.second_fragment, container, false);
	}

	public static Fragment newInstance()
	{
		SecondFragment fragmet = new SecondFragment();
		return fragmet;
	}
}
