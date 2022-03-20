package chapter2.StudentDAO.daoIMP;

import bean.Student;
import dao.StudentDAO;

import java.sql.*;

import chapter2.StudentDAO.connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO {
  public void insert(Student s) {
    String sql = "INSERT INTO student (id, name) values (?,?)";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    try {
      conn = new DataBaseConnection();

      pstmt = conn.getConnection().prepareStatement(sql);
      pstmt.setLong(1, s.getID());
      pstmt.setString(2, s.getName());

      pstmt.executeUpdate();
      pstmt.close();
      conn.close();
    } catch (Exception e) {
    }
  }

  public void update(Student s) {
    String sql = "UPDATE student SET name = ? WHERE id = ?";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    try {
      conn = new DataBaseConnection();

      pstmt = conn.getConnection().prepareStatement(sql);
      pstmt.setString(1, s.getName());
      pstmt.setLong(2, s.getID());

      pstmt.executeUpdate();
      pstmt.close();
      conn.close();
    } catch (Exception e) {

    }
  }

  public void delete(String iD) {
    String sql = "DELETE FROM student WHERE id = ?";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    try {
      conn = new DataBaseConnection();

      pstmt = conn.getConnection().prepareStatement(sql);
      pstmt.setLong(1, s.getID());

      pstmt.executeUpdate();
      pstmt.close();
      conn.close();
    } catch (Exception e) {

    }

  }

  public List findAll() {
    String sql = "SELECT * FROM student";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    try {
      conn = new DataBaseConnection();

      pstmt = conn.getConnection().prepareStatement(sql);
      List<Student> stuList = pstmt.executeQuery();
      pstmt.close();
      conn.close();
      return stuList;
    } catch (Exception e) {

    }
  }

  public Student findByID(long id) {
    String sql = "SELECT * FROM student WHERE id = ?";
    PreparedStatement pstmt = null;
    DataBaseConnection conn = null;
    try {
      conn = new DataBaseConnection();

      pstmt = conn.getConnection().prepareStatement(sql);
      pstmt.setLong(1, s.getLong());
      Student stu = pstmt.executeQuery();
      pstmt.close();
      conn.close();
      return stu;
    } catch (Exception e) {

    }
  }

}
