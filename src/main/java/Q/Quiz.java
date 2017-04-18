package Q;

/**
 * Created by Saif Hassan on 4/8/2017.
 * Email: saiftheboss7@gmail.com
 * ID: 16-31182-1
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz extends JFrame implements ActionListener {

    //class-level variables;
    JLabel lblQuestion;
    JButton btnA;
    JButton btnB;
    JButton btnC;
    JButton btnNext;
    JButton btnPrev;
    JLabel lblCounter;
    JLabel lblOutput;
    JLabel Score;
    int counter = 0;
    ArrayList<Problem> probList = new ArrayList<Problem>();
    public static int correctAnsCounter=0;
    int questionCount=1;




    public Quiz(){ //Constructor
        super("Quiz Game");
        loadProblems();
        setupGUI();
        registerListeners();
        updateScreen();
    } // end constructor

    public void setupGUI(){
        //create components
        JPanel panelQuestions = new JPanel();
        lblQuestion = new JLabel("question",SwingConstants.CENTER);
        lblQuestion.setFont(lblQuestion.getFont().deriveFont(18f));
        btnA = new JButton("Answer A");
        btnB = new JButton("Answer B");
        btnC = new JButton("Answer C");

        JPanel panelControls = new JPanel();
        btnPrev = new JButton("<==");
        lblCounter = new JLabel("1");
        lblOutput = new JLabel("Please click on your answer");
        btnNext = new JButton("==>");

        //add components to Panels
        panelQuestions.setLayout(new GridLayout(0,1));
        panelQuestions.add(lblQuestion);
        panelQuestions.add(btnA);
        panelQuestions.add(btnB);
        panelQuestions.add(btnC);

        panelControls.setLayout(new FlowLayout());
        //panelControls.add(btnPrev);
        panelControls.add(lblCounter);
        panelControls.add(lblOutput);
        panelControls.add(btnNext);

        //set up main layout
        Container mainWindowPanel = this.getContentPane();
        mainWindowPanel.setLayout(new BorderLayout());
        mainWindowPanel.add(panelQuestions, BorderLayout.CENTER);
        mainWindowPanel.add(panelControls, BorderLayout.SOUTH);

        //UI Customization
        this.setBounds(20,20,500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end setupGUI

    public void registerListeners(){
        //register all buttons to self
        btnA.addActionListener(this);
        btnB.addActionListener(this);
        btnC.addActionListener(this);
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
    } // end registerListeners

    public void loadProblems(){
        //load up probList array with data. You can add problems with their answers here

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quiz?user=dev&password=dev");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quiz");

            while (rs.next()) {
                Problem p = new Problem(rs.getString("question"), rs.getString("ans_a"), rs.getString("ans_b"), rs.getString("ans_c"), rs.getString("correct_ans").toUpperCase());
                probList.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    } // end loadProblems

    public void actionPerformed(ActionEvent e){
        System.out.println(e.getActionCommand());
        //check all button presses and send
        //control to appropriate methods
        if (e.getSource() == btnA){
            checkAns("A");
            nextQuestion();
        } else if (e.getSource() == btnB){
            checkAns("B");
            nextQuestion();
        } else if (e.getSource() == btnC){
            checkAns("C");
            nextQuestion();
        } else if (e.getSource() == btnPrev){
            prevQuestion();
        } else if (e.getSource() == btnNext){
            nextQuestion();
        } else {
            lblOutput.setText("something went wrong");
        } // end if


    } // end actionPerformed

    public void checkAns(String guess){
        //See if user's guess is correct and
        //provide appropriate output
        String correct = probList.get(counter).getCorrect();
        if (guess.equals(correct)){

            lblOutput.setText("Correct Answer!");
            correctAnsCounter++;
        } else {
            lblOutput.setText("Wrong Answer!");
        } // end if
    } // end checkAns

    public void prevQuestion(){
        //back up one question if possible
        counter--;
        if (counter < 0){
            counter = 0;
        } // end if
        updateScreen();
    } // end prevQuestion

    public void nextQuestion(){
        //go forward one question if possible
        counter++;
        if (counter >= probList.size()){
            //counter = probList.length - 1;
            endScreen();
            System.out.println("End!");
            System.out.println(correctAnsCounter);
        } // end if
        else{updateScreen();}
    } // end prevQuestion



    public void endScreen() {
        setVisible(false);
        new End();

    }

    public void updateScreen(){
        //updates screen with current problem
        lblCounter.setText("Question: " + Integer.toString(questionCount++));
        Problem p = probList.get(counter);
        lblQuestion.setText(p.getQuestion());
        btnA.setText(p.getAnsA());
        btnB.setText(p.getAnsB());
        btnC.setText(p.getAnsC());
        lblOutput.setText(" Please click on your answer");
    } // end updateScreen

} // end class def


