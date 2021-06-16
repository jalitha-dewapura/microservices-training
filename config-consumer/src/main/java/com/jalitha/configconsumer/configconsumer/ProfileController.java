package com.jalitha.configconsumer.configconsumer;

import com.jalitha.configconsumer.configconsumer.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @Autowired
    MemberProfileConfiguration memberProfileConfiguration;

    @RequestMapping("/profile")
    public MemberProfileConfiguration getConfig(Model model) {
        return memberProfileConfiguration;

//        return "mprofile";
    }
}

