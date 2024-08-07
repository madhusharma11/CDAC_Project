package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ApiResponse {
	private LocalDateTime timeStamp;
	private String message;
	
	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponse(String message)
	{
		super();
		this.message=message;
		this.timeStamp=LocalDateTime.now();
	}
}
