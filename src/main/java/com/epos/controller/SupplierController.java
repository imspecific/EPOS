package com.epos.controller;

import com.epos.model.Supplier;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/addsupplier", method = RequestMethod.GET)
    public ModelAndView addSupplierView() {
        return new ModelAndView("addsupplier");
    }

    @RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {

        model.addAttribute("supplier", supplier);
        supplierService.addSupplier(supplier);
        System.out.println("Supplier added successfully.");

        return "/addsupplier";
    }

    @RequestMapping(value = "/updatesupplier", method = RequestMethod.GET)
    public ModelAndView updateSupplierView(@ModelAttribute("supplier") Supplier supplier, Model model) {

        List<Supplier> supplierList = supplierService.findAllSupplier();
        model.addAttribute("supList", supplierList);

        model.addAttribute("supplier", supplier);
        supplierService.addSupplier(supplier);
        System.out.println("Supplier updated successfully.");

        return new ModelAndView("updatesupplier");
    }
}
