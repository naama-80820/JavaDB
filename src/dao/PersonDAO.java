package dao;
import entities.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDAO {
    public boolean IsExistById(int id) throws SQLException;
    public boolean IsExistByUserNameAndPassword(String userName, String password) throws SQLException;
    public int Add(Person newPerson) throws SQLException;
    public void Update(Person p) throws SQLException;
    public void Delete(int id) throws SQLException;
    public Person GetById(int id) throws SQLException;
    public Person GetByUserNameAndPassword(String userName, String password) throws SQLException;
    public ArrayList<Person> GetAll() throws SQLException;
}
