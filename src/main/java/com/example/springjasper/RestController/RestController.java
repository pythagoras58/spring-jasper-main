package com.example.springjasper.RestController;

import com.example.springjasper.Model.StudentModel;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class RestController {

    public String Index(){
        try{
            String path = "C:\\Users\\Pythagorasweb\\Documents\\programming\\spring boot\\generated\\amigoscode\\spring-jasper\\src\\main\\resources\\reports\\Simple_Blue.jrxml";
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
            
        }catch (Exception e){
            System.out.println("Exception Creating Report");
        }
        return "index";
    }
}
