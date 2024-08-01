import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ACTUALIZAR extends JFrame{
    private JPanel panelUPDATE;
    private JTextField idbookU;
    private JTextField namebookU;
    private JTextField autorbookU;
    private JButton updatebuttonU;
    private JButton backbuttonU;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void actualizar() throws SQLException {
        String idU = idbookU.getText();
        String nameU = namebookU.getText();
        String autorU = autorbookU.getText();


        Connection conex = conexion();
        String query = "UPDATE libros SET Nombre_Libro = ?, Autor = ? WHERE Id_Libro = ?;";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, nameU);
        pstm.setString(2, autorU);
        pstm.setString(3, idU);

        pstm.executeUpdate();

        JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
    }

    public ACTUALIZAR () {
        super("UPDATE");
        setSize(300,300);
        setContentPane(panelUPDATE);

        updatebuttonU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        backbuttonU.addActionListener(new ActionListener() {
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
