package com.example.taxometr;

import com.example.taxometr.Controller.messageController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class workActivity extends Activity  implements OnClickListener, messageController.OnDismissListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.work_activity);
	}
	
	
	@Override
	public void OnDismissListener(int res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
