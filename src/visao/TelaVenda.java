/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import genus.Funcoes;
import genus.Tipos.Venda;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author GilbertoSoares
 */
public class TelaVenda extends javax.swing.JFrame {

    /**
     * Creates new form TelaVenda
     */
    public Venda venda;
    public Funcoes funcoes;
    public int quantidadeProdutos;
    public static int idFuncionario;
    
    public TelaVenda(int idFuncionario) {
        this.funcoes = new Funcoes();
        this.idFuncionario = idFuncionario;
        venda = funcoes.criarVenda(idFuncionario);
        quantidadeProdutos = 0;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        labelVenda = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldQuantidade = new javax.swing.JTextField();
        buttonAdicionarProduto = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaValor = new javax.swing.JTextArea();
        buttonConcluirVenda = new javax.swing.JButton();
        buttonCancelarVenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarrinho = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        textFieldNomeProduto = new javax.swing.JTextField();
        buttonRemover = new javax.swing.JButton();
        textFieldIDRemocao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelVenda.setFont(new java.awt.Font("Vijaya", 1, 36)); // NOI18N
        labelVenda.setText("Venda");

        jLabel1.setText("Código do produto:");

        textFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade:");

        textFieldQuantidade.setText("1");
        textFieldQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantidadeActionPerformed(evt);
            }
        });

        buttonAdicionarProduto.setText("Adicionar produto");
        buttonAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Carrinho");

        jLabel4.setText("Valor:");

        textAreaValor.setEditable(false);
        textAreaValor.setColumns(10);
        textAreaValor.setRows(1);
        textAreaValor.setTabSize(10);
        textAreaValor.setText("R$");
        jScrollPane2.setViewportView(textAreaValor);

        buttonConcluirVenda.setText("Concluir venda");
        buttonConcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConcluirVendaActionPerformed(evt);
            }
        });

        buttonCancelarVenda.setText("Cancelar venda");
        buttonCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarVendaActionPerformed(evt);
            }
        });

        tableCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Quantidade", "Preço"
            }
        ));
        tableCarrinho.setEnabled(false);
        jScrollPane1.setViewportView(tableCarrinho);

        jLabel5.setText("Nome do produto:");

        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        jLabel6.setText("Código:");

        buttonHelp.setText("?");
        buttonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonCancelarVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonConcluirVenda))
                                    .addComponent(jScrollPane1))
                                .addGap(17, 17, 17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(buttonAdicionarProduto))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                            .addComponent(textFieldNomeProduto))
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonHelp))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(buttonRemover)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldIDRemocao, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(labelVenda)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionarProduto)
                    .addComponent(jLabel2)
                    .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldIDRemocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonRemover)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConcluirVenda)
                    .addComponent(buttonCancelarVenda))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCodigoActionPerformed

    private void textFieldQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantidadeActionPerformed

    private void buttonAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarProdutoActionPerformed
        // TODO add your handling code here:
        int codigo;
        String nome = textFieldNomeProduto.getText();
        int quantidade;
        int idVenda = venda.getIDvenda();
        int resultadoAdicao;
        double preco;
        
        try {
            quantidade = Integer.parseInt(textFieldQuantidade.getText());
        }
        catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                    + "Quantidade inválida, insira valores inteiros.", "Erro ao adicionar produto à venda", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(quantidade < 0){
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto!\n"
                    + "Quantidade inválida, insira valores postivos.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (textFieldCodigo.getText().equals("") && textFieldNomeProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado.");
            return;
        }
        if (textFieldCodigo.getText().equals("")) {
            resultadoAdicao = funcoes.adicionarVendaPorNome(nome, idVenda, quantidade);
            if (!funcoes.existeProdutoNome(nome)) {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                        + "Produto não encontrado.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (resultadoAdicao == 2) {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                        + "Não há quantidade suficiente em estoque.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            codigo = funcoes.retornarCodigoPorNome(nome);
            preco = funcoes.retornarPrecoPorID(codigo);
            preco *= quantidade;
            preco = Math.round(preco * 100.0) / 100.0;
            
            venda.atualizaValorTotal(preco);
            double temp3 = temp3 = venda.getValorTotal();
            temp3 = Math.round(temp3 * 100.0) / 100.0;
            textAreaValor.setText("R$ " + temp3);
            quantidadeProdutos = 0;
            for (int i = 0; i < tableCarrinho.getRowCount(); i++) {
                for (int j = 0; j < tableCarrinho.getColumnCount(); j++) {
                    tableCarrinho.setValueAt("", i, j);
                }
            }
            String[] auxiliarTuplas;
            ArrayList<String> listaCarrinho = funcoes.listarCarrinho(venda.getIDvenda());
            int tamanho = listaCarrinho.size();
            for (int i = 0; i < tamanho; i++) {
                auxiliarTuplas = listaCarrinho.get(i).split(Pattern.quote("_-*7"));
                for (int j = 0; j < 4; j++) {
                    tableCarrinho.setValueAt(auxiliarTuplas[j], i, j);
                    quantidadeProdutos++;
                }
            }
            return;
        }
        try {
            codigo = Integer.parseInt(textFieldCodigo.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                    + "Código inválido.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
            textFieldCodigo.setText("");
            return;
        }
        preco = funcoes.retornarPrecoPorID(codigo);
        preco *= quantidade;
        preco = Math.round(preco * 100.0) / 100.0;
        if (nome.equals("")) {
            resultadoAdicao = funcoes.adicionarVendaPorID(codigo, idVenda, quantidade);
            if (resultadoAdicao == 2) {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                        + "Não há quantidade suficiente em estoque.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
                return;
            }
            venda.atualizaValorTotal(preco);
            double temp2 = venda.getValorTotal();
            temp2 = Math.round(temp2 * 100.0) / 100.0;
            textAreaValor.setText("R$ " + temp2);
            quantidadeProdutos = 0;
            for (int i = 0; i < tableCarrinho.getRowCount(); i++) {
                for (int j = 0; j < tableCarrinho.getColumnCount(); j++) {
                    tableCarrinho.setValueAt("", i, j);
                }
            }
            String[] auxiliarTuplas;
            ArrayList<String> listaCarrinho = funcoes.listarCarrinho(venda.getIDvenda());
            int tamanho = listaCarrinho.size();
            for (int i = 0; i < tamanho; i++) {
                auxiliarTuplas = listaCarrinho.get(i).split(Pattern.quote("_-*7"));
                for (int j = 0; j < 4; j++) {
                    tableCarrinho.setValueAt(auxiliarTuplas[j], i, j);
                    quantidadeProdutos++;
                }
            }
            return;
        }
        resultadoAdicao = funcoes.adicionarVendaPorNomeID(codigo, nome, idVenda, quantidade);
        if (!funcoes.existeProdutoNome(nome)) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                    + "Produto não encontrado.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (resultadoAdicao == 2) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto à venda!\n"
                    + "Não há quantidade suficiente em estoque.", "Erro ao adicionar produto", JOptionPane.ERROR_MESSAGE);
            return;
        }
        preco = Math.round(preco * 100.0) / 100.0;
        venda.atualizaValorTotal(preco);
        double temp4 = venda.getValorTotal();
        temp4 = Math.round(temp4 * 100.0) / 100.0;
        textAreaValor.setText("R$ " + temp4);
        quantidadeProdutos = 0;
        for (int i = 0; i < tableCarrinho.getRowCount(); i++) {
            for (int j = 0; j < tableCarrinho.getColumnCount(); j++) {
                tableCarrinho.setValueAt("", i, j);
            }
        }
        String[] auxiliarTuplas;
        ArrayList<String> listaCarrinho = funcoes.listarCarrinho(venda.getIDvenda());
        int tamanho = listaCarrinho.size();
        for (int i = 0; i < tamanho; i++) {
            auxiliarTuplas = listaCarrinho.get(i).split(Pattern.quote("_-*7"));
            for (int j = 0; j < 4; j++) {
                tableCarrinho.setValueAt(auxiliarTuplas[j], i, j);
                quantidadeProdutos++;
            }
        }
    }//GEN-LAST:event_buttonAdicionarProdutoActionPerformed

    private void buttonCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarVendaActionPerformed
        // TODO add your handling code here:
        funcoes.deletarDeVenda(venda.getIDvenda());
        TelaVendedor tela = new TelaVendedor(idFuncionario);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonCancelarVendaActionPerformed

    private void buttonConcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConcluirVendaActionPerformed
        // TODO add your handling code here:
        TelaConfirmacaoVenda tela = new TelaConfirmacaoVenda(venda, this, idFuncionario);
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonConcluirVendaActionPerformed

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
    // TODO add your handling code here:
    int idProduto;
    int idVenda = venda.getIDvenda();
    
    try {
        idProduto = Integer.parseInt(textFieldIDRemocao.getText());
    }
    catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Erro ao remover produto da venda!\n"
                + "Código inválido.", "Erro ao remover produto da venda", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    double totalExcluido = funcoes.deletarDeVendaContem(idVenda,idProduto);
    
    if(totalExcluido == -1){
        JOptionPane.showMessageDialog(this, "Erro ao remover produto da venda!\n"
                + "Produto referente ao código não está presente na venda.",
                "Erro ao remover produto da venda", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    venda.atualizaValorTotal(-totalExcluido);
    double temp5 = venda.getValorTotal();
    temp5 = Math.round(temp5 * 100.0) / 100.0;
    textAreaValor.setText("R$ " + temp5);
    
    for (int i = 0; i < tableCarrinho.getRowCount(); i++) {
        for (int j = 0; j < tableCarrinho.getColumnCount(); j++) {
            tableCarrinho.setValueAt("", i, j);
        }
    }
      
    String[] auxiliarTuplas;
    ArrayList<String> listaCarrinho = funcoes.listarCarrinho(venda.getIDvenda());
    int tamanho = listaCarrinho.size();

    for (int i = 0; i < tamanho; i++) {
        auxiliarTuplas = listaCarrinho.get(i).split(Pattern.quote("_-*7"));
        for (int j = 0; j < 4; j++) {
            tableCarrinho.setValueAt(auxiliarTuplas[j],i,j);
        }
    }
    
    quantidadeProdutos--;
    
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        // TODO add your handling code here:
        TelaAuxiliarProdutos tela = new TelaAuxiliarProdutos(idFuncionario);
        tela.setVisible(true);
    }//GEN-LAST:event_buttonHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda(idFuncionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarProduto;
    private javax.swing.JButton buttonCancelarVenda;
    private javax.swing.JButton buttonConcluirVenda;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelVenda;
    private javax.swing.JTable tableCarrinho;
    private javax.swing.JTextArea textAreaValor;
    private javax.swing.JTextField textFieldCodigo;
    private javax.swing.JTextField textFieldIDRemocao;
    private javax.swing.JTextField textFieldNomeProduto;
    private javax.swing.JTextField textFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
