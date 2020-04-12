package com.example.demo.xxxx.bean

class ResultBean<T>(val resultCode: Int,
                    val data: String? = null,
                    val bean: T? = null)

class ResultModel(val resultCode: Int,
                  val data: String? = null)
