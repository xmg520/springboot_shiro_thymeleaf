package com.mzx.shiromzx209.controller;

import com.mzx.shiromzx209.entity.Movie;
import com.mzx.shiromzx209.service.MovieService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mzx
 * 首页控制器
 */
@Controller
public class IndexController {

    @Autowired
    MovieService movieService;

    /**
     * 登陆认证
     */
    @RequestMapping("/login")
    public String login(String username,String password,boolean rememberMe, HttpServletRequest request) {
        //1、获取subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        //3、执行登录方法
        try {
            //交给Realm处理--->执行它的认证方法
            subject.login(token);

            //如果是root用户 这拥有root,vip,comm目录的加载需求
            if (username.equals("root")){
                request.getSession().setAttribute("svipinfos",movieService.findAllByName(username));
                request.getSession().setAttribute("vipinfos",movieService.findAllByName("vip"));
                request.getSession().setAttribute("userinfos",movieService.findAllByName("user"));
            }else if (username.equals("vip")){
                request.getSession().setAttribute("vipinfos",movieService.findAllByName(username));
                request.getSession().setAttribute("userinfos",movieService.findAllByName("user"));
            }else {
                request.getSession().setAttribute("userinfos",movieService.findAllByName(username));
            }

            //登录成功
            return "redirect:/userAdmin";

        }catch (UnknownAccountException e){
            //登录失败:用户名不存在
            request.getSession().setAttribute("msg","用户名不存在");
            return "redirect:/toLogin";
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            request.getSession().setAttribute("msg","密码错误");
            return "redirect:/toLogin";
        }
    }

    //登出账户
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        return "redirect:/";
    }

    // 首页控制器
    @RequestMapping({"/userAdmin","/"})
    public String indexMain(Model model) {
        // 把数据存入model
        model.addAttribute("title", "SpringBoot与Shiro整合");
        // 返回page目录下的admin.html
        return "page/admin";
    }

    // 登陆页控制器
    @RequestMapping({"/toLogin"})
    public String toLogin() {
        return "login";
    }

    //未授权页面控制器
    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }

    // @RequiresPermissions注解已经在ShiroConfig类中配置
    // 本接口只有拥有svip权限可访问
    @RequiresPermissions("user:svip")
    @RequestMapping("/svip/{id}")
    public String svip(@PathVariable("id")Integer id,Model model){
        Movie movie = movieService.findAllByUidAndId(1,id);
        if (movie != null){
            model.addAttribute("movie",movie);
            return "page/video";
        }else {
            return "redirect:/";
        }
    }

    // 本接口只有拥有svip或vip权限可访问
    // logical 包含 Logical.OR 和 Logical.AND 分别代表二者有其一就可访问 与 需要同时拥有二者才可访问
    @RequiresPermissions(value = {"user:vip","user:svip"},logical = Logical.OR)
    @RequestMapping("/vip/{id}")
    public String vip(@PathVariable("id")Integer id,Model model){
        Movie movie = movieService.findAllByUidAndId(2,id);
        if (movie != null){
            model.addAttribute("movie",movie);
            return "page/video";
        }else {
            return "redirect:/";
        }
    }

    // 本接口只有拥有svip或vip或者comm权限可访问
    @RequiresPermissions(value = {"user:vip","user:svip","user:comm"},logical = Logical.OR)
    @RequestMapping("/comm/{id}")
    public String comm(@PathVariable("id")Integer id,Model model){
        Movie movie = movieService.findAllByUidAndId(3,id);
        if (movie != null){
            model.addAttribute("movie",movie);
            return "page/video";
        }else {
            return "redirect:/";
        }
    }

    // 本接口所有用户均可访问
    @RequestMapping("/mf/{id}")
    public String mf(@PathVariable("id")Integer id,Model model){
        Movie movie = movieService.findAllByUidAndId(4,id);
        if (movie != null){
            model.addAttribute("movie",movie);
            return "page/video";
        }else {
            return "redirect:/";
        }
    }
}
