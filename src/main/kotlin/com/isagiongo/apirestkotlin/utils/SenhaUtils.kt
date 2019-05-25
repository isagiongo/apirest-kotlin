package com.isagiongo.apirestkotlin.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun geraBcrypt(senha: String): String = BCryptPasswordEncoder().encode(senha)

}