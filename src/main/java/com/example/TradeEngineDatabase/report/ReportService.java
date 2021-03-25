package com.example.TradeEngineDatabase.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public void addReport(Report report){
        reportRepository.save(report);
    }

    public List<Report> getAllReports(){
        Pageable paging = PageRequest.of(1, 100, Sort.by("createdAt").descending());

        Page<Report> pagedResult = reportRepository.findAll(paging);
//        List<Report> reports = reportRepository.findAll();
//        Collections.reverse(reports);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }

    }

    public Report getReportById(Long id) throws Exception {
        return reportRepository.findById(id).orElseThrow(
                ()->new Exception("Report with id "+id+" does not exist")
        );
    }
}
