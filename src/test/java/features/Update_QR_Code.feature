Feature: Updating QR Code using Patch Request

@Update_QR_Code_With_Minimum_and_Maximum-Amount @Regression
Scenario Outline: Verify if Qr_Code is being Succesfully updated using Update QR Code API
	Given Update_QR_Code Payload with "<description>"  "<callback_url>" "<amount>" "<Qr_Code_Id>"
	When user calls "Update_QR_CodeAPI" with "PATCH" http request
	Then the API call got success with status code 200
	And "status" in response body is "ACTIVE"
	And verify the Qr_Code_Id "Qr_Code_Id"
	
Examples:
	|description          		   | callback_url 		    |amount  ||Qr_Code_Id	    |
	|Minum Amout Test Description      | https://my-shop.com/callbacks  |1500    ||testing_id_1586839321|
	|Maxmium Amount Test Description   | https://my-shop.com/callbacks  |5000000 ||testing_id_1586839321|

@Update_QR_Code_with_Lessthan_Minimum_and_Greater_Than_Max_Amount
Scenario Outline: Verify if Qr_Code is being updated using Update QR Code API with Lessthan Minimum and Greater Than Max AmountValue Input
	Given Update_QR_Code Payload with "<description>"  "<callback_url>" "<amount>" "<Qr_Code_Id>"
	When user calls "Update_QR_CodeAPI" with "PATCH" http request
	Then the API call should return the status code
	And validate the "status","message" in response body
	
Examples:
	|description          		   | callback_url 		    |amount  ||Qr_Code_Id	    |
	|Minum Amout Test Description      | https://my-shop.com/callbacks  |1400    ||testing_id_1586839321|
	|Maxmium Amount Test Description   | https://my-shop.com/callbacks  |6000000 ||testing_id_1586839321|
	 

@Update_QR_Code_with_Invalid_Amount_data_type
Scenario Outline: Verify if Qr_Code is being updated using Update QR Code API with Invalid Amount data type Value Input
	Given Update_QR_Code Payload with "<description>"  "<callback_url>" "<amount>" "<Qr_Code_Id>"
	When user calls "Update_QR_CodeAPI" with "PATCH" http request
	Then the API call should return the status code
	And validate the "status","message" in response body
	
Examples:
	|description          		   | callback_url 		    |amount  	      ||Qr_Code_Id	    |
	|Minum Amout Test Description      | https://my-shop.com/callbacks  |1500    	      ||testing_id_1586839321|
	|Maxmium Amount Test Description   | https://my-shop.com/callbacks  |FIVE Billion USD ||testing_id_1586839321|

@Update_QR_Code_with_Invalid_resource_id
Scenario Outline: Verify if Qr_Code is being updated using Update QR Code API with Invalid resource_id Value Input
	Given Update_QR_Code Payload with "<description>"  "<callback_url>" "<amount>" "<Qr_Code_Id>"
	When user calls "Update_QR_CodeAPI" with "PATCH" http request
	Then the API call should return the status code
	And validate the "status","message" in response body
	
Examples:
	|description          		   | callback_url 		    |amount  ||Qr_Code_Id	 |
	|Minum Amout Test Description      | https://my-shop.com/callbacks  |1500    ||testing_id_1586839|

	
	
	
	
	
	
	

	
	
	