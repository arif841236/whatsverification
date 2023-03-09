package com.indusnet.controller;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.exception.WhatsappException;
import com.indusnet.model.WhatsAppModel;
import com.indusnet.repository.IWhatsAppRepository;
import com.indusnet.service.impl.WhatsAppServiceImpl;


@RestController
@RequestMapping("/api/v0.0.1")
public class WhatsAppController {

	@Autowired
	private WhatsAppServiceImpl whatsImpl;
	@Autowired
	private IWhatsAppRepository whatsAppRepository;

	@PostMapping
	public ResponseEntity<WhatsAppModel> sendWhatsAppMessage(@RequestBody WhatsAppModel whatsModel) throws IOException {
		return ResponseEntity.ok().body(whatsImpl.sendMesage(whatsModel));
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> verifyUser(@PathVariable("id") Integer id) {
		Optional<WhatsAppModel> whatsModel = whatsAppRepository.findById(id);
		if (whatsModel.isPresent()) {
			WhatsAppModel whatsAppModel = whatsModel.get();
			whatsAppModel.setIsValidate("Yes");
			whatsAppRepository.save(whatsAppModel);
			return ResponseEntity.ok().body("Successfully Validate");
		}
		throw new WhatsappException("Not verified");
	}

//	public ResponseEntity<String> checkingVerification(){
//		
//	}
}
