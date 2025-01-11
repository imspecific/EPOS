package com.epos.controller;

import com.epos.model.Employee;
import com.epos.model.Store;
import com.epos.service.EmployeeService;
import com.epos.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private StoreService storeService;
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT); //yyyy-MM-dd
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/adminhome", method = RequestMethod.GET)
    public ModelAndView adminHomeView(Model model) {
        return new ModelAndView("/adminhome");
    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.GET)
    public ModelAndView addEmployeeView(@ModelAttribute("employee") Employee emp, Model model) {
        model.addAttribute("userName", emp.getEmployeeName());
        List<Store> storeList = storeService.allStore();
        model.addAttribute("storeList", storeList);
        return new ModelAndView("addemployee");
    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee emp, Model model) {
        model.addAttribute("emp", emp);
        model.addAttribute("userName", emp.getEmployeeName());
        empService.addEmployee(emp);
        log.info("Employee added successfully.");
        return "redirect:/adminhome";
    }

    @RequestMapping(value = "/updateemployee", method = RequestMethod.GET)
    public ModelAndView updateEmployeeView(@ModelAttribute("employee") Employee emp, Model model) {
        model.addAttribute("userName", emp.getEmployeeName());

        ModelAndView mav = new ModelAndView();
        List<Employee> empList = empService.findAllEmployees();
        model.addAttribute("empList", empList);

        List<Store> storeList = storeService.allStore();
        model.addAttribute("storeList", storeList);

        model.addAttribute("command", emp);
        return new ModelAndView("/updateemployee");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity search(@RequestParam("emp1") Long employeeId, Model model) {
        Employee emp = empService.findByEmployeeId(employeeId);

        model.addAttribute("employee", emp);
        return ResponseEntity.ok(emp);
    }

    @RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee emp, Model model) {
        empService.addEmployee(emp);
        log.info("Employee updated successfully.");
        return "redirect:/adminhome";
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
    public ModelAndView resetPassword(Model model) {
        List<Employee> empList = empService.findAllEmployees();
        model.addAttribute("empList", empList);
        return new ModelAndView("/resetpassword");
    }

    @RequestMapping(value = "/loadEmployeeByE_Id", method = RequestMethod.GET)
    @ResponseBody
    public Employee loadEmployeeByE_Id(@RequestParam("empList") long employeeId) {
        return empService.findByEmployeeId(employeeId);
    }
}
