package com.epos.controller;


import com.epos.model.Category;
import com.epos.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public ModelAndView addCategoryView(@ModelAttribute("category") Category category, Model model) {
        return new ModelAndView("/addcategory");
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String adCategory(@RequestParam("productCategory") String productCategory,
                             @RequestParam("productBrand") String productBrand) {
        try {
            if (productCategory == null || productCategory.isEmpty() ||
                    productBrand == null || productBrand.isEmpty()) {
                log.warn("Invalid input: productCategory or productBrand is empty.");
                return "/addcategory";
            }
            categoryService.save(productCategory, productBrand);
            log.info("Category added successfully.");
            return "/addcategory";
        } catch (Exception e) {
            log.error("Category added failed.", e);
            return "/addcategory";
        }
    }
}
