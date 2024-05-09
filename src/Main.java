import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            System.out.println("Conexion exitosa");

        //Actualizar datos
            myStamt = myConn.createStatement();
            int rowsAffected = myStamt.executeUpdate("UPDATE employees " + "set email='johanador@example.com' " + "WHERE first_name = 'Johana'");
            myRes = myStamt.executeQuery("SELECT * FROM employees");
            while (myRes.next()){
                System.out.println(myRes.getString("first_name")+","+ myRes.getString("email"));
            }

        //Borrar Datos
            myStamt = myConn.createStatement();
            int rowsAffected2 = myStamt.executeUpdate("DELETE FROM employees " + "WHERE first_name = 'Johana'");
            System.out.println("empleados");
            myRes = myStamt.executeQuery("SELECT * FROM employees");
            while (myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Algo salio mal :(");
        }
    }
}