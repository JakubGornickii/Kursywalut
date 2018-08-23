package kursy.walut.model;

public class BidAskRate {
    private String currency;
    private String code;
    private Double bid;
    private Double ask;
    private Double askChange;
    private Double askChangePercent;
    private Double bidChange;
    private Double bidChangePercent;

    public BidAskRate(String currency, String code, Double bid, Double ask) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }

    public BidAskRate() {
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

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getAskChange() {
        return askChange;
    }

    public void setAskChange(Double askChange) {
        this.askChange = askChange;
    }

    public Double getAskChangePercent() {
        return askChangePercent;
    }

    public void setAskChangePercent(Double askChangePercent) {
        this.askChangePercent = askChangePercent;
    }

    public Double getBidChange() {
        return bidChange;
    }

    public void setBidChange(Double bidChange) {
        this.bidChange = bidChange;
    }

    public Double getBidChangePercent() {
        return bidChangePercent;
    }

    public void setBidChangePercent(Double bidChangePercent) {
        this.bidChangePercent = bidChangePercent;
    }
}
