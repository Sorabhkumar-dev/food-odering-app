package com.sorabh.grabfood.domain.model.post

import com.google.gson.JsonObject

data class LoginPostModel(val header: HashMap<String, String>, val params: JsonObject)