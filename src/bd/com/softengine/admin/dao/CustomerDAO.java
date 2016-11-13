package bd.com.softengine.admin.dao;



import bd.com.softengine.admin.model.Customer;

import java.util.List;

public interface CustomerDAO {
    //Customer .............
    public boolean save(Customer user);

    public boolean update(Customer user);

    public boolean delete(Customer user);

    public List<Customer> findAllCustomer();

    public Customer getCustomer(Long id);

    public Customer getCustomer(String name);

    public Integer count();


}
