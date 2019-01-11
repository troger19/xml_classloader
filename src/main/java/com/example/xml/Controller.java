package com.example.xml;

import com.example.xml.entity.Request;
import com.example.xml.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private Servis servis;

    @GetMapping("test")
    public String test() {
        servis.callParallel();
        return "OK";
    }

    @PostMapping(value = "/xml")
    @ResponseStatus(HttpStatus.OK)
    public Response test(Request request ) {
        return new Response();
    }
}
