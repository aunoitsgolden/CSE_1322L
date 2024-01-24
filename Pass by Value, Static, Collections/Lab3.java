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
    private Scanner quizInput = new Scanner(System.in);

    public void add_question() {
 
        System.out.print("What's the new question? ");
        String question = quizInput.nextLine();
        System.out.print("What's the answer? ");
        String answer = quizInput.nextLine();
        System.out.print("What's the difficulty of this question? ");
        int difficulty = quizInput.nextInt();

        Question newQuestion = new Question(question, answer, difficulty); // cannot find symbol (Question)
        quiz.add(newQuestion);
    }

    public void remove_question() {
        int j = 0;
        for (Question x : quiz) {
            System.out.print(j+") "+ x);
        }

        System.out.print("Which question do you want to remove? ");
        quiz.remove(quizInput.nextInt());
    }

    public void modify_question() {
        int j = 0;
        for (Question q : quiz) {
            System.out.print(j+") "+q);
        }
        System.out.print("Which question would you like to modify? ");
        int questionSelected = quizInput.nextInt();
        System.out.println(quiz.get(questionSelected));
        
        System.out.print("What's the new question? ");
        quiz.get(questionSelected).set_question(quizInput.nextLine());
        System.out.print("What's the answer? ");
        quiz.get(questionSelected).set_answer(quizInput.nextLine());
        System.out.print("What's the difficulty? ");
        quiz.get(questionSelected).set_difficulty(quizInput.nextInt());
    }

    public void give_quiz() {
        int score = 0;

        for (Question x: quiz) {
            System.out.print(x.get_question_text());
            
            if ((quizInput.nextLine()).equals(x.get_answer())) { 
                System.out.println("Correct!");
                score += 1;
            } else {
                System.out.println("Incorrect! Try again");
            }  
        }
        System.out.println("Quiz finished! You scored "+score+" out of "+quiz.size()); //+totalScore); 
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
