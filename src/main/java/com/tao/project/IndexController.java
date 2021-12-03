package com.tao.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author YangTao
 * @date 2021-11-15 20:54
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap) {
        request.setAttribute("lastName","tao");
        modelMap.put("firstName", "yang");
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(HttpServletRequest request, String message) {
        HttpSession session = request.getSession();
        String result = message + " " + session.getId();
        return result;
    }
}
