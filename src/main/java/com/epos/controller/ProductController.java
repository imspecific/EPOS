package com.epos.controller;

import com.epos.model.Category;
import com.epos.model.ProductDetails;
import com.epos.model.Supplier;
import com.epos.service.CategoryService;
import com.epos.service.ProductService;
import com.epos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService prodService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SupplierService suplierService;

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public ModelAndView addProductView(Model model) {

        List<Category> prodList = categoryService.findAllCategory();
        model.addAttribute("categoryList", prodList);

        List<Supplier> supList = suplierService.findAllSupplier();
        model.addAttribute("supList", supList);

        return new ModelAndView("/addproduct");
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("product") ProductDetails product, Model model) {
        System.out.println(product.toString());

        model.addAttribute("product", product);
        prodService.addProduct(product);
        System.out.println("Product added successfully.");

        return "/homeePOSAdmin";
    }

    @RequestMapping(value = "/updateproduct", method = RequestMethod.GET)
    public ModelAndView updateProductView(Model model) {

        List<ProductDetails> prodList = prodService.findAllProducts();
        model.addAttribute("prodList", prodList);

        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList", categoryList);

        List<Supplier> supList = suplierService.findAllSupplier();
        model.addAttribute("supList", supList);

        return new ModelAndView("/updateproduct");
    }


}
