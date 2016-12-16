package online.beiwang.yy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    /**
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     * "/WEB-INF/views/main.jsp"
     * @return
     */
    @RequestMapping("/main")
    public String Main(){
        return "main";
    }

    @RequestMapping("/reg")
    public String Reg(){
        return "reg";
    }

    @RequestMapping("/")
    public String Default(ModelMap model) {
        String[] strs = {
                "纸上得来终觉浅，绝知此事要躬行",
                "记录生活的点点滴滴",
                "黑发不知勤学早，白首方悔读书迟"
        };

        String welcome = strs[(int)(Math.random()*strs.length)];
        model.addAttribute("welcome", welcome);
        return "login";
    }

    @GetMapping("/RegService/{mail}")
    public String RegService(@PathVariable String mail){
        return "main";
    }
}