package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.Person;
import utils.BaseBallGenerator;
import utils.BaseBallNumberValidator;
import utils.InputValidator;

import java.util.List;

public class GameController {

    Person person;

    Computer computer;
    BaseBallNumberValidator validator;

    InputValidator inputValidator;

    public GameController() {

        this.person = new Person();
        this.computer = new Computer();
        this.validator = new BaseBallNumberValidator();
        this.inputValidator = new InputValidator();
    }

    public void gameStart() {
        computer.runGeneratorNumber();
        List<Integer> aiNumberList = computer.getNumberList();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 :");
            String str = Console.readLine();
            inputValidator.checkInputNumber(str);

            person.inputStringToNumber(str);
            List<Integer> personNumberList = person.getNumberList();

            Boolean resultTag = validator.checkInningResult(aiNumberList, personNumberList);

            if (resultTag) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                boolean isStart = checkRestart();
                if (isStart) {
                    computer.runGeneratorNumber();
                    aiNumberList = computer.getNumberList();
                    continue;
                }
                //재시작안함
                break;
            }

        }

    }
    public boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        if (str.equals("1")) {
            return true;
        }else if (str.equals("2")) {
            return false;
        }
        return false;
    }


}
