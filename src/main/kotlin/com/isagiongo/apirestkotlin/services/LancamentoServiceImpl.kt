package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Lancamento
import com.isagiongo.apirestkotlin.repositories.LancamentoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class LancamentoServiceImpl(val lancamentoRepository : LancamentoRepository) : LancamentoService {

    override fun buscarPorFuncionarioId(id: String, pageRequest: PageRequest): Page<Lancamento>
            = lancamentoRepository.findByFuncionarioId(id, pageRequest)

    override fun buscarPorId(id: String): Optional<Lancamento> = lancamentoRepository.findById(id)

    override fun persistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(id: String) = lancamentoRepository.deleteById(id)
}