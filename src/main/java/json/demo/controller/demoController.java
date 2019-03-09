package json.demo.controller;

import json.demo.entity.Category;
import json.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 或 on 2018/4/29.
 */
@Controller
@RequestMapping("")
public class demoController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "demo.d" ,method = RequestMethod.GET)
    public String demo(){
        return "demo";
    }

    @RequestMapping(value = "demo" ,method = RequestMethod.POST
    )
    @ResponseBody
    public ModelAndView demo( Category category ){
        ModelAndView mav = new ModelAndView(  );
        Category c1 = categoryService.getCategory( category.getId() );

        System.out.println(c1);
        mav.setViewName( "aa" );
        return mav;

    }


    @RequestMapping("/demo/{id}")
    @ResponseBody
    public Category demo1(@PathVariable("id") int  id){
        Category category = categoryService.getCategory( id );
        return category;
    }






}
