package testes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.Faltas;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.FuncionarioModificado;
import NovasFuncionalidades.Lotes;
import NovasFuncionalidades.VendaModificada;
import exception.CombProdutoLoteInvalidoException;
import exception.FuncionarioNaoTrabalhaDiaException;
import genus.Tipos.Produto;

public class TesteFaltasFuncionario {
	
	
	List<FuncionarioModificado> listaDeFuncionarios;
	List<Faltas>listaFaltas;
	//List<VendaContemPromocao>listaDeVendaContem;
	List<String>lista;
	Date dataAtual;
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	@Mock
	private VendaModificada novaVenda;
	
	
	
    @SuppressWarnings("deprecation")
	@Before public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeFuncionarios=new ArrayList<FuncionarioModificado>();
    	listaFaltas=new ArrayList<Faltas>();
		

    	FuncionarioModificado auxiliarParaAlocacaoFuncionario;
    	Faltas auxiliarParaAlocacaoFaltas;
		

		when(novasFuncionalidades.retornarFuncionarioPorID(1)).thenReturn(new FuncionarioModificado("Joao", "Neves",1, 35000, "99991-2345", "1996-01-30", "Natal","DO-SG-TE-QA-QI-SE-SA", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(2)).thenReturn(new  FuncionarioModificado("Tirio","Lanis",2, 35000, "97534-2456", "1990-02-28", "Natal","TE-QA-QI-SE", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(3)).thenReturn(new  FuncionarioModificado("Dane","Targa",3, 35000, "99503-8753", "1998-03-12", "Natal","SG-TE-QA", true));
		
		

		
		for(int j=1;j<=10;j++){
			auxiliarParaAlocacaoFuncionario=novasFuncionalidades.retornarFuncionarioPorID(j);
			listaDeFuncionarios.add(auxiliarParaAlocacaoFuncionario);
			
		}
		
		
		
		
		
		when(novasFuncionalidades.retornarFaltaPorID(1)).thenReturn( new Faltas(1,2,new Date(2016,11,10) ) );
		when(novasFuncionalidades.retornarFaltaPorID(2)).thenReturn( new Faltas(2,2,new Date(2016,11,11) ) );
		

		
		for(int j=1;j<=2;j++){
			auxiliarParaAlocacaoFaltas=novasFuncionalidades.retornarFaltaPorID(j);
			listaFaltas.add(auxiliarParaAlocacaoFaltas);
			
		}
		
		
		
		dataAtual=new Date(2016,11,23);
    	
       
    }
    
    @Test    
	public void adicionarFalta() {
    	FuncionarioModificado funcionarioParaTestar=listaDeFuncionarios.get(1);
		FuncionalidadesNovas funcionalidadesTest=new FuncionalidadesNovas();
		List<Faltas> faltasInsercao=new ArrayList<Faltas>(listaFaltas);
		Date dataTeste=new Date(2016,11,10);
		funcionalidadesTest.adicionarFalta(faltasInsercao, funcionarioParaTestar, dataTeste);
		
		

		assertEquals(faltasInsercao.get(3).getIdFalta(), 4);
	}
    
    @Test(expected=FuncionarioNaoTrabalhaDiaException.class)     
 	public void adicionarFaltaDiaFuncionarioNaoTrabalha() {
     	FuncionarioModificado funcionarioParaTestar=listaDeFuncionarios.get(1);
 		FuncionalidadesNovas funcionalidadesTest=new FuncionalidadesNovas();
 		List<Faltas> faltasInsercao=new ArrayList<Faltas>(listaFaltas);
		Date dataTeste=new Date(2016,11,12);
 		funcionalidadesTest.adicionarFalta(faltasInsercao, funcionarioParaTestar, dataTeste);
 		

 	}
    
	

	
	
	@Test    
	public void calcularDiasTrabalhoFuncionarioSemFaltaTest() {
		FuncionalidadesNovas funcionalidadesTest=new FuncionalidadesNovas();
		FuncionarioModificado funcionarioParaTestar=listaDeFuncionarios.get(1);
		int diasTrabalho=0;

		diasTrabalho=funcionalidadesTest.CalcularDiasTrabalhoNoMes(2016, 11, funcionarioParaTestar);
		assertEquals(18, diasTrabalho);
	}
	
	@Test    
	public void calcularDiasTrabalhoFuncionarioComFaltaTest() {
		FuncionalidadesNovas funcionalidadesTest=new FuncionalidadesNovas();
		FuncionarioModificado funcionarioParaTestar=listaDeFuncionarios.get(1);
		int diasFalta=0;

		diasFalta=funcionalidadesTest.CalcularDiasTrabalhoNoMesComFalta(2016, 11, funcionarioParaTestar,listaFaltas);
		assertEquals(16, diasFalta);
	}
	
	
	@Test    
	public void calcularSalarioTest() {
		FuncionalidadesNovas funcionalidadesTest=new FuncionalidadesNovas();
		FuncionarioModificado funcionarioParaTestar=listaDeFuncionarios.get(1);
		int diasTrabalho=0;
		diasTrabalho=funcionalidadesTest.CalcularDiasTrabalhoNoMes(2016, 11, funcionarioParaTestar);
		int diasFalta=0;
		diasFalta=funcionalidadesTest.CalcularDiasTrabalhoNoMesComFalta(2016, 11, funcionarioParaTestar,listaFaltas);
		
		double salario =funcionarioParaTestar.getF_Salario();
		
		double porcentagemDias=((double)diasFalta)/((double)diasTrabalho);
		
		double Total=salario*porcentagemDias;
		
		assertEquals(31111.1111, Total,0.0001);
	}
	

}
