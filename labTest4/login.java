import java.io.*;
import java.util.*;

//FOR GUI
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.lang.String;
public class login implements ActionListener{
    
    private static JLabel input;
    private static JTextField userText;
    private static JLabel result;
    private static JLabel result2;
    private static JButton button;
    private static int counter=0;
    
    
    public static void main(String[] args)throws Exception
    {
        Scanner sc=new Scanner(System.in);
        
        
                
        JFrame frame=new JFrame();//Body
        JPanel panel=new JPanel();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        input=new JLabel("Welcome to Pie \n\n");
        input.setBounds(10, 20, 85, 25);
        userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(input);
        panel.add(userText);
        
        
        button=new JButton("submit");
        button.setBounds(10,80,80,25);
        panel.add(button);
        button.addActionListener(new login());
        
        result=new JLabel(""+counter+"");
        result.setBounds(10,20,80,25);
        panel.add(result);
        
        
        result2=new JLabel("Null");
        result2.setBounds(10,20,80,25);
        panel.add(result2);
        frame.add(panel);
        frame.setVisible(true);//For showing the frame
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        String myString=userText.getText();
        String PI=new String("3.14");
        String sub=myString.substring(2);

        
        String output="";
        int index=0;
        for(int i=0;i<PI.length();i++)
        {
            if(PI.charAt(i) != '.')
            {
                int digit=Integer.parseInt(String.valueOf((PI.charAt(i))));
                for(int j=0;j<digit;j++)
                {
                    output+=myString.charAt(index);
                    index++;
                }
                output+=" ";
            }
        }
        
        System.out.println(output);
        if(PI.length() <= 20) 
        {
            
            counter++;
            
            result.setText(""+counter+"");
            result2.setText(""+output+"");
        }
        
        else
        {
            result.setText("Please input correct sentence ");
        }
	}

}
