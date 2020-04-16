package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.UserMeal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<UserMeal, String> {
    fun findByAccount(account: String): UserMeal?
    fun findById(id: Int): UserMeal?
}