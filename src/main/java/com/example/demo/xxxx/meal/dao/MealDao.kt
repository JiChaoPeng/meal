package com.example.demo.xxxx.meal.dao

import com.example.demo.xxxx.meal.bean.MealBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface MealDao : JpaRepository<MealBean, String> {
    fun findByName(name: String): List<MealBean>?
    fun findById(id: Int): MealBean?
}
