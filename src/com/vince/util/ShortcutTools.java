package com.vince.util;

import com.vince.gfr.MainActivity;
import com.vince.gfr.R;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

public class ShortcutTools {
	
    public static void createShotrcut(Context activity) { 
    	Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", "GFR计算工具");
        localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(activity,R.drawable.ic_launcher));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", new Intent(activity,MainActivity.class));
        localIntent.putExtra("duplicate", false);
        activity.sendBroadcast(localIntent);
    }

}
