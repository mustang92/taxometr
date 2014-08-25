package com.example.taxometr;

import com.example.taxometr.Controller.formController;
import com.example.taxometr.Controller.messageController;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;

public class settingActivity extends Activity  implements OnClickListener, messageController.OnDismissListener {
	formController form;
	Bundle args;
	messageController msg;
	Button btnDriver, btnServer, btnPolygon, btnMode, btnTariff, btnExit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_activity);
		
		args = new Bundle();
		msg = new messageController(this);
		form = (formController) getIntent().getParcelableExtra(formController.class.getCanonicalName());
		
		btnDriver = (Button) findViewById(R.id.buttonDriver);
		btnServer = (Button) findViewById(R.id.btnServer);
		btnPolygon = (Button) findViewById(R.id.btnPolygon);
		btnMode = (Button) findViewById(R.id.btnMode);
		btnTariff = (Button) findViewById(R.id.btnTariff);
		btnExit = (Button) findViewById(R.id.btnExit);
		
		btnDriver.setOnClickListener(this);
		btnServer.setOnClickListener(this);
		btnPolygon.setOnClickListener(this);
		btnMode.setOnClickListener(this);
		btnTariff.setOnClickListener(this);
		btnExit.setOnClickListener(this);
	}
	
	
	@Override
	public void OnDismissListener(int res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.buttonDriver:
			//form.db.test();
			form.showForm(5, this, "driver");
			break;
			
		case R.id.btnServer:
			form.showForm(5, this, "server");
			break; 
		
		case R.id.btnPolygon:
			form.showForm(5, this, "polygon");
			break; 
			
		case R.id.btnMode:
			form.showForm(5, this, "mode");
			break; 
			
		case R.id.btnTariff:
			form.showForm(5, this, "tarif");
			break; 
			
		case R.id.btnExit:
			finish();
			break; 
		}
		
		
	}

}
