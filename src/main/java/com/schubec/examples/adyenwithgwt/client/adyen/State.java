package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class State {
	public boolean isValid;
	public JsPropertyMap<String> data;
}
