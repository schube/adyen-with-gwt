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
				
				
				
				JsPropertyMap<String> map= Js.uncheckedCast(Global.JSON.parse(response));
		        DomGlobal.console.info(map);

		        JsArray<JsPropertyMap<String>> paymentMethods = Js.uncheckedCast(map.get("paymentMethods"));
		        JsPropertyMap<String> methodName = paymentMethods.getAt(0);
		        methodName.set("name", "TEST2");


		        String test = Global.JSON.stringify(map);

		        DomGlobal.console.info(test);
				
				
				
//				Map<String, ? > testMap = Js.uncheckedCast(response);
//				List<Object> paymentMethods = (List<Object>)testMap.get("paymentMethods");
//				Map<String, Object > paymentMethod = (Map<String, Object >)paymentMethods.get(0);
//				String name = (String) paymentMethod.get("name");
//				paymentMethod.put("name", "TEST2");
				
				
				//String test = JSON.stringify(testMap);
				//GWT.log(test);
				
           	 //adyendropin
               Configuration configuration = new Configuration();
               configuration.locale= "en_EN";
               configuration.environment="test";
               configuration.originKey="pub.v2.8015643090761754.aHR0dasdasTo4ODg4.2IZpmudJyAmjWe2_F50puc9YY7ABVHZS_t3BMQjwFP0";
               configuration.paymentMethodsResponse = "{\n" + 
               		"    \"paymentMethods\": [\n" + 
               		"        {\n" + 
               		"            \"details\": [\n" + 
               		"                {\n" + 
               		"                    \"items\": [\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1121\",\n" + 
               		"                            \"name\": \"Test Issuer\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1154\",\n" + 
               		"                            \"name\": \"Test Issuer 5\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1153\",\n" + 
               		"                            \"name\": \"Test Issuer 4\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1152\",\n" + 
               		"                            \"name\": \"Test Issuer 3\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1151\",\n" + 
               		"                            \"name\": \"Test Issuer 2\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1162\",\n" + 
               		"                            \"name\": \"Test Issuer Cancelled\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1161\",\n" + 
               		"                            \"name\": \"Test Issuer Pending\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1160\",\n" + 
               		"                            \"name\": \"Test Issuer Refused\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1159\",\n" + 
               		"                            \"name\": \"Test Issuer 10\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1158\",\n" + 
               		"                            \"name\": \"Test Issuer 9\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1157\",\n" + 
               		"                            \"name\": \"Test Issuer 8\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1156\",\n" + 
               		"                            \"name\": \"Test Issuer 7\"\n" + 
               		"                        },\n" + 
               		"                        {\n" + 
               		"                            \"id\": \"1155\",\n" + 
               		"                            \"name\": \"Test Issuer 6\"\n" + 
               		"                        }\n" + 
               		"                    ],\n" + 
               		"                    \"key\": \"issuer\",\n" + 
               		"                    \"type\": \"select\"\n" + 
               		"                }\n" + 
               		"            ],\n" + 
               		"            \"name\": \"iDEAL\",\n" + 
               		"            \"type\": \"ideal\"\n" + 
               		"        },\n" + 
               		"        {\n" + 
               		"            \"details\": [\n" + 
               		"                {\n" + 
               		"                    \"key\": \"encryptedCardNumber\",\n" + 
               		"                    \"type\": \"cardToken\"\n" + 
               		"                },\n" + 
               		"                {\n" + 
               		"                    \"key\": \"encryptedSecurityCode\",\n" + 
               		"                    \"type\": \"cardToken\"\n" + 
               		"                },\n" + 
               		"                {\n" + 
               		"                    \"key\": \"encryptedExpiryMonth\",\n" + 
               		"                    \"type\": \"cardToken\"\n" + 
               		"                },\n" + 
               		"                {\n" + 
               		"                    \"key\": \"encryptedExpiryYear\",\n" + 
               		"                    \"type\": \"cardToken\"\n" + 
               		"                },\n" + 
               		"                {\n" + 
               		"                    \"key\": \"holderName\",\n" + 
               		"                    \"optional\": true,\n" + 
               		"                    \"type\": \"text\"\n" + 
               		"                }\n" + 
               		"            ],\n" + 
               		"            \"name\": \"Credit Card\",\n" + 
               		"            \"type\": \"scheme\"\n" + 
               		"        },\n" + 
               		"        {\n" + 
               		"            \"name\": \"Pay later with Klarna.\",\n" + 
               		"            \"type\": \"klarna\"\n" + 
               		"        },\n" + 
               		"        {\n" + 
               		"            \"name\": \"Paysafecard\",\n" + 
               		"            \"type\": \"paysafecard\"\n" + 
               		"        }\n" + 
               		"    ],\n" + 
               		"    \"groups\": [\n" + 
               		"        {\n" + 
               		"            \"name\": \"Credit Card\",\n" + 
               		"            \"types\": [\n" + 
               		"                \"mc\",\n" + 
               		"                \"visa\",\n" + 
               		"                \"amex\"\n" + 
               		"            ]\n" + 
               		"        }\n" + 
               		"    ]\n" + 
               		"}";
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
               	
               	GWT.log("On onSubmit: " + state.data.paymentMethod.type );
               	
               
               	
               	
               	
		
               	
               	
               	
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
