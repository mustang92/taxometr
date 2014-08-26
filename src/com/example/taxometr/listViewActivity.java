package com.example.taxometr;

import java.util.ArrayList;

import com.example.taxometr.Adapter.adapter;
import com.example.taxometr.Adapter.varsForAdapter;
import com.example.taxometr.Controller.formController;
import com.example.taxometr.Controller.messageController;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class listViewActivity extends Activity implements OnClickListener, messageController.OnDismissListener{
	formController form;
	Bundle args;
	messageController msg;
	adapter adapter;
	ArrayList<varsForAdapter> data;
	ListView list; 
	Button btnAdd, btnDelete, btnChange;
	String typeListView;
	TextView tempTextView;
	TextView text;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        
        args = new Bundle();
		msg = new messageController(this);
		form = (formController) getIntent().getParcelableExtra(formController.class.getCanonicalName());
		typeListView = getIntent().getStringExtra("typeListView");
		
		text = (TextView) findViewById(R.id.serialCar);
        list = (ListView) findViewById(R.id.listView1);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        btnAdd = (Button) findViewById(R.id.btnAddDriver);
        btnDelete = (Button) findViewById(R.id.btnDeleteDriver);
        btnChange = (Button) findViewById(R.id.btnChangeDriver);
        
        selectType();
        
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnChange.setOnClickListener(this);
    }

    @Override
    public void onResume(){
    	super.onResume();
    	selectType();
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnAddDriver:
					form.db.tempId = -1;
					form.showForm(6, this, typeListView);
			break;
			
		case R.id.btnDeleteDriver:
			switch(typeListView){
			case "driver":
						if(typeListView.equals("driver")){
							if(form.db.getUserId() != 1) {//если не главный пользователь, показываем сообщение
								args = new Bundle();
								args.putInt("type", 2);
						        args.putInt("msg", 5);
						        msg.setArguments(args);
						    	msg.show(getFragmentManager(), "ema");
							}
							else{
								if(form.db.tempId == 1) {// показываем что нельзя удалить главного пользователя
									args = new Bundle();
									args.putInt("type", 2);
							        args.putInt("msg", 6);
							        msg.setArguments(args);
							    	msg.show(getFragmentManager(), "ema");
								}
								else {
									form.db.delete(typeListView);//
									
									args = new Bundle();//показываем сообщение об успешном удалении
									args.putInt("type", 2); 
							        args.putInt("msg", 4); 
							        msg.setArguments(args);
							    	msg.show(getFragmentManager(), "ema");
								}
							}
						}
				break;
				
			default:
				if(form.db.tempId != -1){
						form.db.delete(typeListView);
						args = new Bundle();//показываем сообщение об успешном удалении
						args.putInt("type", 2); 
				        args.putInt("msg", 4); 
				        msg.setArguments(args);
				    	msg.show(getFragmentManager(), "ema");
				}
				else{
						args = new Bundle();
						args.putInt("type", 2);
				        args.putInt("msg", 3);
				        msg.setArguments(args);
				    	msg.show(getFragmentManager(), "ema");
				}
				break;
			}
			break;
			
		case R.id.btnChangeDriver:
					if(form.db.tempId != -1) form.showForm(6, this, typeListView);
					else{
						args = new Bundle();
						args.putInt("type", 2); // put args (show dialog with one button "OK")
				        args.putInt("msg", 3); // put args (body message)
				        msg.setArguments(args);
				    	msg.show(getFragmentManager(), "ema");
					}
			break;
		}
	}


	@Override
	public void OnDismissListener(int res) {
		selectType();
	}
	
	private void selectType(){
		switch(typeListView){
		case "driver":
			     adapter = new adapter(this, form.db.select("selectAllDrivers"), typeListView);
			break;
		case "server":
					adapter = new adapter(this, form.db.select("selectAllServers"), typeListView);
			break;
		case "mode":
					adapter = new adapter(this, form.db.select("selectAllModes"), typeListView);
					btnAdd.setVisibility(View.INVISIBLE);
					btnDelete.setVisibility(View.INVISIBLE);
			break;
		case "polygon":
					adapter = new adapter(this, form.db.select("selectAllPolygon"), typeListView);
			break;
		case "tarif":
					adapter = new adapter(this, form.db.select("selectTarif"), typeListView);
					btnAdd.setVisibility(View.INVISIBLE);
					btnDelete.setVisibility(View.INVISIBLE);
		break;

		}
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		      //Log.d(form.tag, "itemClick: position = " + position + ", id = " + id);
		      
		      for(int i = 0; i < parent.getChildCount(); i++){
		    	  parent.getChildAt(i).setBackgroundColor(0);
		      }
		      view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
		      tempTextView = (TextView) view.findViewById(R.id.textView2);
		      form.db.tempId = Integer.parseInt(tempTextView.getText().toString());
		      
		    }
		});
	}
}
