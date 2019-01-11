package com.example.xml;

import com.example.xml.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class Servis {

    @Autowired
    private RestTemplate restTemplate;

    void callParallel() {
        List<String> params = Arrays.asList("1", "2", "3", "4"); // just to create 4 parallel operations
        params
                .parallelStream() // this is the PROBLEM, stream() works
                .forEach(s -> callServiceLayer(s));
    }

    private void callServiceLayer(String s) {
        Request request = new Request();
        String threadName = Thread.currentThread().getName();
        System.out.println("in servis before the call " + threadName + " , : classloader : " + Thread.currentThread().getContextClassLoader());

//        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());  // this is the FIX
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8002/xml", request, String.class);

        System.out.println("in servis after the call " + threadName + " , : classloader : " + Thread.currentThread().getContextClassLoader());
        System.out.println(response);
    }
}
