package pointman.springmvc_db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello (Model model){

        model.addAttribute("data","hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  //@ResponseBody 디폴트로  객체 리턴시 json으로 변환 후 반환 {"name":"홍길동"}
    }

    static class Hello{
        private String name;
        // getter setter 자바빈 규약 (프로퍼티 접근 방식 )
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
