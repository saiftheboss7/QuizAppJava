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

        //constructor must have all inputs
        public Problem (String Question, String AnsA, String AnsB,
                        String AnsC, String CorrectAns){
            //copy parameters to instance variables
            question = Question;
            this.ansA = AnsA;
            this.ansB = AnsB;
            this.ansC = AnsC;
            this.correct = CorrectAns;
        } // end problem constructor

        //all values are read-only with getters
        String getQuestion(){
            return question;
        } // end getQuestion

        String getAnsA(){
            return ansA;
        } // getAnsA

        String getAnsB(){
            return ansB;
        } // getAnsB

        String getAnsC(){
            return ansC;
        } // getAnsC

        String getCorrect(){
            return correct;
        } // end getCorrectAns

    // end Problem class def
}
