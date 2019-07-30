package com.schubec.examples.adyenwithgwt.client.adyen;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Configuration {



	public String locale;

	public String environment;

	public String originKey;
	
	public Object paymentMethodsResponse;

}