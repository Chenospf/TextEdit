import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by chentao on 2017/4/17.
 */
public class Datee extends JFrame{
    JPanel jp = new JPanel();
    JLabel jl = new JLabel("");
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JLabel jll1 = new JLabel();
    JLabel Jll2 = new JLabel();
    JLabel jll3 = new JLabel();
    JLabel jl1 = new JLabel("格式一：");
    JLabel jl2 = new JLabel("格式二：");
    JLabel jl3 = new JLabel("格式三：");
    JButton jb1 = new JButton("插入1");
    JButton jb2 = new JButton("插入2");
    JButton jb3 = new JButton("插入3");
    String year,month,date1,hour,minute,seconds;
    String time;
    int mm;
    JTextPane t1 = new JTextPane();
    void set(JTextPane n,int m)
    {
        t1=n;
        mm=m;
    }
    public Datee()
    {
        settime();
        this.setLayout(new GridLayout(4, 1));//网格式布局
        jp.add(jl);
        jp1.add(jl1);
        jp1.add(jll1);
        jp1.add(jb1);
        jp2.add(jl2);
        jp2.add(Jll2);
        jp2.add(jb2);
        jp3.add(jl3);
        jp3.add(jll3);
        jp3.add(jb3);
        add(jp);
        add(jp1);
        add(jp2);
        add(jp3);
        //add(jp4);
        jb1.addActionListener(new MyActionListener1());
        jb2.addActionListener(new MyActionListener1());
        jb3.addActionListener(new MyActionListener1());
        jl.setText("当前时间："+year+"年"+month+"月"+date1+"日 "+hour+":"+minute+":"+seconds+"");
        jll1.setText("       "+year+"/"+month+"/"+date1+" "+hour+":"+minute+":"+seconds+"      ");
        Jll2.setText(year+"年"+month+"月"+date1+"日 "+hour+"时"+minute+"分"+seconds+"秒");
        jll3.setText("       "+year+"-"+month+"-"+date1+" "+hour+":"+minute+":"+seconds+"      ");
        this.setTitle("时间");//窗体标签
        this.setSize(400, 200);//窗体大小
    }
    public void settime()
    {
        Calendar c =Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH);
        int d = c.get(Calendar.DATE);
        int h = c.get(Calendar.HOUR_OF_DAY);
        int mi = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        year=y+"";
        month=m+"";
        date1=d+"";
        hour=h+"";
        minute=mi+"";
        seconds=s+"";
    }
    class MyActionListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
            if (e1.getActionCommand()=="插入1"){
                time=year+"/"+month+"/"+date1+" "+hour+":"+minute+":"+seconds;
                String s1 = t1.getText().substring(0,mm);
                String s2 =t1.getText().substring(mm,t1.getText().length());
                t1.setText(s1+" "+time+" "+s2);
                setVisible(false);
            }
            if (e1.getActionCommand()=="插入2"){
                time=year+"年"+month+"月"+date1+"日 "+hour+"时"+minute+"分"+seconds+"秒";
                String s1 = t1.getText().substring(0,mm);
                String s2 =t1.getText().substring(mm,t1.getText().length());
                t1.setText(s1+" "+time+" "+s2);
                setVisible(false);
            }
            if (e1.getActionCommand()=="插入3"){
                time=year+"-"+month+"-"+date1+" "+hour+":"+minute+":"+seconds;
                String s1 = t1.getText().substring(0,mm);
                String s2 =t1.getText().substring(mm,t1.getText().length());
                t1.setText(s1+" "+time+" "+s2);
                setVisible(false);
            }
        }
    }

}
