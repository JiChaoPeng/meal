package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.UserOrder
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import javax.annotation.Resource


//返回json格式
@RestController
class UserController {

    @Autowired
    @Resource
    internal var userService: UserServiceImpl? = null

    @RequestMapping("/meal/signUp",
            params = ["account", "password", "level", "age", "name", "imageIndex", "imageUrl"],
            method = [RequestMethod.POST])
    fun signUp(@RequestParam("account") account: String,
               @RequestParam("password") password: String,
               @RequestParam("level") level: Int? = 0,
               @RequestParam("age") age: Int? = null,
               @RequestParam("name") name: String? = null,
               @RequestParam("imageIndex") imageIndex: Int? = 0,
               @RequestParam("imageUrl") imageUrl: String? = null): ResultBean<UserOrder>? {
        return userService?.signUp(UserOrder(account, password, level, age, name, imageIndex, imageUrl))
    }

    @RequestMapping("/meal/signIn",
            params = ["account", "password"],
            method = [RequestMethod.POST])
    fun signIn(@RequestParam("account") account: String,
               @RequestParam("password") password: String): ResultBean<UserOrder>? {
        return ResultBean(SUCCEED, null, userService?.signIn(account, password))
    }
}
