package Q;

/**
 * Created by Saif Hassan on 4/8/2017.
 * Email: saiftheboss7@gmail.com
 * ID: 16-31182-1
 */
public class Problem {

        // each field is a private instance variable
        private String question;
        private String ansA;
        private String ansB;
        private String ansC;
        private String correct;

        //constructor expects all inputs
        public Problem (String tQuestion, String tAnsA, String tAnsB,
                        String tAnsC, String tCorrect){
            //copy parameters to instance variables
            question = tQuestion;
            this.ansA = tAnsA;
            this.ansB = tAnsB;
            this.ansC = tAnsC;
            this.correct = tCorrect;
        } // end problem constructor

        //all values are read-only with getters
        String getQuestion(){
            return question;
        } // end getQuestion

        String getAnsA(){
            return ansA;
        } // end getAnsA

        String getAnsB(){
            return ansB;
        } // end getAnsB

        String getAnsC(){
            return ansC;
        } // end getAnsC

        String getCorrect(){
            return correct;
        } // end getCorrect

    // end Problem class def
}
