package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)

public class ApplepayConfiguration {
	public String merchantName;
	public String merchantIdentifier;
}
