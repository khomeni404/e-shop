package bd.com.softengine;

import bd.com.softengine.account.dao.*;
import bd.com.softengine.account.service.AccountService;
import bd.com.softengine.admin.dao.CustomerDAO;
import bd.com.softengine.admin.dao.StaffDAO;
import bd.com.softengine.admin.dao.VendorDAO;
import bd.com.softengine.admin.service.AdminService;
import bd.com.softengine.mis.service.MISService;
import bd.com.softengine.security.service.SecurityService;
import bd.com.softengine.shop.dao.*;
import bd.com.softengine.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 30/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/05/16
 * Version : 1.0
 */
@Service
public class ServiceFactory {
    @Autowired
    public AdminService adminService;

    @Autowired
    public SecurityService securityService;

    @Autowired
    public ShopService shopService;

    @Autowired
    public AccountService accountService;

    @Autowired
    public MISService misService;


}
