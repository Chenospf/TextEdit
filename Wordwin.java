/**
 * Created by chentao on 2017/4/11.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Calendar;
public class Wordwin extends JFrame implements DocumentListener {
    private static final long serialVersionUID = 1L;
    JMenuBar menubar=new JMenuBar();
    JLabel information = new JLabel("无");
    JMenu file=new JMenu("文件");
    JMenu edit=new JMenu("编辑");
    JMenu geshi=new JMenu("格式");
    JMenu language =new JMenu("语言:无");
    JMenu help =new JMenu("帮助");
    JTextPane wordArea=new JTextPane();
    JScrollPane imgScrollPane = new JScrollPane(wordArea);
    String [] str1={"新建","打开","保存","页面设置","打印","退出"};
    String [] str2={"剪切","复制","粘贴","查找","替换","插入时间"};
    String [] str3={"字体","自动换行"};
    String [] str4={"C","JAVA","python","php","二进制"};
    String [] str5={"联系开发者","版本信息"};
    Font f1=new Font("隶书",Font.PLAIN,15);
    Search d1=new Search();
    Font1 z1=new Font1();
    Change c1=new Change();
    Language L1=new Language();
    int flag=0;
    String source="";
    PopupMenu pMenu=new PopupMenu();    //创建弹出式菜单，下面三项是菜单项
    MenuItem mItemCopy=new MenuItem("复制");
    MenuItem mItemPaste=new MenuItem("粘贴");
    MenuItem mItemCut=new MenuItem("剪切");
    MouseAdapter mouseAdapter=new MouseAdapter()//监听鼠标事件
    {
        public void mouseClicked(MouseEvent event)
        {
            if(event.getButton()==MouseEvent.BUTTON3)//只响应鼠标右键单击事件
            {
                pMenu.show(wordArea,event.getX(),event.getY());//在鼠标位置显示弹出式菜单
            }
        }
    };
    ActionListener menuAction=new ActionListener()//响应单击菜单项的事件，只是示例，
    {//具体内容可自己编写
        public void actionPerformed(ActionEvent e)
        {
            MenuItem item=(MenuItem)e.getSource();
            if(item==mItemCopy) //单击了“复制”菜单项
            {
                wordArea.copy();
            }
            else if(item==mItemPaste)  //“粘贴”菜单项
            {
                wordArea.paste();

            }
            else
            {
                wordArea.cut();
            }
        }
    };
    public static void main(String[] args) {
        JFrame wordwin=new Wordwin();
        wordwin.setVisible(true);
    }
    public Wordwin(){
        c1.set(wordArea);
        d1.set(wordArea);
        setTitle("文本编辑器Pro");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();//获取屏幕分辨率
        setSize(screenSize.width/2,screenSize.height/2);//大小
        setLocation(screenSize.width/4,screenSize.height/4);//位置
        add(imgScrollPane,BorderLayout.CENTER);
        setJMenuBar(menubar);
        file.setFont(f1);
        edit.setFont(f1);
        geshi.setFont(f1);
        language.setFont(f1);
        help.setFont(f1);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(geshi);
        menubar.add(language);
        menubar.add(help);
        wordArea.getDocument().addDocumentListener(this);
        wordArea.add(pMenu);
        wordArea.addMouseListener(mouseAdapter);  //文本框加入鼠标监听器
        pMenu.add(mItemCopy);  //菜单项的单击事件监听器
        mItemCopy.addActionListener(menuAction);
        pMenu.add(mItemPaste);
        mItemPaste.addActionListener(menuAction);
        pMenu.add(mItemCut);
        mItemCut.addActionListener(menuAction);
        for(int i=0;i<str1.length;i++){
            JMenuItem item1= new JMenuItem(str1[i]);
            item1.addActionListener(new MyActionListener1());
            item1.setFont(f1);
            file.add(item1);
        }
        for(int i=0;i<str2.length;i++){
            JMenuItem item2= new JMenuItem(str2[i]);
            item2.addActionListener(new MyActionListener1());
            item2.setFont(f1);
            edit.add(item2);
        }
        for(int i=0;i<str3.length;i++){
            JMenuItem item3= new JMenuItem(str3[i]);
            item3.addActionListener(new MyActionListener1());
            item3.setFont(f1);
            geshi.add(item3);
        }
        for(int i=0;i<str4.length;i++){
            JMenuItem item4= new JMenuItem(str4[i]);
            item4.addActionListener(new MyActionListener1());
            item4.setFont(f1);
            language.add(item4);
        }
        for(int i=0;i<str5.length;i++){
            JMenuItem item5= new JMenuItem(str5[i]);
            item5.addActionListener(new MyActionListener1());
            item5.setFont(f1);
            help.add(item5);
        }
    }
    public void changedUpdate(DocumentEvent e) {
        flag=1;
    }
    public void insertUpdate(DocumentEvent e) {
        flag=1;
    }
    public void removeUpdate(DocumentEvent e) {
        flag=1;
    }
    void open(){
        FileDialog  filedialog=new FileDialog(this,"打开",FileDialog.LOAD);
        filedialog.setVisible(true);
        String path=filedialog.getDirectory();
        String name=filedialog.getFile();
        if(path!=null && name!=null){
            FileInputStream file = null;
            try {
                file = new FileInputStream(path+name);
            } catch (FileNotFoundException e) {

            }
            InputStreamReader put =new InputStreamReader(file);
            BufferedReader in=new BufferedReader(put);
            String temp="";
            String now = null;
            try {
                now = (String)in.readLine();
            } catch (IOException e) {

                e.printStackTrace();
            }
            while(now!=null){
                temp+=now+"\r\n";
                try {
                    now=(String)in.readLine();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

            wordArea.setText(temp);
        }

    }
    void save(){
        FileDialog  filedialog=new FileDialog(this,"保存",FileDialog.SAVE);
        filedialog.setVisible(true);
        if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
            OutputStreamWriter out = null;
            try {
                out = new OutputStreamWriter(new FileOutputStream(filedialog.getDirectory()+filedialog.getFile()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                out.write(wordArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag=0;
            try {
                out.close();
                source=wordArea.getText();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void newfile(){
        if(flag==0){
            wordArea.setText("");
        }
        if(flag==1){
            int m=  JOptionPane.showConfirmDialog(this,"是否保存该文件");
            if(m==0){
                save();
                wordArea.setText("");
            }

            if(m==1){
                //System.exit(0);
                wordArea.setText("");
                flag=0;
            }
        }
    }
    void exit(){
        if(flag==0){
            System.exit(0);
        }
        if(flag==1){
            int m=  JOptionPane.showConfirmDialog(this,"是否保存该文件");
            if(m==0){
                save();
            }
            if(m==1){
                System.exit(0);
            }
        }
    }
    class MyActionListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()instanceof JMenuItem){
                if(e.getActionCommand()=="剪切"){
                    wordArea.cut();
                }
                if(e.getActionCommand()=="复制"){
                    wordArea.copy();
                }
                if(e.getActionCommand()=="粘贴"){
                    wordArea.paste();
                }
                if(e.getActionCommand()=="查找"){
                    d1.setVisible(true);
                }
                if(e.getActionCommand()=="字体"){
                    z1.set(wordArea,wordArea.getSelectedText(),wordArea.getSelectionStart(),wordArea.getSelectionEnd());
                    z1.setVisible(true);
                }
                if(e.getActionCommand()=="替换"){
                    c1.setVisible(true);
                }
                if(e.getActionCommand()=="插入时间"){
                    Datee dd =new Datee();
                    dd.set(wordArea,wordArea.getSelectionStart());
                    dd.setVisible(true);
                }
                if(e.getActionCommand()=="打开"){
                    open();
                }
                if(e.getActionCommand()=="保存"){
                    save();
                }
                if(e.getActionCommand()=="新建"){
                    newfile();
                }
                if(e.getActionCommand()=="退出"){
                    exit();
                }
                if(e.getActionCommand()=="C"){
                    //C语法设置
                    language.setText("语言：C");
                    L1.Language_C();
                }
                if(e.getActionCommand()=="JAVA"){
                    //JAVA语法设置
                    language.setText("语言：JAVA");
                    L1.Language_JAVA();
                }
                if(e.getActionCommand()=="python"){
                    //python语法设置
                    language.setText("语言：python");
                    L1.Language_python();
                }
                if(e.getActionCommand()=="php"){
                    //php语法设置
                    language.setText("语言：php");
                    L1.Language_php();
                }
                if(e.getActionCommand()=="二进制"){
                    //二进制语法设置
                    language.setText("语言：二进制");
                    L1.Language_erjinzhi();
                }
                if(e.getActionCommand()=="联系开发者"){
                    JOptionPane.showMessageDialog(null,"开发者：B14040723 陈涛\n开发者邮箱:ospfchen@foxmail.com");
                }
                if(e.getActionCommand()=="版本信息"){
                    JOptionPane.showMessageDialog(null,"文本编辑器Pro 版本1.0");
                }
            }

        }

    }
}
