package com.itlike.web;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
    @RequestMapping("menu")
    public String menu(){
        return "menu";
    }
}
