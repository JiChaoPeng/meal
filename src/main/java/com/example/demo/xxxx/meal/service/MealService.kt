package com.example.demo.xxxx.meal.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.meal.bean.MealBean

interface MealService {
    fun addFood(foodBean: MealBean): ResultBean<MealBean>

    fun findAllBean(): List<MealBean>?

    fun findAllBeanByRoomId(roomId: String): List<MealBean>?

    fun findByName(name: String): List<*>?
    fun deleteFood(id: Int): ResultModel?
    fun refreshFood(food: MealBean,id: Int): ResultModel?
}
