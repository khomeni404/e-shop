package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.Item;

import java.util.List;

public interface ItemDAO {
    //Item .............
    public boolean save(Item item);

    public boolean update(Item item);

    public boolean delete(Item item);

    public List<Item> findAllItem();

    public List<Item> findAllItem(Double stock, boolean less);

    public List<Object[]> findAllItemWithDetails();

    public Item getItem(Integer id);

    public Item getItem(String name);


}
