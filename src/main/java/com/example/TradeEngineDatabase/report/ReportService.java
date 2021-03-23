//package com.example.TradeEngineDatabase.report;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ReportService {
//
//    @Autowired
//    private ReportRepository reportRepository;
//
//    public void addReport(Report report){
//        reportRepository.save(report);
//    }
//
//    public List<Report> getAllReports(){
//
//        return reportRepository.findAll();
//    }
//
//    public Report getReportById(Long id) throws Exception {
//        return reportRepository.findById(id).orElseThrow(
//                ()->new Exception("Report with id "+id+" does not exist")
//        );
//    }
//}
