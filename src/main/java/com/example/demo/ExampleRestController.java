package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController methods return object serialized in JSON, XML, etc.
@RestController
@RequestMapping(value = "/example") // methods in this class will be called with /example is accessed
public class ExampleRestController {
    private ExampleRepository exampleRepository;

    @Autowired // injects an instance of ExampleRepository as an argument when controller is created
    ExampleRestController(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
        this.exampleRepository.save(new ExampleModel("Very very very long name"));
        this.exampleRepository.save(new ExampleModel("Short name"));
    }

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String index() {
        return "Go to /example/all for all objects or /example/less/[number] for objects with names less than the specified number.";
    }

    // return all objects in JSON
    // @RequestMapping(value = "/all", method = RequestMethod.GET)
    @GetMapping("/all")
    public List<ExampleModel> all() {
        return exampleRepository.findAll();
    }

    // variables should be annotated as @PathVariables
    // @RequestMapping(value = "/less/{length}", method = RequestMethod.GET)
    @GetMapping("/find/{length}")
    public List<ExampleModel> getLessThanLength(@PathVariable int length) {
        return exampleRepository.findByNameLengthLessThan(length);
    }
}
