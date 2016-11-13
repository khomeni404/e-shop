package bd.com.softengine.enam;

/**
 * Created by MAK on 23/05/16.
 */
public enum CashType {
    HARD(11, "Hard Cash"),
    SALES(12, "Sales Cash"),
    SALES_RETURN(12, "Sales Return"),
    TRANSFERABLE(13, "Transferable Cash");

    public final int CODE;
    public final String NAME;

    private CashType(final int CODE, final String NAME) {
        this.CODE = CODE;
        this.NAME = NAME;
    }
}
