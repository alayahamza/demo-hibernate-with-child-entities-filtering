package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@SpringBootApplication
@Controller
public class DemoHibernateWithChildEntitiesFilteringApplication {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateWithChildEntitiesFilteringApplication.class, args);
    }

    @GetMapping(path = "parents")
    public ResponseEntity<List<Parent>> getAllParents() {
        return ResponseEntity.ok(parentRepository.findAll());
    }

    @GetMapping(path = "parents-with-under-age-children")
    public ResponseEntity<List<Parent>> getAllParentsWithChildrenUnderAge(@PathParam("age") Integer age) {
        return ResponseEntity.ok(parentRepository.findByChildrenAgeLessThan(age));
    }

    @GetMapping(path = "parents-with-under-age-children-only")
    public ResponseEntity<List<Parent>> getAllParentsWithChildrenUnderAgeOnly(@PathParam("age") Integer age) {
        return ResponseEntity.ok(parentRepository.findOnlyChildrenAgeLessThan(age));
    }

    @GetMapping(path = "children")
    public ResponseEntity<List<Child>> getAllChildren() {
        return ResponseEntity.ok(childRepository.findAll());
    }



}
