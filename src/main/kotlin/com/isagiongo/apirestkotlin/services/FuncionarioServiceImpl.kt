package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Funcionario
import com.isagiongo.apirestkotlin.repositories.FuncionarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImpl (val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario = funcionarioRepository.save(funcionario)

    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun buscarPorId(id: String): Optional<Funcionario> = funcionarioRepository.findById(id)
}