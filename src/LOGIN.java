import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LOGIN extends JFrame{
    private JLabel label;
    private JTextField usuario;
    private JTextField pass;
    private JLabel label2;
    private JLabel label3;
    private JButton LOGINButton;
    private JPanel panel1;


    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void logeo() throws SQLException {
        String user =usuario.getText();
        String password = pass.getText();
        String tipo;

        Connection conex = conexion();

        String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, user);
        pstm.setString(2, password);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            user = rs.getString("usuario");
            password = rs.getString("contraseña");
            tipo=rs.getString("tipo");

            if (tipo.equals("administrador")) {
                JFrame frame = new JFrame("MENU");
                MENU menu = new MENU();
                frame.setContentPane(menu.getContentPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }

            if (tipo.equals("usuario")) {
                JFrame frame = new JFrame("BUSCAR");
                LEER leer = new LEER();
                frame.setContentPane(leer.getContentPane());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA");
        }

    }



    public LOGIN() {

        setSize(300,300);
        setContentPane(panel1);


        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    logeo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
    }


}
