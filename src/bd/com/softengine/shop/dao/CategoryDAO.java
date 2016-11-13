package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.Category;

import java.util.List;

public interface CategoryDAO {
    //Category .............
    public boolean save(Category category);

    public boolean update(Category category);

    public boolean delete(Category category);

    public List<Category> findAllCategory();

    public Category getCategory(Integer id);

    public Category getCategory(String name);


}
