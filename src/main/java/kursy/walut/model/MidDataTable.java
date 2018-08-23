package kursy.walut.model;

import java.util.List;

public class MidDataTable {
    private String effectiveDate;
    private List<MidRate> midRates;

    public MidDataTable() {
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<MidRate> getMidRates() {
        return midRates;
    }

    public void setMidRates(List<MidRate> midRates) {
        this.midRates = midRates;
    }
}
