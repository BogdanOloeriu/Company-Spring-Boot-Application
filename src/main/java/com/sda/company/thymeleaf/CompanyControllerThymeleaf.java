package com.sda.company.thymeleaf;

import com.mysql.cj.util.StringUtils;
import com.sda.company.service.CompanyService;
import com.sda.company.thymeleaf.dto.GdprDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.expression.Strings;

import java.net.http.HttpRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class CompanyControllerThymeleaf {

    private final CompanyService companyService;

    public CompanyControllerThymeleaf(@Qualifier("companyServiceVersion1") CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
     public String indexPage(Model model, Principal principal){

        model.addAttribute("welcomeMessage", "This is company landing page");
        model.addAttribute("hello", "Hello, ");
        model.addAttribute("userName", principal.getName());
        return "index";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startPage(){

        return "start";
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public String companyPage(@ModelAttribute(name = "gdprForm") GdprDTO gdprForm, Model model){

        if(gdprForm.getName().isBlank()){
            model.addAttribute("errorMessage", "Please enter your name");
            return startPage();
        }
        if(!gdprForm.isGdprConsent()){
            model.addAttribute("errorMessage", "Please check the gdpr form");
            return startPage();
        }
        return "company";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAllCompanies(Model model){

       var companyList =  companyService.getAll();
       model.addAttribute("companyList", companyList);

        return "companyTable";
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String redirectHome(){

        return "company";
    }

}
