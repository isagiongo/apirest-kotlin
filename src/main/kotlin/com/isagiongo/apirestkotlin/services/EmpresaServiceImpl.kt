package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Empresa
import com.isagiongo.apirestkotlin.repositories.EmpresaRepository
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl (val empresaRepository: EmpresaRepository): EmpresaService {
    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}