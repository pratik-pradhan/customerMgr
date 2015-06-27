package org.customerMgr.dao.api;


import org.customerMgr.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    public boolean addCustomer(Customer customer);

    public List<Customer> listCustomer();

    public void removeCustomer(Integer id);

	public List<Customer> searchCustomer(String customer);
}
