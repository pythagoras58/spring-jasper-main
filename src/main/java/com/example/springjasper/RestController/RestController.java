package com.example.springjasper.RestController;

import com.example.springjasper.Model.StudentModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class RestController {

    @GetMapping("/")
    public String Index(){
        try{
            String filePath = "C:\\Users\\Pythagorasweb\\Documents\\programming\\spring boot\\generated\\amigoscode\\spring-jasper\\src\\main\\resources\\reports\\Simple_Blue.jrxml";
            String destination = "C:\\Users\\Pythagorasweb\\Documents\\programming\\spring boot\\generated\\amigoscode\\spring-jasper\\src\\main\\resources\\reports\\destination\\report.pdf";
            Map<String, Object> parameters = new HashMap<String,Object>();
            parameters.put("studentName", "Pythagoras");

            // create student objects
            StudentModel studentModel = new StudentModel(1L,"Danso", "Pytha", "Nii Boiman", "Lapaz");
            StudentModel studentModel1 = new StudentModel(1L,"Danso", "Pytha", "Nii Boiman", "Lapaz");

            List<StudentModel> studentModelList = new ArrayList<StudentModel>();

            studentModelList.add(studentModel);
            studentModelList.add(studentModel1);

            // use JRBean Collection Datasource
            JRBeanCollectionDataSource dataSource =  new JRBeanCollectionDataSource(studentModelList);

            // compile the jrxml file
            JasperReport report = JasperCompileManager.compileReport(filePath);

            // feed the data to the report
           JasperPrint print = JasperFillManager.fillReport(report, parameters, dataSource);

           // export the printed jasper report in pdf format
            JasperExportManager.exportReportToPdfFile(print, destination);

        }catch (Exception e){
            System.out.println("Exception Creating Report");
        }
        return "index";
    }
}
