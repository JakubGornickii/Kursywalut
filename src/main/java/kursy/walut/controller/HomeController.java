package kursy.walut.controller;

import kursy.walut.Service.DataService;
import kursy.walut.client.CallRestService;
import kursy.walut.model.BidAskDataTable;
import kursy.walut.model.MidDataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;


@Controller
public class HomeController {

    @Autowired
    private DataService dataService;

    @Autowired
    private CallRestService callRestService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView homePage() throws ParseException {
        ModelAndView modelAndView = new ModelAndView("index");
        BidAskDataTable table = dataService.generateBidAskTable();
        modelAndView.addObject("table", table);
        return modelAndView;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView all() throws ParseException {
        ModelAndView modelAndView = new ModelAndView("allCurrency");
        MidDataTable table = dataService.generateMidTable();
        modelAndView.addObject("table", table);
        return modelAndView;
    }
}


