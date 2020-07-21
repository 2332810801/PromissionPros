package com.dj.web;

import com.dj.domain.department;
import com.dj.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeparterController {
    @Autowired
    DepartmentService service;
    @RequestMapping("/depaterList")
    @ResponseBody
    public List<department> depaterList(){
      return service.getdepaterList();
    }
}
