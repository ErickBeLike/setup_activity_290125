package com.app.setup.service;

import com.app.setup.entity.LogGeneral;
import com.app.setup.repository.LogGeneralRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogGeneralService {

    private final LogGeneralRepository logGeneralRepository;

    public LogGeneralService(LogGeneralRepository logGeneralRepository) {
        this.logGeneralRepository = logGeneralRepository;
    }

    public List<LogGeneral> getAllLogs() {
        return logGeneralRepository.findAll();
    }
}
