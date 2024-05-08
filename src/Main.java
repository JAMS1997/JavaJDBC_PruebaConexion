import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet MyRes = null;
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            System.out.println("Conexion exitosa");

            myStamt = myConn.createStatement();
            MyRes = myStamt.executeQuery("SELECT * FROM employees");

            while (MyRes.next()){
                System.out.println(MyRes.getString("first_name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Algo salio mal :(");
        }
    }
}