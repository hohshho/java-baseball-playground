import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.IntStream;

public class NumbersBaseball {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean continueGame = true;

        while(continueGame) {
            startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int command = stoi(br.readLine());

            continueGame = isGameFinish(command);
        }
    }

    public static boolean isGameFinish(int command){
         return command != 2;
    }

    public static void startGame() throws IOException {
        String[] answer = getRandomAnswer();
        boolean continueGame = true;

        while(continueGame) {
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

            System.out.print("숫자를 입력해 주세요 : ");
            String[] input = br.readLine().split("");

            Result result = getResult(answer, input);

            continueGame = result.writeConsole();
        }
    }

    public static Result getResult(String[] answer, String[] input) {
        Result result = new Result(0, 0);
        boolean[] checked = new boolean[3];

        for (int i = 0; i < 3; i++) {
            String curItem = answer[i];

            checkStrikeBall(curItem, input, checked, i, result);
        }

        return result;
    }

    public static void checkStrikeBall(String curItem, String[] input, boolean[] checked, int index, Result result) {
        if (isStrike(curItem, input, checked, index)) {
            result.strike += 1;
            return;
        }

        if (isBall(curItem, input, checked, index)) {
            result.ball += 1;
        }
    }

    public static String[] getRandomAnswer() {
        Random random = new Random();

        return String.valueOf(100 + random.nextInt(900)).split("");
    }

    public static boolean isStrike(String curItem, String[] input, boolean[] checked, int index) {
        if(curItem.equals(input[index])) {
            checked[index] = true;
            return true;
        }

        return false;
    }

//    public static boolean isBall(String item, String[] input, boolean[] checked, int index) {
//        for(int i=0; i<3; i++){
//            // 스트라이크 상황 제외
//            if(i == index) continue;
//
//            if(item.equals(input[i]) && !checked[i]) {
//                checked[i] = true;
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean isBall(String item, String[] input, boolean[] checked, int index) {
        return IntStream.range(0, 3)
                .filter(i -> i != index && item.equals(input[i]) && !checked[i])
                .peek(i -> checked[i] = true)
                .findFirst()
                .isPresent();
    }

    public static class Result {
        int strike;
        int ball;
        Result(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isAllMiss() {
            return strike == 0 && ball == 0;
        }

        public boolean isFinish() {
            return this.strike == 3;
        }

        public int getBall() {
            return this.ball;
        }

        public int getStrike() {
            return this.strike;
        }

        public boolean writeConsole() {
            if(this.isAllMiss()) {
                System.out.println("낫싱");
            }

            if(this.isFinish()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }

            if(this.getBall() > 0) {
                System.out.println(this.getBall() + "볼 ");
            }

            if(this.getStrike() > 0) {
                System.out.println(this.getStrike() + "스트라이크");
            }

            return true;
        }
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
