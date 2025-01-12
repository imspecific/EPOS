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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(value = "/adminhome")
    public ModelAndView adminHomeView(Model model) {
        return new ModelAndView("/adminhome");
    }

    @GetMapping(value = "/addemployee")
    public ModelAndView addEmployeeView(@ModelAttribute("employee") Employee emp, Model model) {
        model.addAttribute("userName", emp.getEmployeeName());
        List<Store> storeList = storeService.allStore();
        model.addAttribute("storeList", storeList);
        return new ModelAndView("addemployee");
    }

    @PostMapping(value = "/addemployee")
    public String addEmployee(@ModelAttribute("employee") Employee emp, Model model) {
        model.addAttribute("emp", emp);
        model.addAttribute("userName", emp.getEmployeeName());
        empService.addEmployee(emp);
        log.info("Employee added successfully.");
        return "redirect:/adminhome";
    }

    @GetMapping(value = "/updateemployee")
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

    @GetMapping(value = "/search")
    @ResponseBody
    public ResponseEntity search(@RequestParam("emp1") Long employeeId, Model model) {
        Employee emp = empService.findByEmployeeId(employeeId);

        model.addAttribute("employee", emp);
        return ResponseEntity.ok(emp);
    }

    @PostMapping(value = "/updateemployee")
    public String updateEmployee(@ModelAttribute("employee") Employee emp, Model model) {
        empService.addEmployee(emp);
        log.info("Employee updated successfully.");
        return "redirect:/adminhome";
    }

    @GetMapping(value = "/resetpassword")
    public ModelAndView resetPassword(Model model) {
        List<Employee> empList = empService.findAllEmployees();
        model.addAttribute("empList", empList);
        return new ModelAndView("/resetpassword");
    }

    @GetMapping(value = "/loadEmployeeByE_Id")
    @ResponseBody
    public Employee loadEmployeeByE_Id(@RequestParam("empList") long employeeId) {
        return empService.findByEmployeeId(employeeId);
    }
}
