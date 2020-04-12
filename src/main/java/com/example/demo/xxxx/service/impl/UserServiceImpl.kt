package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.UserOrder
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

    override fun findByAccount(account: String): UserOrder? {
        return userDao.findByAccount(account)
    }

    override fun signUp(user: UserOrder): ResultBean<UserOrder> {
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

    override fun signIn(account: String, password: String): UserOrder? {
        val findByAccount = findByAccount(account)
        return if (findByAccount?.account == account && findByAccount.password == password) {
            findByAccount
        } else {
            null
        }
    }

    override fun findAllBean(): List<UserOrder>? {
        return userDao.findAll()
    }

}
