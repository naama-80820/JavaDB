package dao;

import dao.PersonDAO;
import db_manager.ConnectionPool;
import entities.LoginDetails;
import entities.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAODB implements PersonDAO {

    ConnectionPool pool = ConnectionPool.getInstance();

    public PersonDAODB() throws SQLException, ClassNotFoundException {
    }


    @Override
    public boolean IsExistById(int id) throws SQLException {
        String query = "SELECT EXISTS (SELECT * FROM  mydb.person WHERE id ="+id+")";
        ResultSet rs = pool.runGetQuery(query);
        rs.next();
        return rs.getBoolean(1);
    }

    @Override
    public boolean IsExistByUserNameAndPassword(String userName, String password) throws SQLException {
        String query = "SELECT EXISTS (SELECT * FROM  mydb.person WHERE userName ="+userName+" and password = "+password+")";
        ResultSet rs = pool.runGetQuery(query);
        rs.next();
        return rs.getBoolean(1);
    }

    @Override
    public int Add(Person newPerson) throws SQLException {
        String query = "INSERT INTO mydb.person (name,age,gender, date_of_birth, user_name, password) " +
        "VALUES ('"+newPerson.getName()+"',"+newPerson.getAge()+","+newPerson.getGender()+",'"+newPerson.getDateOfBirth()+ "','"
        +newPerson.getLoginDetails().getUserName()+"','" +newPerson.getLoginDetails().getPassWord()+"')";
        return pool.runInsertQuerry(query);
    }

    @Override
    public void Update(Person p) throws SQLException {
        String query = "UPDATE mydb.person\n" +
                "SET name = '"+p.getName()+"', age ="+p.getAge()+", gender = "+p.getGender()+", date_of_birth = '"+p.getDateOfBirth()+"', user_name = '"+p.getLoginDetails().getUserName()+"', password = '"+p.getLoginDetails().getPassWord()+"'\n" +
                "WHERE id = "+p.getId()+";";
        pool.runUpdateQuerry(query);
    }

    @Override
    public void Delete(int id) throws SQLException {
        String query = "DELETE FROM mydb.person WHERE id = " + id;
        pool.runDeleteQuerry(query);
    }

    @Override
    public Person GetById(int id) throws SQLException {
        String query = "SELECT * FROM mydb.person WHERE id ="+ id;
        ResultSet rs = pool.runGetQuery(query);
        rs.next();
        return new Person(rs.getInt(1),rs.getString(2), rs.getInt(3),
                rs.getBoolean(4), rs.getDate(5).toLocalDate(),
                new LoginDetails(rs.getString(6), rs.getString(7)));
    }

    @Override
    public Person GetByUserNameAndPassword(String userName, String password) throws SQLException {
        String query = "SELECT * FROM mydb.person WHERE userName ="+userName+" and password ="+ password;
        ResultSet rs = pool.runGetQuery(query);
        rs.next();
        return new Person(rs.getInt(1),rs.getString(2), rs.getInt(3),
                rs.getBoolean(4), rs.getDate(5).toLocalDate(),
                new LoginDetails(rs.getString(6), rs.getString(7)));
    }

    @Override
    public  ArrayList<Person> GetAll() throws SQLException {
        ArrayList<Person> personList = new ArrayList<Person>();
        String query = "SELECT * FROM mydb.person";
        ResultSet rs = pool.runGetQuery(query);
        while(rs.next())
        {
            personList.add(new Person(rs.getInt(1),rs.getString(2), rs.getInt(3),
                    rs.getBoolean(4), rs.getDate(5).toLocalDate(),
                    new LoginDetails(rs.getString(6), rs.getString(7))));
        }
        return personList;
    }
}
