package com.isagiongo.apirestkotlin

import com.isagiongo.apirestkotlin.documents.Empresa
import com.isagiongo.apirestkotlin.documents.Funcionario
import com.isagiongo.apirestkotlin.enums.PerfilEnum
import com.isagiongo.apirestkotlin.repositories.EmpresaRepository
import com.isagiongo.apirestkotlin.repositories.FuncionarioRepository
import com.isagiongo.apirestkotlin.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiRestKotlinApplication(val empresaRepository: EmpresaRepository, val funcionarioRepository: FuncionarioRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()

		val empresa: Empresa = Empresa("Empresa LTDA", "35417492000108", "1")
		empresaRepository.save(empresa)

		val admin: Funcionario
				= Funcionario("Isadora Giongo", "isa@gmail.com",
				SenhaUtils().gerarBcrypt("123456"), "42357696001",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		funcionarioRepository.save(admin)

		val funcionario: Funcionario
				= Funcionario("Veronica Torres", "veronica@gmail.com",
				SenhaUtils().gerarBcrypt("654321"), "17347006023",
				PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionarioRepository.save(funcionario)

		println("Empresa ID: " + empresa.id)
		println("Admin ID: " + admin.id)
		println("Funcionario ID: " + funcionario.id)
	}
}

fun main(args: Array<String>) {
	runApplication<ApiRestKotlinApplication>(*args)
}
