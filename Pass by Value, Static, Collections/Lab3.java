import java.util.Scanner;
import java.util.ArrayList;

class Question {

    private String text;
    private String answer;
    private int difficulty;
    // private int questionNumber; // modify modify_question() and give_quiz()

    public Question(String text, String answer, int difficulty) {
        this.text = text;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public String get_question_text() {
        return text;
    }

    public String get_answer() {
        return answer;
    }
    
    public int get_difficulty() {
        return difficulty;
    }

    public void set_question(String text) {
        this.text = text;
    }

    public void set_answer(String answer) {
        this.answer = answer;
    }

    public void set_difficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    
}

class Quiz {

    private ArrayList<Question> quiz = new ArrayList<Question>();

    public void add_question() {
        
        System.out.print("What's the new question? ");
        String question = input.nextLine();
        System.out.print("What's the answer? ");
        String answer = input.nextLine();
        System.out.print("What's the difficulty of this question? ");
        int difficulty = input.nextInt();

        quiz.add(Question(question, answer, difficulty));
    }

    public void remove_question() {
        // for (Question x : Quiz) {
        //     System.out.print(x);
        // }

        for (int i = 0; i < quiz.length; i++) {
            System.out.print(i+") "+quiz.get(i));
        }
        System.out.print("Which question do you want to remove? ");
        quiz.remove(input.nextInt());
    }

    public void modify_question() {
        // for (Question x : Quiz) { // how do I add indices for this?
        //     System.out.print(x);
        // }                            

        for (int i = 0; i < quiz.length; i++) {
            System.out.print(i+") "+quiz.get(i));
        }
        System.out.print("Which question would you like to modify? ");
        questionSelected = input.nextInt();
        System.out.println(quiz.get(questionSelected));
        
        System.out.print("What's the new question? ");
        quiz.get(questionSelected).set_question(input.nextLine());
        System.out.print("What's the answer? ");
        quiz.get(questionSelected).set_answer(input.nextLine());
        System.out.print("What's the difficulty? ");
        quiz.get(questionSelected).set_difficulty(input.nextInt());
    }

    public Quiz give_quiz() {
        int score = 0;
        String localAnswer = quiz.get(i).answer;
        String localQuestion = quiz.get(i).text;

        for (int i = 0; i < quiz.length; i++) {
            System.out.print(localQuestion);
            if ((input.nextLine).equals(localAnswer)) { 
                System.out.println("Correct!");
                score += 1;
            } else {
                System.out.println("Incorrect! Try again");
                i -= 1; // repeat question, is there a better way to do this?
            }  
        }
        System.out.println("Quiz finished! You scored "+score+" out of "); //+totalScore); 
    }

}

public class Lab3 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Quiz newQuiz = new Quiz();
        int menuInput;
            
        do {

            System.out.println("\n1. Add a question to the quiz"
                            +"\n2. Remove a question from the quiz"
                            +"\n3. Modify a question in the quiz"
                            +"\n4. Take the quiz"
                            +"\n5. Quit"
            );
            menuInput = input.nextInt();

            switch (menuInput) {
                case 1:
                    newQuiz.add_question();
                    break;

                case 2:
                    newQuiz.remove_question();
                    break;

                case 3:
                    newQuiz.modify_question();
                    break;

                case 4:
                    newQuiz.give_quiz();
                    // add high score, so if they'd like to take it again they can.
                    break;
            }

        } while (menuInput != 5);
        input.close();
    }
    
}
