package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Funcionario
import java.util.*

interface FuncionarioService {

    fun persistir(funcionario: Funcionario): Funcionario

    fun buscarPorCpf(cpf: String): Funcionario?

    fun buscarPorEmail(email: String): Funcionario?

    fun buscarPorId(id: String): Optional<Funcionario>
}