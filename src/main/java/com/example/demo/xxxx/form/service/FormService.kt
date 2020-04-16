package com.example.demo.xxxx.form.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.form.bean.FormBean

interface FormService {
    fun addForm(formBean: FormBean): ResultBean<FormBean>

    fun findAllBean(): List<FormBean>?

    fun findByOwnerName(ownerName: String): List<*>?

    fun finishForm(id: Int): ResultModel?
    fun payForm(id: Int): ResultModel?
}
