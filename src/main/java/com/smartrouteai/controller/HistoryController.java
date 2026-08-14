package com.smartrouteai.controller;

import com.smartrouteai.firebase.FirebaseService;
import com.smartrouteai.firebase.SearchHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private FirebaseService firebaseService;


    @GetMapping("/history")
    public String showHistory(Model model) {

        System.out.println(
                "========== HISTORY PAGE CALLED =========="
        );

        List<SearchHistory> historyList =
                firebaseService.getSearchHistory();

        model.addAttribute(
                "historyList",
                historyList
        );

        return "history";
    }
}
