import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class user implements ActionListener {
    static int Count1 =0 , Count2=0;
    int min=1,max=3;
    String Message1 = "Rock Paper Scissor Game.";
    String Message2 = "Enjoy Playing This Game.";
    String Message3 = "Its a Single Player Game.(You v/s Computer).";
    String Message4 = "First to Win 5 Points Wins the Game.";
    static String win = "Congratulations !!You Beat Computer.";
    static String lose = "Aww Try again !!You Lost to Computer.";
    static String t1 = "Player :: ";
    static String t2 = "Computer :: ";
    static String t3 =null;
    JFrame message = new JFrame("Rules");
    JLabel Rules = new JLabel();
    JLabel Rules2 = new JLabel();
    JLabel Rules3 = new JLabel();
    JLabel Rules4 = new JLabel();
    JFrame frame = new JFrame("Rock_Paper_Scissor_Game");
    JButton Rock = new JButton("Rock");
    JButton Paper = new JButton("Paper");
    JButton Scissor = new JButton("Scissor");
    JButton Play =new JButton("Play Again");
    JLabel L1 = new JLabel("Rock Paper Scissor Game");
    JLabel L2 = new JLabel("Choice Your Weapon");
    JLabel you = new JLabel();
    JLabel comp = new JLabel();
    JLabel Winner = new JLabel();
    Font f1 = new Font("",Font.BOLD,30);
    Font f2 = new Font ("",Font.BOLD,20);

    user(){
        message.setSize(300, 200);
        message.getContentPane().setBackground(Color.PINK);
        message.setLayout(null);

        Rules.setText(Message1);
        Rules.setBounds(5,10,250,50);
        Rules.setFont(new Font("",Font.ITALIC,10));

        Rules2.setText(Message2);
        Rules2.setBounds(5,40,250,50);
        Rules2.setFont(new Font("",Font.ITALIC,10));

        Rules3.setText(Message3);
        Rules3.setBounds(5,70,250,50);
        Rules3.setFont(new Font("",Font.ITALIC,10));

        Rules4.setText(Message4);
        Rules4.setBounds(5,100,250,50);
        Rules4.setFont(new Font("",Font.ITALIC,10));

        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setLayout(null);

        L1.setBounds(30, 20, 400, 50);
        L1.setFont(f1);
        L1.setForeground(Color.BLACK);

        you.setText(t1 + Count1);
        you.setBounds(30, 90, 200, 40);
        you.setFont(f2);

        comp.setText(t2 + Count2);
        comp.setBounds(270, 90, 200, 40);
        comp.setFont(f2);

        L2.setBounds(70, 130, 350, 50);
        L2.setFont(new Font("", Font.BOLD, 30));
        L2.setForeground(Color.DARK_GRAY);

        Rock.setBounds(20, 200, 120, 50);
        Rock.setFocusable(false);
        Rock.addActionListener(this);
        Rock.setForeground(Color.RED);
        Rock.setFont(f2);

        Paper.setBounds(160, 200, 120, 50);
        Paper.setFocusable(false);
        Paper.addActionListener(this);
        Paper.setForeground(Color.RED);
        Paper.setFont(f2);

        Scissor.setBounds(290, 200, 120, 50);
        Scissor.setFocusable(false);
        Scissor.addActionListener(this);
        Scissor.setForeground(Color.RED);
        Scissor.setFont(f2);

        Play.addActionListener(this);
        Play.setBounds(120, 350, 200, 50);
        Play.setForeground(Color.BLUE);
        Play.setFocusable(false);
        Play.setFont(f1);

        Winner.setBounds(20,280,400,30);
        Winner.setFont(f2);

        message.add(Rules);
        message.add(Rules2);
        message.add(Rules3);
        message.add(Rules4);
        frame.add(L1);
        frame.add(you);
        frame.add(comp);
        frame.add(L2);
        frame.add(Rock);
        frame.add(Paper);
        frame.add(Scissor);
        frame.add(Winner);
        frame.add(Play);
        frame.setVisible(true);
        message.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();
        int ch = random.nextInt(max - min + 1) + min;
        if((Count1<5) && (Count2<5)){
            if ((ch == 1 && e.getSource() == Rock) || (ch == 2 && e.getSource() == Paper) || (ch == 3 && e.getSource() == Scissor)) {
                System.out.println("Its a Tie");
            } else if ((ch == 1 && e.getSource() == Paper) || (ch == 3 && e.getSource() == Paper) || (ch == 2 && e.getSource() == Scissor)) {
                System.out.println("+1 Point to Player");
                Count1 += 1;
                you.setText(t1 + Count1);
            } else if ((ch == 1 && e.getSource() == Scissor) || (ch == 2 && e.getSource() == Rock) || (ch == 3 && e.getSource() == Rock)) {
                System.out.println("+1 Point to Computer");
                Count2 += 1;
                comp.setText(t2 + Count2);
            } else {
                System.out.println("Invalid");
            }
        }
        else{
            System.out.println("Game Over !!");
            if(Count1>Count2){
                Winner.setText(win);
            }
            else{
                Winner.setText(lose);
            }
        }
        if(e.getSource()==Play){
            Count1 = 0;
            Count2 = 0;
            you.setText(t1 + Count1);
            comp.setText(t2 + Count2);
            Winner.setText(t3);
        }
    }
}
