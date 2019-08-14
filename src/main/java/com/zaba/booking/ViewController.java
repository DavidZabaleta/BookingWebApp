package com.zaba.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ViewController {

    /**
     * This class is use to conect the HTML files
     **/
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "DavidZabaleta");
        model.addAttribute("mode", "development");//|| production

        return "index";
    }
}
