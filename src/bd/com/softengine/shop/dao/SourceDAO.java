package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.Source;

import java.util.List;

public interface SourceDAO {
    //Source .............
    public boolean save(Source source);

    public boolean update(Source source);

    public boolean delete(Source source);

    public List<Source> findAllSource();

    public Source getSource(Integer id);

    public Source getSource(String name);


}
