///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package contactlist;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.derby.jdbc.ClientDriver;
//
///**
// *
// * @author AhmedWard
// */
//// todo: no sync between next and last and prev and 
//public class DBHandler {
//
//    private Connection connection;
//    private PreparedStatement pst;
//    private ResultSet rs;
//
//    public DBHandler() {
//
//        try {
//            DriverManager.registerDriver(new ClientDriver());
//            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Contact", "root", "root");
//            pst = connection.prepareStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            rs = pst.executeQuery("select * from Contact");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public Contact getFirst() throws SQLException {
//        if (rs.first()) {
//            int id = rs.getInt("id");
//            String fN = rs.getString("FirstName");
//            String lN = rs.getString("LastName");
//            String mN = rs.getString("MiddleName");
//            String email = rs.getString("email");
//            String phone = rs.getString("phone");
//            return new Contact(id, fN, mN, lN, email, phone);
//        }
//        return null;
//    }
//
//    public Contact getLast() throws SQLException {
//        if (rs.last()) {
//            int id = rs.getInt("id");
//            String fN = rs.getString("FirstName");
//            String lN = rs.getString("LastName");
//            String mN = rs.getString("MiddleName");
//            String email = rs.getString("email");
//            String phone = rs.getString("phone");
//            return new Contact(id, fN, mN, lN, email, phone);
//        }
//        return null;
//    }
//
//    public Contact getNext() throws SQLException {
//        if (rs.next()) {
//            int id = rs.getInt("id");
//            String fN = rs.getString("FirstName");
//            String lN = rs.getString("LastName");
//            String mN = rs.getString("MiddleName");
//            String email = rs.getString("email");
//            String phone = rs.getString("phone");
//            return new Contact(id, fN, mN, lN, email, phone);
//        }
//        return null;
//    }
//
//    public Contact getPrevious() throws SQLException {
//
//        if (rs.previous()) {
//            int id = rs.getInt("id");
//            String fN = rs.getString("FirstName");
//            String lN = rs.getString("LastName");
//            String mN = rs.getString("MiddleName");
//            String email = rs.getString("email");
//            String phone = rs.getString("phone");
//            return new Contact(id, fN, mN, lN, email, phone);
//        }
//        return null;
//    }
//
//    public void update(Contact contact) throws SQLException {
//        
//        pstUpdater = connection.prepareStatement("UPDATE Contact SET FirstName = ?, MiddleName = ?, LastName = ?, Email = ?, Phone = ? WHERE ID = ?",
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_READ_ONLY);
//
//        pstUpdater.setString(1, contact.FN);
//        pstUpdater.setString(2, contact.MN);
//        pstUpdater.setString(3, contact.LN);
//        pstUpdater.setString(4, contact.Email);
//        pstUpdater.setString(5, contact.phone);
//        pstUpdater.setInt(6, contact.id);
//        pstUpdater.executeUpdate();
//
//    }
//
//    public void delete(int id) throws SQLException {
//        pstDeleter = connection.prepareStatement("DELETE FROM Contact WHERE Id = ?",
//                ResultSet.TYPE_SCROLL_INSENSITIVE,
//                ResultSet.CONCUR_READ_ONLY);
//        pstDeleter.setInt(1, id);
//        pstDeleter.executeUpdate();
//
//    }
//    
//    public void insertData(Contact contact) throws SQLException{
//    PreparedStatement pst = connection.prepareStatement("INSERT INTO Contact (id,firstName, middleName, lastName, Email, Phone) VALUES (?,?, ?, ?, ?, ?)");
//            pst.setInt(1, contact.id);
//            pst.setString(2, contact.FN);
//            pst.setString(3, contact.MN);
//            pst.setString(4, contact.LN);
//            pst.setString(5, contact.Email);
//            pst.setString(6, contact.phone);
//            pst.executeUpdate();
//        
//    }
//
//}
