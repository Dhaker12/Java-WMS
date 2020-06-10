/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;

/**
 *
 * @author Dhake
 */
public class SMS {
    public static void SendSMS(String FROM , String messageText , String to  )
    {
   NexmoClient client = new NexmoClient.Builder()
  .apiKey("c208cf87")
  .apiSecret("Prl9N2VpextLY7kW")
  .build();
TextMessage message = new TextMessage(FROM, to , messageText);
SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
}
}
    

