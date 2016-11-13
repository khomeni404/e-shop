package bd.com.softengine.admin.dao;



import bd.com.softengine.admin.model.Vendor;

import java.util.List;

public interface VendorDAO {
    //Vendor .............
    public boolean save(Vendor user);

    public boolean update(Vendor user);

    public boolean delete(Vendor user);

    public List<Vendor> findAllVendor();

    public Vendor getVendor(Long id);

    public Vendor getVendor(String name);


}
