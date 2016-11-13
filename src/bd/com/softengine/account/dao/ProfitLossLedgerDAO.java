package bd.com.softengine.account.dao;


import bd.com.softengine.account.model.ProfitLossLedger;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */


public interface ProfitLossLedgerDAO {
    public boolean save(ProfitLossLedger ledger);

    public boolean update(ProfitLossLedger ledger);

    public boolean delete(ProfitLossLedger ledger);

    public List<ProfitLossLedger> findAllProfitLossLedger();

    public ProfitLossLedger getProfitLossLedger(Integer id);

}
