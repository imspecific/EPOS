package com.epos.controller;

import com.epos.model.Category;
import com.epos.model.ProductDetails;
import com.epos.service.CategoryService;
import com.epos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class PurchaseController {

    @Autowired
    private ProductService prodService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/purchasereport", method = RequestMethod.GET)
    public ModelAndView purchaseReportView(Model model) {

        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList", categoryList);

        List<ProductDetails> prodList = prodService.findAllProducts();
        model.addAttribute("prodList", prodList);

        return new ModelAndView("purchasereport");
    }
}
