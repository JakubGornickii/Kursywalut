package kursy.walut.model;

public class MidRate {
    private String currency;
    private String code;
    private Double mid;
    private Double yesterdayMid;
    private Double midChange;
    private Double midChangePercent;

    public Double getYesterdayMid() {
        return yesterdayMid;
    }

    public void setYesterdayMid(Double yesterdayMid) {
        this.yesterdayMid = yesterdayMid;
    }

    public MidRate(String currency, String code, Double mid, Double yesterdayMid) {
        this.currency = currency;
        this.code = code;
        this.mid = mid;
        this.yesterdayMid = yesterdayMid;
    }


    public MidRate() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getMidChange() {
        return midChange;
    }

    public void setMidChange(Double midChange) {
        this.midChange = midChange;
    }

    public Double getMidChangePercent() {
        return midChangePercent;
    }

    public void setMidChangePercent(Double midChangePercent) {
        this.midChangePercent = midChangePercent;
    }
}
