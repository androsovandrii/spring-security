package com.androsov.andrii;

import com.androsov.andrii.utility.Temperature;
import com.androsov.andrii.service.TimeService;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 * 
 *
 * @author Andrii Androsov
 *
 */
@Controller
public class HomeController {

    @Autowired
    private TimeService service;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "home";
    }

    /**
     * Method returns Temperature, wrapped in JSON object.
     * @return 
     */
    @RequestMapping(value = "/getTemperature", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Temperature> home1() {
        return new ResponseEntity<>(new Temperature(service.getTemperatureForLastHour()), HttpStatus.OK);
    }

}
