package bd.com.softengine.shop.dao;

import bd.com.softengine.shop.model.MeasurementUnit;

import java.util.List;

public interface UnitDAO {
    //MeasurementUnit .............
    public boolean save(MeasurementUnit unit);

    public boolean update(MeasurementUnit unit);

    public boolean delete(MeasurementUnit unit);

    public List<MeasurementUnit> findAllMeasurementUnit();

    public MeasurementUnit getMeasurementUnit(Integer id);

    public MeasurementUnit getMeasurementUnit(String name);


}
