package com.schubec.examples.adyenwithgwt.client;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.TextCallback;

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

import elemental2.core.Global;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class AdyenWithGwt implements EntryPoint {
    public void onModuleLoad() {
        GWT.log("onModuleLoad");

        Defaults.setAddXHttpMethodOverrideHeader(false);
        
        AdyenService service = GWT.create(AdyenService.class);
        
        
        service.order("DE", "EUR", "500", new TextCallback() {
			
			@Override
			public void onSuccess(Method method, String response) {
				GWT.log(response);
				
				Object jsonResponse1 = Global.JSON.parse(response);
				
				
           	 //adyendropin
               Configuration configuration = new Configuration();
               configuration.locale= "en_EN";
               configuration.environment="test";
               configuration.originKey="pub.v2.8015643090761754.aHR0cDovLzEyNy4wLjAuMTo4ODg4.2IZpmudJyAmjWe2_F50puc9YY7ABVHZS_t3BMQjwFP0";
               configuration.paymentMethodsResponse = jsonResponse1;
                AdyenCheckout checkout = new AdyenCheckout(configuration);
               
               
               PaymentMethodsConfiguration paymentMethodsConfiguration = new PaymentMethodsConfiguration();
               paymentMethodsConfiguration.applepay  = new ApplepayConfiguration();
               paymentMethodsConfiguration.applepay.merchantIdentifier="com.immobingooo";
               paymentMethodsConfiguration.applepay.merchantName="ImmoBingooo";
               
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
                   String test = Global.JSON.stringify(state.data);
               		service.makePayment(test, new TextCallback() {
						
						@Override
						public void onSuccess(Method method, String response) {
							Object jsonResponse2 = Global.JSON.parse(response);
							theDropin.handleAction(jsonResponse2);
						}
						
						@Override
						public void onFailure(Method method, Throwable exception) {
							// TODO Auto-generated method stub
							
						}
					});
            	   
            	   
               	
               	
               
               	
               	
               	
		
               	
               	
               	
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
