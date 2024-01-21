public class Lab1 {
    public static void main(String args[]) {
        char[][] copy = new char[4][13];
        char[][] car = make_forward();
        
        // Make the copy of car
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                copy[i][j] = car[i][j];    
            }
        }

        // Print the copy
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                System.out.print(copy[i][j]);    
            }
            System.out.print("\n");
        }

        // Print reflection 
        char[][] reflection = make_mirror(copy);

        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                System.out.print(reflection[i][j]);    
            }
            System.out.print("\n");
        }

        // Concatenate arrays, collide
        char[][] collision = new char[copy.length*2][26];
        
        for (int i = 0; i < collision.length; i++) {
            for (int j = 0; j < collision.length; j++) {
                collision[i] = copy[i] + reflection[i];
            }
            
        }
    }

    public static char[][] make_forward() {
        char[][] pixel = new char[4][13];
        pixel[0][0]=' ';
        pixel[0][1]=' ';
        pixel[0][2]='_';
        pixel[0][3]='_';
        pixel[0][4]='_';
        pixel[0][5]='_';
        pixel[0][6]='_';
        pixel[0][7]='_';
        pixel[0][8]=' ';
        pixel[0][9]=' ';
        pixel[0][10]=' ';
        pixel[0][11]=' ';
        pixel[0][12]=' ';
        pixel[1][0]=' ';
        pixel[1][1]='/';
        pixel[1][2]='|';    
        pixel[1][3]='_';     
        pixel[1][4]='|';     
        pixel[1][5]='|';     
        pixel[1][6]='_';     
        pixel[1][7]='\\';    
        pixel[1][8]='\'';     
        pixel[1][9]='.';     
        pixel[1][10]='_';     
        pixel[1][11]='_';     
        pixel[1][12]=' ';     
        pixel[2][0]='(';     
        pixel[2][1]=' ';     
        pixel[2][2]=' ';     
        pixel[2][3]=' ';     
        pixel[2][4]='_';     
        pixel[2][5]=' ';     
        pixel[2][6]=' ';     
        pixel[2][7]=' ';    
        pixel[2][8]=' ';     
        pixel[2][9]='_';     
        pixel[2][10]=' ';     
        pixel[2][11]='_';     
        pixel[2][12]='\\';     
        pixel[3][0]='=';
        pixel[3][1]='\'';
        pixel[3][2]='-';
        pixel[3][3]='(';
        pixel[3][4]='_';
        pixel[3][5]=')';
        pixel[3][6]='-';
        pixel[3][7]='-';
        pixel[3][8]='(';
        pixel[3][9]='_';
        pixel[3][10]=')';
        pixel[3][11]='-';
        pixel[3][12]='\'';
        return pixel;
    }  

    public static char[][] make_mirror(char[][] car) {
        char[][] mirroredCar = new char[car.length][13]; // how do I not hardcode arr[].length
        
        for (int i = 0; i < car.length; i++) {
            for (int j = 0, k = car[i].length - 1; j < car[i].length; j++, k--) {
                char presentCharacter = car[i][k];

                if (presentCharacter == '(') {
                    mirroredCar[i][j] = ')';
                } else if (presentCharacter == ')') {
                    mirroredCar[i][j] = '(';
                } else if (presentCharacter == '/') {
                    mirroredCar[i][j] = '\\';
                } else if (presentCharacter == '\\') {
                    mirroredCar[i][j] = '/';
                } else {
                    mirroredCar[i][j] = presentCharacter;
                }
            }
        }
        return mirroredCar;

    }

}
