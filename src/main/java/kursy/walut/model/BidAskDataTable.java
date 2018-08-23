package kursy.walut.model;
import java.util.List;

public class BidAskDataTable {
    private String effectiveDate;
    private List<BidAskRate> bidAskRates;

    public BidAskDataTable() {
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<BidAskRate> getBidAskRates() {
        return bidAskRates;
    }

    public void setBidAskRates(List<BidAskRate> bidAskRates) {
        this.bidAskRates = bidAskRates;
    }
}
