package com.indusnet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WhatsappErrorResponce {
	private Integer status;
	private String message;
}
