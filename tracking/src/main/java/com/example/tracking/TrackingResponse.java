package com.example.tracking;

import java.time.ZonedDateTime;

import lombok.Data;


@Data
public class TrackingResponse {
	
	private String trackingNumber;
    private ZonedDateTime createdAt;

}
