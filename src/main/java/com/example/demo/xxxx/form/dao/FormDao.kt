package com.example.demo.xxxx.form.dao

import com.example.demo.xxxx.form.bean.FormBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface FormDao : JpaRepository<FormBean, String> {
    fun findByOwnerName(owner_name: String): List<FormBean>?
    fun findById(id: Int): FormBean?
}
