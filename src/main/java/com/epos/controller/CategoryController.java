package com.epos.controller;


import com.epos.model.Category;
import com.epos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategoryView(@ModelAttribute("category") Category category, Model model) {
        return new ModelAndView("/addcategory");
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String adCategory(@RequestParam("prod_Category") String prod_Category, @RequestParam("prod_Brand") String prod_Brand) {
        try {
            categoryService.save(new Category(prod_Category, prod_Brand));
            System.out.println("Category added succussfully.");
            return "/addcategory";

        } catch (Exception e) {
            System.out.println("Category added failed.");
            return "/addcategory";
        }
    }

}
