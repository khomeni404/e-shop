package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.ItemOutLog;

import java.util.List;

public interface ItemOutLogDAO {
    //ItemOutLog .............
    public boolean save(ItemOutLog log);

    public boolean update(ItemOutLog log);

    public boolean delete(ItemOutLog log);

    public List<ItemOutLog> findAllItemOutLog();

    public ItemOutLog getItemOutLog(Integer id);

    public ItemOutLog getItemOutLog(String name);


}
