package kursy.walut.client;

import kursy.walut.model.Table;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService {

    public Table[] callRest(String table) {
        RestTemplate restTemplate = new RestTemplate();
        Table[] tables = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/" + table + "?format=json", Table[].class);
        return tables;
    }
    public Table[] callRest(String table,String date) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("http://api.nbp.pl/api/exchangerates/tables/" + table +"/"+date+ "?format=json");
        Table[] tables = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/" + table +"/"+date+ "?format=json", Table[].class);
        return tables;
    }
}
