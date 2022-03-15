package com.zeman.rps.util;

import com.zeman.rps.domain.Move;

import java.security.InvalidParameterException;
import java.util.*;

public class CLIHelper {

    private static final List<Move> MOVES = Collections.unmodifiableList(Arrays.stream(Move.values()).toList());
    private static final int EXIT_INDEX = MOVES.size() + 1;
    private static final int LAST_CHOICE_INDEX = EXIT_INDEX;



    public void printIntroduction() {
        System.out.println(Utils.BUNDLE.getString("cli.welcome"));
    }

    public void presentChoices() {
        System.out.println(Utils.BUNDLE.getString("cli.choose"));
        int i;
        for (i = 0; i < MOVES.size(); i++) {
            System.out.println(i + 1 + ": " + MOVES.get(i));
        }
        System.out.println(EXIT_INDEX + ": " + Utils.BUNDLE.getString("cli.exit"));
    }

    public String getInput() {
        Scanner console = new Scanner(System.in);
        return console.next();
    }

    public boolean isExit(String choice) throws InvalidParameterException {
        if (validateChoice(choice) == false) {
            throw new InvalidParameterException();
        }

        return choice.equals(String.valueOf(EXIT_INDEX));
    }

    public Move processChoice(String choice) throws InvalidParameterException {
        if (validateChoice(choice) == false) {
            throw new InvalidParameterException();
        }

        return MOVES.get(Integer.parseInt(choice) - 1);
    }

    private boolean validateChoice(String choice) {
        int number;
        try {
            number = Integer.valueOf(choice);
        } catch (NumberFormatException e) {
            return false;
        }

        if (number < 1 || number > LAST_CHOICE_INDEX) {
            return false;
        }

        return true;
    }
}
