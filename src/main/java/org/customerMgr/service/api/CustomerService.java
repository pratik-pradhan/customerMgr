package org.customerMgr.service.api;

import org.customerMgr.domain.Customer;

import java.util.List;

public interface CustomerService {

    public boolean addCustomer(Customer customer);

    public List<Customer> listCustomer();
    
    public List<Customer> searchCustomer(String customer);

    public void removeCustomer(Integer id);
}
