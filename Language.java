import javax.swing.*;

/**
 * Created by chentao on 2017/4/16.
 */
public class Language {
    public JTextPane a1= new JTextPane();
    public void set(JTextPane n){a1=n;}
    public void Language_C(){
        String [] lan_c={"auto","short","int","long","float","double","char",
                        "struct","union","enum","typedef","const","unsigned",
                        "signed","extern","register","static","volatile",
                        "void","if","else","switch","for","do","while","goto",
                        "continue","break","default","sizeof","return"};
        System.out.print(lan_c);
    }
    public void Language_JAVA(){
        String [] lan_java={"abstract","boolean","break","byte","case","catch","char",
                            "class","continue","default","do","double", "else","extend",
                            "false","final","finally","float","for","if","implement",
                            "import","instanceof","int","interface","long","native","const",
                            "new","null","package","private","protected","public","return",
                            "short","static","super","switch","synchronized","this","throw",
                            "throws","transient","true","try","void","volatile","ehile","goto"};
    }
    public void Language_php(){
        String [] lan_php={"__halt_compiler()","abstract","and","array()","as",
                           "break","callable","case","catch","class","clone",
                            "const","continue","declare","default","die","do",
                            "echo","else","elseif","empty()","enddeclare","endfor",
                            "endforeach","endif","endswitch","endwhile","eval","exit",
                            "extends","final","finally","for","foreach","function",
                            "global","goto","if","implements","include","include_once",
                            "instanceof","insteadof","interface","isset","list",
                            "namespace","new","or","print","private","protected","public",
                            "require","require_once","return","static","switch","throw",
                            "trait","try","unset","use","var","while","xor","yield"};
    }
    public void Language_python(){
        String [] lan_python={"False","class","finally","is","return","None",
                              "continue","for","lambda","try","True","def","from",
                              "nonlocal","while","and","del","global","not","with",
                              "as","elif","if","or","yield","assert","else","import",
                              "pass","break","except","in","raise"
        };
    }
    public void Language_erjinzhi(){

    }
}
