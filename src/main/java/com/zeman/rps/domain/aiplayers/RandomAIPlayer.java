package com.zeman.rps.domain.aiplayers;

import com.zeman.rps.domain.Move;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This AI player always chooses their move randomly
 */
public class RandomAIPlayer implements AIPlayer {
    @Override
    public Move playMove() {
        Move[] moves = Move.values();

        return moves[ThreadLocalRandom.current().nextInt(0, moves.length)];
    }

}
