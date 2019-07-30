package com.schubec.examples.adyenwithgwt.client.adyen;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import org.fusesource.restygwt.client.TextCallback;


public interface AdyenService extends RestService{
	
	public static final String BASEURL = "http://localhost:12345/v1";
	
	@GET
	@Path(BASEURL + "/paymentmethods/{country}/{currency}/{amount}")
	@Consumes("application/json")
	void order(@PathParam("country") String country,@PathParam("currency") String currency, @PathParam("amount") String amount, TextCallback callback);

	@POST
	@Path(BASEURL + "/makepayment")
	@Consumes("application/json")
	void makePayment(String jsonString, TextCallback callback);

	

}
