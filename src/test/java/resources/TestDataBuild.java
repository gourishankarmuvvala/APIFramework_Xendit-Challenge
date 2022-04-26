package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	
	
	public UpdateQRCodeAPI updateQrCodePayLoad(String description, String callback_url, int amount)
	{
		UpdateQRCode updateqrcodePayload =new UpdateQRCode();

		updateqrcodePayload.setdescription(description);
		updateqrcodePayload.setcallback_url(callback_url);
		updateqrcodePayload.setamount(amount);
		
		return updateqrcodePayload;
	}
	
}
