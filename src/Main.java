import dao.PersonDAO;
import dao.PersonDAODB;
import db_manager.ConnectionPool;
import entities.LoginDetails;
import entities.Person;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PersonDAODB personDAODB = new PersonDAODB();
        personDAODB.Add(new Person("esti", 20, false, LocalDate.of(2003,10,30), new LoginDetails("ester", "123")));
        personDAODB.Add(new Person("naama", 19, false, LocalDate.of(2004,9,14), new LoginDetails("nami", "321")));
    }



}