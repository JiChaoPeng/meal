package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.bean.UserMeal


interface UserService {


    fun signUp(user: UserMeal): ResultBean<UserMeal>

    fun signIn(account: String, password: String): UserMeal?

    fun findAllBean(): List<UserMeal>?

    fun findByAccount(account: String): UserMeal?
    fun update(user: UserMeal, id: Int): ResultBean<UserMeal>?

    fun delete(id: Int): ResultModel?
}
