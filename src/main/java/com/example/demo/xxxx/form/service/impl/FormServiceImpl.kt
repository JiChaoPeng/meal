package com.example.demo.xxxx.form.service.impl

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.constant.ERROR
import org.springframework.stereotype.Service
import javax.annotation.Resource
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.form.bean.FormBean
import com.example.demo.xxxx.form.dao.FormDao
import com.example.demo.xxxx.form.service.FormService
import org.springframework.data.domain.Sort

@Service("formService")
class FormServiceImpl : FormService {
    @Resource
    lateinit var formDao: FormDao

    override fun finishForm(id: Int): ResultModel? {
        val findById = formDao.findById(id)
        return if (findById != null) {
            findById.isFinish = 1
            formDao.save(findById)
            ResultModel(SUCCEED, null)
        } else {
            ResultModel(ERROR, null)
        }
    }

    override fun payForm(id: Int): ResultModel? {
        val findById = formDao.findById(id)
        return if (findById != null) {
            findById.isPay = 1
            formDao.save(findById)
            ResultModel(SUCCEED, null)
        } else {
            ResultModel(ERROR, null)
        }
    }
    override fun findByOwnerName(ownerName: String): List<FormBean>? {
        return formDao.findByOwnerName(ownerName)
    }

    override fun addForm(formBean: FormBean): ResultBean<FormBean> {
        formDao.save(formBean)
        return ResultBean(SUCCEED, null, formBean)

    }

    override fun findAllBean(): List<FormBean>? {
        val sort = Sort.by(Sort.Direction.ASC, "time")
        return formDao.findAll(sort)

    }

}
