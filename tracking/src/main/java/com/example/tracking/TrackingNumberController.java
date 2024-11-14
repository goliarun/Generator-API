package com.example.tracking;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


	@RestController
	public class TrackingNumberController {

	    @Autowired
	    private TrackingNumberService trackingNumberService;

	   	    
	    @GetMapping("/next-tracking-number")
	    public TrackingResponse getNextTrackingNumber(
	            @RequestParam String originCountryId,
	            @RequestParam String destinationCountryId,
	            @RequestParam double weight,
	            @RequestParam String createdAt,
	            @RequestParam String customerId,
	            @RequestParam String customerName,
	            @RequestParam String customerSlug) {

	        TrackingRequest request = new TrackingRequest();
	        request.setOriginCountryId(originCountryId);
	        request.setDestinationCountryId(destinationCountryId);
	        request.setWeight(weight);
	        request.setCreatedAt(ZonedDateTime.parse(createdAt));
	        request.setCustomerId(UUID.fromString(customerId));
	        request.setCustomerName(customerName);
	        request.setCustomerSlug(customerSlug);

	        String trackingNumber = trackingNumberService.generateTrackingNumber(request);
	        TrackingResponse response = new TrackingResponse();
	        response.setTrackingNumber(trackingNumber);
	        response.setCreatedAt(ZonedDateTime.now());

	        return response;
	    }
	}


