public class Lab1 {
    public static void main(String args[]) {
        char[][] copy = new char[4][13];
        char[][] car = make_forward();
        
        // Make copy
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                copy[i][j] = car[i][j];    
            }
        }

        // Print copy
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                System.out.print(copy[i][j]);    
            }
            System.out.print('\n');
        }

        // Mirror
        char[][] reflection = make_mirror(copy);

        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[i].length; j++) {
                System.out.print(reflection[i][j]);    
            }
            System.out.print('\n');
        }

        // Collision
        int rowLength = copy[0].length + reflection[0].length;
        char[][] collision = new char[copy.length][rowLength];

        // Fill cells
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                collision[i][j] = copy[i][j];
            }
        }
        for (int i = 0; i < reflection.length; i++) {
            for (int j = 0; j < reflection[i].length; j++) {
                collision[i][j + copy[i].length] = reflection[i][j];
            }
        }
        
        // Final print
        for (int i = 0; i < collision.length; i++) {
            for (int j = 0; j < collision[i].length; j++) {
                System.out.print(collision[i][j]);
            }
            System.out.print('\n');
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
        char[][] mirroredCar = new char[car.length][];
        
        for (int i = 0; i < car.length; i++) {
            mirroredCar[i] = new char[car[i].length];

            for (int j = 0, k = car[i].length - 1; j < car[i].length; j++, k--) {
                char presentCharacter = car[i][k];

                switch (presentCharacter) {
                    case '(':
                        mirroredCar[i][j] = ')';    
                        break;
                    
                    case ')':
                        mirroredCar[i][j] = '(';
                        break;

                    case '/':
                        mirroredCar[i][j] = '\\';
                        break;

                    case '\\':
                        mirroredCar[i][j] = '/';
                        break;

                    default:
                        mirroredCar[i][j] = presentCharacter;
                        break;
                }
            }
        }
        return mirroredCar;

    }

}
