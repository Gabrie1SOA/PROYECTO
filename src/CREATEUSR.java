import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CREATEUSR extends JFrame {
    private JPanel crearusuario;
    private JTextField userCU;
    private JTextField contraCU;
    private JTextField typeCU;
    private JButton registrarbuttonCU;
    private JButton regresarButtonCU;
    private JButton ELIMINARButton;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void insertar() throws SQLException{
        String usrCU = userCU.getText();
        String passCU = contraCU.getText();
        String typeCu = typeCU.getText();

        Connection conex = conexion();

        String query= "INSERT INTO Usuarios (Usuario,contraseña,tipo) VALUES (?,?,?);";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, usrCU);
        pstm.setString(2, passCU);
        pstm.setString(3, typeCu);

        //Actualizamos
        int rowsAffected= pstm.executeUpdate();

        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null, "Cuenta creada");
        }

        pstm.close();
        conex.close();


    }

    public void eliminar() throws SQLException{
        String usrCU = userCU.getText();


        Connection conex = conexion();

        String query= "DELETE FROM Usuarios WHERE Usuario = ?;";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, usrCU);


        //Actualizamos
        int rowsAffected= pstm.executeUpdate();

        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null, "Cuenta eliminada");
        }

        pstm.close();
        conex.close();


    }


    public CREATEUSR() {


        setSize(300, 300);
        setContentPane(crearusuario);

        registrarbuttonCU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        regresarButtonCU.addActionListener(new ActionListener() {
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
        ELIMINARButton.addActionListener(new ActionListener() {
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
