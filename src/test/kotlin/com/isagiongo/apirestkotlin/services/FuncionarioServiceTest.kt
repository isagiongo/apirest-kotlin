package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Funcionario
import com.isagiongo.apirestkotlin.enums.PerfilEnum
import com.isagiongo.apirestkotlin.repositories.FuncionarioRepository
import com.isagiongo.apirestkotlin.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @Autowired
    val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val NOME = "Isa Giongo"
    private val EMAIL = "isa@gmail.com"
    private val CPF = "062.243.120-01"
    private val ID = "1"
    private val SENHA = SenhaUtils().gerarBcrypt("123456")
    private val PERFIL = PerfilEnum.ROLE_USUARIO
    private val EMPRESA = "1"
    private val VALOR_HORA = 56.33
    private val HORAS_TRABALHO = 7.5f
    private val HORAS_ALMOCO = 1.5f

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(funcionarioRepository?.save(funcionario())).willReturn(funcionario())
    }

    @Test
    fun devePersistirFuncionario(){
        val funcionario: Funcionario? = funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario =
            Funcionario(NOME, EMAIL, SENHA, CPF, PERFIL, EMPRESA, VALOR_HORA, HORAS_TRABALHO, HORAS_ALMOCO, ID)
}