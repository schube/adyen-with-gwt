package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name="Object", namespace = JsPackage.GLOBAL)
public class CardConfiguration {
	public boolean hasHolderName;
	public boolean holderNameRequired;
	public boolean enableStoreDetails;
	public String name;
}
