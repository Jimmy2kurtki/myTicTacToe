import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Back game = new Back();
        Scanner s = new Scanner(System.in);
        String answerUser;
        do {
            int turn = 2;
            game.startGame();
            do {
                if (turn % 2 == 0) {
                    game.setStrPlayer("X");
                } else {
                    game.setStrPlayer("O");
                }
                if (game.getQuantityPlayers() == 1 && game.getStrPlayer().equals("O")) {
                    game.botStep();
                    System.out.println("Бот ходит на поле " + game.getStep());
                } else {
                    game.visual();
                    game.setStep();
                }
                switch (game.getStep()) {
                    case 7 -> game.setGameMatrice(0, 0, game.getStrPlayer());
                    case 8 -> game.setGameMatrice(0, 1, game.getStrPlayer());
                    case 9 -> game.setGameMatrice(0, 2, game.getStrPlayer());
                    case 4 -> game.setGameMatrice(1, 0, game.getStrPlayer());
                    case 5 -> game.setGameMatrice(1, 1, game.getStrPlayer());
                    case 6 -> game.setGameMatrice(1, 2, game.getStrPlayer());
                    case 1 -> game.setGameMatrice(2, 0, game.getStrPlayer());
                    case 2 -> game.setGameMatrice(2, 1, game.getStrPlayer());
                    case 3 -> game.setGameMatrice(2, 2, game.getStrPlayer());
                }
                turn++;
            } while (game.check() == 0);
            if (game.check() == 1) {
                game.visual();
                System.out.println("!!!НИЧЬЯ!!!");
            } else if (game.check() == 2) {
                game.visual();
                System.out.println("!!!Игрок " + game.getStrPlayer() + " ПОБЕДИЛ!!!");
            }
            System.out.println("Если хотите сыграть еще, введите 1:");
            answerUser = s.nextLine();
        } while (answerUser.equals("1"));
    }
}