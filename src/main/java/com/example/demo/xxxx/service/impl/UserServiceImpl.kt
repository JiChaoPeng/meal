package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.bean.UserMeal
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.UserDao
import com.example.demo.xxxx.service.UserService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service("userService")
class UserServiceImpl : UserService {

    @Resource
    lateinit var userDao: UserDao

    override fun findByAccount(account: String): UserMeal? {
        return userDao.findByAccount(account)
    }

    override fun signUp(user: UserMeal): ResultBean<UserMeal> {
        return try {
            val findByAccount = userDao.findByAccount(user.account)
            if (findByAccount !== null) {
                ResultBean(ERROR, "账号已存在 ")
            } else {
                userDao.save(user)
                ResultBean(SUCCEED, null, user)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 ")
        }
    }

    override fun delete(id: Int): ResultModel {
        return try {
            val findByAccount = userDao.findById(id)
            if (findByAccount == null) {
                ResultModel(ERROR, "账号不已存在 ")
            } else {
                userDao.delete(findByAccount)
                ResultModel(SUCCEED)
            }
        } catch (e: Exception) {
            ResultModel(ERROR, "存储失败 ")
        }
    }

    override fun update(user: UserMeal, id: Int): ResultBean<UserMeal> {
        return try {
            val findByAccount = userDao.findById(id)
            if (findByAccount == null) {
                ResultBean(ERROR, "账号不已存在 ")
            } else {
                findByAccount.account = user.account
                findByAccount.password = user.password
                findByAccount.age = user.age
                findByAccount.imageUrl = user.imageUrl
                findByAccount.level = user.level
                userDao.save(findByAccount)
                ResultBean(SUCCEED, null, user)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 ")
        }
    }

    override fun signIn(account: String, password: String): UserMeal? {
        val findByAccount = findByAccount(account)
        return if (findByAccount?.account == account && findByAccount.password == password) {
            findByAccount
        } else {
            null
        }
    }

    override fun findAllBean(): List<UserMeal>? {
        return userDao.findAll()
    }

}
