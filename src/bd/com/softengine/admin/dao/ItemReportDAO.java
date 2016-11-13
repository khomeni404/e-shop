package bd.com.softengine.admin.dao;



import bd.com.softengine.admin.model.ItemReport;

import java.util.List;

public interface ItemReportDAO {
    //ItemReport .............
    public boolean save(ItemReport report);

    public boolean update(ItemReport report);

    public boolean delete(ItemReport report);

    public List<ItemReport> findAllItemReport();

    public ItemReport getItemReport(Integer id);

    public ItemReport getItemReport(String name);

    public Integer count();


}
