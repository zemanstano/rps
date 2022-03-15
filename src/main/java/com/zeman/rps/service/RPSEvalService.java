package com.zeman.rps.service;

import com.zeman.rps.domain.Move;
import com.zeman.rps.domain.Outcome;

public interface RPSEvalService {

    /**
     * Returns the outcome of the game for the player
     * @param playerMove
     * @param opponentMove
     * @return @{@link Outcome}
     */
    Outcome evalMove(Move playerMove, Move opponentMove);
}
