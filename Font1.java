/**
 * Created by chentao on 2017/4/11.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Font1 extends JDialog implements ItemListener{
    private static final long serialVersionUID = 1L;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JComboBox font = new JComboBox();
    JComboBox comboBox2 = new JComboBox();
    JComboBox comboBox3 = new JComboBox();
    JLabel lab1=new JLabel("字体：");
    JLabel lab2=new JLabel("字形：");
    JLabel lab3=new JLabel("字号：");
    JLabel lab4=new JLabel("预览");
    String name=new String("宋体");
    Font f1=new Font("隶书",Font.PLAIN,15);
    int style=1;
    int size=12;
    String []array2=new String[]{"常规","倾斜","加粗","倾斜加粗"};
    String []array3=new String[]{"14","15","16","17","18","19","20"};
    GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
    String [] fontName=ge.getAvailableFontFamilyNames();
    JButton b1=new JButton("确定");
    JButton b2=new JButton("颜色");
    JTextPane a1=new JTextPane();
    JTextPane a2=new JTextPane();
    int start1,end1;
    Color fontcolor;
    void set(JTextPane n,String x,int s,int e){
        a2.setText(x);
        start1=s;
        end1 =e;
        a1=n;
    }
    public Font1(){
        setTitle("字体");
        setSize(400,400);
        setLayout(new FlowLayout());
        lab1.setFont(f1);
        lab2.setFont(f1);
        font.setModel(new DefaultComboBoxModel(fontName));
        font.setFont(f1);
        for(int i=1;i<fontName.length;i++){
            font.setSelectedItem(fontName);
        }
        comboBox2.setModel(new DefaultComboBoxModel(array2));
        comboBox2.setFont(f1);
        for(int i=1;i<array2.length;i++){
            comboBox2.setSelectedItem(array2);
        }
        comboBox3.setModel(new DefaultComboBoxModel(array3));
        comboBox3.setFont(f1);
        for(int i=1;i<array3.length;i++){
            comboBox2.setSelectedItem(array3);
        }
        panel1.add(lab1);
        panel1.add(font);
        panel2.add(lab2);
        panel2.add(comboBox2);
        panel3.add(lab3);
        panel3.add(comboBox3);
        panel5.add(b2);
        panel4.add(b1);
        panel6.add(lab4);
        panel6.add(a2);
        b2.addActionListener(new MyActionListener3());
        font.addItemListener(this);
        comboBox2.addItemListener(this);
        comboBox3.addItemListener(this);
        b1.addActionListener(new MyActionListener3());
        this.setLayout(new GridLayout(6, 1));//网格式布局
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel5);
        add(panel4);
        add(panel6);
    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==font){
            name=font.getSelectedItem().toString();
            Font f=new Font(name,style,size);
            a2.setFont(f);
        }
        if(e.getSource()==comboBox2){
            String s1=comboBox2.getSelectedItem().toString();
            if(s1.equals("加粗")){
                style=Font.BOLD;
                Font f=new Font(name,style,size);
                a2.setFont(f);
            }
            if(s1.equals("倾斜")){
                style=Font.ITALIC;
                Font f=new Font(name,style,size);
                a2.setFont(f);
            }
            if(s1.equals("常规")){
                style=Font.PLAIN;
                Font f=new Font(name,style,size);
                a2.setFont(f);
            }
            if(s1.equals("倾斜加粗")){
                style=(Font.BOLD)+(Font.ITALIC);
                Font f=new Font(name,style,size);
                a2.setFont(f);
            }
        }
        if(e.getSource()==comboBox3){
            String s2=comboBox3.getSelectedItem().toString();
            size=Integer.parseInt(s2);
            Font f=new Font(name,style,size);
            a2.setFont(f);
        }

    }
    class MyActionListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e2) {
            if (e2.getActionCommand()=="确定"){
                Font f=new Font(name,style,size);
                a1.setFont(f);
                a1.setForeground(fontcolor);
                setVisible(false);
            }
            if(e2.getActionCommand()=="颜色"){
                setcolor();
                a2.setForeground(fontcolor);
            }
        }
    }
    void setcolor(){
        fontcolor=JColorChooser.showDialog(this,"字体颜色选择",a1.getForeground());
    }
}

