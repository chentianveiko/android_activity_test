package com.example.activitytest;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);           
		
		Button button1 = (Button) findViewById (R.id.button_1);
		Button button_secActivity = (Button) findViewById (R.id.button_secAct);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FirstActivity.this,"You Clicked Button 1", Toast.LENGTH_SHORT).show();
				//finish();
			}
		});
		
		button_secActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data = "欢迎使用测试工具!\r\n";
				//Intent intent = new Intent("com.example.activitytest.ACTION_START");
				//intent.addCategory("com.example.activitytest.MY_CATEGORY");
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extral_data", data);
				startActivityForResult(intent,1);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		switch(requestCode){
		case 1:
			if(resultCode == RESULT_OK){
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
			break;
			default:
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
			default:
				break;
		}
		
		return true;
	}
}
