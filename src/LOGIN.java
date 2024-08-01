import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JFrame{
    private JLabel label;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JButton LOGINButton;
    private JPanel panel1;

    public LOGIN() {

        setSize(300,300);
        setContentPane(panel1);


        LOGINButton.addActionListener(new ActionListener() {
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
