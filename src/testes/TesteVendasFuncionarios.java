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
import exception.ProdutoInexistenteException;

public class TesteVendasFuncionarios {
	
	
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
    	VendaModificada auxiliarParaAlocacaoVendas;
    	when(novasFuncionalidades.retornarFuncionarioPorID(1)).thenReturn(new FuncionarioModificado("Joao", "Neves",1, 3000, "99991-2345", "1996-01-30", "Natal","DO-SG-TE-QA-QI-SE-SA", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(2)).thenReturn(new  FuncionarioModificado("Tirio","Lanis",2, 1500, "97534-2456", "1990-02-28", "Natal","TE-QA-QI-SE", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(3)).thenReturn(new  FuncionarioModificado("Dane","Targa",3, 2000, "99503-8753", "1998-03-12", "Natal","SG-TE-QA", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(4)).thenReturn(new  FuncionarioModificado("Elizabeth","Targa",4, 2000, "99503-8753", "1998-03-12", "Natal","SG-TE-QA", true));
		

		
		for(int j=1;j<=4;j++){
			auxiliarParaAlocacaoFuncionario=novasFuncionalidades.retornarFuncionarioPorID(j);
			listaDeFuncionarios.add(auxiliarParaAlocacaoFuncionario);
			
		}
		
		
		
		
		

		
		
		when(novasFuncionalidades.retornarVendaPorID(1)).thenReturn( new VendaModificada(1, 1, 0, 1000, new Date(2016,11,10)) );
		when(novasFuncionalidades.retornarVendaPorID(2)).thenReturn( new VendaModificada(2, 1, 0, 2000, new Date(2016,11,12)) );
		when(novasFuncionalidades.retornarVendaPorID(3)).thenReturn( new VendaModificada(3, 1, 0, 4000, new Date(2016,10,10)) );
		when(novasFuncionalidades.retornarVendaPorID(4)).thenReturn( new VendaModificada(4, 1, 0, 8000, new Date(2016,11,16)) );
		when(novasFuncionalidades.retornarVendaPorID(5)).thenReturn( new VendaModificada(5, 2, 0, 250, new Date(2016,11,16)) );
		when(novasFuncionalidades.retornarVendaPorID(6)).thenReturn( new VendaModificada(6, 3, 0, 150, new Date(2016,11,16)) );
		when(novasFuncionalidades.retornarVendaPorID(7)).thenReturn( new VendaModificada(7, 3, 0, 350, new Date(2016,11,16)) );
		
		
		
		for(int j=1;j<=7 ;j++){
			auxiliarParaAlocacaoVendas=novasFuncionalidades.retornarVendaPorID(j);
			listaVendas.add(auxiliarParaAlocacaoVendas);
			
			
		}
		
		
		

		
		
		
		
		dataAtual=new Date(2016,11,23);
    	
       
    }
    
    
    @Test    
	public void calcularValorVendasMesFuncionario() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	FuncionarioModificado funcTeste=listaDeFuncionarios.get(2);
    	
    	valorVenda=novasFuncionalidades.calcularVendasFuncionarioMes(2016, 11, listaVendas,funcTeste);
		
		

		assertEquals(500, valorVenda,0.001);
	}
    
    
    @Test    
	public void calcularValorVendasMesSemVenda() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	FuncionarioModificado funcTeste=listaDeFuncionarios.get(2);
    	
    	valorVenda=novasFuncionalidades.calcularVendasFuncionarioMes(2016, 12, listaVendas,funcTeste);
		
		

		assertEquals(0, valorVenda,0.001);
	}
    
    
    @Test  
	public void calcularValorVendasFuncionarioDiaEspecifico() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	FuncionarioModificado funcTeste=listaDeFuncionarios.get(2);
    	
    	valorVenda=novasFuncionalidades.calcularVendasFuncionarioDia(2016, 12,16, listaVendas,funcTeste);
		
		

		assertEquals(0, valorVenda,0.001);
	}
    
	
    @Test(expected=NenhumaVendaDiaException.class)
	public void calcularValorVendasFuncionarioDiaEspecificoSemVenda() {
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	FuncionarioModificado funcTeste=listaDeFuncionarios.get(2);
    	
    	valorVenda=novasFuncionalidades.calcularVendasFuncionarioDia(2016, 12,17, listaVendas,funcTeste);
		
		

		assertEquals(0, valorVenda,0.001);
	}
    
    @Test  
   	public void calcularValorVendasFuncionarioAno() {
       	
       	
       	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
       	double valorVenda=0;
       	
       	FuncionarioModificado funcTeste=listaDeFuncionarios.get(2);
       	
       	valorVenda=novasFuncionalidades.calcularVendasFuncionarioAno(2016, listaVendas,funcTeste);
   		
   		

   		assertEquals(0, valorVenda,0.001);
   	}
       
   	
    @Test(expected=NenhumaVendaAnoException.class)
   	public void calcularValorVendasFuncionarioAnoEspecificoSemVenda() {
       	
       	
       	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
       	double valorVenda=0;
       	
       	FuncionarioModificado funcTeste=listaDeFuncionarios.get(3);
       	
       	valorVenda=novasFuncionalidades.calcularVendasFuncionarioAno(2016, listaVendas,funcTeste);
   		
   		

   		assertEquals(0, valorVenda,0.001);
   	}
     

    

    
	

	
	

	

}
