package linilq.shop.controller;

import linilq.shop.bean.api.ApiResponse;
import linilq.shop.bean.database.SysUser;
import linilq.shop.bean.exception.BusinessRespondEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author lizhijian
 * @description 登陆控制器
 * @date 2019/5/31
 */
@Controller
public class LoginController {
    Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        logger.info("this is INFO log test");
        logger.debug("this is DEBUG log test");
        logger.warn("this is WARN log test");
        logger.error("this is ERROR log test");
        if (request.getSession(false) == null) {
            modelAndView.setViewName("/login");
        } else {
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userName");
            modelAndView.addObject("username", userName);
        }
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login(ModelAndView modelAndView) {
        return "/login";
    }

    /**
     * 登陆接口
     */
    @RequestMapping("/dologin")
    @ResponseBody
    public ApiResponse<String> doLogin(@RequestBody SysUser sysUser) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            if (!StringUtils.isEmpty(sysUser.getUserName()) && sysUser.getUserName().equals("linilq")) {
                session = request.getSession(true);
                session.setAttribute("userName", sysUser.getUserName());
                session.setMaxInactiveInterval(10 * 60);
                return new ApiResponse("index");
            } else {
                return new ApiResponse(BusinessRespondEnum.ERROR);
            }
        } else {
            return new ApiResponse("index");
        }
    }

}
