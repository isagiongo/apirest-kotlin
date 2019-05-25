package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa
}