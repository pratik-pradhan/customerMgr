package org.customerMgr.controller;

import org.customerMgr.domain.Customer;
import org.customerMgr.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String loadAddCustomer(Map<String, Object> map) {
        map.put("customer", new Customer());
        return "customer";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String loadEditCustomer(Map<String, Object> map) {
        map.put("customer", new Customer());
        return "search";
    }

    @RequestMapping("/list")
    public String listCustomer(Map<String, Object> map) {

        map.put("customer", new Customer());
        map.put("customerList", customerService.listCustomer());
        System.out.println("list is " +map.get("customerList"));
        return "listCustomers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customer";
        }
        customerService.addCustomer(customer);
        return "redirect:/add";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        
        System.out.println("first name is " +customer.getFirstname());
       
        model.addAttribute("customerList", customerService.searchCustomer(customer.getFirstname()));
        
        
        return "search";
    }
    
    @RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.removeCustomer(customerId);
        return "redirect:/list";
    }
}
