package com.example.taxometr.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.example.taxometr.R;
import com.example.taxometr.R.raw;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

public class soundController extends Activity {
	private MediaPlayer mediaPlayer;
	private int[] sound = {
			R.raw.ding,
			R.raw.error
	};
	Context context;
	
	public soundController(Context context){
		this.context = context;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	}

	public void play(int id) {
		
		mediaPlayer = MediaPlayer.create(context, sound[id]);
        mediaPlayer.start();
	}

}
