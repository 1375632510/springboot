package cn.analysys.demo.controller;

import cn.analysys.demo.entity.User;
import cn.analysys.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping({"/tologin","/"})
    public String toLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(String username, String password, Model model){
        User user = null;
        user = iUserService.login(username, password);
        if(user==null){
            model.addAttribute("error","账号密码错误！");
            return "/";
        }else{
            model.addAttribute("user",user);
            return "redirect:/allBook/1";
        }
    }
}
