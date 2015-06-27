package org.customerMgr.service;

import org.customerMgr.dao.api.CustomerDAO;
import org.customerMgr.domain.Customer;
import org.customerMgr.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    @Transactional
    public List<Customer> listCustomer() {

        return customerDAO.listCustomer();
    }

    @Transactional
    public List<Customer> searchCustomer(String customer){
    	return customerDAO.searchCustomer(customer);
    }
    @Transactional
    public void removeCustomer(Integer id) {
        customerDAO.removeCustomer(id);
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
