package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.UserOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<UserOrder, String> {
    fun findByAccount(account: String): UserOrder?
}