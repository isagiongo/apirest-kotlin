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
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val NOME: String = "Isa Giongo"
    private val EMAIL: String = "isa@gmail.com"
    private val CPF: String = "062.243.120-01"
    private val ID: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp(){
        //BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.save(funcionario())).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(ID)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(EMAIL)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(CPF)).willReturn(funcionario())
    }

    @Test
    fun devePersistirFuncionario(){
        val funcionario: Funcionario? = funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun deveBuscarFuncionarioPorEmail(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(EMAIL)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun deveBuscarFuncionarioPorCpf(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(CPF)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun deveBuscarFuncionarioPorId(){
        val funcionario: Optional<Funcionario>? = this.funcionarioService?.buscarPorId(ID)
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario =
            Funcionario(NOME, EMAIL, SenhaUtils().gerarBcrypt("123456"),
                    CPF, PerfilEnum.ROLE_USUARIO, ID)
}