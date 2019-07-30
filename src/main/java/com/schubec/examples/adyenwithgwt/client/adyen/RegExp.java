package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
class RegExp {
	 @JsConstructor
	public RegExp(String pattern, String... flags) {
		 
	 };

	public native boolean test();

	public String flags;
}
