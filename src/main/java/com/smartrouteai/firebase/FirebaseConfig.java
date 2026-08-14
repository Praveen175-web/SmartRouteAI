package com.smartrouteai.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() {

        try {

            // Prevent Firebase from being initialized twice
            if (!FirebaseApp.getApps().isEmpty()) {

                System.out.println(
                        "Firebase is already initialized."
                );

                return;
            }

            // Read Firebase service-account JSON
            InputStream serviceAccount =
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream(
                                    "firebase-service-account.json"
                            );

            // Check whether file exists
            if (serviceAccount == null) {

                throw new RuntimeException(
                        "firebase-service-account.json " +
                                "not found in src/main/resources"
                );
            }

            // Create Firebase configuration
            FirebaseOptions options =
                    FirebaseOptions.builder()
                            .setCredentials(
                                    GoogleCredentials
                                            .fromStream(
                                                    serviceAccount
                                            )
                            )
                            .build();

            // Initialize Firebase
            FirebaseApp.initializeApp(
                    options
            );

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "       FIREBASE INITIALIZED SUCCESSFULLY"
            );

            System.out.println(
                    "=========================================="
            );

        } catch (Exception e) {

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "       FIREBASE INITIALIZATION FAILED"
            );

            System.out.println(
                    "=========================================="
            );

            e.printStackTrace();
        }
    }
}
