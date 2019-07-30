package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsFunction;

@JsFunction
public interface OnAdditionalDetailsInterface {
	void onAdditionalDetails(State state, Object dropin);
}
