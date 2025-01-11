package com.epos.controller;

import com.epos.model.ProductDetails;
import com.epos.model.Store;
import com.epos.model.Supplier;
import com.epos.service.StoreService;
import com.epos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/stockreport", method = RequestMethod.GET)
    public ModelAndView stockReport(Model model) {

        List<Store> storeList = storeService.allStore();
        model.addAttribute("storeList", storeList);

        return new ModelAndView("stockreport");
    }

    @RequestMapping(value = "/viewstock", method = RequestMethod.GET)
    public ModelAndView viewStock() {
        return new ModelAndView("viewstock");
    }

    @RequestMapping(value = "/ordernewstock", method = RequestMethod.GET)
    public ModelAndView orderNewStockView(Model model) {

        List<Supplier> supplierList = supplierService.findAllSupplier();
        model.addAttribute("supList", supplierList);

        return new ModelAndView("ordernewstock");
    }

    @RequestMapping(value = "/loadProductBySupplier", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductDetails> loadProductBySupplier() {
        List<ProductDetails> prodListBySupplier = null;

        return prodListBySupplier;
    }

}
