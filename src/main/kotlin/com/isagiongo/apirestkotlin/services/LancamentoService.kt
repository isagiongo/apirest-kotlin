package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.util.*

interface LancamentoService {

    fun buscarPorFuncionarioId(id: String, pageRequest: PageRequest): Page<Lancamento>

    fun buscarPorId(id: String): Optional<Lancamento>

    fun persistir(lancamento: Lancamento): Lancamento

    fun remover(id: String)
}