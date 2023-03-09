package com.indusnet.service.impl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.indusnet.model.WhatsAppModel;
import com.indusnet.repository.IWhatsAppRepository;
import com.indusnet.util.WhatsAppUtil;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WhatsAppServiceImpl {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private IWhatsAppRepository whatsAppRepository;

	@Autowired
	WhatsAppUtil whatsAppUtil;

	public WhatsAppModel sendMesage(WhatsAppModel whatsModel) throws IOException {
		whatsAppRepository.save(whatsModel);
		String message = sendEmail(whatsModel);
		log.info(message);
		return whatsModel;
	}

	public String sendEmail(WhatsAppModel whatsModel) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo("pritamshank@gmail.com");
		email.setSubject("Verification");
		email.setText("Verify your whatsApp : " + "http://localhost:8080/api/v0.0.1/" + whatsModel.getOrderId());
		mailSender.send(email);
		return "successfully verified";
	}

}
