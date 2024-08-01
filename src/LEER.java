import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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

    public void leer() throws SQLException {
        String idR= idbookR.getText();

        Connection conex = conexion();
        String query= "SELECT * FROM libros WHERE Id_Libro = ?;";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, idR);

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String id = rs.getString("Id_Libro");
            String name = rs.getString("Nombre_Libro");
            String autor = rs.getString("Autor");

            JOptionPane.showMessageDialog(null, "ID: " + id + "\n" + "Nombre: " + name + "\n" + "Autor: " + autor);

        }
    }

    public LEER () {
        super("READ");
        setSize(300,300);
        setContentPane(panelREAD);


        searchbuttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    leer();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        backbuttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("MENU");
                MENU menu = new MENU();
                frame.setContentPane(menu.getContentPane());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });

    }
}
