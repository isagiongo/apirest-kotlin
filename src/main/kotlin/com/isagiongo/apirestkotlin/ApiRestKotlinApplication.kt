package com.isagiongo.apirestkotlin

import com.isagiongo.apirestkotlin.documents.Empresa
import com.isagiongo.apirestkotlin.documents.Funcionario
import com.isagiongo.apirestkotlin.documents.Lancamento
import com.isagiongo.apirestkotlin.enums.PerfilEnum
import com.isagiongo.apirestkotlin.enums.TipoEnum
import com.isagiongo.apirestkotlin.repositories.EmpresaRepository
import com.isagiongo.apirestkotlin.repositories.FuncionarioRepository
import com.isagiongo.apirestkotlin.repositories.LancamentoRepository
import com.isagiongo.apirestkotlin.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.Instant
import java.util.*

@SpringBootApplication
class ApiRestKotlinApplication(val empresaRepository: EmpresaRepository,
							   val funcionarioRepository: FuncionarioRepository,
							   val lancamentoRepository: LancamentoRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()
		lancamentoRepository.deleteAll()

		var empresa: Empresa = Empresa("Empresa LTDA", "35417492000108")
		empresa = empresaRepository.save(empresa)

		var admin: Funcionario
				= Funcionario("Isadora Giongo", "isa@gmail.com",
				SenhaUtils().gerarBcrypt("123456"), "42357696001",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		admin = funcionarioRepository.save(admin)

		var funcionario: Funcionario
				= Funcionario("Veronica Torres", "veronica@gmail.com",
				SenhaUtils().gerarBcrypt("654321"), "17347006023",
				PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionario = funcionarioRepository.save(funcionario)

		var lancamentoFuncionario: Lancamento
				= Lancamento(Date.from(Instant.now()),TipoEnum.INICIO_TRABALHO, funcionario.id!!,
				"teste", "testelocal")
		lancamentoFuncionario = lancamentoRepository.save(lancamentoFuncionario)

		println("Empresa ID: " + empresa.id)
		println("Admin ID: " + admin.id)
		println("Funcionario ID: " + funcionario.id)
		println("Lancamento ID: " + lancamentoFuncionario.id)
	}
}

fun main(args: Array<String>) {
	runApplication<ApiRestKotlinApplication>(*args)
}
