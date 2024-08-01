import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CREAR extends JFrame{
    private JTextField namebookT;
    private JTextField autorbookT;
    private JButton backbuttonC;
    private JTextField idbookT;
    private JPanel panelCREATE;
    private JButton ingresarbuttonC;

    public Connection conexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/libroconnect";
        String user = "root";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }

    public void insertar() throws SQLException{
        String idC = idbookT.getText();
        String nameC = namebookT.getText();
        String autorC = autorbookT.getText();

        Connection conex = conexion();

        String query= "INSERT INTO libros (Id_Libro,Nombre_Libro,Autor) VALUES (?,?,?);";

        PreparedStatement pstm = conex.prepareStatement(query);
        pstm.setString(1, idC);
        pstm.setString(2, nameC);
        pstm.setString(3, autorC);

        //Actualizamos
        int rowsAffected= pstm.executeUpdate();

        if(rowsAffected>0){
            JOptionPane.showMessageDialog(null, "Registro insertado");
        }

        pstm.close();
        conex.close();


    }

    public CREAR (){
        super("CREAR");
        setSize(300,300);
        setContentPane(panelCREATE);


        ingresarbuttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
