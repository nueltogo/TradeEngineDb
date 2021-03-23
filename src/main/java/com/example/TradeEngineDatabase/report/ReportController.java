package com.example.TradeEngineDatabase.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public void sendReport(@RequestBody Report report){
        reportService.addReport(report);
    }

    @GetMapping("/all")
    public List<Report> getReports(){
        return reportService.getAllReports();
    }

    @GetMapping("/id/{id}")
    public Report getReports(@PathVariable("id") long id) throws Exception {
        return reportService.getReportById(id);
    }
}
