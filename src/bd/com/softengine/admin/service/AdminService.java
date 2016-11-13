package bd.com.softengine.admin.service;

import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.admin.model.*;

import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 30/12/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/12/15
 * Version : 1.0
 */

public interface AdminService {

    //Manufacturer .............
    public boolean save(Manufacturer manufacturer);

    public boolean update(Manufacturer manufacturer);

    public boolean delete(Manufacturer manufacturer);

    public List<Manufacturer> findAllManufacturer();

    public Manufacturer getManufacturer(Integer id);

    public Manufacturer getManufacturer(String name);

    //ItemReport .............
    public boolean save(ItemReport report);

    public boolean update(ItemReport report);

    public boolean delete(ItemReport report);

    public List<ItemReport> findAllItemReport();

    public ItemReport getItemReport(Integer id);

    public ItemReport getItemReport(String name);

    // Staff .............
    public boolean saveStaff(
            String name,
            String cellPhone,
            String altPhone,
            String emailAddress,
            String mailingAddress,
            Integer staffType,
            String fatherName,
            String referenceName,
            String username,
            String password
    );
    public boolean save(Staff user);

    public boolean update(Staff user);

    public boolean delete(Staff user);

    public List<Staff> findAllStaff();

    public List<Staff> findAllStaff(Integer staffType);

    public Staff getStaff(Long id);

    public Staff getStaff(String name);


    // Vendor .............
    public boolean save(Vendor user);

    public boolean update(Vendor user);

    public boolean delete(Vendor user);

    public List<Vendor> findAllVendor();

    public Vendor getVendor(Long id);

    public Vendor getVendor(String name);

    // Customer .............
    public boolean saveCustomer(
            String name,
            String cellPhone,
            String altPhone,
            String emailAddress,
            String mailingAddress,
            String nid,
            String tin,
            String keyName,
            Integer custType,
            String businessAddress
    );

    public boolean save(Customer user);

    public boolean update(Customer user);

    public boolean delete(Customer user);

    public List<Customer> findAllCustomer();

    public Customer getCustomer(Long id);

    public Customer getCustomer(String name);


}
