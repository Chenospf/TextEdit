/**
 * Created by chentao on 2017/4/11.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Search extends JDialog{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLabel l1=new JLabel("查找内容");
    JPanel jp1=new JPanel();
    JPanel jp2 = new JPanel();
    JTextPane jt1=new JTextPane();
    JTextField search=new JTextField(10);
    JButton b1=new JButton("查找下一个");
    JButton b3=new JButton("查找全部");
    JButton b2=new JButton("取消");
    JTextPane a1=new JTextPane();
    Font f1=new Font("隶书",Font.PLAIN,15);
    void set(JTextPane n){
        a1=n;
    }
    public Search(){
        setTitle("查找");
        setSize(300,100);
        setLayout(new FlowLayout());
        b1.setFont(f1);
        b2.setFont(f1);
        l1.setFont(f1);
        jp1.add(l1);
        jp1.add(search);
        jp2.add(b1);
        jp2.add(b3);
        jp2.add(b2);
        add(jp1);
        add(jp2);
        b1.addActionListener(new MyActionListener1());
        b3.addActionListener(new MyActionListener1());
        b2.addActionListener(new MyActionListener1());
    }
    class MyActionListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
            int m;
            String source=a1.getText();
            String find=search.getText();
            if (e1.getActionCommand() == "查找下一个") {
                m=source.indexOf(find,0);
                String s1=source.substring(0,m);
                String s2=source.substring(m+find.length());
                if(m==-1){
                    JOptionPane.showMessageDialog(null,"对不起，没找到您要找的内容！");
                }else{
                    JOptionPane.showMessageDialog(null,"Find！"+m);
                }
            }
            if (e1.getActionCommand() == "查找全部") {

            }
            if (e1.getActionCommand() == "取消") {
                setVisible(false);
            }
        }
    }
}
