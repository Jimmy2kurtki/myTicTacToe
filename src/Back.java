import java.util.Random;
import java.util.Scanner;

public class Back {
    Scanner s = new Scanner(System.in);
    final String[][] gameMatrice = new String[3][3];
    int step;
    String strPlayer = "X";
    final int[] oldStep = new int[10];
    Random r = new Random();
    int quantityPlayers;
    int difficulty;

    int getQuantityPlayers() {
        return quantityPlayers;
    }

    void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    String getStrPlayer() {
        return strPlayer;
    }

    void startGame() {
        System.out.println("КРЕСТИКИ НОЛИКИ");
        for (int i = 0; i < gameMatrice.length; i++) {
            for (int j = 0; j < gameMatrice[i].length; j++) {
                gameMatrice[i][j] = ".";
            }
        }
        for (int i = 0; i < oldStep.length; i++) {
            oldStep[i] = 0;
        }
        System.out.println("1 или 2 игрока?");
        String strQuantityPlayers = s.nextLine();
        strQuantityPlayers = strQuantityPlayers.replaceAll("\\s+", "");
        try {
            quantityPlayers = Integer.parseInt(strQuantityPlayers);
            if (quantityPlayers == 1) {
                System.out.println("Выбрана одиночная игра");
            } else if (quantityPlayers == 2) {
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
            strDifficulty = strDifficulty.replaceAll("\\s+", "");
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
        for (int i = 0; i < gameMatrice.length; i++) {
            for (int j = 0; j < gameMatrice[i].length; j++) {
                System.out.print(gameMatrice[i][j] + "  ");
                if (j != 2) {
                    System.out.print("|  ");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("-------------");
            }
        }
    }

    void setStep() {
        int userStep = 1;
        do {
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
                    strUserStep = strUserStep.replaceAll("\\s+", "");
                    if (strUserStep.isEmpty()) {
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
                if (checkStep == 1 && userStep != 0) {
                    visual();
                    System.out.println("ТАКОЙ ХОД УЖЕ БЫЛ!");
                }
            } while (checkStep == 1);
            if (userStep > 0 && userStep < 10) {
                oldStep[userStep] = userStep;
            }
            if (userStep < 1 && userStep != 0 || userStep > 9) {
                visual();
                System.out.println("НЕТ ТАКОГО ПОЛЯ!");
            }
        } while (userStep < 1 || userStep > 9);
        step = userStep;
    }

    int getStep() {
        return step;
    }

    int check() {
        int result;
        if        (gameMatrice[0][0].equals(gameMatrice[0][1]) && gameMatrice[0][1].equals(gameMatrice[0][2]) && !gameMatrice[0][2].equals(".")
                || gameMatrice[1][0].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[1][2]) && !gameMatrice[1][2].equals(".")
                || gameMatrice[2][0].equals(gameMatrice[2][1]) && gameMatrice[2][1].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][0].equals(gameMatrice[1][0]) && gameMatrice[1][0].equals(gameMatrice[2][0]) && !gameMatrice[2][0].equals(".")
                || gameMatrice[0][1].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][1]) && !gameMatrice[2][1].equals(".")
                || gameMatrice[0][2].equals(gameMatrice[1][2]) && gameMatrice[1][2].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][0].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][2]) && !gameMatrice[2][2].equals(".")
                || gameMatrice[0][2].equals(gameMatrice[1][1]) && gameMatrice[1][1].equals(gameMatrice[2][0]) && !gameMatrice[2][0].equals(".")) {
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

    void setGameMatrice(int z, int x, String c) {
        gameMatrice[z][x] = c;
    }
}