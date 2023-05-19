package com.softusing.joe.controller;


import com.softusing.joe.domain.UserLogin;
import com.softusing.joe.entity.User;
import com.softusing.joe.form.UserForm;
import com.softusing.joe.form.UserForm;
import com.softusing.joe.service.UserLoginInterface;
import com.softusing.joe.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping ("/login")
    public String loginPage(Model model) {

        model.addAttribute("user",new UserLogin());
            return "login";

    }


    @PostMapping ("/login")
    public String loginPage(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        boolean flag = userLoginService.login(userLogin);
        if(flag==true){
            return "loginSuccess";

        }else {
            return "Middle";
        }
    }




    @GetMapping("/loginSuccess")
    public String loginSuccess()
    {
        return "loginSuccess";
    }


    @GetMapping("/register")
    public String regsterPage(Model model)
    {

        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result, Model model){

        if(!userForm.confirmPassword())
        {
            result.rejectValue("confirmPassword","confirmError","两次密码不一致");

        }
        if (result.hasErrors())
        {
            return "register";
        }


        UserLogin userLogin = userForm.convertToUser();
        userLoginService.save(userLogin);

        return "redirect:/login";




    }

    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException();
    }



//    @RequestParam String username,
//    @RequestParam String password,
//    @RequestParam String email,
//    @RequestParam Integer phone) {
//
//
//        UserLogin userLogin = new UserLogin();
//        userLogin.setUsername(username);
//        userLogin.setPassword(password);
//        userLogin.setEmail(email);
//        userLogin.setPhone(phone);
//        userLoginService.save(userLogin)




}
