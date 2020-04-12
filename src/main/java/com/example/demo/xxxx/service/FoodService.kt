package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.bean.ResultBean


interface FoodService {

    fun addFood(food: FoodBean): ResultBean<FoodBean>

    fun findAllBean(): List<FoodBean>?
    fun findAllBeanByRoomId(roomId: String): List<FoodBean>?

    fun findByName(name: String): List<FoodBean>?

}
