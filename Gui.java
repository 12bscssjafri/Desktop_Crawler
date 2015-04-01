/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filesearch;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;

public class QuitButtonEx extends JFrame {

    public QuitButtonEx(FileSearch T1) {

        initUI(T1);
    }

    private void initUI(final FileSearch T1) {

        JButton quitButton = new JButton("Quit");

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                T1.file_exists("haha.txt");
                
                
                JTextArea path=new JTextArea("my text area");
                
                JButton quitButton2 = new JButton("yesss");
                createLayout(path);
                createLayout(quitButton2);
                setSize(300, 200);
             setLocationRelativeTo(null);
             setDefaultCloseOperation(EXIT_ON_CLOSE);
                //System.exit(0);
            }
        });

        createLayout(quitButton);

        setTitle("File Explorer");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

    public static void main(String[] args) {

        final FileSearch T1 = new FileSearch( "d t");
                
                
		T1.start();
                for(int i=0;i<1000000;i++){}
                if(T1.file_exists("haha.txt")){
                System.out.println("mubarak ho mil gayeeeee!!!!");
                }
                
                
        
        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                QuitButtonEx ex;
                ex = new QuitButtonEx(T1);
                ex.setVisible(true);
            }
        });
    }
}
