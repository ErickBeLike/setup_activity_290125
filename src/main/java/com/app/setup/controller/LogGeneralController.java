package com.app.setup.controller;

import com.app.setup.service.LogGeneralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogGeneralController {

    private final LogGeneralService logGeneralService;

    public LogGeneralController(LogGeneralService logGeneralService) {
        this.logGeneralService = logGeneralService;
    }

    @GetMapping("/logs")
    public String getLogs(Model model) {
        model.addAttribute("logs", logGeneralService.getAllLogs());
        return "logs"; // Este es el nombre de la vista Thymeleaf
    }
}
