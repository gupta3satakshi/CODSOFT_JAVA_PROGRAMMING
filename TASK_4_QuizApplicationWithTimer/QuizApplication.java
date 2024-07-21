import java.util.Scanner;
public class QuizApplication {
    private static final String[][] questions = {
            {"What is a correct syntax to output \"Hello World\" in Java?", "A.  echo(\"Hello World\");", "B.  Console.WriteLine(\"Hello World\");", "C.  System.out.println(\"Hello World\");", "D.  print (\"Hello World\");", "C"},
            {"Which of the following is not a Java features?", "A. Dynamic", "B. Architecture Neutral", "C. Use of pointers", "D. Object-oriented", "C"},
            {"_____ is used to find and fix bugs in the Java programs.", "A. JVM", "B. JRE", "C. JDK", "D. JDB", "D"},
            {"What does the expression float a = 35 / 0 return?", "A. 0", "B. Not a Number", "C. Infinity", "D. Run time exception", "C"},
            {"Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?", "A. javap tool", "B. javaw command", "C. Javadoc tool", "D. javah command", "C"}
    };
    private static final int QUESTION_TIME_LIMIT = 10; // Time limit for each question in seconds
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (String[] q : questions) {
            System.out.println(q[0]);
            for (int i = 1; i < 5; i++) {
                System.out.println(q[i]);
            }
            System.out.print("Enter your answer (A, B, C, or D): ");
            String userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase(q[5])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + q[5] + "\n");
            }
            try {
                Thread.sleep(QUESTION_TIME_LIMIT * 1000); // Pause for QUESTION_TIME_LIMIT seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Quiz completed! Your final score is: " + score + "/" + questions.length);
    }
}