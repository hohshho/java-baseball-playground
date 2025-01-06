import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class NumbersBaseball {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(true) {
            startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int command = stoi(br.readLine());

            if(command == 2) break;
        }
    }

    public static void startGame() throws IOException {
        String[] answer = getRandomAnswer();

        while(true) {
            System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

            System.out.print("숫자를 입력해 주세요 : ");
            String[] input = br.readLine().split("");

            Result result = getResult(answer, input);

            if(result.isAllMiss()) {
                System.out.println("낫싱");
                continue;
            }

            if(result.isFinish()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            if(result.getBall() > 0) {
                System.out.print(result.getBall() + "볼 ");
            }
            if(result.getStrike() > 0) {
                System.out.print(result.getStrike() + "스트라이크");
            }
            System.out.println("");
        }
    }

    public static Result getResult(String[] answer, String[] input) {
        int strike = 0;
        int ball = 0;
        boolean[] checked = new boolean[3];

        for (int i = 0; i < 3; i++) {
            String curItem = answer[i];

            if (isStrike(curItem, input, checked, i)) {
                strike += 1;
                continue;
            }

            if (isBall(curItem, input, checked, i)) {
                ball += 1;
            }
        }

        return new Result(strike, ball);
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

    public static boolean isBall(String item, String[] input, boolean[] checked, int index) {
        for(int i=0; i<3; i++){
            // 스트라이크 상황 제외
            if(i == index) continue;

            if(item.equals(input[i]) && !checked[i]) {
                checked[i] = true;
                return true;
            }
        }
        return false;
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
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
