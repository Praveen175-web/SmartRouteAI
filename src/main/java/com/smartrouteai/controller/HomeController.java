package com.smartrouteai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // ==========================================
    // HOME PAGE
    // ==========================================

    @GetMapping("/")
    public String home() {

        System.out.println(
                "========== HOME CONTROLLER CALLED =========="
        );

        return "index";
    }


    // ==========================================
    // JOURNEY PAGE
    // ==========================================

    @GetMapping("/journey")
    public String journey() {

        System.out.println(
                "========== JOURNEY PAGE CALLED =========="
        );

        return "journey";
    }
}