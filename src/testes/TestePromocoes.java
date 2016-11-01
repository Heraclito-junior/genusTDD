package testes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.VendaContemPromocao;
import NovasFuncionalidades.VendaModificada;
import genus.Funcoes;
import genus.Tipos.Funcionario;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

public class TestePromocoes {
	
	
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	
	@Mock
	private VendaModificada novaVenda;
	
	List<Produto> listaDeProdutos;
	List<Desconto>listaDeDescontos;
	
	private static boolean setUpIsDone = false;

	@SuppressWarnings("deprecation")
	@Test
	public void testPromocoesUmProduto() {
		MockitoAnnotations.initMocks(this);
		
		Produto auxiliarParaAlocacaoProdutos;
		Desconto auxiliarParaAlocacaoDesconto;
		
		 List<Produto> listaDeProdutos=new ArrayList<Produto>();
		 List<Desconto> listaDeDescontos=new ArrayList<Desconto>();
		 
		 Date dataFicticia=new Date(2016,11,01);
		 
		 
		 List<VendaContemPromocao> listaDeConteudoParaTeste=new ArrayList<VendaContemPromocao>();
		 
		 listaDeConteudoParaTeste.add(new VendaContemPromocao(1, 1, 2, 1));
		 listaDeConteudoParaTeste.add(new VendaContemPromocao(1, 6, 3, 2));
		 
		
		
		//setUp();
		
		
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
		
		
		
		when(novasFuncionalidades.retornarDescontoPorID(0)).thenReturn(new Desconto(0,0,1,"Nenhum"));
		when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
		when(novasFuncionalidades.retornarDescontoPorID(2)).thenReturn(new Desconto(2,5,0.4,"Liquidacao de Sabão"));
		
		
		for(int j=1;j<=2;j++){
			auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarDescontoPorID(j);
			listaDeDescontos.add(auxiliarParaAlocacaoDesconto);
			
		}
		
		
		
		
		
		
		
		
		
		
		Produto produtoParaVerificar;
		produtoParaVerificar= listaDeProdutos.get(0);
		
		//when(novasFuncionalidades.calcularDescontoProduto(listaDeProdutos.get(0), listaDeDescontos)).thenReturn(new Produto(1,"tomate",91,0.4,1));
		
		
		
		//produtoParaVerificar=novasFuncionalidades.calcularDescontoProduto(listaDeProdutos.get(0), listaDeDescontos);

				
		novaVenda=new VendaModificada();
				
		when(novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda, 2)).thenReturn(new VendaModificada(1,1));
		
		
		
		novaVenda=novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda,2);
		
		
		produtoParaVerificar= listaDeProdutos.get(5);
		
		when(novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda, 3)).thenReturn(new VendaModificada(1,1));
		
		
		novaVenda=novasFuncionalidades.adicionarAVenda(produtoParaVerificar, novaVenda,3);
		
		when(novasFuncionalidades.FinalizarVenda(novaVenda,listaDeDescontos)).thenReturn(new VendaModificada(1,1));
		
		
		when(novaVenda.getValorTotal()).thenReturn(3.5);
		
		
		
		
		
		
		
		assertEquals(3.5, novaVenda.getValorTotal(), 0.001);		
		
		
		
		
		
	}
	
	
	
	
	
	
	public void setUp() {
	    if (setUpIsDone) {
	        return;
	    }
	    
	  MockitoAnnotations.initMocks(this);
	  
	  Produto auxiliarParaAlocacaoProdutos;
	  Desconto auxiliarParaAlocacaoDesconto;
	    
	  List<Produto> listaDeProdutos=new ArrayList<Produto>();
	  List<Desconto> listaDeDescontos=new ArrayList<Desconto>();
	  
	  
	  when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
	  when(novasFuncionalidades.retornarDescontoPorID(1)).thenReturn(new Desconto(1,1,0.2,"Liquidacao de Tomate"));
	  
	  auxiliarParaAlocacaoProdutos=novasFuncionalidades.retornarProdutoPorID(1);
	  
	  listaDeProdutos.add(auxiliarParaAlocacaoProdutos);
	  
	  
	  auxiliarParaAlocacaoDesconto=novasFuncionalidades.retornarDescontoPorID(1);
	  
	  listaDeDescontos.add(auxiliarParaAlocacaoDesconto);
	  
	  
	 
	    setUpIsDone = true;
	}
	
	
	
	

}
