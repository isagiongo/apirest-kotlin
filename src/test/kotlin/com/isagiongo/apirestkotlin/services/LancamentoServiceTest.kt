package com.isagiongo.apirestkotlin.services

import com.isagiongo.apirestkotlin.documents.Lancamento
import com.isagiongo.apirestkotlin.enums.TipoEnum
import com.isagiongo.apirestkotlin.repositories.LancamentoRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.BDDMockito.willReturn
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.collections.ArrayList

@RunWith(SpringRunner::class)
@SpringBootTest
class LancamentoServiceTest {

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    @Autowired
    val lancamentoService: LancamentoService? = null

    private val ID = "1"
    private val DATA = Date()
    private val FUNCIONARIO_ID = "1"
    private val DESCRICAO = "Lancamento início do dia"
    private val LOCALIZACAO = ""
    private val TIPO = TipoEnum.INICIO_TRABALHO
    private val PAGE = 0
    private val SIZE = 10

    @Before
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(ID, PageRequest.of(PAGE, SIZE)))
            .willReturn(PageImpl(ArrayList<Lancamento>()))
        BDDMockito.given(lancamentoRepository?.findById(ID)).willReturn(Optional.of(lancamento()))
        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java))).willReturn(lancamento())
    }

    @Test
    fun deveBuscarLancamentoPorId(){
        val lancamento: Optional<Lancamento>? = lancamentoService?.buscarPorId(ID)
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun deveBuscarLancamentosPorFuncionarioId(){
        val lancamento: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(ID, PageRequest.of(0, 10))
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun devePersistirLancamento(){
        val lancamento: Lancamento? = lancamentoService?.persistir(lancamento())
        Assert.assertNotNull(lancamento)
    }

    private fun lancamento(): Lancamento = Lancamento(DATA, TIPO, FUNCIONARIO_ID, DESCRICAO, LOCALIZACAO, ID)
}