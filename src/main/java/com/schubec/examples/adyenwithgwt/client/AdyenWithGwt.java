package com.schubec.examples.adyenwithgwt.client;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

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

import elemental2.dom.DomGlobal;
import elemental2.dom.Response;

public class AdyenWithGwt implements EntryPoint {
    public void onModuleLoad() {
        GWT.log("onModuleLoad");

        Defaults.setAddXHttpMethodOverrideHeader(false);
        
        AdyenService service = GWT.create(AdyenService.class);
        
        
        service.order("DE", "EUR", "500", new MethodCallback<Object>() {
			
        	/* reponse looks like
					{
					    "paymentMethods": [
					        {
					            "details": [
					                {
					                    "key": "encryptedCardNumber",
					                    "type": "cardToken"
					                },
					                {
					                    "key": "encryptedSecurityCode",
					                    "type": "cardToken"
					                },
					                {
					                    "key": "encryptedExpiryMonth",
					                    "type": "cardToken"
					                },
					                {
					                    "key": "encryptedExpiryYear",
					                    "type": "cardToken"
					                },
					                {
					                    "key": "holderName",
					                    "optional": true,
					                    "type": "text"
					                }
					            ],
					            "name": "Credit Card",
					            "type": "scheme"
					        },
					        {
					            "name": "Online bank transfer.",
					            "type": "directEbanking"
					        },
					        {
					            "name": "Pay later with Klarna.",
					            "type": "klarna"
					        },
					        {
					            "name": "Paysafecard",
					            "type": "paysafecard"
					        },
					        {
					            "details": [
					                {
					                    "key": "bic",
					                    "type": "text"
					                }
					            ],
					            "name": "GiroPay",
					            "type": "giropay"
					        },
					        {
					            "name": "Slice it with Klarna.",
					            "type": "klarna_account"
					        }
					    ],
					    "groups": [
					        {
					            "name": "Credit Card",
					            "types": [
					                "visa",
					                "mc",
					                "amex"
					            ]
					        }
					    ]
					}
        	 */
        	
        	
			@Override
			public void onSuccess(Method method, Object response) {
				
				GWT.log(response.toString());
            	
           	 //adyendropin
               Configuration configuration = new Configuration();
               configuration.locale= "de_DE";
               configuration.environment="test";
               configuration.originKey="pub.v2.8015643090761754.aHR0cDovLzEyNy4wLjAuMTo4ODg4.2IZpmudJyAmjWe2_F50puc9YY7ABVHZS_t3BMQjwFP0";
               configuration.paymentMethodsResponse = response;
                AdyenCheckout checkout = new AdyenCheckout(configuration);
               
               
               PaymentMethodsConfiguration paymentMethodsConfiguration = new PaymentMethodsConfiguration();
               paymentMethodsConfiguration.applepay  = new ApplepayConfiguration();
               paymentMethodsConfiguration.applepay.merchantIdentifier="test";
               paymentMethodsConfiguration.applepay.merchantName="schubec GmbH";
               
               paymentMethodsConfiguration.card = new CardConfiguration();
               paymentMethodsConfiguration.card.enableStoreDetails = true;
               paymentMethodsConfiguration.card.hasHolderName= true;
               paymentMethodsConfiguration.card.holderNameRequired = true;
               paymentMethodsConfiguration.card.name = "Bernhard Schulz";
               
               
               
               
               
               
               DropinConfiguration dropinConfiguration= new DropinConfiguration();
               dropinConfiguration.paymentMethodsConfiguration = paymentMethodsConfiguration;
               dropinConfiguration.onAdditionalDetails = (state,theDropin) -> {
               	GWT.log("On onAdditionalDetails");
               };
               dropinConfiguration.onSubmit = (state,theDropin) -> {
               	
               	GWT.log("On onSubmit: " + state.data.paymentMethod.type );
               	
               
               	
               	
               	
					
					//Send payment to server
               	DomGlobal.fetch("http://localhost:12345/v1/makePayment")
			        .then(Response::json)
			        .then(
			            (jsonAction) -> {
			            	
			            	
			            	theDropin.handleAction(jsonAction);
			            	return null;
			            }
			        );
               	
               	
               	
               };
               
				AdyenDropin dropin = checkout.create(
               			"dropin",
               			dropinConfiguration
               		);
               GWT.log("mount");
               dropin.mount("#dropin");
               
           	

			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				GWT.log("ERROR: " + exception.getLocalizedMessage());
				
			}
		});



        
        
       


        
       

    }
}
