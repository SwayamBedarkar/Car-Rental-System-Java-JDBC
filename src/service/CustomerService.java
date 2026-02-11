package service;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public Customer addCustomer(String name) {
        return customerDAO.save(name);
    }
}

