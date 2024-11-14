package com.example.tracking;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;


@Data
public class TrackingRequest {
    private String originCountryId;
    private String destinationCountryId;
    private double weight;
    private ZonedDateTime createdAt;
    private UUID customerId;
    private String customerName;
    private String customerSlug;

}
