package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.bean.UserListBean
import com.example.demo.xxxx.bean.UserMeal
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
               @RequestParam("imageUrl") imageUrl: String? = null): ResultBean<UserMeal>? {
        return userService?.signUp(UserMeal(account, password, level, age, name, imageIndex, imageUrl))
    }

    @RequestMapping("/meal/signIn",
            params = ["account", "password"],
            method = [RequestMethod.POST])
    fun signIn(@RequestParam("account") account: String,
               @RequestParam("password") password: String): ResultBean<UserMeal>? {
        return ResultBean(SUCCEED, null, userService?.signIn(account, password))
    }

    @RequestMapping("/meal/account/all",
            method = [RequestMethod.POST])
    fun allAccount(): ResultBean<UserListBean>? {
        return ResultBean(SUCCEED, null, UserListBean(userService?.findAllBean()))
    }
    @RequestMapping("/meal/update",
            params = ["account", "password", "level", "age", "name", "imageIndex", "imageUrl", "id"],
            method = [RequestMethod.POST])
    fun update(@RequestParam("account") account: String,
               @RequestParam("password") password: String,
               @RequestParam("level") level: Int? = 0,
               @RequestParam("age") age: Int? = null,
               @RequestParam("name") name: String? = null,
               @RequestParam("imageIndex") imageIndex: Int? = 0,
               @RequestParam("imageUrl") imageUrl: String? = null,
               @RequestParam("id") id: Int): ResultBean<UserMeal>? {
        return userService?.update(UserMeal(account, password, level, age, name, imageIndex, imageUrl), id)
    }

    @RequestMapping("/meal/delete",
            params = ["id"],
            method = [RequestMethod.POST])
    fun delete(@RequestParam("id") id: Int): ResultModel? {
        return userService?.delete(id)
    }

}
