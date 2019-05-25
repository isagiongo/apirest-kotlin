package com.isagiongo.apirestkotlin.repositories

import com.isagiongo.apirestkotlin.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa
}