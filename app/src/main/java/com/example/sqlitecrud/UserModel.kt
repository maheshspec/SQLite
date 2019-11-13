package com.example.sqlitecrud

import java.io.Serializable


data class UserModel(var name:String?=null,var designation:String?=null,var id:Int=0): Serializable

//data class UserModel(var name:String?=null,var designation:String?=null,var id:Int=0): Serializable