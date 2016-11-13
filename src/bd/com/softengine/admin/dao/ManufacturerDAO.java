package bd.com.softengine.admin.dao;



import bd.com.softengine.admin.model.Manufacturer;

import java.util.List;

public interface ManufacturerDAO {
    //Manufacturer .............
    public boolean save(Manufacturer manufacturer);

    public boolean update(Manufacturer manufacturer);

    public boolean delete(Manufacturer manufacturer);

    public List<Manufacturer> findAllManufacturer();

    public Manufacturer getManufacturer(Integer id);

    public Manufacturer getManufacturer(String name);

    public Integer count();


}
