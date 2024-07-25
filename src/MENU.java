import javax.swing.*;

public class MENU extends JFrame{

    private JLabel text1;
    private JPanel panelmenu;
    private JButton createbutton;
    private JButton readbutton;
    private JButton updatebutton;
    private JButton deletebutton;
    private JButton backButton;

    public MENU (){
        super("LibroConnect");
        setSize(300,300);
        setContentPane(panelmenu);
    }
}
