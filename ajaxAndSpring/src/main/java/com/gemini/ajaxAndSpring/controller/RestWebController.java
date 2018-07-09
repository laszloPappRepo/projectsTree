package com.gemini.ajaxAndSpring.controller;

import com.gemini.ajaxAndSpring.model.Customer;
import com.gemini.ajaxAndSpring.model.HeroResponse;
import com.gemini.ajaxAndSpring.model.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    List<Customer> cust = new ArrayList<>();

    @GetMapping(value = "/all")
    public HeroResponse getResource() {
        return new HeroResponse();
    }

    @PostMapping(value = "/save")
    public Response postCustomer(@RequestBody Customer customer) {
        cust.add(customer);

        // Create Response Object
        Response response = new Response("Done", customer);
        return response;
    }
}
