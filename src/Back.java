import java.util.Random;
import java.util.Scanner;

public class Back {
    Scanner s = new Scanner(System.in);
    private final String[][] gameMatrice = new String[3][3];
    private int step;
    private String strPlayer = "X";
    private final int[] oldStep = new int[10];
    Random r = new Random();
    private int quantityPlayers;
    private int difficulty;

    public int getQuantityPlayers(){
        return quantityPlayers;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    void startGame() {
        System.out.println("КРЕСТИКИ НОЛИКИ");
        for (int i = 0; i < gameMatrice.length; i++) {
            for (int j = 0; j < gameMatrice[i].length; j++) {
                gameMatrice[i][j] = ".";
            }
        }
        for (int i = 0; i < oldStep.length; i++){
            oldStep[i] = 0;
        }
        System.out.println("1 или 2 игрока?");
        String strQuantityPlayers = s.nextLine();
        strQuantityPlayers = strQuantityPlayers.replaceAll("\\s+","");
        try {
            quantityPlayers = Integer.parseInt(strQuantityPlayers);
            if (quantityPlayers == 1) {
                System.out.println("Выбрана одиночная игра");
            } else if (quantityPlayers == 2){
                System.out.println("Выбрана игра на двоих");
            } else {
                System.out.println("Ввод непонятен, выбрана игра по умолчанию: одиночная");
                quantityPlayers = 1;
            }
        } catch (NumberFormatException e) {
            quantityPlayers = 1;
            System.out.println("Ввод непонятен, выбрана игра по умолчанию: одиночная");
        }
        if (quantityPlayers == 1) {
            System.out.println("Введите уровень сложности бота, от 1 до 3");
            String strDifficulty = s.nextLine();
            strDifficulty = strDifficulty.replaceAll("\\s+","");
            try {
                difficulty = Integer.parseInt(strDifficulty);
                if (difficulty == 1) {
                    System.out.println("Выбран легкий уровень");
                } else if (difficulty == 2) {
                    System.out.println("Выбран средний уровень");
                } else if (difficulty == 3) {
                    System.out.println("Выбран сложный уровень");
                } else {
                    difficulty = 2;
                    System.out.println("Ввод непонятен, выбран уровень по умолчанию: средний");
                }
            } catch (NumberFormatException e) {
                difficulty = 2;
                System.out.println("Ввод непонятен, выбран уровень по умолчанию: средний");
            }
        }
    }

    void visual() {
        for (int i = 0; i < gameMatrice.length; i++){
            for (int j = 0; j < gameMatrice[i].length; j++){
                System.out.print(gameMatrice[i][j] + "  ");
                if (j != 2){
                    System.out.print("|  ");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("-------------");
            }
        }
    }

    public void setStep(){
        int userStep = 1;
        do{
            int checkStep;
            do {
                checkStep = 0;
                int checkUserStep = 1;
                String strUserStep;
                do {
                    if (userStep == 0) {
                        visual();
                        System.out.println("НЕТ ТАКОГО ПОЛЯ!");
                    }
                    System.out.println("Игрок " + strPlayer + " ваш ход!");
                    System.out.println("Введите номер поля от 1 до 9:");
                    strUserStep = s.nextLine();
                    strUserStep = strUserStep.replaceAll("\\s+","");
                    if (strUserStep.isEmpty()){
                        visual();
                        System.out.println("ВЫ НИЧЕГО НЕ ВВЕЛИ!");
                        userStep = 1;
                    } else {
                        try {
                            userStep = Integer.parseInt(strUserStep);
                            checkUserStep = 2;
                        } catch (NumberFormatException e) {
                            visual();
                            userStep = 1;
                            System.out.println("ТРЕБУЕТСЯ ВВЕСТИ ЧИСЛА!");
                        }
                    }
                } while (checkUserStep == 1);
                for (int j : oldStep) {
                    if (userStep == j) {
                        checkStep = 1;
                        break;
                    }
                }
                if (checkStep == 1 && userStep != 0){
                    visual();
                    System.out.println("ТАКОЙ ХОД УЖЕ БЫЛ!");
                }
            } while (checkStep == 1);
            if (userStep > 0 && userStep < 10) {
                oldStep[userStep] = userStep;
            }
            if (userStep < 1 && userStep != 0 || userStep > 9){
                visual();
                System.out.println("НЕТ ТАКОГО ПОЛЯ!");
            }
        } while (userStep < 1 || userStep > 9);
        step = userStep;
    }

    public int getStep() {
        return step;
    }

    public  int check(){
        int result;
        if (gameMatrice[0][0].equals(gameMatrice[0][1]) && gameMatrice[0][1].equals(gameMatrice[0][2]) && !gameMatrice[0][2].equals(".")
                || gameMatrice[1][0].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[1][2]) && !gameMatrice[1][2].equals(".")
                || gameMatrice[2][0].equals(gameMatrice[2][1]) && gameMatrice[2][1].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][0].equals(gameMatrice[1][0]) && gameMatrice[1][0].equals(gameMatrice[2][0]) && !gameMatrice[2][0].equals(".")
                || gameMatrice[0][1].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][1]) && !gameMatrice[2][1].equals(".")
                || gameMatrice[0][2].equals(gameMatrice[1][2]) && gameMatrice[1][2].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][0].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][2].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][0]) && !gameMatrice[2][0].equals(".")){
            result = 2;
        } else if (!gameMatrice[0][0].equals(".") && !gameMatrice[0][1].equals(".") && !gameMatrice[0][2].equals(".") &&
                !gameMatrice[1][0].equals(".") && !gameMatrice[1][1].equals(".") && !gameMatrice[1][2].equals(".") &&
                !gameMatrice[2][0].equals(".") && !gameMatrice[2][1].equals(".") && !gameMatrice[2][2].equals(".")) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    public void setGameMatrice(int z, int x, String c) {
        gameMatrice[z][x] = c;
    }

    public void botStep(){
        int chanseStep = r.nextInt(100) + 1;
        if (difficulty == 1){
            if (chanseStep <= 65) {
                hardBotStep();
            } else {
                easyBotStep();
            }
        } else if (difficulty == 2) {
            if (chanseStep <= 80) {
                hardBotStep();
            } else {
                easyBotStep();
            }
        } else {
            if (chanseStep <= 95) {
                hardBotStep();
            } else {
                easyBotStep();
            }
        }
    }

    public void easyBotStep(){
        int checkBotStep;
        int botStep;
        do {
            checkBotStep = 0;
            botStep = r.nextInt(9) + 1;
            for (int j : oldStep) {
                if (j == botStep) {
                    checkBotStep = 1;
                    break;
                }
            }
        } while (checkBotStep == 1);
        oldStep[botStep] = botStep;
        step = botStep;
    }

    public void hardBotStep(){
        int hardBotStep = 0;
        int chanse = r.nextInt(12) + 1;
        if        (gameMatrice[0][0].equals(".") && gameMatrice[0][1].equals("O") && gameMatrice[0][2].equals("O")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[0][1].equals(".") && gameMatrice[0][2].equals("O")) {
            hardBotStep = 8;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[0][1].equals("O") && gameMatrice[0][2].equals(".")) {
            hardBotStep = 9;
        } else if (gameMatrice[1][0].equals(".") && gameMatrice[1][1].equals("O") && gameMatrice[1][2].equals("O")) {
            hardBotStep = 4;
        } else if (gameMatrice[1][0].equals("O") && gameMatrice[1][1].equals(".") && gameMatrice[1][2].equals("O")) {
            hardBotStep = 5;
        } else if (gameMatrice[1][0].equals("O") && gameMatrice[1][1].equals("O") && gameMatrice[1][2].equals(".")) {
            hardBotStep = 6;
        } else if (gameMatrice[2][0].equals(".") && gameMatrice[2][1].equals("O") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 1;
        } else if (gameMatrice[2][0].equals("O") && gameMatrice[2][1].equals(".") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 2;
        } else if (gameMatrice[2][0].equals("O") && gameMatrice[2][1].equals("O") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][0].equals(".") && gameMatrice[1][0].equals("O") && gameMatrice[2][0].equals("O")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[1][0].equals(".") && gameMatrice[2][0].equals("O")) {
            hardBotStep = 4;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[1][0].equals("O") && gameMatrice[2][0].equals(".")) {
            hardBotStep = 1;
        } else if (gameMatrice[0][1].equals(".") && gameMatrice[1][1].equals("O") && gameMatrice[2][1].equals("O")) {
            hardBotStep = 8;
        } else if (gameMatrice[0][1].equals("O") && gameMatrice[1][1].equals(".") && gameMatrice[2][1].equals("O")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][1].equals("O") && gameMatrice[1][1].equals("O") && gameMatrice[2][1].equals(".")) {
            hardBotStep = 2;
        } else if (gameMatrice[0][2].equals(".") && gameMatrice[1][2].equals("O") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 9;
        } else if (gameMatrice[0][2].equals("O") && gameMatrice[1][2].equals(".") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 6;
        } else if (gameMatrice[0][2].equals("O") && gameMatrice[1][2].equals("O") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][0].equals(".") && gameMatrice[1][1].equals("O") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[1][1].equals(".") && gameMatrice[2][2].equals("O")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][0].equals("O") && gameMatrice[1][1].equals("O") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][2].equals(".") && gameMatrice[1][1].equals("O") && gameMatrice[2][0].equals("O")) {
            hardBotStep = 9;
        } else if (gameMatrice[0][2].equals("O") && gameMatrice[1][1].equals(".") && gameMatrice[2][0].equals("O")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][2].equals("O") && gameMatrice[1][1].equals("O") && gameMatrice[2][0].equals(".")) {
            hardBotStep = 1;
        }
        else if   (gameMatrice[0][0].equals(".") && gameMatrice[0][1].equals("X") && gameMatrice[0][2].equals("X")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[0][1].equals(".") && gameMatrice[0][2].equals("X")) {
            hardBotStep = 8;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[0][1].equals("X") && gameMatrice[0][2].equals(".")) {
            hardBotStep = 9;
        } else if (gameMatrice[1][0].equals(".") && gameMatrice[1][1].equals("X") && gameMatrice[1][2].equals("X")) {
            hardBotStep = 4;
        } else if (gameMatrice[1][0].equals("X") && gameMatrice[1][1].equals(".") && gameMatrice[1][2].equals("X")) {
            hardBotStep = 5;
        } else if (gameMatrice[1][0].equals("X") && gameMatrice[1][1].equals("X") && gameMatrice[1][2].equals(".")) {
            hardBotStep = 6;
        } else if (gameMatrice[2][0].equals(".") && gameMatrice[2][1].equals("X") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 1;
        } else if (gameMatrice[2][0].equals("X") && gameMatrice[2][1].equals(".") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 2;
        } else if (gameMatrice[2][0].equals("X") && gameMatrice[2][1].equals("X") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][0].equals(".") && gameMatrice[1][0].equals("X") && gameMatrice[2][0].equals("X")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[1][0].equals(".") && gameMatrice[2][0].equals("X")) {
            hardBotStep = 4;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[1][0].equals("X") && gameMatrice[2][0].equals(".")) {
            hardBotStep = 1;
        } else if (gameMatrice[0][1].equals(".") && gameMatrice[1][1].equals("X") && gameMatrice[2][1].equals("X")) {
            hardBotStep = 8;
        } else if (gameMatrice[0][1].equals("X") && gameMatrice[1][1].equals(".") && gameMatrice[2][1].equals("X")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][1].equals("X") && gameMatrice[1][1].equals("X") && gameMatrice[2][1].equals(".")) {
            hardBotStep = 2;
        } else if (gameMatrice[0][2].equals(".") && gameMatrice[1][2].equals("X") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 9;
        } else if (gameMatrice[0][2].equals("X") && gameMatrice[1][2].equals(".") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 6;
        } else if (gameMatrice[0][2].equals("X") && gameMatrice[1][2].equals("X") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][0].equals(".") && gameMatrice[1][1].equals("X") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 7;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[1][1].equals(".") && gameMatrice[2][2].equals("X")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][0].equals("X") && gameMatrice[1][1].equals("X") && gameMatrice[2][2].equals(".")) {
            hardBotStep = 3;
        } else if (gameMatrice[0][2].equals(".") && gameMatrice[1][1].equals("X") && gameMatrice[2][0].equals("X")) {
            hardBotStep = 9;
        } else if (gameMatrice[0][2].equals("X") && gameMatrice[1][1].equals(".") && gameMatrice[2][0].equals("X")) {
            hardBotStep = 5;
        } else if (gameMatrice[0][2].equals("X") && gameMatrice[1][1].equals("X") && gameMatrice[2][0].equals(".")) {
            hardBotStep = 1;
        } else {
            if (gameMatrice[1][1].equals(".")){
                hardBotStep = 5;
            } else if (gameMatrice[0][0].equals(gameMatrice[0][2]) && gameMatrice[2][0].equals(gameMatrice[2][2])
                    && gameMatrice[0][0].equals(gameMatrice[2][2])){
                if (chanse < 4) {
                    hardBotStep = 7;
                } else if (chanse < 7) {
                    hardBotStep = 9;
                } else if (chanse < 10) {
                    hardBotStep = 1;
                } else {
                    hardBotStep = 3;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[0][2]) && gameMatrice[2][0].equals(gameMatrice[0][2])) {
                if (chanse < 5) {
                    hardBotStep = 7;
                } else if (chanse < 9) {
                    hardBotStep = 9;
                } else {
                    hardBotStep = 1;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[0][2]) && gameMatrice[2][2].equals(gameMatrice[0][2])) {
                if (chanse < 5) {
                    hardBotStep = 7;
                } else if (chanse < 9) {
                    hardBotStep = 9;
                } else {
                    hardBotStep = 3;
                }
            } else if (gameMatrice[2][2].equals(gameMatrice[0][2]) && gameMatrice[2][0].equals(gameMatrice[0][2])) {
                if (chanse < 5) {
                    hardBotStep = 3;
                } else if (chanse < 9) {
                    hardBotStep = 9;
                } else {
                    hardBotStep = 1;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[2][2]) && gameMatrice[2][0].equals(gameMatrice[2][2])) {
                if (chanse < 5) {
                    hardBotStep = 7;
                } else if (chanse < 9) {
                    hardBotStep = 3;
                } else {
                    hardBotStep = 1;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[0][2]) && gameMatrice[0][2].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 7;
                } else {
                    hardBotStep = 9;
                }
            } else if (gameMatrice[0][2].equals(gameMatrice[2][2]) && gameMatrice[0][2].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 3;
                } else {
                    hardBotStep = 9;
                }
            } else if (gameMatrice[2][2].equals(gameMatrice[2][0]) && gameMatrice[2][2].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 1;
                } else {
                    hardBotStep = 3;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[2][0]) && gameMatrice[2][0].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 7;
                } else {
                    hardBotStep = 1;
                }
            } else if (gameMatrice[0][0].equals(gameMatrice[2][2]) && gameMatrice[2][2].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 7;
                } else {
                    hardBotStep = 3;
                }
            } else if (gameMatrice[0][2].equals(gameMatrice[2][0]) && gameMatrice[2][0].equals(".")) {
                if (chanse < 7) {
                    hardBotStep = 1;
                } else {
                    hardBotStep = 9;
                }
            } else if (gameMatrice[0][0].equals(".")) {
                hardBotStep = 7;
            } else if (gameMatrice[0][2].equals(".")) {
                hardBotStep = 9;
            } else if (gameMatrice[2][0].equals(".")) {
                hardBotStep = 1;
            } else if (gameMatrice[2][2].equals(".")) {
                hardBotStep = 3;
            } else {
                easyBotStep();
            }
        }
        oldStep[hardBotStep] = hardBotStep;
        step = hardBotStep;
    }
}