
package local.ikn.bookstoreweb.model.dao;

import connection.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import local.ikn.bookstoreweb.model.bean.Book;


public class BookDAO {
    
    private static final String SQL_INSERT = "INSERT INTO book (titulo, " 
            + "autor, preco) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM book";
    private static final String SQL_SELECT_ID = "SELECT * FROM book  WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE book SET titulo = ?,"
            + "autor = ?, preco = ? "
            + "WHERE id = ?";
    
    private static final String SQL_DELETE = "DELETE FROM book WHERE id = ?";
    
    /**
     * Insere um usuario na base de dados Produto
     * @param p 
     */
    public void create (Book b){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = conn.prepareStatement (SQL_INSERT);
            
            stmt.setString(1, b.getTitulo());
            stmt.setString(2, b.getAutor());
            stmt.setDouble(3, b.getPreco());
            
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO,null,
                    "Inclusao: " + auxRetorno);

        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE,null,
                sQLException);
        } finally {
            // Encerrra a conexão com o banco e o statement
            MySQLConnection.closeConnection(conn, stmt);
        }
    }

    /**
     * Retorna todos os registros da tabela prodto
     * @return 
     */
    public  List<Book> getResults(){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book b = null;
        List<Book> listaBook = null;
        
        try {
            // Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            
            //Carrega os daods do Result rs, converte em Produto e
            // adiciona na lista de retorno 
            listaBook = new ArrayList<>();
            
            while (rs.next()) {
                b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitulo(rs.getString("titulo"));
                b.setAutor(rs.getString("autor"));
                b.setPreco(rs.getDouble("preco"));
                
                listaBook.add(b);      
            }
            
         
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return listaBook;
    
    
    }
    /**
     * Retorna um produto da tabela produto 
     * @param id Identificação do Produto
     * @return 
     */
    public Book getResultById (int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Book b = null;
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitulo(rs.getString("titulo"));
                b.setAutor(rs.getString("autor"));
                b.setPreco(rs.getDouble("preco"));
            }
            
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
        } finally {
            //Encerra a conexão com o baanco e o statement
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        
        return b;
        
    }
    
    public void update (Book b){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
         
         
         
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, b.getAutor());
            stmt.setString(2, b.getTitulo());
            stmt.setDouble(3, b.getPreco());
            stmt.setDouble(4, b.getId());
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO, null,
                    "Update: " + auxRetorno);
            
            
            
            
        } catch (SQLException sQLException) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
            
        } finally {
            //Encerra a conexão com o banco e o statemnent.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    
    
    
    public void delete (int id){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(BookDAO.class.getName()).log(Level.INFO, null,
                    "Delete: " + auxRetorno);
            
            
            
            
        } catch (SQLException sQLExcepton) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null,
                    sQLExcepton);
        } finally {
            //Encerra a conexão com o banco e o statemnent.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    
    
    
    
    
    
    
}
