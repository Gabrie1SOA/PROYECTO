import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("LOGIN");
                LOGIN login = new LOGIN();
                frame.setContentPane(login.getContentPane());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                dispose();
            }
        });

        createbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("CREAR");
                CREAR crear = new CREAR();
                frame.setContentPane(crear.getContentPane());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

                dispose();

            }
        });
    }
}
