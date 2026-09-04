package com.smartrouteai.util;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Graph;

public class CityData {

    public static Graph createGraph() {

        Graph graph = new Graph();

        // ============================================================
        // 32 DISTRICTS
        // ============================================================

        City chennai = new City("Chennai", 0);
        City tiruvallur = new City("Tiruvallur", 0);
        City chengalpattu = new City("Chengalpattu", 0);
        City kanchipuram = new City("Kanchipuram", 0);
        City ranipet = new City("Ranipet", 0);
        City vellore = new City("Vellore", 0);
        City tirupathur = new City("Tirupathur", 0);
        City tiruvannamalai = new City("Tiruvannamalai", 0);
        City villupuram = new City("Villupuram", 0);
        City kallakurichi = new City("Kallakurichi", 0);
        City cuddalore = new City("Cuddalore", 0);
        City krishnagiri = new City("Krishnagiri", 0);
        City dharmapuri = new City("Dharmapuri", 0);
        City salem = new City("Salem", 0);
        City namakkal = new City("Namakkal", 0);
        City erode = new City("Erode", 0);
        City tiruppur = new City("Tiruppur", 0);
        City coimbatore = new City("Coimbatore", 0);
        City nilgiris = new City("Nilgiris", 0);
        City karur = new City("Karur", 0);
        City tiruchirappalli = new City("Tiruchirappalli", 0);
        City perambalur = new City("Perambalur", 0);
        City ariyalur = new City("Ariyalur", 0);
        City thanjavur = new City("Thanjavur", 0);
        City tiruvarur = new City("Tiruvarur", 0);
        City nagapattinam = new City("Nagapattinam", 0);
        City mayiladuthurai = new City("Mayiladuthurai", 0);
        City pudukkottai = new City("Pudukkottai", 0);
        City dindigul = new City("Dindigul", 0);
        City madurai = new City("Madurai", 0);
        City sivaganga = new City("Sivaganga", 0);
        City ramanathapuram = new City("Ramanathapuram", 0);

        // ============================================================
        // ADD ALL DISTRICTS
        // ============================================================

        graph.addCity(chennai);
        graph.addCity(tiruvallur);
        graph.addCity(chengalpattu);
        graph.addCity(kanchipuram);
        graph.addCity(ranipet);
        graph.addCity(vellore);
        graph.addCity(tirupathur);
        graph.addCity(tiruvannamalai);
        graph.addCity(villupuram);
        graph.addCity(kallakurichi);
        graph.addCity(cuddalore);
        graph.addCity(krishnagiri);
        graph.addCity(dharmapuri);
        graph.addCity(salem);
        graph.addCity(namakkal);
        graph.addCity(erode);
        graph.addCity(tiruppur);
        graph.addCity(coimbatore);
        graph.addCity(nilgiris);
        graph.addCity(karur);
        graph.addCity(tiruchirappalli);
        graph.addCity(perambalur);
        graph.addCity(ariyalur);
        graph.addCity(thanjavur);
        graph.addCity(tiruvarur);
        graph.addCity(nagapattinam);
        graph.addCity(mayiladuthurai);
        graph.addCity(pudukkottai);
        graph.addCity(dindigul);
        graph.addCity(madurai);
        graph.addCity(sivaganga);
        graph.addCity(ramanathapuram);

        // ============================================================
        // CHENNAI REGION
        // ============================================================

        graph.addRoad(chennai, tiruvallur, 50);
        graph.addRoad(chennai, kanchipuram, 70);
        graph.addRoad(chennai, chengalpattu, 60);

        graph.addRoad(tiruvallur, kanchipuram, 70);
        graph.addRoad(tiruvallur, vellore, 130);

        graph.addRoad(kanchipuram, chengalpattu, 65);
        graph.addRoad(kanchipuram, ranipet, 55);

        graph.addRoad(chengalpattu, villupuram, 105);
        graph.addRoad(chengalpattu, cuddalore, 110);

        // ============================================================
        // NORTH TAMIL NADU
        // ============================================================

        graph.addRoad(ranipet, vellore, 30);
        graph.addRoad(ranipet, tiruvannamalai, 95);

        graph.addRoad(vellore, tirupathur, 90);
        graph.addRoad(vellore, tiruvannamalai, 85);
        graph.addRoad(vellore, krishnagiri, 100);

        graph.addRoad(tirupathur, krishnagiri, 85);
        graph.addRoad(tirupathur, tiruvannamalai, 110);

        graph.addRoad(krishnagiri, dharmapuri, 90);
        graph.addRoad(krishnagiri, salem, 110);

        graph.addRoad(tiruvannamalai, villupuram, 65);
        graph.addRoad(tiruvannamalai, kallakurichi, 95);
        graph.addRoad(tiruvannamalai, salem, 160);

        // ============================================================
        // VILLUPURAM / CUDDALORE REGION
        // ============================================================

        graph.addRoad(villupuram, cuddalore, 45);
        graph.addRoad(villupuram, kallakurichi, 70);
        graph.addRoad(villupuram, salem, 175);

        graph.addRoad(cuddalore, kallakurichi, 90);
        graph.addRoad(cuddalore, mayiladuthurai, 100);

        graph.addRoad(kallakurichi, salem, 140);
        graph.addRoad(kallakurichi, perambalur, 115);

        // ============================================================
        // SALEM / WESTERN REGION
        // ============================================================

        graph.addRoad(dharmapuri, salem, 65);

        graph.addRoad(salem, namakkal, 55);
        graph.addRoad(salem, erode, 65);
        graph.addRoad(salem, karur, 95);
        graph.addRoad(salem, tiruchirappalli, 135);

        graph.addRoad(namakkal, erode, 75);
        graph.addRoad(namakkal, karur, 55);
        graph.addRoad(namakkal, tiruchirappalli, 90);

        graph.addRoad(erode, tiruppur, 55);
        graph.addRoad(erode, karur, 65);
        graph.addRoad(erode, coimbatore, 100);

        graph.addRoad(tiruppur, coimbatore, 55);
        graph.addRoad(tiruppur, karur, 80);

        graph.addRoad(coimbatore, nilgiris, 55);
        graph.addRoad(coimbatore, karur, 125);

        // ============================================================
        // CENTRAL REGION
        // ============================================================

        graph.addRoad(karur, tiruchirappalli, 80);
        graph.addRoad(karur, dindigul, 100);

        graph.addRoad(tiruchirappalli, perambalur, 60);
        graph.addRoad(tiruchirappalli, ariyalur, 75);
        graph.addRoad(tiruchirappalli, thanjavur, 60);
        graph.addRoad(tiruchirappalli, pudukkottai, 55);
        graph.addRoad(tiruchirappalli, dindigul, 100);

        graph.addRoad(perambalur, ariyalur, 35);
        graph.addRoad(perambalur, kallakurichi, 115);

        graph.addRoad(ariyalur, thanjavur, 55);
        graph.addRoad(ariyalur, mayiladuthurai, 90);

        // ============================================================
        // DELTA REGION
        // ============================================================

        graph.addRoad(thanjavur, tiruvarur, 55);
        graph.addRoad(thanjavur, nagapattinam, 85);
        graph.addRoad(thanjavur, mayiladuthurai, 115);
        graph.addRoad(thanjavur, pudukkottai, 60);

        graph.addRoad(tiruvarur, nagapattinam, 30);
        graph.addRoad(tiruvarur, mayiladuthurai, 40);

        graph.addRoad(nagapattinam, mayiladuthurai, 45);

        graph.addRoad(mayiladuthurai, ariyalur, 90);
        graph.addRoad(mayiladuthurai, cuddalore, 100);

        // ============================================================
        // PUDUKKOTTAI / SOUTH CENTRAL
        // ============================================================

        graph.addRoad(pudukkottai, sivaganga, 70);
        graph.addRoad(pudukkottai, madurai, 110);
        graph.addRoad(pudukkottai, ramanathapuram, 120);

        // ============================================================
        // DINDIGUL / MADURAI
        // ============================================================

        graph.addRoad(dindigul, madurai, 65);
        graph.addRoad(dindigul, tiruchirappalli, 100);
        graph.addRoad(dindigul, karur, 100);

        graph.addRoad(madurai, sivaganga, 50);
        graph.addRoad(madurai, ramanathapuram, 120);

        // ============================================================
        // RAMANATHAPURAM REGION
        // ============================================================

        graph.addRoad(sivaganga, ramanathapuram, 95);
        graph.addRoad(sivaganga, madurai, 50);

        // ============================================================
        // ADDITIONAL ALTERNATIVE ROUTES
        //
        // These connections are important because the shortest-path
        // algorithm must be able to compare multiple possible routes.
        // ============================================================

        graph.addRoad(chennai, vellore, 140);
        graph.addRoad(chennai, villupuram, 160);

        graph.addRoad(vellore, salem, 180);
        graph.addRoad(vellore, villupuram, 145);

        graph.addRoad(salem, coimbatore, 170);
        graph.addRoad(salem, tiruchirappalli, 135);

        graph.addRoad(coimbatore, dindigul, 160);

        graph.addRoad(karur, dindigul, 100);

        graph.addRoad(tiruchirappalli, madurai, 135);

        graph.addRoad(thanjavur, madurai, 170);

        graph.addRoad(pudukkottai, thanjavur, 60);

        graph.addRoad(madurai, ramanathapuram, 120);

        // ============================================================
        // RETURN COMPLETE 32-DISTRICT GRAPH
        // ============================================================

        return graph;
    }
}