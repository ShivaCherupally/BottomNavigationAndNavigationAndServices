package com.example.shiva.bottomnavigationandnavigationbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiva.bottomnavigationandnavigationbar.FragmentActivities.ItemOneFragment;
import com.example.shiva.bottomnavigationandnavigationbar.FragmentActivities.SecondFragment;
import com.example.shiva.bottomnavigationandnavigationbar.FragmentActivities.ThirdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener
{
	@BindView(R.id.startBtn)
	Button startBtn;
	@BindView(R.id.stopBtn)
	Button stopBtn;

	@BindView(R.id.bottomnavigation)
	BottomNavigationView bottomnavigation;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);


		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		startBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);


		bottomnavigation.setOnNavigationItemSelectedListener
				(new BottomNavigationView.OnNavigationItemSelectedListener()
				{
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem item)
					{
						Fragment selectedFragment = null;
						switch (item.getItemId())
						{
							case R.id.action_item1:
								selectedFragment = ItemOneFragment.newInstance();
								break;
							case R.id.action_item2:
								selectedFragment = SecondFragment.newInstance();
								break;
							case R.id.action_item3:
								selectedFragment = ThirdFragment.newInstance();
								break;
						}
						FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
						transaction.replace(R.id.frame_layout, selectedFragment);
						transaction.commit();
						return true;
					}
				});


		//Manually displaying the first fragment - one time only
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.frame_layout, ItemOneFragment.newInstance());
		transaction.commit();

		//Used to select an item programmatically
		//bottomNavigationView.getMenu().getItem(2).setChecked(true);

	/*	FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				        .setAction("Action", null).show();
			}
		});*/

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);


	}

	@Override
	public void onBackPressed()
	{
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
		}
		else
		{
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item)
	{
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera)
		{
			Toast.makeText(this, "Item1 Click", Toast.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_gallery)
		{
			Toast.makeText(this, "Item2 Click", Toast.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_slideshow)
		{
			Toast.makeText(this, "Item3 Click", Toast.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_manage)
		{
			Toast.makeText(this, "Item4 Click", Toast.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_share)
		{
			Toast.makeText(this, "Item5 Click", Toast.LENGTH_LONG).show();
		}
		else if (id == R.id.nav_send)
		{
			Toast.makeText(this, "Item6 Click", Toast.LENGTH_LONG).show();
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override
	public void onClick(final View view)
	{
		switch (view.getId())
		{
			case R.id.startBtn:
				startService(new Intent(this, MyService.class));
				break;
			case R.id.stopBtn:
				stopService(new Intent(this, MyService.class));
				break;
		}

	}
}
