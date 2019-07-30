package com.schubec.examples.adyenwithgwt.client.adyen;

import jsinterop.annotations.JsFunction;

@JsFunction

public interface OnSubmitInterface {
	void onSubmit(State state, Object dropin);
}
