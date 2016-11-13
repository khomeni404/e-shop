package bd.com.softengine.admin.dao;



import bd.com.softengine.admin.model.Staff;

import java.util.List;

public interface StaffDAO {
    //Staff .............
    public boolean save(Staff user);

    public boolean update(Staff user);

    public boolean delete(Staff user);

    public List<Staff> findAllStaff();

    public List<Staff> findAllStaff(Integer staffType);

    public Staff getStaff(Long id);

    public Staff getStaff(String name);

    public Integer count();
}
