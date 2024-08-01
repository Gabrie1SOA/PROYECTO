import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LEER extends JFrame {
    private JButton backbuttonR;
    private JButton searchbuttonR;
    private JTextField idbookR;
    private JPanel panelREAD;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }



    public LEER () {
        super("READ");
        setSize(300,300);
        setContentPane(panelREAD);

    }
}
