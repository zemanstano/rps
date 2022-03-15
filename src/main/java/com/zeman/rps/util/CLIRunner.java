package com.zeman.rps.util;

import com.zeman.rps.domain.aiplayers.AIPlayer;
import com.zeman.rps.domain.aiplayers.RandomAIPlayer;
import com.zeman.rps.domain.Move;
import com.zeman.rps.service.RPSEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
@Profile("!test")
public class CLIRunner implements CommandLineRunner {

    @Autowired
    private RPSEvalService rpsEvalService;

    @Override
    public void run(String... args) throws Exception {

        AIPlayer aiPlayer = new RandomAIPlayer();
        CLIHelper cliHelper = new CLIHelper();

        cliHelper.printIntroduction();
        while (true) {
            cliHelper.presentChoices();
            String choice = cliHelper.getInput();
            Move playerMove;
            try {
                if (cliHelper.isExit(choice)) {
                    return;
                }

                playerMove = cliHelper.processChoice(choice);
            } catch (InvalidParameterException e) {
                System.out.println(Utils.BUNDLE.getString("cli.opponent.invalid.move"));
                continue;
            }
            Move opponentMove = aiPlayer.playMove();

            System.out.println(Utils.BUNDLE.getString("cli.opponent.move") + " " + opponentMove);
            System.out.println(rpsEvalService.evalMove(playerMove, opponentMove));
        }
    }

}
