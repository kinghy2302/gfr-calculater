/**
 * 
 */
package com.vince.gfr;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * @author Administrator
 *
 */
public class MyService extends Service {

	private MediaPlayer mPlayer=null;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		Toast.makeText(this, "MusicService onCreate()", Toast.LENGTH_SHORT).show();
        //创建一个音乐播放器对象
        mPlayer=MediaPlayer.create(getApplicationContext(), R.raw.js);
        //设置可以重复播放
        mPlayer.setLooping(true);
        mPlayer.start();
        Log.i("1", "MusicService onCreate()");
		super.onCreate();
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
        Toast.makeText(this, "MusicService onDestroy()", Toast.LENGTH_SHORT).show();
        mPlayer.stop();
        Log.i("2", "MusicService onDestroy()");
		super.onDestroy();
	}

	/* (non-Javadoc)
	 * @see android.app.Service#onUnbind(android.content.Intent)
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		
		return super.onUnbind(intent);
	}


	
}
