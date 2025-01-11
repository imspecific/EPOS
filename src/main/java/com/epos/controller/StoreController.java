package com.epos.controller;

import java.util.List;

import com.epos.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.epos.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value = "/addstore", method = RequestMethod.GET)
	public ModelAndView addStoreView() { 	
		return new ModelAndView("addstore");    
	}

	@RequestMapping(value = "/addstore", method = RequestMethod.POST)
	public String addStore(@ModelAttribute("store") Store store, Model model) {
		
		model.addAttribute("store", store);
		storeService.addStore(store);
		System.out.println("Store added successfully.");
		
		return "/addstore";
	}
	
	@RequestMapping(value = "/viewstore", method = RequestMethod.GET)
	public ModelAndView viewStoreView(Model model) {
		
		List<Store> storeList = storeService.allStore();
		model.addAttribute("storeList", storeList);
		
		return new ModelAndView("/viewstore");    
	}
	
	@RequestMapping(value = "/updatestore", method = RequestMethod.GET)
	public ModelAndView updateStoreView(@ModelAttribute("store") Store store, Model model) { 
		
		List<Store> storeList = storeService.allStore();
		model.addAttribute("storeList", storeList);
		
		model.addAttribute("store", store);
		storeService.addStore(store);
		System.out.println("Store updated successfully.");
		
		return new ModelAndView("updatestore");    
	}
}
