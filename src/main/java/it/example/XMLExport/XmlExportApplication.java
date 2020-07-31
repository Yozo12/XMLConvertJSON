package it.example.XMLExport;

import it.example.Object.ResponseObject;
import it.example.service.XMLServiceExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class XmlExportApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(XmlExportApplication.class, args);
        XMLServiceExport xmlService= new XMLServiceExport();
        ResponseObject res= xmlService.convertXML();
    }
}
