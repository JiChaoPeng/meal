package com.example.demo.xxxx.form.controller

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.form.bean.FormBean
import com.example.demo.xxxx.form.bean.FormListBean
import com.example.demo.xxxx.form.service.impl.FormServiceImpl

//返回json格式
@RestController
class FormController {

    @Autowired
    @Resource
    lateinit var formService: FormServiceImpl

    @RequestMapping(params = ["price", "owner_name",
        "seat_id", "comment", "commentStar", "foodDetail",
        "isFinish", "isPay", "time"], method = [RequestMethod.POST], value = ["/form/add"])
    fun addFood(@RequestParam("price") price: Int,
                @RequestParam("owner_name") owner_name: String?=null,
                @RequestParam("seat_id") seat_id: Int,
                @RequestParam("comment") comment: String?=null,
                @RequestParam("commentStar") commentStar: Int,
                @RequestParam("foodDetail") foodDetail: String,
                @RequestParam("isFinish") isFinish: Int,
                @RequestParam("isPay") isPay: Int,
                @RequestParam("time") time: Long): ResultBean<*> {
        return formService.addForm(FormBean(price,
                owner_name, seat_id, comment, commentStar, foodDetail, isFinish, isPay, time))

    }

    @RequestMapping(params = ["ownerName"], method = [RequestMethod.POST],
            value = ["/form/all/ownername"])
    fun findAllFormByOwnerId(@RequestParam("ownerName") ownerName: String): ResultBean<FormListBean> {
        return ResultBean(SUCCEED, null, FormListBean(formService.findByOwnerName(ownerName)))
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/form/all"])
    fun findAllForm(): ResultBean<FormListBean> {
        return ResultBean(SUCCEED, null, FormListBean(formService.findAllBean()))
    }

    @RequestMapping(params = ["id"],method = [RequestMethod.POST], value = ["/form/finish"])
    fun finishForm(@RequestParam("id") id: Int): ResultModel? {
        return formService.finishForm(id)
    }

    @RequestMapping(params = ["id"],method = [RequestMethod.POST], value = ["/form/pay"])
    fun payForm(@RequestParam("id") id: Int): ResultModel? {
        return formService.payForm(id)
    }
}
