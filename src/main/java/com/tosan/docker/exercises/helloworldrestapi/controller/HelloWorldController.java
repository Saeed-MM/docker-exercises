package com.tosan.docker.exercises.helloworldrestapi.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author S.Mokhatri
 * @since 8/8/2022
 */
@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWord() {
        return new ResponseEntity<>("Hello Stranger", HttpStatus.OK);
    }

    @GetMapping(value = "/helloworld", params = "name")
    public ResponseEntity<String> helloWord(@RequestParam("name") String name) {
        if (StringUtils.isNotBlank(name)) {
            name = CaseUtils.toCamelCase(name, true, ' ');
            return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/author")
    public ResponseEntity<String> author() {
        return new ResponseEntity<>("Saeed Mokhtari", HttpStatus.OK);
    }
}
