package kursy.walut.Service;

import kursy.walut.model.BidAskDataTable;
import kursy.walut.model.MidDataTable;
import java.text.ParseException;

public interface DataService {
public BidAskDataTable generateBidAskTable() throws ParseException;
public MidDataTable generateMidTable() throws ParseException;

}
