package logic;

import models.AnswerModel;

import java.util.List;

public class Calculation {
    /**
     * returns an AnswerModel with the current answers of the thrown dices.
     * @param dices the list of dices to check.
     */
    public static AnswerModel GetAnswers(List<Dice> dices){
        AnswerModel results = new AnswerModel();
        for (Dice dice: dices){
            results = CheckDiceValue(dice, results);
        }
        return results;
    }

    /**
     * updates an AnswerModel with the answers of the current dice.
     * @param dice a dice to update the AnswerModel with.
     * @param toReturn the AnswerModel to update.
     */
    private static AnswerModel CheckDiceValue(Dice dice, AnswerModel toReturn){
        switch (dice.GetValue()){
            case 1:
                toReturn.TotalIceHoles++;
                toReturn.TotalPenguins += 6;
                break;
            case 2:
                break;
            case 3:
                toReturn.TotalIceHoles++;
                toReturn.TotalPolarBears += 2;
                toReturn.TotalPenguins += 4;
                break;
            case 4:
                break;
            case 5:
                toReturn.TotalIceHoles++;
                toReturn.TotalPolarBears += 4;
                toReturn.TotalPenguins += 2;
            case 6:
                break;
        }

        return toReturn;
    }
}
