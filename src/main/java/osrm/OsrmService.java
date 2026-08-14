package com.smartrouteai.osrm;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OsrmService {

    private final RestClient restClient;

    public OsrmService() {

        restClient = RestClient.builder()
                .baseUrl("https://router.project-osrm.org")
                .build();
    }

    public OsrmResponse getRoute(
            double startLatitude,
            double startLongitude,
            double endLatitude,
            double endLongitude) {

        String url =
                "/route/v1/driving/"
                        + startLongitude + ","
                        + startLatitude + ";"
                        + endLongitude + ","
                        + endLatitude
                        + "?overview=full&geometries=geojson";

        try {

            return restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(OsrmResponse.class);

        } catch (Exception e) {

            System.out.println(
                    "OSRM error: " + e.getMessage()
            );

            return null;
        }
    }
}
