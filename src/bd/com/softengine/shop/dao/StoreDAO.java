package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.Store;

import java.util.List;

public interface StoreDAO {

    public boolean save(Store store);

    public boolean update(Store store);

    public boolean delete(Store store);

    public List<Store> findAllStore();

    public List<Object[]> findAllStoreComboData();

    public Store getStore(Integer id);

    public Store getStore(String name);


}
