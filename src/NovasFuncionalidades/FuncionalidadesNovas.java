/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.ProdutoInexistenteException;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

/**
 *
 * @author Heráclito Júnior
 */
public class FuncionalidadesNovas {
	
	public FuncionalidadesNovas(){
		
	}
	
	
	public Produto retornarProdutoPorID(int idProduto){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Desconto retornarDescontoPorID(int idDesconto){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Lotes retornarLotesPorID(int idLote){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Produto calcularDescontoProduto(Produto produtoParaCalcular,List<Desconto> listaDeDescontosParaCalcular,List<Produto> listaEstoque){
		Produto produtoRetornado=new Produto();
		int achouDesconto=-1;
		
		if(!(listaEstoque.contains(produtoParaCalcular))){
			
			throw new ProdutoInexistenteException();
		}
		
		for(int i=0;i<listaDeDescontosParaCalcular.size();i++){
			if(listaDeDescontosParaCalcular.get(i).getIDProduto()==produtoParaCalcular.getIDproduto()){
				achouDesconto=i;
				break;
			}			
		}
		if(achouDesconto!=-1){
			double proporcaoDesconto=(1-(listaDeDescontosParaCalcular.get(achouDesconto).getPorcentagem()));
			double armazenarResultado=produtoParaCalcular.getPreco()*proporcaoDesconto;
			produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
			produtoRetornado.setNome(produtoParaCalcular.getNome());
			produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
			produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
			produtoRetornado.setPreco(armazenarResultado);
			
			return produtoRetornado;
			
		}
		produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
		produtoRetornado.setNome(produtoParaCalcular.getNome());
		produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
		produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
		produtoRetornado.setPreco(produtoParaCalcular.getPreco());
		
		return produtoRetornado;
		
		
		
	}
	
	public VendaModificada adicionarAVenda(Produto produtoParaVenda,VendaModificada novaVenda,double novaQuantidade){
		
		throw new UnsupportedOperationException();
		 
		
	}
	

	
	
	
	public List<VendaContemPromocao> setarVendaContem(VendaModificada novaVenda,List<Desconto> listaDescontos){
		List<VendaContemPromocao> novoVendaContem=new ArrayList<VendaContemPromocao>();
		List<Produto> carrinho=new ArrayList<Produto>();
		List<Produto> estoque=new ArrayList<Produto>();
		carrinho=novaVenda.getListaDeProdutos();
		estoque=novaVenda.getEstoque();
		
		boolean descontoEncontradoInteracao=false;
		int idDaPromocao=-1;
		int PosicaoDesconto=-1;
		for(int i=0;i<carrinho.size();i++){
			idDaPromocao=-1;
			PosicaoDesconto=-1;
			descontoEncontradoInteracao=false;
			for(int j=0;j<listaDescontos.size();j++){
				if(carrinho.get(i).getIDproduto()==listaDescontos.get(j).getIDProduto()){
					idDaPromocao=listaDescontos.get(j).IDdesconto;
					PosicaoDesconto=j;
				}
			}
			
			
			if(idDaPromocao==-1){
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				
				double precoNormal=estoque.get(interador).getPreco();
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal, precoNormal, 0));
			}else{
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				double precoNormal=estoque.get(interador).getPreco();
				
				
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal,carrinho.get(i).getPreco() ,idDaPromocao));
			}
			
			
		}
		return novoVendaContem;
				
		
	}
	public void setarLotes(List<Lotes> listaLotes,Date dataAtual){
		
		throw new UnsupportedOperationException();
		
	}


	


	


	
	

	
	
	
}
