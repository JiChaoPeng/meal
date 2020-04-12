package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.bean.FoodListBean
import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.service.impl.FoodServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.util.*
import javax.annotation.Resource


//返回json格式
@RestController
class FoodController {

    @Autowired
    @Resource
    internal var foodService: FoodServiceImpl? = null

    @RequestMapping("/android/v1/food/add",
            params = ["name", "content",  "price", "address", "imageUrl", "roomId"],
            method = [RequestMethod.POST])
    fun addFood(@RequestParam("name") name: String,
                @RequestParam("content") content: String,
                @RequestParam("price") price: Int = 0,
                @RequestParam("address") address: String? = null,
                @RequestParam("imageUrl") imageUrl: String?,
                @RequestParam("roomId") roomId: Int): ResultBean<FoodBean>? {
        return foodService?.addFood(FoodBean(name, content
                , price, imageUrl,address,  roomId))

    }

    @RequestMapping("/android/v1/food/allbyid",
            params = ["roomId"],
            method = [RequestMethod.POST])
    fun findAllFood(@RequestParam("roomId") roomId: String): ResultBean<FoodListBean>? {
        return ResultBean( SUCCEED, null, FoodListBean(foodService?.findAllBeanByRoomId(roomId)))
    }


    @RequestMapping("/android/v1/food/all",
            method = [RequestMethod.POST])
    fun findAllFood(): ResultBean<FoodListBean>? {
        return ResultBean( SUCCEED, null, FoodListBean(foodService?.findAllBean()))
    }

    @RequestMapping(value = ["/android/v1/food/Upload"])
    @Throws(Exception::class)
    fun uploadImage(@RequestParam(value = "file", required = false, defaultValue = "") file: MultipartFile): ResultModel {
        if (file.isEmpty) {
            return ResultModel( ERROR, "图片为空")
        }
        var fileName = file.originalFilename  // 文件名
        val suffixName = fileName?.substring(fileName.lastIndexOf("."))  // 后缀名
        if (suffixName != ".jpg" && suffixName != ".png") {
            return ResultModel( ERROR, " 请选择图片 ！！！")
        }
        val filePath = "/pic/food/" // 上传后的路径
        fileName = UUID.randomUUID().toString() + suffixName // 新文件名
        val dest = File(filePath + fileName)
        if (!dest.parentFile.exists()) {
            dest.parentFile.mkdirs()
        }
        try {
            file.transferTo(dest)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val filename = "http://39.99.210.2/pic/food/$fileName"
        return ResultModel( SUCCEED, filename)
    }


}
