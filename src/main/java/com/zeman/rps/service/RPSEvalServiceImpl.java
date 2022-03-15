package com.zeman.rps.service;

import com.zeman.rps.domain.Move;
import com.zeman.rps.domain.Outcome;
import org.springframework.stereotype.Service;

@Service
public class RPSEvalServiceImpl implements RPSEvalService{

    @Override
    public Outcome evalMove(Move playerMove, Move opponentMove) {
        if (playerMove.beats().contains(opponentMove)) {
            return Outcome.WIN;
        } else if (playerMove.draws().contains(opponentMove)) {
            return Outcome.DRAW;
        } else if (playerMove.loses().contains(opponentMove)) {
            return Outcome.LOSS;
        }

        return null;
    }
}
