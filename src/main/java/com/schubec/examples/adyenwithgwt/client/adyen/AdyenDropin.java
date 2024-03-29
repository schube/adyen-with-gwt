package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)

public class AdyenDropin {
	
	public native void mount(String target);

	public native void handleAction(Object json);

	public native void setStatus(String string);
	

}
