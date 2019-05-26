package com.isagiongo.apirestkotlin.responses

data class Response<T> (val erros: ArrayList<String> = arrayListOf(), var data: T? = null)