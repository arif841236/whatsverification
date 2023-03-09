package com.indusnet.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import com.indusnet.model.WhatsAppModel;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Component
public class WhatsAppUtil {
	@Autowired
	private SimpMessagingTemplate webSocket;
	public static final String ACCOUNT_SID = "AC1e78d14723267e80f82fbec07de6d6ee";
	public static final String AUTH_TOKEN = "e0eed58b076af4865bb6251b000746ea";

	public void send(String mobile, WhatsAppModel whatsModel) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message.creator(new PhoneNumber("whatsapp:+91" + mobile), new PhoneNumber("whatsapp:+14155238886"),
				"Verify your whatsApp : " + "http://localhost:8080/api/v0.0.1/" + whatsModel.getOrderId()).create();
		webSocket.convertAndSend("/api/v1.1.2/otp/generate", getTimeStamp() + ": SMS has been sent!: " + mobile);
	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
}
