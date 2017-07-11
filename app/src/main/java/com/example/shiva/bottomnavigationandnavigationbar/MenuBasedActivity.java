package com.example.shiva.bottomnavigationandnavigationbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationSubMenu;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Shiva on 7/11/2017.
 */

public abstract class MenuBasedActivity extends AppCompatActivity
{
	private final String SS_KEY_MENU_1 = "ss.key.menu.1";

	private NavigationSubMenu firstMenu;
	LinearLayout header_layout;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		header_layout = (LinearLayout) findViewById(R.id.header_layout);
		/*if (savedInstanceState != null)
		{
			if (savedInstanceState.containsKey(SS_KEY_MENU_1))
			{
				firstMenu = savedInstanceState.getParcelable(SS_KEY_MENU_1);
			}
		}*/
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		// save state for the menu
//		outState.putParcelable(SS_KEY_MENU_1, firstMenu);
	}

	/*public void addContentView(int layoutId)
	{
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View contentView = inflater.inflate(layoutId, null, false);
//		header_layout.addView(contentView, 0);
	}*/

	public void addContentView(int layoutId) {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View contentView = inflater.inflate(layoutId, null, false);
		header_layout.addView(contentView, 0);
	}
}
