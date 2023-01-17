/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author AhmedWard
 */
// todo: no sync between next and last and prev and 
public class DataBaseHandler {

    private Connection connection;
    private PreparedStatement pstGetter;

    private PreparedStatement pstUpdater;

    private PreparedStatement pstDeleter;
    private ResultSet rs;

    
    ResultSet rsMaximum;
    private PreparedStatement pstMaxId;

    public DataBaseHandler() {

        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Contact", "root", "root");
            pstGetter = connection.prepareStatement("select * from Contact", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            pstMaxId = connection.prepareStatement("select Max(id)  as lastId from Contact", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = pstGetter.executeQuery();
            rsMaximum = pstMaxId.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Contact getFirst() throws SQLException {
        if (rs.first()) {
            int id = rs.getInt("id");
            String fN = rs.getString("FirstName");
            String lN = rs.getString("LastName");
            String mN = rs.getString("MiddleName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            return new Contact(id, fN, mN, lN, email, phone);
        }
        return null;
    }

    public Contact getLast() throws SQLException {
        if (rs.last()) {
            int id = rs.getInt("id");
            String fN = rs.getString("FirstName");
            String lN = rs.getString("LastName");
            String mN = rs.getString("MiddleName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            return new Contact(id, fN, mN, lN, email, phone);
        }
        return null;
    }

    public Contact getNext() throws SQLException {
        if (rs.next()) {
            int id = rs.getInt("id");
            String fN = rs.getString("FirstName");
            String lN = rs.getString("LastName");
            String mN = rs.getString("MiddleName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            return new Contact(id, fN, mN, lN, email, phone);
        }
        if(rs.isAfterLast()){
            rs.previous();
        }
        return null;
    }

    public Contact getPrevious() throws SQLException {

        if (rs.previous()) {
            int id = rs.getInt("id");
            String fN = rs.getString("FirstName");
            String lN = rs.getString("LastName");
            String mN = rs.getString("MiddleName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            return new Contact(id, fN, mN, lN, email, phone);
        }
        if(rs.isBeforeFirst()){
            rs.next();
        }
        return null;
    }

    /**
     *
     * @param contact
     * @throws SQLException
     */
    public void updateDB(Contact contact) throws SQLException {

        pstUpdater = connection.prepareStatement("UPDATE Contact SET FirstName = ?, MiddleName = ?, LastName = ?, Email = ?, Phone = ? WHERE ID = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        pstUpdater.setString(1, contact.FN);
        pstUpdater.setString(2, contact.MN);
        pstUpdater.setString(3, contact.LN);
        pstUpdater.setString(4, contact.Email);
        pstUpdater.setString(5, contact.phone);
        pstUpdater.setInt(6, contact.id);
        pstUpdater.executeUpdate();
        rs = pstGetter.executeQuery();

    }

    public void delete(int id) throws SQLException {
        pstDeleter = connection.prepareStatement("DELETE FROM Contact WHERE Id = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        pstDeleter.setInt(1, id);
        pstDeleter.executeUpdate();

        rs = pstGetter.executeQuery();
        rsMaximum = pstMaxId.executeQuery();

    }

    public void insertData(Contact contact) throws SQLException {
        PreparedStatement pst = connection.prepareStatement("INSERT INTO Contact (id,firstName, middleName, lastName, Email, Phone) VALUES (?,?, ?, ?, ?, ?)");
        pst.setInt(1, contact.id);
        pst.setString(2, contact.FN);
        pst.setString(3, contact.MN);
        pst.setString(4, contact.LN);
        pst.setString(5, contact.Email);
        pst.setString(6, contact.phone);
        pst.executeUpdate();

        rs = pstGetter.executeQuery();
        rsMaximum = pstMaxId.executeQuery();

    }

    public int getLastId() throws SQLException {
        rsMaximum = pstMaxId.executeQuery();
        rsMaximum.next();
        return rsMaximum.getInt("lastId");
    }
    
    public ResultSet getResultSet() {
        return rs;
    }

}
