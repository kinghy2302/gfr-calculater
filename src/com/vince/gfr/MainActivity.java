package com.vince.gfr;


import com.vince.util.FlashlightTools;
import com.vince.util.VibrateTools;

import cn.jpush.android.api.InstrumentedActivity;
import android.os.Bundle;
import android.os.IBinder;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends InstrumentedActivity {
	RadioGroup rg;
	RadioButton rb1,rb2;
	Button button;
	EditText et1,et2;
	int sex;
    final ServiceConnection conn = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(MainActivity.this, "ServiceConnection onServiceConnected", Toast.LENGTH_SHORT).show();
                Log.i("3", "ServiceConnection onServiceConnected");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
                Toast.makeText(MainActivity.this, "ServiceConnection onServiceDisconnected", Toast.LENGTH_SHORT).show();
                Log.i("4", "ServiceConnection onServiceDisconnected");

        }};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         rg=(RadioGroup)findViewById(R.id.RadioGroup01);
         rb1=(RadioButton)findViewById(R.id.radioButton1);
         rb2=(RadioButton)findViewById(R.id.radioButton2);
         et1=(EditText)findViewById(R.id.editText1);
         et2=(EditText)findViewById(R.id.editText2);
         et1.requestFocus(0);
		/* 设置事件监听  */
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				if (checkedId == rb1.getId())
				{
					sex=1;
				}
				else
				{
					sex=0;
				}
			}
		});

		 button = (Button) findViewById(R.id.button1);
		/* 监听button的事件信息 */
		button.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				if(et1.getText().toString().equals("")){
					Toast.makeText(MainActivity.this, "请输入肌酐值！", Toast.LENGTH_SHORT).show();
					return;
				}
				if(et2.getText().toString().equals("")){
					Toast.makeText(MainActivity.this, "请输入年龄！", Toast.LENGTH_SHORT).show();
					return;
				}
				if(!rb1.isChecked()&&!rb2.isChecked()){
					Toast.makeText(MainActivity.this, "请选择性别！", Toast.LENGTH_SHORT).show();
					return;
				}

				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				Bundle bundle =new Bundle();  
                bundle.putDouble("jg",Double.parseDouble( et1.getText().toString()));  
                bundle.putInt("age", Integer.parseInt(et2.getText().toString()));  
                bundle.putInt("sex", sex);
                intent.putExtras(bundle);
                
				intent.setClass(MainActivity.this, SecondActivity.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				MainActivity.this.finish();
			}
		});
        //定义服务链接对象
  
//		Intent service=new Intent(MainActivity.this,MyService.class);
//		bindService(service, conn, Context.BIND_AUTO_CREATE);
		//新建快捷方式
 /*       Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", "GFR计算工具");
        localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this,R.drawable.ic_launcher));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", new Intent(this,MainActivity.class));
        localIntent.putExtra("duplicate", false);
        sendBroadcast(localIntent);*/
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	/*处理菜单事件*/
	public boolean onOptionsItemSelected(MenuItem item)
	{
		//得到当前选中的MenuItem的ID,
		int item_id = item.getItemId();

		switch (item_id)
		{
			case R.id.menu_about:

				new AlertDialog.Builder(this).setTitle(R.string.menu_about)
						.setMessage(R.string.aboutInfo).setPositiveButton(
								R.string.ok_label,
								new DialogInterface.OnClickListener() {
									public void onClick(
											DialogInterface dialoginterface, int i) {
									}
								}).show();
			
				break;
			case R.id.menu_vibrate:
				VibrateTools.Vibrate(this, 3000);
				break;
			case R.id.menu_flashlight:
				if(FlashlightTools.isOn)
				FlashlightTools.close();
				else
					FlashlightTools.open();	
				break;
			case R.id.menu_exit:
				System.exit(0);
				finish();
				break;
		}
		return true;
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		   if(keyCode==KeyEvent.KEYCODE_BACK){
			   openQiutDialog();
			   return true;
		   }
		return super.onKeyDown(keyCode, event);
	}
	
	/**
	 * 退出
	 */
	private void openQiutDialog() {
		new AlertDialog.Builder(this).setTitle("退出GFR计算工具").setMessage("是否退出程序？")
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {						
						 System.exit(0);
						 finish();
						}
				}).setNegativeButton("取消",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						}).show();
	}
@Override
public void onDestroy(){
	//unbindService(conn);
	super.onDestroy();
}

}
