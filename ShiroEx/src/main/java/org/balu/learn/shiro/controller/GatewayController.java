package org.balu.learn.shiro.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GatewayController {
	@RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    /*@RequestMapping("/en")
    @ResponseBody
    public String encrypt() {
        User user = userRepository.findByUsername("balu");
        user.setSalt(user.getUsername());
        user.setPassword((new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getSalt()), 1024)).toString());
        userRepository.save(user);
        return "succ";
    }*/

	@GetMapping("/login")
    public String login() throws Exception {
        return "login";
    }
	
    @PostMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "Unknown Account";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "Wrong credentials";
            } else {
                msg = exception;
            }
        }

        map.put("msg", msg);
        return "login";
    }

    @RequestMapping("/create")
    @RequiresPermissions("CREATE")
    public String create() {
        return "create";
    }

    @RequestMapping("/update")
    @RequiresPermissions("UPDATE")
    public String update() {
        return "update";
    }

    @RequestMapping("/read")
    @RequiresPermissions("READ")
    public String read() {
        return "read";
    }
    
    @RequestMapping("/delete")
    @RequiresPermissions("DELETE")
    public String delete() {
        return "delete";
    }
}
