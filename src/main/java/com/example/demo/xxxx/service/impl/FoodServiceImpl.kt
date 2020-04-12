package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.FoodDao
import com.example.demo.xxxx.service.FoodService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service("foodService")
class FoodServiceImpl : FoodService {

    @Resource
    lateinit var foodDao: FoodDao

    override fun addFood(food: FoodBean): ResultBean<FoodBean> {
        return try {
            val findByAccount = foodDao.findByName(food.name)
            if ((findByAccount != null && findByAccount.isNotEmpty())) {
                ResultBean(ERROR, "菜品已存在 ")
            } else {
                foodDao.save(food)
                ResultBean(SUCCEED, null, food)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 ${e.message}  ${e.cause} ")
        }
    }

    override fun findAllBean(): List<FoodBean>? {
        return foodDao.findAll()
    }

    override fun findAllBeanByRoomId(roomId: String): List<FoodBean>? {

        val findAll = foodDao.findAll()
        val listOf = arrayListOf<FoodBean>()
        findAll.forEach {
            if (it.room_id.equals(roomId)) {
                listOf.add(it)
            }
        }
        return listOf
    }

    override fun findByName(name: String): List<FoodBean>? {
        return foodDao.findByName(name)

    }

}

