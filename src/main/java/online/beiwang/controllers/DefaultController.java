package online.beiwang.controllers;

import online.beiwang.manager.headlineManager;
import online.beiwang.manager.userManager;
import online.beiwang.models.headlineModel;
import online.beiwang.models.jsonMessage;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Request;

@Controller
public class DefaultController {

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/WEB-INF/views/main.jsp"
     * @return
     */
       @RequestMapping("/")
    public String Default(ModelMap model) {
        String[] strs = {
                "纸上得来终觉浅，绝知此事要躬行",
                "记录生活的点点滴滴",
                "黑发不知勤学早，白首方悔读书迟",
                "学而不思则罔，思而不学则殆"
        };

        String welcome = strs[(int)(Math.random()*strs.length)];
        model.addAttribute("welcome", welcome);
        model.addAttribute("headline", headlineManager.GetTop10());

        return "login";
    }


    @RequestMapping(value = "/LoginService",method = RequestMethod.POST)    //@RequestMapping(value="/json", method = RequestMethod.GET)
    public @ResponseBody
    jsonMessage LoginService(@RequestParam(value = "mail",required = true) String mail,@RequestParam(value = "password",required = true) String password) {
        String login=userManager.Login(mail,password);
        jsonMessage msg=new
                jsonMessage();
        if(login.equals("")) {
            msg.setState("ok");
            msg.setMsg("");
        }
        else {
            msg.setState("error");
            msg.setMsg(login);
        }
        return msg;
    }

    @RequestMapping(value = "/RegService",method = RequestMethod.POST)    //@RequestMapping(value="/json", method = RequestMethod.GET)
    public @ResponseBody
    jsonMessage RegService(@RequestParam(value = "mail",required = true) String mail) {
        jsonMessage msg=new
                jsonMessage();
        if(userManager.Exist(mail)) {
            msg.setState("error");
            msg.setMsg("该邮箱已使用");
        }
        else {
            msg.setState("ok");
        }
        return msg;
    }

    @RequestMapping("/main")
    public String Main(){
        return "main";
    }

    @RequestMapping("/reg")
    public String Reg(){
        return "reg";
    }
}


