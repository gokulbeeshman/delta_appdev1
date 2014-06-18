package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
 TimerTask timerTask;  String items[]={"00:00:00","00:00:00","00:00:00","00:00:00","00:00:00"};
 int n=0;int x=0;int y=0,check=0;int z=0;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  ListView listView1 = (ListView) findViewById(R.id.listView1);
  

  
  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, items);
  
  listView1.setAdapter(adapter);
  
 }

 public void startTimer(View view) {
	 if(check==0){
  final Handler handler = new Handler();
  Timer ourtimer = new Timer();
  check=1;
  timerTask = new TimerTask() {
          public void run() {
                  handler.post(new Runnable() {
                          public void run() {
                     TextView timer = (TextView)findViewById(R.id.androidtimer);
                     x+=n/100;
                     y+=x/60;
                     if(x==60)
                     {
                    	 x=0;
                     }
                     if(n==100)
                     {
                    	n=0;
                     }
                     timer.setText(y+ ":" + x + ":" + n);
                         n++;
                          }
                 });
          }};


      ourtimer.schedule(timerTask, 0, 10);

 }}
 public void pauseTimer(View view) {
if(check==1){
  timerTask.cancel();
  timerTask=null;
  check=0;
 }}
 public void stopTimer(View view) {
	  x=0;y=0;	  n=0;
	  TextView timer = (TextView)findViewById(R.id.androidtimer);
	  ListView listView1 = (ListView) findViewById(R.id.listView1);
	  

	  
	  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, items);
	  
	  listView1.setAdapter(adapter);
	  if(z>4)
	  {
	  z=0;
	  }
	  items[z]=timer.getText().toString();
	  z++;
	  timer.setText("0:0:0");
	  pauseTimer(view);
	 }
}