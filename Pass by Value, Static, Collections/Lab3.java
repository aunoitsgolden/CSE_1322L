import java.util.Scanner;
import java.util.ArrayList;

class Question {

    private String text;
    private String answer;
    private int difficulty;

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
    private static Scanner quizInput = new Scanner(System.in);
    private int highScore;    

    public void add_question() {
 
        System.out.print("What's the new question? ");
        String question = quizInput.nextLine();
        System.out.print("What's the answer? ");
        String answer = quizInput.nextLine();
        System.out.print("What's the difficulty of this question? ");
        int difficulty = quizInput.nextInt(); // no error handling (removed to wait for module 5)
        quizInput.nextLine();
        
        Question newQuestion = new Question(question, answer, difficulty);
        quiz.add(newQuestion);
    }

    public void remove_question() {
        if (quiz.isEmpty()) {
            System.out.println("There are no questions to remove!");
        } else {
            int i = 0;
            for (Question x : quiz) {
                System.out.println(i +") "+ x.get_question_text());
                i++;
            }
            System.out.print("Which question do you want to remove? ");
            quiz.remove(quizInput.nextInt());
            quizInput.nextLine();
        }
    }

    public void modify_question() {
        if (quiz.isEmpty()) {
            System.out.println("There are no questions to modify!");
        } else {
            int i = 0;
            for (Question x : quiz) {
                System.out.println(i +") "+ x.get_question_text());
                i++;
            }
            System.out.print("Which question do you want to modify? ");
            int questionSelected = quizInput.nextInt();
            quizInput.nextLine();

            System.out.print("What's the new question? ");
            String question = quizInput.nextLine();
            System.out.print("What's the answer? ");
            String answer = quizInput.nextLine();
            System.out.print("What's the difficulty of this question? ");
            int difficulty = quizInput.nextInt();
            quizInput.nextLine();

            Question newQuestion = new Question(question, answer, difficulty);
            quiz.set(questionSelected, newQuestion);
            // no error handling, throws error if index does not exist
        }
    }

    public void give_quiz() {
        if (quiz.isEmpty()) {
            System.out.println("There are no questions in the quiz! Press 1 to add questions.");
        
        } else {
            int score = 0;
            for (Question x: quiz) {
                System.out.print(x.get_question_text()+" ");

                if ((quizInput.nextLine()).equals(x.get_answer())) { 
                    System.out.println("Correct!");
                    score += 1;
                } else {
                    System.out.println("Incorrect!, the answer was \""+x.get_answer()+"\"");
                    // no retries, otherwise would do for loop and i-=1 (max of 3 tries)
                }  
            }

            System.out.println("Quiz finished! You scored "+score+" out of "+quiz.size());
            
            if (score > highScore) {
                System.out.println("New highscore: "+score+"!");
                highScore = score;
            }
        }
    }

    public void closeInput() {
        quizInput.close();
    }
}

public class Lab3 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Quiz newQuiz = new Quiz();
        int menuInput;
            
        do {

            System.out.println("What would you like to do?"
                            +"\n1. Add a question to the quiz"
                            +"\n2. Remove a question from the quiz"
                            +"\n3. Modify a question in the quiz"
                            +"\n4. Take the quiz"
                            +"\n5. Quit"
            );
            menuInput = input.nextInt();
            input.nextLine();

            while (menuInput < 0 || menuInput > 5) {
                System.out.print("Invalid input! Please enter one of the options above: ");
                menuInput = input.nextInt();
                input.nextLine();
            }

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
                    break;
            }

        } while (menuInput != 5);
        newQuiz.closeInput();
        input.close();
    }
    
}
