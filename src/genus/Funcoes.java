/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genus;

//import static genus.Genus.DB_URL;
import genus.Tipos.Cliente;
import genus.Tipos.Fatura;
import genus.Tipos.Funcionario;
import genus.Tipos.Venda;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class Funcoes {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/genus?autoReconnect=true&useSSL=false";
//Database credentials

    static final String USER = "root";
    static final String PASS = "1234";

    public boolean cadastrarCliente(Cliente novoCliente) {
        //String id = Integer.toString(novoCliente.getIdCliente());

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "INSERT INTO cliente "
                    + "VALUES ('" + novoCliente.getIdCliente() + "', '" + novoCliente.getNome() + "')";
            stmt.executeUpdate(sql);

            return true;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean retornaCliente(int novoCPF) {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;

        double resultado = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT CPF FROM cliente where CPF='" + novoCPF + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = rs.getInt("CPF");
            }
            rs.close();

            if (resultado != 0) {
                return true;
            } else {
                return false;
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {

            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try
        }//end try

        return false;
    }

    public boolean cadastrarGerente(Funcionario novoGerente, String senha) {
        //String id = Integer.toString(novoCliente.getIdCliente());
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT IDfuncionarios FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idTemp = rs.getInt("IDfuncionarios");
            }
            rs.close();
            sql = "INSERT INTO empregado "
                    + "VALUES ('" + novoGerente.getF_Nome() + "', '" + novoGerente.getF_Sobrenome() + "','" + idTemp + "','" + novoGerente.getF_Salario() + "','" + novoGerente.getF_Telefone() + "','" + novoGerente.getF_DataNascimento() + "','" + novoGerente.getF_Endereco() + "',true)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO gerente "
                    + "VALUES ('" + idTemp + "')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO cadastro "
                    + "VALUES ('" + idTemp + "','" + senha + "')";
            stmt.executeUpdate(sql);
            idTemp++;
            sql = "UPDATE dadosSistema "
                    + "SET IDfuncionarios = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean cadastrarVendedor(Funcionario novoVendedor, String senha) {
        //String id = Integer.toString(novoCliente.getIdCliente());
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT IDfuncionarios FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idTemp = rs.getInt("IDfuncionarios");       
            }
            rs.close();
            sql = "INSERT INTO empregado "
                    + "VALUES ('" + novoVendedor.getF_Nome() + "', '" + novoVendedor.getF_Sobrenome() + "','" + idTemp + "','" + novoVendedor.getF_Salario() + "','" + novoVendedor.getF_Telefone() + "','" + novoVendedor.getF_DataNascimento() + "','" + novoVendedor.getF_Endereco() + "',true)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO vendedor "
                    + "VALUES ('" + idTemp + "')";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO cadastro "
                    + "VALUES ('" + idTemp + "','" + senha + "')";
            stmt.executeUpdate(sql);
            idTemp++;
            sql = "UPDATE dadosSistema "
                    + "SET IDfuncionarios = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean cadastrarProduto(String nome, int quantidade, double preco, String categoria) {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int categ = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDproduto FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDproduto");
            }
            rs.close();

            sql = "SELECT IDcategoria FROM categoria WHERE nome='" + categoria + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                categ = rs.getInt("IDcategoria");
            }
            rs.close();

            sql = "INSERT INTO produto "
                    + "VALUES ('" + idTemp + "', '" + nome + "', '" + quantidade + "','" + preco + "','" + categ + "')";
            stmt.executeUpdate(sql);
            idTemp++;

            sql = "UPDATE dadosSistema "
                    + "SET IDproduto = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            System.out.println("categoria invalida");
            return false;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return false;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return false;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }//end finally try
        }//end try

        return true;
    }

    public boolean cadastrarFornecedor(String nome) {

        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int fornecedor = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDfornecedor FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDfornecedor");
            }
            rs.close();

            sql = "INSERT INTO fornecedor "
                    + "VALUES ('" + idTemp + "', '" + nome + "')";
            stmt.executeUpdate(sql);

            idTemp = idTemp + 1;

            sql = "UPDATE dadosSistema "
                    + "SET IDfornecedor = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return false;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return false;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return false;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }//end finally try
        }//end try

        return true;
    }

    public Venda criarVenda(int idVendedor) {
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDvenda FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDvenda");
            }
            rs.close();

            sql = "INSERT INTO venda "
                    + "VALUES ('" + idTemp + "', '" + idVendedor + "', null,null)";
            stmt.executeUpdate(sql);

            Venda venda = new Venda(idTemp, idVendedor);
            idTemp++;

            sql = "UPDATE dadosSistema "
                    + "SET IDvenda = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);

            return venda;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            System.out.println("venda invalida");

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("CRIEI ERRADO!");
        return null;
    }

    public Fatura criarFatura() {
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT IDfatura FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDfatura");
            }
            rs.close();
            sql = "INSERT INTO fatura "
                    + "VALUES ('" + idTemp + "', null, null, null,null)";
            stmt.executeUpdate(sql);
            Fatura fatura = new Fatura(idTemp);
            idTemp++;
            sql = "UPDATE dadosSistema "
                    + "SET IDfatura = " + idTemp + " WHERE marco=1";
            stmt.executeUpdate(sql);
            return fatura;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            System.out.println("fatura invalida");
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("CRIEI ERRADO!");
        return null;
    }
    
    

    public int adicionarVendaPorID(int idProd, int idVenda, int quantidad) {
        Connection conn = null;
        Statement stmt = null;
        int qnt = 0;
        int temp = 0;
        int quantidadeFinal;
        int temp2 = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT quantidade FROM produto WHERE IDproduto='" + idProd + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
            }
            rs.close();
            if (qnt < quantidad) {
                return 2;
            }
            sql = "SELECT quantidade FROM venda_contem WHERE IDproduto='" + idProd + "' and idVenda='" + idVenda + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
                temp2++;
            }
            rs.close();
            if (temp2 > 0) {
                quantidadeFinal = qnt + quantidad;
                sql = "update venda_contem Set quantidade='" + quantidadeFinal + "' where idProduto='" + idProd + "' and IDvenda='" + idVenda + "'";
                stmt.executeUpdate(sql);
                return 0;
            }
            double preco = 0;
            sql = "SELECT preco FROM produto WHERE IDproduto='" + idProd + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                preco = rs.getDouble("preco");
                temp2++;
            }

            sql = "INSERT INTO venda_contem "
                    + "VALUES ('" + idVenda + "', '" + idProd + "', '" + quantidad + "','" + preco + "')";
            stmt.executeUpdate(sql);
            return 0;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("NÃO CRIOU VENDA_CONTEM");
        return 1;
    }

    /**
     *
     * @param idProduto
     * @param idVenda
     * @param quantidade
     * @return retorna 0 se funcionou, 1 se não achou o produto, 2 se não tem
     * produto suficiente
     */
    public int adicionarVendaPorNome(String novoNome, int idVenda, int quantidade) {
        Connection conn = null;
        Statement stmt = null;
        int qnt = 0;
        int temp = 0;
        int quantidadeFinal;
        int temp2 = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            int idProduto = 0;
            sql = "SELECT quantidade FROM produto WHERE nome='" + novoNome + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
            }
            rs.close();
            if (qnt < quantidade) {
                return 2;
            }
            sql = "SELECT idProduto FROM produto WHERE nome='" + novoNome + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idProduto = rs.getInt("idProduto");
                temp++;
            }
            rs.close();
            sql = "SELECT quantidade FROM venda_contem WHERE IDproduto='" + idProduto + "' and idVenda='" + idVenda + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
                temp2++;
            }
            rs.close();
            if (temp2 > 0) {
                quantidadeFinal = qnt + quantidade;
                sql = "update venda_contem Set quantidade='" + quantidadeFinal + "' where idProduto='" + idProduto + "' and IDvenda='" + idVenda + "'";
                stmt.executeUpdate(sql);
                return 0;
            }

            double preco = 0;
            sql = "SELECT preco FROM produto WHERE IDproduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                preco = rs.getDouble("preco");
                temp2++;
            }
            sql = "INSERT INTO venda_contem "
                    + "VALUES ('" + idVenda + "', '" + idProduto + "', '" + quantidade + "','" + preco + "')";
            stmt.executeUpdate(sql);
            return 0;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("NÃO CRIOU VENDA_CONTEM");
        return 1;
    }

    /**
     *
     * @param idProduto
     * @param idVenda
     * @param quantidade
     * @return retorna 0 se funcionou, 1 se não achou o produto, 2 se não tem
     * produto suficiente
     */
    public int adicionarVendaPorNomeID(int idProduto, String novoNome, int idVenda, int quantidade) {
        Connection conn = null;
        Statement stmt = null;
        int qnt = 0;
        int temp = 0;
        int quantidadeFinal;
        int temp2 = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            int idProduto2 = 0;
            sql = "SELECT quantidade FROM produto WHERE nome='" + novoNome + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
            }
            rs.close();
            if (qnt < quantidade) {
                return 2;
            }
            sql = "SELECT idProduto FROM produto WHERE nome='" + novoNome + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idProduto2 = rs.getInt("idProduto");
            }
            rs.close();
            sql = "SELECT quantidade FROM venda_contem WHERE IDproduto='" + idProduto + "' and idVenda='" + idVenda + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getInt("quantidade");
                temp2++;
            }
            rs.close();
            if (temp2 > 0) {
                quantidadeFinal = qnt + quantidade;
                sql = "update venda_contem Set quantidade='" + quantidadeFinal + "' where idProduto='" + idProduto + "' and IDvenda='" + idVenda + "'";
                stmt.executeUpdate(sql);
                return 0;
            }

            double preco = 0;
            sql = "SELECT preco FROM produto WHERE IDproduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                preco = rs.getDouble("preco");
                temp2++;
            }

            if (idProduto == idProduto2) {
                sql = "INSERT INTO venda_contem "
                        + "VALUES ('" + idVenda + "', '" + idProduto + "', '" + quantidade + "','" + preco + "')";
                stmt.executeUpdate(sql);
                return 0;
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("NÃO CRIOU VENDA_CONTEM");
        return 1;
    }

    /**
     *
     * @param novoNome
     * @return se retornar 0 o produto não foi encontrado
     */
    public int retornarCodigoPorNome(String novoNome) {
        Connection conn = null;
        Statement stmt = null;
        int idProduto = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT idProduto FROM produto WHERE nome='" + novoNome + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idProduto = rs.getInt("idProduto");
            }
            rs.close();

            return idProduto;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return idProduto;
    }

    /**
     *
     * @param novoCodigo
     * @return se retornar falso se o produto não foi encontrado
     */
    public String retornarNomePorCodigo(int novoCodigo) {
        Connection conn = null;
        Statement stmt = null;
        String nome = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT nome FROM produto WHERE IDproduto='" + novoCodigo + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                nome = rs.getString("nome");
            }
            rs.close();

            return nome;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return nome;
    }

    public boolean verificarDisponibilidadeProduto(int novoProduto, int quantidadeDesejada) {
        //String id = Integer.toString(novoCliente.getIdCliente());
        Connection conn = null;
        Statement stmt = null;
        int quantidadeDisponivel = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT quantidade FROM produto WHERE IDproduto='" + novoProduto + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                quantidadeDisponivel = rs.getInt("quantidade");
            }
            rs.close();

            if (quantidadeDisponivel >= quantidadeDesejada) {
                return true;
            }
            return false;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public String listarDesconto() {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int categ = 0;
        String resultado = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT descricao FROM desconto";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = resultado + rs.getString("descricao") + "_-*7";
            }
            rs.close();

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return "";

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return "";
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return "";
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return "";
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return "";
            }//end finally try
        }//end try

        return resultado;
    }

    public String listarCategoria() {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int categ = 0;
        String resultado = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT nome FROM categoria";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = resultado + rs.getString("nome") + "_-*7";
            }
            rs.close();

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return "";

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return "";
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return "";
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return "";
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return "";
            }//end finally try
        }//end try

        return resultado;
    }

    public boolean cadastrarDesconto(double desconto, String descricao) {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int categ = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDdesconto FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDdesconto");
            }
            rs.close();

            sql = "SELECT IDdesconto FROM desconto WHERE porcentagem='" + desconto + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                categ = rs.getInt("IDdesconto");
            }
            rs.close();

            if (categ == 0) {

                sql = "INSERT INTO desconto "
                        + "VALUES ('" + idTemp + "', '" + desconto + "', '" + descricao + "')";
                stmt.executeUpdate(sql);

                idTemp = idTemp + 1;

                sql = "UPDATE dadosSistema "
                        + "SET IDdesconto = " + idTemp + " WHERE marco=1";
                stmt.executeUpdate(sql);

            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return false;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return false;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return false;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }//end finally try
        }//end try

        return true;
    }

    /*
     entra o nome da nova categoria, se der erro de sql ou já existir categoria com esse nome da false
     */
    public boolean cadastrarCategoria(String nomeCategoria) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int idTemp = 0;
        int categ = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT IDcategoria FROM dadosSistema WHERE marco=1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDcategoria");
            }
            rs.close();
            sql = "SELECT nome FROM categoria WHERE nome='" + nomeCategoria + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                categ = rs.getInt("IDdesconto");
            }
            rs.close();
            if (categ == 0) {
                sql = "INSERT INTO categoria "
                        + "VALUES ('" + idTemp + "', '" + nomeCategoria + "')";
                stmt.executeUpdate(sql);
                idTemp = idTemp + 1;
                sql = "UPDATE dadosSistema "
                        + "SET IDcategoria = " + idTemp + " WHERE marco=1";
                stmt.executeUpdate(sql);
                return true;
            } else {
                System.out.println("nome de categoria já existe");
                return false;
            }

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {

            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try
        }//end try
        return false;
    }

    public double retornarPrecoPorID(int idProd) {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;

        double resultado = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT preco FROM produto where IDproduto='" + idProd + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = rs.getDouble("preco");
            }
            rs.close();

            return resultado;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {

            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try
        }//end try

        return 0;
    }

    /**
     *
     * @param valorInicial
     * @param novoDescontoID id do desconto que se vai usar
     * @return retorna o valor convertido certo se funcionar ou o -1 se falhar
     */
    public double converterValorComDesconto(double valorInicial, String novoDescontoNome) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;

        double valorConvertido = valorInicial;
        double porcentagem = 0;
        double porcentagemInvertida = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;

            sql = "SELECT porcentagem FROM desconto WHERE descricao='" + novoDescontoNome + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                porcentagem = rs.getDouble("porcentagem");
            }
            rs.close();

            porcentagemInvertida = porcentagemInvertida - porcentagem;
            valorConvertido = valorConvertido * porcentagemInvertida;

            return valorConvertido;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {

            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try
        }//end try
        return -1;
    }

    public double getValorMaximo(double valor1, double valor2, double valor3) {

        double valorMaximo = 0;

        if (valor1 >= valor2) {
            if (valor1 >= valor3) {
                valorMaximo = valor1;
            }
        }

        if (valor2 >= valor1) {
            if (valor2 >= valor3) {
                valorMaximo = valor2;
            }
        }

        if (valor3 >= valor1) {
            if (valor3 >= valor2) {
                valorMaximo = valor3;
            }
        }

        return valorMaximo;
    }

    public boolean atualizaVenda(int novaVenda, long novoCPF, double valor) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        valor = Math.round(valor * 100.0) / 100.0;
        double resultado = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "UPDATE venda set IDcliente='" + novoCPF + "',ValorTotal='" + valor + "' where IDvenda='" + novaVenda + "'";
            stmt.executeUpdate(sql);
            return true;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean atualizaVendaSemCPF(int novaVenda, double valor) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        valor = Math.round(valor * 100.0) / 100.0;
        double resultado = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "UPDATE venda set ValorTotal='" + valor + "' where IDvenda='" + novaVenda + "'";
            stmt.executeUpdate(sql);
            return true;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public ArrayList listarGerentes() {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT nome,sobrenome,ID,Salario,telefone,datanasc,endereco,ativo FROM empregado, gerente WHERE ID=gerID";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                stringTemp = rs.getString("nome");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("sobrenome");
                resultado = resultado + stringTemp + "_-*7";
                intTemp = rs.getInt("ID");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("Salario");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("telefone");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("datanasc");
                resultado = resultado + stringTemp + "_-*7";

                stringTemp = rs.getString("endereco");
                resultado = resultado + stringTemp + "_-*7";
                boolTemp = rs.getBoolean("ativo");
                if (boolTemp == true) {
                    resultado = resultado + "true";
                } else {
                    resultado = resultado + "false";
                }
                lista.add(resultado);

            }
            rs.close();

            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return lista;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try

    }

    public ArrayList listarVendedores() {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT nome,sobrenome,ID,Salario,telefone,datanasc,endereco,ativo FROM empregado, vendedor WHERE ID=vendedorID";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                stringTemp = rs.getString("nome");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("sobrenome");
                resultado = resultado + stringTemp + "_-*7";
                intTemp = rs.getInt("ID");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("Salario");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("telefone");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("datanasc");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("endereco");
                resultado = resultado + stringTemp + "_-*7";
                boolTemp = rs.getBoolean("ativo");
                if (boolTemp == true) {
                    resultado = resultado + "true";
                } else {
                    resultado = resultado + "false";
                }
                lista.add(resultado);

            }
            rs.close();

            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return lista;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try

    }

    /**
     * retorna o arraylist com os dados do produto bem como o nome da categoria
     * o ArrayList contem em ordem: IDproduto / nome / quantidade / preco /
     * IDcategoria / nomeCategoria
     *
     * @return
     */
    public ArrayList listarProdutos() {

        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            ResultSet rs;

            sql = "SELECT A.IDproduto,A.nome,A.quantidade,A.preco,A.IDcategoria,B.nome FROM produto as A,categoria as B where A.IDcategoria=B.IDcategoria;";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDproduto");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("A.nome");
                resultado = resultado + stringTemp + "_-*7";
                intTemp = rs.getInt("A.quantidade");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.preco");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDcategoria");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("B.nome");
                resultado = resultado + stringTemp + "_-*7";

                lista.add(resultado);

            }
            rs.close();

            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();

            return lista;

        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try

    }

    public boolean modificarProdutoPorID(int idProdutoNovo, String nome, double preco, String categoria) {
        Connection conn = null;
        Statement stmt = null;
        int categ = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDcategoria FROM categoria WHERE nome='" + categoria + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                categ = rs.getInt("IDcategoria");
            }
            rs.close();

            sql = "UPDATE produto "
                    + "SET nome = '" + nome + "',preco='" + preco + "',IDcategoria='" + categ + "' WHERE IDproduto='" + idProdutoNovo + "'";
            stmt.executeUpdate(sql);

            return true;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean modificarFuncionarioPorID(int idFuncionario, double salari, String telefon, String enderec) {
        Connection conn = null;
        Statement stmt = null;
        int categ = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE empregado "
                    + "SET salario = '" + salari + "',telefone='" + telefon + "',endereco='" + enderec + "' WHERE ID='" + idFuncionario + "'";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean mudarAtivacaoFuncionario(int idFuncionario) {
        Connection conn = null;
        Statement stmt = null;
        boolean booltemp = false;
        int verificador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT ativo FROM empregado WHERE ID='" + idFuncionario + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                booltemp = rs.getBoolean("ativo");
                verificador++;
            }
            rs.close();
            if (booltemp == true && verificador > 0) {
                sql = "UPDATE empregado "
                        + "SET ativo = '0' WHERE ID='" + idFuncionario + "'";
                stmt.executeUpdate(sql);
                return true;
            } else if (booltemp == false && verificador > 0) {
                sql = "UPDATE empregado "
                        + "SET ativo = '1' WHERE ID='" + idFuncionario + "'";
                stmt.executeUpdate(sql);
                return true;
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean inserirPagamento(int idvend, Double valorVenda, String desc1, String desc2, String desc3) {
        Connection conn = null;
        Statement stmt = null;
        boolean booltemp = false;
        int rota;
        int verificador = 0;
        int idTemp = 0;
        double porc1 = 0;
        double porc2 = 0;
        double porc3 = 0;
        double porcFinal = 0;
        double valorFinal = 0;
        int idDesconto1 = 0;
        int idDesconto2 = 0;
        int idDesconto3 = 0;
        int ganhador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            if ((!desc1.equals("nenhum")) && desc2.equals("nenhum") && desc3.equals("nenhum")) {
                System.out.println("chegou");
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc1 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc1 = rs.getDouble("porcentagem");
                    idDesconto1 = rs.getInt("IDdesconto");
                    System.out.println(idDesconto1);
                    verificador++;
                }
                rs.close();
            }
            if ((desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc2 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc2 = rs.getDouble("porcentagem");
                    idDesconto2 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if ((desc1.equals("nenhum")) && (desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc3 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc3 = rs.getDouble("porcentagem");
                    idDesconto3 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if ((!desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc1 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc1 = rs.getDouble("porcentagem");
                    idDesconto1 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc2 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc2 = rs.getDouble("porcentagem");
                    idDesconto2 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if ((!desc1.equals("nenhum")) && (desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc1 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc1 = rs.getDouble("porcentagem");
                    idDesconto1 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc3 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc3 = rs.getDouble("porcentagem");
                    idDesconto3 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if ((desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc2 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc2 = rs.getDouble("porcentagem");
                    idDesconto2 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc3 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc3 = rs.getDouble("porcentagem");
                    idDesconto3 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if ((!desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc1 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc1 = rs.getDouble("porcentagem");
                    idDesconto1 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc2 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc2 = rs.getDouble("porcentagem");
                    idDesconto2 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
                sql = "SELECT porcentagem,IDdesconto FROM desconto WHERE descricao='" + desc3 + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //Retrieve by column name
                    porc3 = rs.getDouble("porcentagem");
                    idDesconto3 = rs.getInt("IDdesconto");
                    verificador++;
                }
                rs.close();
            }
            if (verificador == 0) {
                return false;
            }
            if ((!desc1.equals("nenhum")) && (desc2.equals("nenhum")) && (desc3.equals("nenhum"))) {
                porcFinal = porc1;
                ganhador = 1;
            }
            if ((desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (desc3.equals("nenhum"))) {
                porcFinal = porc2;
                ganhador = 2;
            }
            if ((desc1.equals("nenhum")) && (desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                porcFinal = porc3;
                ganhador = 3;
            }
            if ((!desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (desc3.equals("nenhum"))) {
                if (porc1 <= porc2) {
                    porcFinal = porc1;
                    ganhador = 1;
                } else {
                    porcFinal = porc2;
                    ganhador = 2;
                }
            }
            if ((desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                if (porc2 <= porc3) {
                    porcFinal = porc2;
                    ganhador = 2;
                } else {
                    porcFinal = porc3;
                    ganhador = 3;
                }
            }
            if ((!desc1.equals("nenhum")) && (!desc2.equals("nenhum")) && (!desc3.equals("nenhum"))) {
                if (porc1 <= porc2 && porc1 <= porc3) {
                    porcFinal = porc1;
                    ganhador = 1;
                }
                if (porc2 <= porc1 && porc2 <= porc3) {
                    porcFinal = porc2;
                    ganhador = 2;
                }
                if (porc3 <= porc1 && porc3 <= porc2) {
                    porcFinal = porc3;
                    ganhador = 3;
                }
            }
            porcFinal = 1 - porcFinal;
            valorFinal = valorVenda * porcFinal;
            valorFinal = Math.round(valorFinal * 100.0) / 100.0;
            sql = "SELECT IDpagamento FROM dadosSistema WHERE marco=1";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idTemp = rs.getInt("IDpagamento");
            }
            rs.close();
            if (ganhador == 1) {

                sql = "INSERT INTO pagamento "
                        + "VALUES ('" + idTemp + "', '" + valorFinal + "','" + idvend + "','" + idDesconto1 + "')";
                stmt.executeUpdate(sql);
            } else if (ganhador == 2) {
                sql = "INSERT INTO pagamento "
                        + "VALUES ('" + idTemp + "', '" + valorFinal + "','" + idvend + "','" + idDesconto2 + "')";
                stmt.executeUpdate(sql);
            } else if (ganhador == 3) {

                sql = "INSERT INTO pagamento "
                        + "VALUES ('" + idTemp + "', '" + valorFinal + "','" + idvend + "','" + idDesconto3 + "')";
                stmt.executeUpdate(sql);
            }
            idTemp = idTemp + 1;
            sql = "UPDATE dadosSistema "
                    + "SET IDpagamento = '" + idTemp + "' WHERE marco=1";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean diminuirEstoque(int idvend) {
        Connection conn = null;
        Statement stmt = null;
        boolean booltemp = false;
        int verificador = 0;
        int intTemp = 0;
        int dblTemp = 0;
        int quantidadeTemp = 0;

        LinkedList<Integer> chave = new LinkedList<Integer>();
        LinkedList<Integer> quant = new LinkedList<Integer>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql;

            sql = "SELECT IDproduto, quantidade FROM venda_contem WHERE IDvenda='" + idvend + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("IDproduto");
                dblTemp = rs.getInt("quantidade");
                chave.add(intTemp);
                quant.add(dblTemp);
                verificador++;
            }
            rs.close();

            for (int i = 0; i < chave.size(); i++) {

                sql = "SELECT quantidade FROM produto WHERE IDproduto='" + chave.get(i) + "'";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    quantidadeTemp = rs.getInt("quantidade");
                }
                rs.close();
                dblTemp = quant.get(i);
                quantidadeTemp = quantidadeTemp - dblTemp;
                sql = "UPDATE produto "
                        + "SET quantidade = " + quantidadeTemp + " WHERE IDproduto='" + chave.get(i) + "'";
                stmt.executeUpdate(sql);
            }

            return true;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public double deletarDeVendaContem(int idvend, int idprod) {
        Connection conn = null;
        Statement stmt = null;
        boolean booltemp = false;
        int verificador = 0;
        int idTemp = 0;
        double dblTemp = 0;
        int qnt = 0;
        double total = 0;
        double roundOff = 0;
        double a = 0;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT A.idVenda,A.IDProduto,A.quantidade,B.Preco FROM venda_contem as A,produto as B WHERE A.idProduto=B.idProduto and A.IDproduto='" + idprod + "'and A.IDvenda='" + idvend + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDvenda");
                idTemp = rs.getInt("A.IDProduto");
                qnt = rs.getInt("A.quantidade");
                dblTemp = rs.getDouble("B.Preco");
                a = total;

                total = total + (qnt * dblTemp);

                roundOff = Math.round(total * 100.0) / 100.0;

                verificador++;
            }
            rs.close();
            sql = "SELECT IDvenda FROM venda_contem WHERE IDproduto='" + idprod + "'and IDvenda='" + idvend + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDvenda");
                verificador++;
            }
            rs.close();
            sql = "delete from venda_contem where IDvenda='" + idvend + "'and IDproduto='" + idprod + "'";
            stmt.executeUpdate(sql);
            if (idTemp > 0) {
                return roundOff;
            } else {
                return -1;
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return -1;
    }

    public ArrayList listarCarrinho(int idVend) {
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int quanti = 0;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDproduto,A.nome,B.quantidade,B.precoNoMomento FROM produto as A,venda_contem as B where A.IDproduto=B.IDproduto and B.IDvenda='" + idVend + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDproduto");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("A.nome");
                resultado = resultado + stringTemp + "_-*7";
                intTemp = rs.getInt("B.quantidade");
                conversor = Integer.toString(intTemp);
                quanti = intTemp;
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.precoNoMomento");
                doubleTemp = doubleTemp * quanti;
                doubleTemp = Math.round(doubleTemp * 100.0) / 100.0;
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarVendas() {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        long intTemp2 = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDvenda,A.IDvendedor,A.IDcliente,A.ValorTotal,B.totalPago,B.IDdesconto,C.descricao FROM venda as A,pagamento as B,desconto as C where A.IDvenda=B.IDVenda and B.IDdesconto=C.IDdesconto";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDvenda");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDvendedor");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp2 = rs.getLong("A.IDcliente");
                conversor = Long.toString(intTemp2);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.ValorTotal");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.totalPago");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("C.descricao");
                resultado = resultado + stringTemp + "_-*7";

                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarVendasPorCPF(long cpf) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        long intTemp2 = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDvenda,A.IDvendedor,A.IDcliente,A.ValorTotal,B.totalPago,B.IDdesconto,C.descricao FROM venda as A,pagamento as B,desconto as C where A.IDvenda=B.IDVenda and B.IDdesconto=C.IDdesconto and A.IDcliente='" + cpf + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDvenda");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDvendedor");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp2 = rs.getLong("A.IDcliente");
                conversor = Long.toString(intTemp2);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.ValorTotal");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.totalPago");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("C.descricao");
                resultado = resultado + stringTemp + "_-*7";

                lista.add(resultado);
            }
            rs.close();
            return lista;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarVendasPorIDvendedor(int idVendedor) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDvenda,A.IDvendedor,A.IDcliente,A.ValorTotal,B.totalPago,B.IDdesconto,C.descricao FROM venda as A,pagamento as B,desconto as C where A.IDvenda=B.IDVenda and B.IDdesconto=C.IDdesconto and A.IDvendedor='" + idVendedor + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDvenda");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDvendedor");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDcliente");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.ValorTotal");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.totalPago");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("C.descricao");
                resultado = resultado + stringTemp + "_-*7";

                lista.add(resultado);
            }
            rs.close();
            return lista;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarClientes() {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        long intLong = 0;
        String stringTemp;
        boolean boolTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT CPF,nome FROM cliente";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intLong = rs.getLong("CPF");
                conversor = Long.toString(intLong);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("nome");
                resultado = resultado + stringTemp + "_-*7";

                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarFaturas() {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        int categ = 0;
        double valor = 0;
        String data = "";
        int idForc = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT IDfatura,valorFatura,dataFatura,IDfornecedor,IDgerente FROM fatura";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("IDfatura");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                valor = rs.getDouble("valorFatura");
                conversor = Double.toString(valor);
                resultado = resultado + conversor + "_-*7";
                data = rs.getString("dataFatura");
                resultado = resultado + data + "_-*7";
                intTemp = rs.getInt("IDfornecedor");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("IDgerente");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList detalhesVendas(int idVend) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        long intTemp2 = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDvenda,A.IDvendedor,A.IDcliente,A.ValorTotal,B.totalPago,C.descricao FROM venda as A,pagamento as B,desconto as C where A.IDvenda=B.IDVenda and B.IDdesconto=C.IDdesconto and A.idVenda='" + idVend + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDvenda");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDvendedor");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp2 = rs.getLong("A.IDcliente");
                conversor = Long.toString(intTemp2);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.ValorTotal");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.totalPago");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("C.descricao");
                resultado = resultado + stringTemp + "_-*7";
                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList detalhesFatura(int idFatura) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        long intTemp2 = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDfatura,A.IDgerente,A.valorFatura,A.dataFatura,B.fname FROM fatura as A, fornecedor as B where A.IDfornecedor=B.IDfornecedor  and A.IDfatura='" + idFatura + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDfatura");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                intTemp = rs.getInt("A.IDgerente");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("A.valorFatura");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("A.dataFatura");
                resultado = resultado + stringTemp + "_-*7";
                stringTemp = rs.getString("B.fname");
                resultado = resultado + stringTemp + "_-*7";
                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public ArrayList listarCarrinhoFatura(int idFatura) {
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        int quanti = 0;
        int categ = 0;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT B.IDproduto,A.nome,B.quantidade,B.precoNaHora FROM produto as A,fatura_referente_produto as B where A.IDproduto=B.IDproduto and B.IDfatura='" + idFatura + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("B.IDproduto");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("A.nome");
                resultado = resultado + stringTemp + "_-*7";
                intTemp = rs.getInt("B.quantidade");
                conversor = Integer.toString(intTemp);
                quanti = intTemp;
                resultado = resultado + conversor + "_-*7";
                doubleTemp = rs.getDouble("B.precoNaHora");
                doubleTemp = doubleTemp * quanti;
                doubleTemp = Math.round(doubleTemp * 100.0) / 100.0;
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";
                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public boolean deletarDeVenda(int idvend) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "delete from venda where IDvenda='" + idvend + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE dadosSistema "
                    + "SET IDvenda = '" + idvend + "' WHERE marco=1";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean adicionarFornecimentoPorID(int idFornecedor, int idProduto, double prec) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int contador = 0;
        int tmp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;

            sql = "SELECT preco FROM fornece_produto WHERE idFornecedor='" + idFornecedor + "'and idProduto='" + idProduto + "'and preco='" + prec + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name

                qnt = rs.getDouble("preco");
                contador++;

            }
            rs.close();
            if (contador > 0) {
                return false;
            }

            sql = "SELECT preco FROM fornece_produto WHERE idFornecedor='" + idFornecedor + "'and idProduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name

                qnt = rs.getDouble("preco");
                tmp++;

            }
            if (tmp > 0) {
                sql = "UPDATE fornece_produto "
                        + "SET preco = '" + prec + "' WHERE idFornecedor='" + idFornecedor + "' and IDproduto='" + idProduto + "'";
                stmt.executeUpdate(sql);
                return true;
            }

            sql = "INSERT INTO fornece_produto VALUES ('" + idFornecedor + "', '" + idProduto + "', '" + prec + "')";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            // se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            //e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                //se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("NÃO CRIOU VENDA_CONTEM");
        return false;
    }

    public boolean alterarFornecimentoPorID(int idFornece, int idPro, double preco) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;

            sql = "update fornece_produto Set preco='" + preco + "' where IDfornecedor='" + idFornece + "' and IDproduto='" + idPro + "'";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public ArrayList listarFornecimento(int idFornecedor) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;
        int intTemp = 0;
        String stringTemp;
        boolean boolTemp;
        double doubleTemp;
        ArrayList<String> lista = new ArrayList();
        String resultado = "";
        String conversor = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT A.IDproduto,A.nome,B.preco FROM produto as A,fornece_produto as B where A.IDproduto=B.IDproduto and B.IDfornecedor='" + idFornecedor + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                resultado = "";
                intTemp = rs.getInt("A.IDproduto");
                conversor = Integer.toString(intTemp);
                resultado = resultado + conversor + "_-*7";
                stringTemp = rs.getString("A.nome");
                resultado = resultado + stringTemp + "_-*7";
                doubleTemp = rs.getDouble("B.preco");
                conversor = Double.toString(doubleTemp);
                resultado = resultado + conversor + "_-*7";

                lista.add(resultado);
            }
            rs.close();
            return lista;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
            return lista;
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
            return lista;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return lista;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                return lista;
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                return lista;
            }//end finally try
        }//end try
    }

    public int converterNomeFornecedorEmID(String name) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int idTemp = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT IDfornecedor FROM fornecedor WHERE fname='" + name + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idTemp = rs.getInt("IDfornecedor");

            }
            if (idTemp == 0) {
                return -1;
            }
            return idTemp;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return -1;
    }

    public double inserirProdutoNaFatura(int idFatura, int idFornecedor, int idProduto, int quanti) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int qnt2;
        int contador = 0;
        double precoAtual = 0;
        double precofinal = 0;
        double a = 0;
        double roundOff = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT preco FROM fornece_produto WHERE idFornecedor='" + idFornecedor + "'and idProduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                precoAtual = rs.getDouble("preco");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                System.out.println("erro1");
                return -1;
            }
            sql = "SELECT preco FROM fornece_produto WHERE idFornecedor='" + idFornecedor + "'and idProduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            contador = 0;
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getDouble("preco");
            }
            sql = "SELECT precoNaHora FROM fatura_referente_produto where IDfatura='" + idFatura + "' and IDproduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            contador = 0;
            while (rs.next()) {
                //Retrieve by column name
                qnt = rs.getDouble("precoNaHora");
                contador++;
            }
            rs.close();
            sql = "INSERT INTO fatura_referente_produto VALUES ('" + idProduto + "', '" + idFatura + "', '" + quanti + "','" + precoAtual + "')";
            stmt.executeUpdate(sql);
            precofinal = quanti * precoAtual;
            a = precofinal;
            roundOff = Math.round(a * 100.0) / 100.0;
            return roundOff;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("erro2");
        return -1;
    }

    public boolean deletarDeFatura(int idFatura) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "delete from fatura where IDfatura='" + idFatura + "'";
            stmt.executeUpdate(sql);
            sql = "UPDATE dadosSistema "
                    + "SET IDfatura = '" + idFatura + "' WHERE marco=1";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean aumentarEstoqueFatura(int idFatura) {
        Connection conn = null;
        Statement stmt = null;
        boolean booltemp = false;
        int verificador = 0;
        int intTemp = 0;
        int intTemp2 = 0;
        double dblTemp = 0;
        double quantidadeTemp = 0;
        LinkedList<Integer> chave = new LinkedList<Integer>();
        LinkedList<Integer> quant = new LinkedList<Integer>();
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT IDproduto, quantidade FROM fatura_referente_produto WHERE IDfatura='" + idFatura + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("IDproduto");
                intTemp2 = rs.getInt("quantidade");
                chave.add(intTemp);
                quant.add(intTemp2);
                verificador++;
            }
            rs.close();
            for (int i = 0; i < chave.size(); i++) {
                sql = "SELECT quantidade FROM produto WHERE IDproduto='" + chave.get(i) + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    quantidadeTemp = rs.getDouble("quantidade");
                }
                rs.close();
                dblTemp = quant.get(i);
                quantidadeTemp = quantidadeTemp + dblTemp;
                sql = "UPDATE produto "
                        + "SET quantidade = " + quantidadeTemp + " WHERE IDproduto='" + chave.get(i) + "'";
                stmt.executeUpdate(sql);
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean existeProduto(int idProduto) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        double precoAtual = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT idProduto FROM produto WHERE IDproduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("idProduto");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }

            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean existeProdutoNome(String name) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        double precoAtual = 0;
        int idProduto = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;

            sql = "SELECT idProduto FROM produto WHERE nome='" + name + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                idProduto = rs.getInt("idProduto");
            }
            rs.close();
            if (idProduto == 0) {
                return false;
            }

            sql = "SELECT idProduto FROM produto WHERE IDproduto='" + idProduto + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("idProduto");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }

            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public String verificarLogin(int idEmpregado, String senha) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int contador = 0;
        int contador2 = 0;
        int contador3 = 0;
        int emp2 = 0;
        int emp3 = 0;
        int emp = 0;
        String sen = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT IDempregado,senha FROM cadastro WHERE IDempregado='" + idEmpregado + "'and senha='" + senha + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                emp = rs.getInt("IDempregado");
                sen = rs.getString("senha");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                System.out.println("erro1");
                return "nada";
            }
            
            sql = "SELECT ativo FROM empregado WHERE ID='" + idEmpregado + "'";
            rs = stmt.executeQuery(sql);
            contador = 0;
            boolean ativ=true;
            while (rs.next()) {
                //Retrieve by column name
                ativ = rs.getBoolean("ativo");
            }
            if (ativ==false) {
                return "nada";
            }
            
            sql = "SELECT gerID FROM gerente WHERE gerID='" + idEmpregado + "'";
            rs = stmt.executeQuery(sql);
            contador = 0;
            while (rs.next()) {
                //Retrieve by column name
                emp2 = rs.getInt("gerID");
                contador2++;
            }
            if (contador2 > 0) {
                return "gerente";
            }
            rs.close();
            sql = "SELECT vendedorID FROM vendedor WHERE vendedorID='" + idEmpregado + "'";
            rs = stmt.executeQuery(sql);
            contador = 0;
            while (rs.next()) {
                //Retrieve by column name
                emp3 = rs.getInt("vendedorID");
                contador3++;
            }
            if (contador3 > 0) {
                return "vendedor";
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("erro2");
        return "nada";
    }

    public void atualizaFatura(int idFatura, double valor, int idFornecedor,int idGerent) {
        //String novaQuantidade = Double.toString(quantidade);
        //String novoPreco = Double.toString(preco);
        Connection conn = null;
        Statement stmt = null;

        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;

            System.out.println(timeStamp);
            sql = "UPDATE fatura set valorFatura='" + valor + "',dataFatura='" + timeStamp + "',idFornecedor='" + idFornecedor + "',IDgerente='"+idGerent+"' where IDfatura='" + idFatura + "'";
            stmt.executeUpdate(sql);
            return;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException sa) {
            //System.out.println("categoria invalida");
            sa.printStackTrace();
        } catch (SQLException se) {
            System.out.println("erro chave duplicada ou categoria inexistente");
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return;
    }

    public boolean existeFuncionario(int idEmpregado) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        double precoAtual = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT ID FROM empregado WHERE ID='" + idEmpregado + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("ID");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean existeVenda(int idVenda) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT IDvenda FROM venda WHERE IDvenda='" + idVenda + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("IDvenda");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public boolean existeFatura(int idFatura) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT IDfatura FROM fatura WHERE IDfatura='" + idFatura + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("IDfatura");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    
    public boolean existeFornecedor(String name) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT fname FROM fornecedor WHERE fname='" + name + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("name");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    
    public boolean existeProdutoNaFatura(int idFat) {
        Connection conn = null;
        Statement stmt = null;
        double qnt = 0;
        int intTemp = 0;
        int contador = 0;
        double precoAtual = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT idProduto FROM fatura_referente_produto WHERE IDfatura='" + idFat + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getInt("idProduto");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    
    public boolean existeCPF(long cpf) {
        Connection conn = null;
        Statement stmt = null;
        long intTemp = 0;
        int contador = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT cpf FROM cliente WHERE CPF='" + cpf + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                intTemp = rs.getLong("cpf");
                contador++;
            }
            rs.close();
            if (contador == 0) {
                return false;
            }
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }
    


}
