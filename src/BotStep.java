public class BotStep extends Back {

    void botStep(){
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

    void easyBotStep(){
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

    void hardBotStep(){
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