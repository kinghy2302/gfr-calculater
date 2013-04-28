package com.vince.util;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;

public class FlashlightTools {
	
private static Parameters parameters = null;  

private static Camera	camera =null;

public static boolean isOn;
	
public static void open(){
	//直接开启  
		camera = Camera.open(0);   
		                parameters = camera.getParameters();  
		                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);//开启  
		                camera.setParameters(parameters);  
		                isOn=true;
}

public static void close(){
	//直接关闭  
	parameters.setFlashMode(Parameters.FLASH_MODE_OFF);//关闭  
	                camera.setParameters(parameters);  
	                camera.release();
	                isOn=false;
}


}
