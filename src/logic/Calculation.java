package logic;

import models.AnswerModel;

import java.util.List;

public class Calculation {
    public static AnswerModel GetAnswers(List<Dice> dices){
        AnswerModel results = new AnswerModel();
        for (Dice dice: dices){
            results = CheckDiceValue(dice, results);
        }
        return results;
    }

    private static AnswerModel CheckDiceValue(Dice dice, AnswerModel toReturn){
        switch (dice.GetValue()){
            case 1:
                toReturn.TotalWakken++;
                toReturn.TotalPenguins += 6;
                break;
            case 2:
                break;
            case 3:
                toReturn.TotalWakken++;
                toReturn.TotalPolarBears += 2;
                toReturn.TotalPenguins += 4;
                break;
            case 4:
                break;
            case 5:
                toReturn.TotalWakken++;
                toReturn.TotalPolarBears += 4;
                toReturn.TotalPenguins += 2;
            case 6:
                break;
        }

        return toReturn;
    }
}
