package com.example.taxometr.Controller;

import com.example.taxometr.R;
import com.example.taxometr.loginActivity;
import com.example.taxometr.mainActivity;
import com.example.taxometr.settingActivity;
import com.example.taxometr.addOrChangeListViewActivity;
import com.example.taxometr.listViewActivity;
import com.example.taxometr.workActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class formController extends Activity implements Parcelable{
	Context context = null;
	public dbController db = null;
	Intent intent = null;
	
	public formController(Context context){
		db = new dbController(context);
	}
	
	public void showForm(int i, Context context, String type){
		switch(i){
		case 1:
			intent = new Intent(context, loginActivity.class);
			break;
		case 2:
			intent = new Intent(context, mainActivity.class);
			break;
		case 3:
			intent = new Intent(context, workActivity.class);
			break;
		case 4:
			intent = new Intent(context, settingActivity.class);
			break;
		case 5:
			intent = new Intent(context, listViewActivity.class);
			break;
		case 6:
			intent = new Intent(context, addOrChangeListViewActivity.class);
			break;
		}
		intent.putExtra("typeListView", type);//передаем переменную для адаптера, какого типа данных считывать
		intent.putExtra(formController.class.getCanonicalName(), this);//передаем класс контроллера форм
		context.startActivity(intent);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeParcelable(db, 0);
	}
	
	
	public static final Parcelable.Creator<formController> CREATOR = new Parcelable.Creator<formController>() {
	    public formController createFromParcel(Parcel in) {
	      return new formController(in);
	    }

	    public formController[] newArray(int size) {
	      return new formController[size];
	    }
	};

	private formController(Parcel parcel) {
		 db = (dbController) parcel.readParcelable(dbController.class.getClassLoader());
	}

}
