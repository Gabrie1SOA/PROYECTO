import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ELIMINAR extends JFrame{
    private JTextField idbookD;
    private JButton deletebuttonD;
    private JButton backbuttonD;
    private JPanel panelDELETE;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void eliminar() throws SQLException {
        String idD = idbookD.getText();

        Connection conex= conexion();
        String query = "DELETE FROM libros WHERE Id_Libro = ?;";

        // try ya que no sabemos si el registro puede eliminarse
        try (PreparedStatement pst = conex.prepareStatement(query)) {
            pst.setString(1, idD);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro eliminado");
        }
    }


    public ELIMINAR (){
        super("DELETE");
        setSize(300,300);
        setContentPane(panelDELETE);

        backbuttonD.addActionListener(new ActionListener() {
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
        deletebuttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
