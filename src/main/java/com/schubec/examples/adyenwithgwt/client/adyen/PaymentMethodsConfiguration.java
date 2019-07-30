package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name="Object", namespace = JsPackage.GLOBAL)
public class PaymentMethodsConfiguration {
	public CardConfiguration card;
	public ApplepayConfiguration applepay;
}
