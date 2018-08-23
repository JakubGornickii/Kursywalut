package kursy.walut.controller;

import kursy.walut.client.CallRestService;
import kursy.walut.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class HomeController {

    @Autowired
    CallRestService callRestService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView homePage() {

        ModelAndView modelAndView = new ModelAndView("index");
Table[] tables = callRestService.callRest("C");
modelAndView.addObject("tables",tables);
        return modelAndView;
    }
@RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView("allCurrency");
    Table[] tableA = callRestService.callRest("a");
    Table[] tableB = callRestService.callRest("b");
    modelAndView.addObject("tableA",tableA);
    modelAndView.addObject("tableB",tableB);
        return modelAndView;
}
}


