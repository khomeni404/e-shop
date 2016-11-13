package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.ItemInLog;

import java.util.List;

public interface ItemInLogDAO {
    //ItemInLog .............
    public boolean save(ItemInLog log);

    public boolean update(ItemInLog log);

    public boolean delete(ItemInLog log);

    public List<ItemInLog> findAllItemInLog();

    public ItemInLog getItemInLog(Integer id);

    public ItemInLog getItemInLog(String name);


}
