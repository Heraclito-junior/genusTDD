package testes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import NovasFuncionalidades.Faltas;
import NovasFuncionalidades.FaturaModificada;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.FuncionarioModificado;
import NovasFuncionalidades.VendaModificada;
import exception.NenhumaVendaAnoException;
import exception.NenhumaVendaDiaException;
import exception.NenhumaVendaMesException;

public class TesteBalacoMes {
	
	
	List<FuncionarioModificado> listaDeFuncionarios;
	List<Faltas>listaFaltas;
	List<VendaModificada> listaVendas;
	List<String>lista;
	List<FaturaModificada> listaFatura;
	Date dataAtual;
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	
	
	
	
	
    @SuppressWarnings("deprecation")
	@Before public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeFuncionarios=new ArrayList<FuncionarioModificado>();
    	listaFaltas=new ArrayList<Faltas>();
    	listaVendas=new ArrayList<VendaModificada>();
    	listaFatura=new ArrayList<FaturaModificada>();

    	FuncionarioModificado auxiliarParaAlocacaoFuncionario;
    	Faltas auxiliarParaAlocacaoFaltas;
    	VendaModificada auxiliarParaAlocacaoVendas;
    	FaturaModificada auxiliarParaAlocacaoFatura;
		 

		when(novasFuncionalidades.retornarFuncionarioPorID(1)).thenReturn(new FuncionarioModificado("Joao", "Neves",1, 3000, "99991-2345", "1996-01-30", "Natal","DO-SG-TE-QA-QI-SE-SA", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(2)).thenReturn(new  FuncionarioModificado("Tirio","Lanis",2, 1500, "97534-2456", "1990-02-28", "Natal","TE-QA-QI-SE", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(3)).thenReturn(new  FuncionarioModificado("Dane","Targa",3, 2000, "99503-8753", "1998-03-12", "Natal","SG-TE-QA", true));
		
		

		
		for(int j=1;j<=3;j++){
			auxiliarParaAlocacaoFuncionario=novasFuncionalidades.retornarFuncionarioPorID(j);
			listaDeFuncionarios.add(auxiliarParaAlocacaoFuncionario);
			
		}
		
		
		
		
		
		when(novasFuncionalidades.retornarFaltaPorID(1)).thenReturn( new Faltas(1,2,new Date(2016,11,10) ) );
		when(novasFuncionalidades.retornarFaltaPorID(2)).thenReturn( new Faltas(2,2,new Date(2016,11,11) ) );
		

		
		for(int j=1;j<=2;j++){
			auxiliarParaAlocacaoFaltas=novasFuncionalidades.retornarFaltaPorID(j);
			listaFaltas.add(auxiliarParaAlocacaoFaltas);
			
		}
		
		
		when(novasFuncionalidades.retornarVendaPorID(1)).thenReturn( new VendaModificada(1, 1, 0, 1000, new Date(2016,11,10)) );
		when(novasFuncionalidades.retornarVendaPorID(2)).thenReturn( new VendaModificada(2, 1, 0, 2000, new Date(2016,11,12)) );
		when(novasFuncionalidades.retornarVendaPorID(3)).thenReturn( new VendaModificada(3, 1, 0, 4000, new Date(2016,10,10)) );
		when(novasFuncionalidades.retornarVendaPorID(4)).thenReturn( new VendaModificada(4, 1, 0, 8000, new Date(2016,11,16)) );
		
		
		
		for(int j=1;j<=4;j++){
			auxiliarParaAlocacaoVendas=novasFuncionalidades.retornarVendaPorID(j);
			listaVendas.add(auxiliarParaAlocacaoVendas);
			
			
		}
		
		
		
		when(novasFuncionalidades.retornarFaturaPorID(1)).thenReturn( new FaturaModificada(1, 2000, new Date(2016,11,01), true, 1));
		when(novasFuncionalidades.retornarFaturaPorID(2)).thenReturn( new FaturaModificada(2, 1200, new Date(2016,11,02), true, 1) );
		when(novasFuncionalidades.retornarFaturaPorID(3)).thenReturn( new FaturaModificada(3, 1000, new Date(2016,10,03), false, 1) );
		
		
		
		for(int j=1;j<=3;j++){
			auxiliarParaAlocacaoFatura=novasFuncionalidades.retornarFaturaPorID(j);
			listaFatura.add(auxiliarParaAlocacaoFatura);
			
		}
		
		
		
		
		
		dataAtual=new Date(2016,11,23);
    	
       
    }
    
    @Test    
	public void calcularValorVendasMes() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasMes(2016, 11, listaVendas);
		
		

		assertEquals(11000, valorVenda,0.001);
	}

    
    @Test(expected=NenhumaVendaMesException.class)   
	public void calcularValorVendasMesSemVenda() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasMes(2016, 11, listaVendas);
		
		

	}
    
    @Test(expected=NenhumaVendaAnoException.class)   
	public void calcularValorVendasAnoSemVenda() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasAno(2017, listaVendas);
		
		

	}
    
    @Test 
	public void calcularValorVendasDia() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasDia(2016,11,12, listaVendas);
    	
    	assertEquals(2000, valorVenda,0.001);
		

	}
    
    @Test(expected=NenhumaVendaDiaException.class)   
	public void calcularValorVendasDiaSemVenda() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasDia(2016,11,13, listaVendas);
    	
		

	}
    
    @Test 
	public void calcularValorVendasAno() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasAno(2016, listaVendas);
    	
    	assertEquals(15000, valorVenda,0.001);
		

	}
    
    
    
    
    @Test    
	public void calcularValorFaturaMes() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorFatura=0;
    	
    	valorFatura=novasFuncionalidades.calcularFaturaMes(2016, 11, listaFatura);
		
		

		assertEquals(3200, valorFatura,0.001);
	}
    
    
    
    @Test    
	public void calcularBalancoMes() {
    	
    	
    	

    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularVendasMes(2016, 11, listaVendas);
    	
    	valorVenda=novasFuncionalidades.truncarValor(valorVenda);

    	
    	double valorFatura=0;
    	
    	valorFatura=novasFuncionalidades.calcularFaturaMes(2016, 11, listaFatura);
    	
    	valorFatura=novasFuncionalidades.truncarValor(valorFatura);
    	double valorSalarios=0;
    	
    	
 
    	
    	valorSalarios=novasFuncionalidades.calcularSalarios(2016, 11, listaFaltas, listaDeFuncionarios);
    	
    	
    	valorSalarios=novasFuncionalidades.truncarValor(valorSalarios);

    
    	
		double valorTotal=valorVenda-valorFatura-valorSalarios;
		
		
		

		assertEquals(1466.67, valorTotal,0.001);
	}
    
   
    

    

    
	

	
	

	

}
