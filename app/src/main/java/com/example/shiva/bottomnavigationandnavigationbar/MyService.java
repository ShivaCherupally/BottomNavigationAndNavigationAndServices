package com.example.shiva.bottomnavigationandnavigationbar;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Shiva on 7/11/2017.
 */

public class MyService extends Service
{
	MediaPlayer player;
	@Nullable
	@Override
	public IBinder onBind(final Intent intent)
	{
		Toast.makeText(this, "Service Bind.", Toast.LENGTH_LONG).show();
		return null;
	}

	@Override
	public void onCreate()
	{
		Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	/*@Override
	public void onStart(final Intent intent, final int startId)
	{
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		super.onStart(intent, startId);
	}*/

	@Override
	public void onDestroy()
	{
		player.stop();
		Toast.makeText(this, "Service Destroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	public int onStartCommand(final Intent intent, final int flags, final int startId)
	{
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		player = MediaPlayer.create(this, notification);
		player.setLooping(true);
		player.start();
		return START_STICKY;
//		return super.onStartCommand(intent, flags, startId);
	}
}
