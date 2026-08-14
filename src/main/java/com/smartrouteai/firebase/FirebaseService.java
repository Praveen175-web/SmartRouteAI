package com.smartrouteai.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirebaseService {

    // =====================================================
    // SAVE SEARCH HISTORY
    // =====================================================

    public void saveSearchHistory(SearchHistory history) {

        try {

            Firestore db =
                    FirestoreClient.getFirestore();

            CollectionReference collection =
                    db.collection("search_history");

            Map<String, Object> data =
                    new HashMap<>();

            data.put(
                    "source",
                    history.getSource()
            );

            data.put(
                    "destination",
                    history.getDestination()
            );

            data.put(
                    "vehicleType",
                    history.getVehicleType()
            );

            data.put(
                    "distance",
                    history.getDistance()
            );

            data.put(
                    "fuelRequired",
                    history.getFuelRequired()
            );

            data.put(
                    "fuelCost",
                    history.getFuelCost()
            );

            data.put(
                    "estimatedTime",
                    history.getEstimatedTime()
            );

            data.put(
                    "trafficLevel",
                    history.getTrafficLevel()
            );

            data.put(
                    "trafficPercentage",
                    history.getTrafficPercentage()
            );

            data.put(
                    "weather",
                    history.getWeather()
            );

            data.put(
                    "temperature",
                    history.getTemperature()
            );

            data.put(
                    "currentTime",
                    history.getCurrentTime()
            );


            ApiFuture<?> future =
                    collection.add(data);

            future.get();


            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "SEARCH HISTORY SAVED TO FIREBASE"
            );

            System.out.println(
                    "Source: "
                            + history.getSource()
            );

            System.out.println(
                    "Destination: "
                            + history.getDestination()
            );

            System.out.println(
                    "Vehicle: "
                            + history.getVehicleType()
            );

            System.out.println(
                    "=========================================="
            );


        } catch (Exception e) {

            System.out.println(
                    "FIREBASE SEARCH HISTORY ERROR"
            );

            e.printStackTrace();
        }
    }


    // =====================================================
    // GET SEARCH HISTORY
    // =====================================================

    public List<SearchHistory> getSearchHistory() {

        List<SearchHistory> historyList =
                new ArrayList<>();

        try {

            Firestore db =
                    FirestoreClient.getFirestore();

            CollectionReference collection =
                    db.collection("search_history");


            // Get all documents

            ApiFuture<QuerySnapshot> future =
                    collection.get();

            QuerySnapshot snapshot =
                    future.get();


            // Convert Firebase documents
            // into SearchHistory objects

            for (
                    DocumentSnapshot document
                    : snapshot.getDocuments()
            ) {

                SearchHistory history =
                        document.toObject(
                                SearchHistory.class
                        );


                if (history != null) {

                    historyList.add(
                            history
                    );
                }
            }


            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "SEARCH HISTORY LOADED"
            );

            System.out.println(
                    "TOTAL RECORDS: "
                            + historyList.size()
            );

            System.out.println(
                    "=========================================="
            );


        } catch (Exception e) {

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "FIREBASE HISTORY READ ERROR"
            );

            System.out.println(
                    "=========================================="
            );

            e.printStackTrace();
        }


        return historyList;
    }
}