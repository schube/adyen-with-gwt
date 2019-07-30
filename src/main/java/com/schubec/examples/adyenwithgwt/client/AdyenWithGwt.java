package com.schubec.examples.adyenwithgwt.client;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.TextCallback;
import com.google.gwt.user.client.Timer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.schubec.examples.adyenwithgwt.client.adyen.AdyenCheckout;
import com.schubec.examples.adyenwithgwt.client.adyen.AdyenDropin;
import com.schubec.examples.adyenwithgwt.client.adyen.AdyenService;
import com.schubec.examples.adyenwithgwt.client.adyen.ApplepayConfiguration;
import com.schubec.examples.adyenwithgwt.client.adyen.CardConfiguration;
import com.schubec.examples.adyenwithgwt.client.adyen.Configuration;
import com.schubec.examples.adyenwithgwt.client.adyen.DropinConfiguration;
import com.schubec.examples.adyenwithgwt.client.adyen.PaymentMethodsConfiguration;
import elemental2.dom.Response;

import elemental2.core.Global;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class AdyenWithGwt implements EntryPoint {
	 public void onModuleLoad() {
	        GWT.log("onModuleLoad");

	   

		
					 DomGlobal.fetch("http://localhost:12345/v1/paymentmethods/DE/EUR/200")
				        .then(Response::json)
				        .then(
				            (json) -> {
				            	
				            	Object parse = Global.JSON.parse("{\"paymentMethods\":[{\"details\":[{\"key\":\"encryptedCardNumber\",\"type\":\"cardToken\"},{\"key\":\"encryptedSecurityCode\",\"type\":\"cardToken\"},{\"key\":\"encryptedExpiryMonth\",\"type\":\"cardToken\"},{\"key\":\"encryptedExpiryYear\",\"type\":\"cardToken\"},{\"key\":\"holderName\",\"optional\":true,\"type\":\"text\"}],\"name\":\"Credit Card\",\"type\":\"scheme\"},{\"name\":\"Online bank transfer.\",\"type\":\"directEbanking\"},{\"name\":\"Pay later with Klarna.\",\"type\":\"klarna\"},{\"name\":\"Paysafecard\",\"type\":\"paysafecard\"},{\"details\":[{\"key\":\"bic\",\"type\":\"text\"}],\"name\":\"GiroPay\",\"type\":\"giropay\"},{\"name\":\"Slice it with Klarna.\",\"type\":\"klarna_account\"}],\"groups\":[{\"name\":\"Credit Card\",\"types\":[\"visa\",\"mc\",\"amex\"]}]}");
				            	
				            	 //adyendropin
				                Configuration configuration = new Configuration();
				                configuration.locale= "en_US";
				                configuration.environment="test";
				                configuration.originKey="pub.v2.udJyAmjWe2_F50puc9YY7ABVHZS_t3BMQjwFP0";
				                configuration.paymentMethodsResponse = parse;
				                 AdyenCheckout checkout = new AdyenCheckout(configuration);
				                
				                
				                PaymentMethodsConfiguration paymentMethodsConfiguration = new PaymentMethodsConfiguration();
				                paymentMethodsConfiguration.applepay  = new ApplepayConfiguration();
				                paymentMethodsConfiguration.applepay.merchantIdentifier="test";
				                paymentMethodsConfiguration.applepay.merchantName="Bingooo";
				                
				                paymentMethodsConfiguration.card = new CardConfiguration();
				                paymentMethodsConfiguration.card.enableStoreDetails = true;
				                paymentMethodsConfiguration.card.hasHolderName= true;
				                paymentMethodsConfiguration.card.holderNameRequired = true;
				                paymentMethodsConfiguration.card.name = "Bernhard";
				                
				                
				                
				                
				                
				                
				                DropinConfiguration c= new DropinConfiguration();
				                c.paymentMethodsConfiguration = paymentMethodsConfiguration;
				                c.onAdditionalDetails = (state,theDropin) -> {};
				                c.onSubmit = (state,theDropin) -> {};
				                
								AdyenDropin dropin = checkout.create(
				                			"dropin",
				                			c
				                		);
				                GWT.log("mount");
				                dropin.mount("#dropin");
				                
				            	
				            	
				            	
				            	
				            	
				            	
				            	
				            	
				            	
				             return null; 
				            }
				        );
					
			
	
	        
	        
	        
	       


	        
	       

	    }
	}

