package com.example.demo;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller methods return String that indicates which template to render
@Controller
public class ExampleController {
    private ExampleRepository exampleRepository;

    // injects value as defined in application.properties
    @Value("${mode}")
    private String mode;

    // this is an alternative way to get the value of 'mode' instead of @Value
    // @Autowired
    // public ExampleController(Environment env) {
    //    mode = env.getProperty("mode");
    // }

    @Autowired
    ExampleController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mode", mode); // do this for any variable used in template
        return "index"; // render resources/templates/index.html
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("newObject", new ExampleModel()); // for the form in form.html
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("newObject") ExampleModel newObject) { // @ModelAttributes are bound to incoming form content
        newObject.setNameLength(newObject.getName().length());
        exampleRepository.save(newObject);
        return "result";
    }
}
