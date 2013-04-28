/**
 * 
 */
package com.vince.gfr;

/**
 * @author Administrator
 *
 */
public class TestJNI {
	
private static native void displayHelloWorld();

static{
	System.loadLibrary("hello");
}
public static void main(String[] args){
	displayHelloWorld();
	}
}
