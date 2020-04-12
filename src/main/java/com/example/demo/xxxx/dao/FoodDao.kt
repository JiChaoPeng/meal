package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.FoodBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodDao : JpaRepository<FoodBean, String> {
    fun findByName(name: String): List<FoodBean>?
}