package kursy.walut.Service;

import kursy.walut.client.CallRestService;
import kursy.walut.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("dataService")
public class DataServiceImpl implements DataService {

    @Autowired
    CallRestService callRestService;

    @Override
    public BidAskDataTable generateBidAskTable() throws ParseException {
        Table[] tableToday = callRestService.callRest("c");
        Table[] tableYesterday = callRestService.callRest("c", getYesterday(tableToday[0].getEffectiveDate()));
        BidAskDataTable bidAskDataTable = new BidAskDataTable();
        bidAskDataTable.setEffectiveDate(tableToday[0].getEffectiveDate());
        List<BidAskRate> lists = new ArrayList<>();


        for (int i = 0; i < tableToday[0].getRates().size(); i++) {
            Rate rateToday = tableToday[0].getRates().get(i);
            Rate rateYesterday = tableYesterday[0].getRates().get(i);
            BidAskRate bidAskRate = new BidAskRate(rateToday.getCurrency(), rateToday.getCode(), rateToday.getBid(), rateToday.getAsk());
            double bidT = rateToday.getBid();
            double bidY = rateYesterday.getBid();
            double askT = rateToday.getAsk();
            double askY = rateYesterday.getAsk();
            bidAskRate = createbidData(bidAskRate, bidT, bidY);
            bidAskRate = createaskData(bidAskRate, askT, askY);


            lists.add(bidAskRate);
        }
        bidAskDataTable.setBidAskRates(lists);
        return bidAskDataTable;
    }

    private BidAskRate createbidData(BidAskRate bidAskRate, double bidT, double bidY) {
        Double changeBidDouble = BigDecimal.valueOf(bidT - bidY)
                .setScale(6, RoundingMode.HALF_UP)
                .doubleValue();
        bidAskRate.setBidChange(changeBidDouble);
        double change = bidAskRate.getBidChange();
        if (change < 0) {
            change = -change;}
            Double changePro = BigDecimal.valueOf((bidT - bidY) / bidT * 100)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            bidAskRate.setBidChangePercent(changePro);
          return bidAskRate;
       }
        private BidAskRate createaskData(BidAskRate bidAskRate, double askT, double askY) {
            Double changeBidDouble = BigDecimal.valueOf(askT - askY)
                    .setScale(6, RoundingMode.HALF_UP)
                    .doubleValue();
            bidAskRate.setAskChange(changeBidDouble);
            double change = bidAskRate.getBidChange();
            if (change < 0) {
                change = -change;}
                Double changePro = BigDecimal.valueOf((askT - askY) / askT * 100)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();
                bidAskRate.setAskChangePercent(changePro);
                  return bidAskRate;
            }


    @Override
    public MidDataTable generateMidTable() throws ParseException {
        Table[] tableToday = callRestService.callRest("a");
        Table[] tableYesterday = callRestService.callRest("a", getYesterday(tableToday[0].getEffectiveDate()));

        MidDataTable midDataTable = new MidDataTable();
        midDataTable.setEffectiveDate(tableToday[0].getEffectiveDate());
        List<MidRate> lists = new ArrayList<>();
        for (int i = 0; i < tableToday[0].getRates().size(); i++) {
            Rate rateToday = tableToday[0].getRates().get(i);
            Rate rateYesterday = tableYesterday[0].getRates().get(i);
            MidRate midRate = new MidRate(rateToday.getCurrency(), rateToday.getCode()
                    , rateToday.getMid(), rateYesterday.getMid());
            double midT = rateToday.getMid();
            double midY = rateYesterday.getMid();

            Double changeDouble = BigDecimal.valueOf(midT - midY)
                    .setScale(6, RoundingMode.HALF_UP)
                    .doubleValue();
            midRate.setMidChange(changeDouble);
            double change = midRate.getMidChange();
            if (change < 0) {
                change = -change;
            }

            Double changePro = BigDecimal.valueOf((midT - midY) / midT * 100)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            midRate.setMidChangePercent(changePro);
            lists.add(midRate);

        }
        midDataTable.setMidRates(lists);
        return midDataTable;
    }


    public String getYesterday(String stringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(stringDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        String dateyesterday = sdf.format(yesterday);

        return dateyesterday;
    }
}



