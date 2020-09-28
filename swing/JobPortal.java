import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
public class JobPortal {

public static void main(String[] args) throws Exception
{
design f = new design();
}
}


class design
extends JFrame
implements FocusListener,ActionListener {

// Components of the Form
private Container cn;
private JLabel title;
private JLabel name;
private JTextField tname;
private JLabel rno;
private JTextField trno;
private JLabel course;
private JRadioButton ug;
private JRadioButton pg;
private JRadioButton phd;
private ButtonGroup coursegp;
private JLabel prog;
private JComboBox selectprg;
private JLabel name_author;
private JTextArea tname_author;
private JCheckBox term;
private JButton sub;
private JButton reset;
private JTextArea tout;
private JLabel res;
private JTextArea resadd;

private String cate[]
= { "Action and adventure","Classics","Mistery","Trillers","Biopic","Education"};
// constructor, to initialize the components
// with default values.
public design()
{
setTitle("Library");
setBounds(200, 90, 1000, 900);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setResizable(false);

cn = getContentPane();
cn.setLayout(null);

title = new JLabel("Register As Job Seeker");
title.setFont(new Font("Arial", Font.PLAIN, 30));
title.setSize(500, 30);
title.setLocation(300, 30);
cn.add(title);

name = new JLabel("Name");
name.setFont(new Font("Arial", Font.PLAIN, 20));
name.setSize(100, 20);
name.setLocation(100, 100);
cn.add(name);

tname = new JTextField();
tname.setFont(new Font("Arial", Font.PLAIN, 15));
tname.setSize(190, 20);
tname.setLocation(200, 100);
cn.add(tname);
tname.addFocusListener(this);

rno = new JLabel("Reg No"); //Mobile number should be validated(both in case of number of digits and numeric values)
rno.setFont(new Font("Arial", Font.PLAIN, 20));
rno.setSize(100, 20);
rno.setLocation(100, 150);
cn.add(rno);


trno = new JTextField();
trno.setFont(new Font("Arial", Font.PLAIN, 15));
trno.setSize(150, 20);
trno.setLocation(200, 150);
cn.add(trno);
trno.addFocusListener(this);

course = new JLabel("Course");
course.setFont(new Font("Arial", Font.PLAIN, 20));
course.setSize(100, 20);
course.setLocation(100, 200);
cn.add(course);

ug = new JRadioButton("UG");
ug.setFont(new Font("Arial", Font.PLAIN, 15));
ug.setSelected(true);
ug.setSize(75, 20);
ug.setLocation(200, 200);
cn.add(ug);

pg = new JRadioButton("PG");
pg.setFont(new Font("Arial", Font.PLAIN, 15));
pg.setSelected(false);
pg.setSize(80, 20);
pg.setLocation(275, 200);
cn.add(pg);

phd = new JRadioButton("PhD");
phd.setFont(new Font("Arial", Font.PLAIN, 15));
phd.setSelected(false);
phd.setSize(80, 20);
phd.setLocation(350, 200);
cn.add(phd);

coursegp = new ButtonGroup();
coursegp.add(ug);
coursegp.add(pg);
coursegp.add(phd);

prog = new JLabel("Category");
prog.setFont(new Font("Arial", Font.PLAIN, 20));
prog.setSize(120, 20);
prog.setLocation(100, 250);
cn.add(prog);

selectprg = new JComboBox(cate);
selectprg.setFont(new Font("Arial", Font.PLAIN, 15));
selectprg.setSize(120, 20);
selectprg.setLocation(250, 250);
cn.add(selectprg);

name_author = new JLabel("Title and Author");
name_author.setFont(new Font("Arial", Font.PLAIN, 20));
name_author.setSize(200, 20);
name_author.setLocation(100, 300);
cn.add(name_author);

tname_author = new JTextArea();
tname_author.setFont(new Font("Arial", Font.PLAIN, 15));
tname_author.setSize(200, 75);
tname_author.setLocation(250, 300);
tname_author.setLineWrap(true);
cn.add(tname_author);

term = new JCheckBox("Accept Terms And Conditions.");
term.setFont(new Font("Arial", Font.PLAIN, 15));
term.setSize(250, 20);
term.setLocation(150, 400);
cn.add(term);

sub = new JButton("Submit");
sub.setFont(new Font("Arial", Font.PLAIN, 15));
sub.setSize(100, 20);
sub.setLocation(150, 450);
sub.addActionListener(this);
cn.add(sub);

reset = new JButton("Reset");
reset.setFont(new Font("Arial", Font.PLAIN, 15));
reset.setSize(100, 20);
reset.setLocation(270, 450);
reset.addActionListener(this);
cn.add(reset);



tout = new JTextArea();
tout.setFont(new Font("Arial", Font.PLAIN, 15));
tout.setSize(300, 400);
tout.setLocation(500, 100);
tout.setLineWrap(true);
tout.setEditable(false);
cn.add(tout);

res = new JLabel("");
res.setFont(new Font("Arial", Font.PLAIN, 20));
res.setSize(500, 25);
res.setLocation(100, 500);
cn.add(res);

resadd = new JTextArea();
resadd.setFont(new Font("Arial", Font.PLAIN, 15));
resadd.setSize(200, 75);
resadd.setLocation(580, 175);
resadd.setLineWrap(true);
cn.add(resadd);

setVisible(true);
}
public void focusLost(FocusEvent e){
// res.setText("Focus lost");
}
public void focusGained(FocusEvent e){
// res.setText("Focus gained");
}
// method actionPerformed()
// to get the action performed
// by the user and act accordingly
public void actionPerformed(ActionEvent e)
{ // can submit only when all the fields is filled
//Focus will be automatically moved to the next field.
//Name should be validate
//Mobile number should be validate
String rn = trno.getText();
String nam = tname.getText();
if (e.getSource() == sub) {
if (term.isSelected()) {
if(nameval(nam)){
if(mobval(rn)){

String data1;
String data
= "Name : "
+ tname.getText() + "\n"
+ "Reg No : "
+ trno.getText() + "\n";
if (ug.isSelected())
data1 = "Course : UG"
+ "\n";
else if (pg.isSelected())
data1 = "Course : PG"
+ "\n";
else
data1 = "Course : PhD"
+ "\n";
String data2
= "Programme : "
+ selectprg.getSelectedItem()
+ "\n";

String data3 = "Book Details : " + tname_author.getText();
tout.setText(data + data1 + data2 + data3);
tout.setEditable(false);
res.setText("Registration Successfully..");
}
}
}
else {
tout.setText("");
resadd.setText("");
res.setText("Please accept the"
+ " terms & conditions..");
}
}

else if (e.getSource() == reset) {
String def = "";
tname.setText(def);
tname_author.setText(def);
trno.setText(def);
res.setText(def);
tout.setText(def);
term.setSelected(false);
selectprg.setSelectedIndex(0);
resadd.setText(def);
}
}

public boolean nameval(String name){
String regex = "[A-Za-z ]+$";
if(name.matches(regex)){
return true;
}
else{
res.setText("Please enter a valid Name");
tname.setText("");
return false;
}
}
public boolean mobval(String m){
String regex = "[0-9]{7}";
if(m.matches(regex)){
return true;
}
else{
res.setText("Please enter a valid register number");
trno.setText("");
return false;
}
}
}
