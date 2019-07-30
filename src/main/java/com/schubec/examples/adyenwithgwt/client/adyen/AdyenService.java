package com.schubec.examples.adyenwithgwt.client.adyen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;


public interface AdyenService extends RestService{
	
	public static final String BASEURL = "http://localhost:12345/v1";
	
	@GET
	@Path(BASEURL + "/paymentmethods/{country}/{currency}/{amount}")
	void order(@PathParam("country") String country,@PathParam("currency") String currency, @PathParam("amount") String amount, MethodCallback<Object> callback);

	

}
