package com.vince.gfr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ServiceBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action=intent.getAction();
		if(action.equals("android.intent.action.BOOT_COMPLETED")){
//			Intent service=new Intent(context,MyService.class);
//			context.startService(service);
		}
	}

}
