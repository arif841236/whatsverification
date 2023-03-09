package com.indusnet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class WhatsAppModel {
	@Id
	private Integer orderId;
	private String loginMethod;
	private String redirectionURL;
	private String state;
	private String isValidate;
}
