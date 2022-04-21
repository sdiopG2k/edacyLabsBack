package com.edacy.edacylabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.xml.sax.SAXException;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication
@EnableWebMvc
public class EdacyLabsApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(EdacyLabsApplication.class, args);

    }


}
