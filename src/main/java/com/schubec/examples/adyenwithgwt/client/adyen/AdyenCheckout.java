package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "AdyenCheckout", namespace = JsPackage.GLOBAL)
public class AdyenCheckout {

	@JsConstructor
	public AdyenCheckout(Configuration configuration) {
	}


	public native AdyenDropin create(String name,
			DropinConfiguration config);

}