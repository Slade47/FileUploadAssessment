package com.michael.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Michael Fan
 *	define a index controller used to return a view name and redirect to upload page
 */
@Controller
public class IndexController {
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String index() {
        return "FileUpload";
    }
}