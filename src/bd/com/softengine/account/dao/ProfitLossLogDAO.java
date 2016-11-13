package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.ProfitLossLog;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface ProfitLossLogDAO {
    public boolean save(ProfitLossLog log);

    public boolean update(ProfitLossLog log);

    public boolean delete(ProfitLossLog log);

    public List<ProfitLossLog> findAllProfitLossLog();

    public ProfitLossLog getProfitLossLog(Long id);

}
