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

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.Faltas;
import NovasFuncionalidades.FaturaModificada;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.FuncionarioModificado;
import NovasFuncionalidades.VendaContemPromocao;
import NovasFuncionalidades.VendaModificada;
import exception.NenhumaVendaAnoException;
import exception.NenhumaVendaDiaException;
import exception.NenhumaVendaMesException;
import exception.ProdutoInexistenteException;
import exception.PromocaoNaoExiste;
import genus.Tipos.Produto;

public class TesteTotalPromocao {
	
	
	List<FuncionarioModificado> listaDeFuncionarios;
	List<VendaModificada> listaVendas;
	List<String>lista;
	List<Desconto>listaDeDescontos;
	List<Produto> listaDeProdutos;
	List<VendaContemPromocao> listaVendaContem;

	Date dataAtual;
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	
	
	
	
	
    @SuppressWarnings("deprecation")
	@Before public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeFuncionarios=new ArrayList<FuncionarioModificado>();
    	listaVendas=new ArrayList<VendaModificada>();
    	listaDeProdutos=new ArrayList<Produto>();
    	listaVendaContem=new ArrayList<VendaContemPromocao>();
    	listaDeDescontos=new ArrayList<Desconto>();
    	
    	FuncionarioModificado auxiliarParaAlocacaoFuncionario;
    	VendaModificada auxiliarParaAlocacaoVendas;
    	Desconto auxiliarParaAlocacaoDesconto;
    	Produto auxiliarParaAlocacaoProdutos;
    	VendaContemPromocao auxiliasrVendaContem;
    	

		when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
		when(novasFuncionalidades.retornarProdutoPorID(2)).thenReturn(new Produto(2, "laranja", 106, 0.4, 1));
		when(novasFuncionalidades.retornarProdutoPorID(3)).thenReturn(new Produto(3, "mouse", 30, 20.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(4)).thenReturn(new Produto(4, "teclado", 25, 50.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(5)).thenReturn(new Produto(5, "detergente", 100, 2.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(6)).thenReturn(new Produto(6, "sabao", 100, 1.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(7)).thenReturn(new Produto(7, "absorvente", 70, 19.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(8)).thenReturn(new Produto(8, "analgesico", 60, 15.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(9)).thenReturn(new Produto(9, "batom", 50, 15.5, 5));
		when(novasFuncionalidades.retornarProdutoPorID(10)).thenReturn(new Produto(10, "perfume", 25, 25.5, 5));
		

		
		for(int j=1;j<=10;j++){
			auxiliarParaAlocacaoProdutos=novasFuncionalidades.retornarProdutoPorID(j);
			listaDeProdutos.add(auxiliarParaAlocacaoProdutos);
			
		}
		
		
		when(novasFuncionalidades.retornarVendaPorID(1)).thenReturn(new VendaModificada( 1,1,1,5.1,new Date(2016,11,22)));
		when(novasFuncionalidades.retornarVendaPorID(2)).thenReturn(new VendaModificada( 2,1,1,59.7,new Date(2016,11,22)));
		when(novasFuncionalidades.retornarVendaPorID(2)).thenReturn(new VendaModificada( 3,1,1,19.5,new Date(2016,11,22)));
		

		
		for(int j=1;j<=3;j++){
			auxiliarParaAlocacaoVendas=novasFuncionalidades.retornarVendaPorID(j);
			listaVendas.add(auxiliarParaAlocacaoVendas);
			
		}

		
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(1,1, 1, 3, 0.5, 0.4, 1));
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(2,1, 2, 3, 0.4, 0.4, 0));
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(3,1, 6, 3, 1.5, 0.9, 1));
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(4,2, 1, 3, 0.5, 0.4, 1));
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(5,2, 7, 3, 19.5, 19.5, 0));
		when(novasFuncionalidades.retornarVendaContemPromocaoPorID(1)).thenReturn(new VendaContemPromocao(6,3, 7, 1, 19.5, 19.5, 0));
		

		
		for(int j=1;j<=6;j++){
			auxiliasrVendaContem=novasFuncionalidades.retornarVendaContemPromocaoPorID(j);
			listaVendaContem.add(auxiliasrVendaContem);
			
		}


		when(novasFuncionalidades.retornarFuncionarioPorID(1)).thenReturn(new FuncionarioModificado("Joao", "Neves",1, 3000, "99991-2345", "1996-01-30", "Natal","DO-SG-TE-QA-QI-SE-SA", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(2)).thenReturn(new  FuncionarioModificado("Tirio","Lanis",2, 1500, "97534-2456", "1990-02-28", "Natal","TE-QA-QI-SE", true));
		when(novasFuncionalidades.retornarFuncionarioPorID(3)).thenReturn(new  FuncionarioModificado("Dane","Targa",3, 2000, "99503-8753", "1998-03-12", "Natal","SG-TE-QA", true));
		
		

		
		for(int j=1;j<=3;j++){
			auxiliarParaAlocacaoFuncionario=novasFuncionalidades.retornarFuncionarioPorID(j);
			listaDeFuncionarios.add(auxiliarParaAlocacaoFuncionario);
			
		}
		

		when(novasFuncionalidades.retornarDescontoPorID(0)).thenReturn(new Desconto(0,0,1,"Nenhum"));
		when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
		when(novasFuncionalidades.retornarDescontoPorID(2)).thenReturn(new Desconto(2,6,0.4,"Liquidacao de Sabão"));
		
		
		for(int j=1;j<=2;j++){
			auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarDescontoPorID(j);
			listaDeDescontos.add(auxiliarParaAlocacaoDesconto);
			
		}
		
		
		
		
		
		dataAtual=new Date(2016,11,23);
    	
       
    }
    
    @Test    
	public void calcularCustoPromocao() {
    	
    	
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularTotalDesconto(1,listaVendaContem);
		
		

		assertEquals(0.6, valorVenda,0.01);
	}
    
    @Test(expected=PromocaoNaoExiste.class)
	public void calcularCustoPromocaoInvalida() {
    	
    	
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	
    	
    	novasFuncionalidades.calcularTotalDesconto(9,listaVendaContem);
		
		

	}
    
    @Test    
	public void calcularValorPromocaoVenda() {
    	
    	
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularTotalDescontoVenda(1,listaVendaContem);
		
		

		assertEquals(2.1, valorVenda,0.01);
	}
    
    @Test    
	public void calcularValorPromocaoVendaSemDesconto() {
    	
    	
    	
    	
    	FuncionalidadesNovas novasFuncionalidades=new FuncionalidadesNovas();
    	double valorVenda=0;
    	
    	valorVenda=novasFuncionalidades.calcularTotalDesconto(3,listaVendaContem);
		
		

		assertEquals(0, valorVenda,0.01);
	}

    

    
   
    

    

    
	

	
	

	

}
