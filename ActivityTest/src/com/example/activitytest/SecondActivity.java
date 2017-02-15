package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);   
		
		Intent intent = getIntent();
		
		String data = intent.getStringExtra("extral_data");
		
		Log.d("SecondActivity", data);
		
		Button button_tst = (Button) findViewById (R.id.button_toast);
		Button button_home = (Button) findViewById(R.id.ButtonHome);
		
		button_tst.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(SecondActivity.this, "You clicked button toast!", Toast.LENGTH_SHORT).show();
				Intent intent_ex = new Intent(Intent.ACTION_DIAL);
				intent_ex.setData(Uri.parse("tel:18215635079"));
				startActivity(intent_ex);
			}
		});
		
		button_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hellow FirstActivity!");
				setResult(RESULT_OK,intent);
				finish();
				//startActivity(intent);
			}
		});
	}
}
