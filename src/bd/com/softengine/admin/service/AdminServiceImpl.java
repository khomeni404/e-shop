package bd.com.softengine.admin.service;

import bd.com.softengine.DAOFactory;
import bd.com.softengine.account.model.CashAccount;
import bd.com.softengine.admin.model.*;
import bd.com.softengine.security.SessionUtil;
import bd.com.softengine.security.dao.TokenDao;
import bd.com.softengine.security.model.Token;
import bd.com.softengine.security.model.User;
import bd.com.softengine.util.SoftUtil;
import bd.com.softengine.util.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 30/12/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/12/15
 * Version : 1.0
 */

@Service
@Transactional/*(propagation = Propagation.REQUIRED, readOnly = false)*/
public class AdminServiceImpl extends DAOFactory implements AdminService {
    @Autowired
    private TokenDao tokenDao;

    // Staff


    @Override
    public boolean saveStaff(String name,
                             String cellPhone,
                             String altPhone,
                             String emailAddress,
                             String mailingAddress,
                             Integer staffType,
                             String fatherName,
                             String referenceName,
                             String username,
                             String password
    ) {
        try {
            Token token = new Token();
            token.setUsername(username);
            token.setPassword(password);
            boolean savedToken = tokenDao.save(token);

            if (savedToken) {
                Integer totalStaff = staffDAO.count();
                User operator = SessionUtil.getSessionUser();
                Staff staff = new Staff();
                staff.setSid(Text.DF_0000.format(totalStaff + 1));
                staff.setName(name);
                staff.setCellPhone(cellPhone);
                staff.setAltPhone(altPhone);
                staff.setEmailAddress(emailAddress);
                staff.setMailingAddress(mailingAddress);
                staff.setStaffType(staffType);
                staff.setFatherName(fatherName);
                staff.setReferenceName(referenceName);
                staff.setActive(true);
                staff.setToken(token);

                boolean savedCust = staffDAO.save(staff);
                if (savedCust) {
                    CashAccount account = new CashAccount();
                    account.setOwner(staff);
                    account.setActive(true);
                    account.setNote(name + "'s Accounts");
                    account.setActiveBy(operator);
                    account.setOpeningDate(new Date());
                    return cashAccountDAO.save(account);
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Staff user) {
        return staffDAO.save(user);
    }

    @Override
    public boolean update(Staff user) {
        return staffDAO.update(user);
    }

    @Override
    public boolean delete(Staff user) {
        return staffDAO.delete(user);
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffDAO.findAllStaff();
    }

    @Override
    public List<Staff> findAllStaff(Integer staffType) {
        return staffDAO.findAllStaff(staffType);
    }

    @Override
    public Staff getStaff(Long id) {
        return staffDAO.getStaff(id);
    }

    @Override
    public Staff getStaff(String name) {
        return staffDAO.getStaff(name);
    }


    // Customer

    @Override
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
    ) {
        try {
            Integer totalCustomer = customerDAO.count();
            Token token = new Token();
            String username = "c"+Text.DF_0000.format(totalCustomer + 1);
            token.setUsername(username);
            token.setPassword(username + 123);
            boolean savedToken = tokenDao.save(token);

            if (savedToken) {
                User operator = SessionUtil.getSessionUser();
                Customer customer = new Customer();
                customer.setCid(Text.DF_0000.format(totalCustomer+1));
                customer.setName(name);
                customer.setCellPhone(cellPhone);
                customer.setAltPhone(altPhone);
                customer.setEmailAddress(emailAddress);
                customer.setMailingAddress(mailingAddress);
                customer.setNid(nid);
                customer.setTin(tin);
                customer.setKeyName(keyName);
                customer.setCustType(custType);
                customer.setBusinessAddress(businessAddress);
                customer.setActive(false);
                customer.setToken(token);
                boolean savedCust = customerDAO.save(customer);
                if (savedCust) {
                    CashAccount a = new CashAccount();
                    a.setOwner(customer);
                    a.setActive(true);
                    a.setNote(name + "'s Accounts");
                    a.setActiveBy(operator);
                    a.setOpeningDate(new Date());
                    return cashAccountDAO.save(a);
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Customer user) {
        return customerDAO.save(user);
    }

    @Override
    public boolean update(Customer user) {
        return customerDAO.update(user);
    }

    @Override
    public boolean delete(Customer user) {
        return customerDAO.delete(user);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDAO.findAllCustomer();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public Customer getCustomer(String name) {
        return customerDAO.getCustomer(name);
    }

    //Manufacturer
    @Override
    public boolean save(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public boolean update(Manufacturer manufacturer) {
        return manufacturerDAO.update(manufacturer);
    }

    @Override
    public boolean delete(Manufacturer manufacturer) {
        return manufacturerDAO.delete(manufacturer);
    }

    @Override
    public List<Manufacturer> findAllManufacturer() {
        return manufacturerDAO.findAllManufacturer();
    }

    @Override
    public Manufacturer getManufacturer(Integer id) {
        return manufacturerDAO.getManufacturer(id);
    }

    @Override
    public Manufacturer getManufacturer(String name) {
        return manufacturerDAO.getManufacturer(name);
    }


    //ItemReport
    @Override
    public boolean save(ItemReport itemReport) {
        return itemReportDAO.save(itemReport);
    }

    @Override
    public boolean update(ItemReport itemReport) {
        return itemReportDAO.update(itemReport);
    }

    @Override
    public boolean delete(ItemReport itemReport) {
        return itemReportDAO.delete(itemReport);
    }

    @Override
    public List<ItemReport> findAllItemReport() {
        return itemReportDAO.findAllItemReport();
    }

    @Override
    public ItemReport getItemReport(Integer id) {
        return itemReportDAO.getItemReport(id);
    }

    @Override
    public ItemReport getItemReport(String name) {
        return itemReportDAO.getItemReport(name);
    }


    // Vendor
    @Override
    public boolean save(Vendor user) {
        return vendorDAO.save(user);
    }

    @Override
    public boolean update(Vendor user) {
        return vendorDAO.update(user);
    }

    @Override
    public boolean delete(Vendor user) {
        return vendorDAO.delete(user);
    }

    @Override
    public List<Vendor> findAllVendor() {
        return vendorDAO.findAllVendor();
    }

    @Override
    public Vendor getVendor(Long id) {
        return vendorDAO.getVendor(id);
    }

    @Override
    public Vendor getVendor(String name) {
        return vendorDAO.getVendor(name);
    }


}
