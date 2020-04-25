package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel


interface FoodService {

    fun addFood(food: FoodBean): ResultBean<FoodBean>

    fun findAllBean(): List<FoodBean>?
    fun findAllBeanByRoomId(roomId: String): List<FoodBean>?

    fun findByName(name: String): List<FoodBean>?
    fun refreshFood(food: FoodBean): ResultModel?

}
