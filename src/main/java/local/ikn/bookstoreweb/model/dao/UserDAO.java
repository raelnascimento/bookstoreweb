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
import local.ikn.bookstoreweb.model.bean.User;


public class UserDAO {
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    private static final String SQL_SELECT_AUTHENTIC = "SELECT * FROM user "
            + "WHERE email = ? AND password = ?";
    private static final String SQL_INSERT = "INSERT INTO user (email, password, fullname) VALUES (?, ?, ?)";
    
    private static final String SQL_SELECT_ID = "SELECT * FROM user  WHERE id = ?";
    
    private static final String SQL_UPDATE = "UPDATE user SET email = ?,"
            + "password = ?, fullname = ? "
            + "WHERE id = ?";
    
    private static final String SQL_DELETE = "DELETE FROM user WHERE id = ?";
    
    /**
     * Insere um usuario na base de dados Produto
     * @param p 
     */
    public void create (User u){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = conn.prepareStatement (SQL_INSERT);
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getFullname());
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO,null,
                    "Inclusao: " + auxRetorno);

        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null,
                sQLException);
        } finally {
            // Encerrra a conexão com o banco e o statement
            MySQLConnection.closeConnection(conn, stmt);
        }
    }

    /**
     * Retorna todos os registros da tauela prodto
     * @return 
     */
    public  List<User> getResults(){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        List<User> listaUser = null;
        
        try {
            // Prepara a string de SELECT e executa a query.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            
            
            //Carrega os daods do Result rs, converte em Produto e
            // adiciona na lista de retorno 
            listaUser = new ArrayList<>();
            
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullname(rs.getString("fullname"));
                
                listaUser.add(u);      
            }
            
         
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return listaUser;
    
    
    }
    /**
     * Retorna um produto da tabela produto 
     * @param id Identificação do Produto
     * @return 
     */
    public User getResultById (int id) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullname(rs.getString("fullname"));
            }
            
        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
        } finally {
            //Encerra a conexão com o baanco e o statement
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        
        return u;
        
    }
    
    public void update (User u){
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
         
         
         
        try {
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getFullname());
            
            //Executa a query
            int auxRetorno = stmt.executeUpdate();
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null,
                    "Update: " + auxRetorno);
            
            
            
            
        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
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
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, null,
                    "Delete: " + auxRetorno);
            
            
            
            
        } catch (SQLException sQLExcepton) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLExcepton);
        } finally {
            //Encerra a conexão com o banco e o statemnent.
            MySQLConnection.closeConnection(conn, stmt);
        }
    }
    
    public User checkLogin(String email, String password) {
        Connection conn = MySQLConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;
        
        try {
            stmt = conn.prepareStatement(SQL_SELECT_AUTHENTIC);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFullname(rs.getString("fullname"));
            }
            
        } catch (SQLException sQLException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
                    sQLException);
        } finally {
            //Encerra a conexão com o baanco e o statement
            MySQLConnection.closeConnection(conn, stmt, rs);
        }
        
        return u;
        
        
        
    }
}
