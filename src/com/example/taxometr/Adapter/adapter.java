package com.example.taxometr.Adapter;

import java.util.ArrayList;

import com.example.taxometr.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class adapter extends BaseAdapter {
	private Activity activity;
    private ArrayList<varsForAdapter> data;
    private static LayoutInflater inflater=null;
    varsForAdapter tempValues;
    private String typeAdapter;

	public adapter(Activity a, ArrayList<varsForAdapter> customListViewValuesArr, String type) {
		typeAdapter = type;
		activity = a;
        data=customListViewValuesArr;
        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
    private static class ViewHolder {
            public TextView fio, serialCar, driverId, textView1, textView2;
            public EditText editText1;
            public CheckBox checkBox1;
    }

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int pos) {
		return data.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
        ViewHolder holder;
        
        switch(typeAdapter){
        case "driver":
		            if(convertView==null){
		                vi = inflater.inflate(R.layout.item_list_view, null);//выбираем layout для парсинга
		                holder = new ViewHolder();
		                holder.serialCar = (TextView) vi.findViewById(R.id.serialCar);//находим текстовое поле по идентификатору
		                holder.fio = (TextView) vi.findViewById(R.id.fio);//находим текстовое поле по идентификатору
		                holder.driverId = (TextView) vi.findViewById(R.id.textView2);//находим текстовое поле по идентификатору
		                vi.setTag( holder );
		            }
		            else holder=(ViewHolder) vi.getTag();
		            
		            //берет один элемент из набора данных бд, который вернул котроллер бд
		            tempValues = (varsForAdapter) data.get( position );
		            //устанавливаем текстовому полю serialCar значение элемента driver.get(1) (позывной)
		            holder.serialCar.setText( tempValues.driver.get(1) );
		          //устанавливаем текстовому полю serialCar значение элемента (фио), формируется из трех элементов
		            holder.fio.setText( tempValues.driver.get(2)+" "+tempValues.driver.get(3)+" "+tempValues.driver.get(4));
		            //для скрытого элемента устанавливаем значение элемента (id)
		            holder.driverId.setText( tempValues.driver.get(0));
        	break;
        case "server":
		            if(convertView==null){
		                vi = inflater.inflate(R.layout.server_item, null);
		                holder = new ViewHolder();
		                holder.checkBox1 = (CheckBox) vi.findViewById(R.id.workServer);
		                holder.textView1 = (TextView) vi.findViewById(R.id.textView1);
		                holder.textView2 = (TextView) vi.findViewById(R.id.textView2);
		                vi.setTag( holder );
		            }
		            else holder=(ViewHolder) vi.getTag();
		            
		            tempValues = (varsForAdapter) data.get( position );
		            holder.checkBox1.setChecked(Boolean.valueOf(tempValues.driver.get(2)));
		            holder.textView1.setText( tempValues.driver.get(1));
		            holder.textView2.setText( tempValues.driver.get(0));
		        	break;
		 case "polygon":
					 if(convertView==null){
			                vi = inflater.inflate(R.layout.item_list_view, null);
			                holder = new ViewHolder();
			                holder.serialCar = (TextView) vi.findViewById(R.id.serialCar);
			                holder.fio = (TextView) vi.findViewById(R.id.fio);
			                holder.driverId = (TextView) vi.findViewById(R.id.textView2);
			                vi.setTag( holder );
			            }
			            else holder=(ViewHolder) vi.getTag();
			            
			            tempValues = (varsForAdapter) data.get( position );
			            holder.serialCar.setText( tempValues.driver.get(0) );
			            holder.fio.setText(tempValues.driver.get(1) );
			            holder.driverId.setText( tempValues.driver.get(0));
		        	break;
		 case "mode":
					 if(convertView==null){
			                vi = inflater.inflate(R.layout.server_item, null);
			                holder = new ViewHolder();
			                holder.checkBox1 = (CheckBox) vi.findViewById(R.id.workServer);
			                holder.textView1 = (TextView) vi.findViewById(R.id.textView1);
			                holder.textView2 = (TextView) vi.findViewById(R.id.textView2);
			                vi.setTag( holder );
			            }
			            else holder=(ViewHolder) vi.getTag();
			            
			            tempValues = (varsForAdapter) data.get( position );
			            holder.checkBox1.setChecked(Boolean.valueOf(tempValues.driver.get(2)));
			            holder.textView1.setText( tempValues.driver.get(1));
			            holder.textView2.setText( tempValues.driver.get(0));
			        break;
		 case "tarif":
			 if(convertView==null){
	                vi = inflater.inflate(R.layout.item_list_view, null);
	                holder = new ViewHolder();
	                holder.serialCar = (TextView) vi.findViewById(R.id.serialCar);
	                holder.fio = (TextView) vi.findViewById(R.id.fio);
	                holder.driverId = (TextView) vi.findViewById(R.id.textView2);
	                vi.setTag( holder );
	            }
	            else holder=(ViewHolder) vi.getTag();
	            
	            tempValues = (varsForAdapter) data.get( position );
	            holder.serialCar.setText( "" );
	            holder.fio.setText("Тариф");
	            holder.driverId.setText( tempValues.driver.get(0));
			 break;
			 
        }
        
       
   
        return vi;
	}


}
