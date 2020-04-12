package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.UserOrder


interface UserService {


    fun signUp(user: UserOrder): ResultBean<UserOrder>

    fun signIn(account: String, password: String): UserOrder?

    fun findAllBean(): List<UserOrder>?

    fun findByAccount(account: String): UserOrder?

}
