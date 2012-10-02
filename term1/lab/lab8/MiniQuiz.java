package lab8;

//*****************************************************************
//MiniQuiz.java Author: Lewis/Loftus
//
//Demonstrates the use of a class that implements an interface.
//*****************************************************************
import java.util.Scanner;

public class MiniQuiz {
    // --------------------------------------------------------------
    // Presents a short quiz.
    // --------------------------------------------------------------
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Question q1, q2;
        q1 = new Question("What is the capital of Jamaica?", "Kingston");
        q1.setComplexity(4);
        q2 = new Question("Which is worse, ignorance or apathy?",
                "I don't know and I don't care");
        q2.setComplexity(10);
        askQuestion(q1);
        System.out.println();
        askQuestion(q2);
    }
    
    private static void askQuestion(Question question){
        String possible;
        System.out.print(question.getQuestion());
        System.out.println(" (Level: " + question.getComplexity() + ")");
        possible = scan.nextLine();
        if (question.answerCorrect(possible))
            System.out.println("Correct");
        else
            System.out.println("No, the answer is " + question.getAnswer());
    }
}
