package com.example.tracking;



import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class TrackingNumberService {

    // In-memory set to store generated tracking numbers
    private Set<String> generatedTrackingNumbers = new HashSet<>();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random RANDOM = new Random();

    public String generateTrackingNumber(TrackingRequest request) {
        String trackingNumber = generateRandomTrackingNumber();

        // Ensure uniqueness of the tracking number
        while (generatedTrackingNumbers.contains(trackingNumber)) {
            trackingNumber = generateRandomTrackingNumber();
        }

        generatedTrackingNumbers.add(trackingNumber);
        return trackingNumber;
    }

    private String generateRandomTrackingNumber() {
        StringBuilder trackingNumber = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            trackingNumber.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return trackingNumber.toString();
    }
}