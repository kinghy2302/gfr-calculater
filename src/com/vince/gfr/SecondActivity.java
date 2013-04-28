/**
 * 
 */
package com.vince.gfr;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class SecondActivity extends Activity {
	
    @Override	
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        DecimalFormat df=new DecimalFormat("0.00");
	        Intent intent =this.getIntent();
	        double jg=(Double) intent.getExtras().get("jg");
	        int age=(Integer)intent.getExtras().get("age");
	        int sex=(Integer)intent.getExtras().get("sex");
	        double gfr=186*Math.pow(jg/88.4, -1.154)*Math.pow(age,-0.203)*1.233;
	        if(sex==0)
	        gfr=gfr*0.742;
	        
	        setContentView(R.layout.activity_second);			
	        TextView tv=(TextView) findViewById(R.id.textView4);

	        tv.setText(df.format(gfr));
//	        inflate=LayoutInflater.from(this);
//	        buttonCallme=(Button)inflate.inflate(R.id.buttonCallme, null);
//	        buttonCallme=(Button)findViewById(R.id.buttonCallme);
//	        buttonCallme.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
////					Uri uri = Uri.parse("tel:18021571182");
////					Intent it =new Intent(Intent.ACTION_CALL,uri); 
//					Intent it =new Intent("com.vince.action.ABOUT");
//					startActivity(it);  
//				}
//			});
	    }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   if(keyCode==KeyEvent.KEYCODE_BACK){
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
			   intent.setClass(SecondActivity.this, MainActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				SecondActivity.this.finish();
			   return true;
		   }
		return super.onKeyDown(keyCode, event);
	}
	
}
