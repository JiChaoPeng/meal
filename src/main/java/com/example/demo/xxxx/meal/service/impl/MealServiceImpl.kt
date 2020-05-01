package com.example.demo.xxxx.meal.service.impl


import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.meal.bean.MealBean
import com.example.demo.xxxx.meal.dao.MealDao
import com.example.demo.xxxx.meal.service.MealService
import org.springframework.stereotype.Service

import javax.annotation.Resource
import java.util.ArrayList

import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED

@Service("orderFoodService")
class MealServiceImpl : MealService {

    @Resource
    lateinit var mealDao: MealDao

    override fun addFood(foodBean: MealBean): ResultBean<MealBean> {
        return try {
            val byName = mealDao.findByName(foodBean.name)
            if (byName != null && byName.isNotEmpty()) {
                ResultBean(ERROR, "菜品已存在 ", null)
            } else {
                mealDao.save(foodBean)
                ResultBean(SUCCEED, null, foodBean)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 \${e.message}  \${e.cause} ", null)
        }

    }
    override fun deleteFood(id: Int): ResultModel? {
        val findById = mealDao.findById(id)
        return if (findById != null) {
            mealDao.delete(findById)
            ResultModel(SUCCEED, null)
        } else {
            ResultModel(ERROR, null)
        }
    }
    override fun refreshFood(food: MealBean, id: Int): ResultModel? {
        val findById = mealDao.findById(id)
        return if (findById != null) {
            findById.content = food.content
            findById.image_url = food.image_url
            findById.name = food.name
            findById.address = food.address
            findById.price = food.price
            findById.room_id = food.room_id
            mealDao.save(findById)
            ResultModel(SUCCEED, null)
        } else {
            ResultModel(ERROR, null)
        }
    }
    override fun findAllBean(): List<MealBean>? {
        return mealDao.findAll()
    }

    override fun findAllBeanByRoomId(roomId: String): List<MealBean>? {
        val all = mealDao.findAll()
        val listOf = ArrayList<MealBean>()
        for (model in all) {
            if (roomId == model.room_id.toString()) {
                listOf.add(model)
            }
        }
        return listOf
    }

    override fun findByName(name: String): List<MealBean>? {
        return mealDao.findByName(name)

    }
}
