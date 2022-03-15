package com.zeman.rps.service;

import com.zeman.rps.domain.Move;
import com.zeman.rps.domain.Outcome;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class RPSEvalServiceImplTest {

    @Autowired
    private RPSEvalService rpsEvalService;

    @Test
    void evalMoveTest() {
        assertEquals(Outcome.WIN, rpsEvalService.evalMove(Move.ROCK, Move.SCISSORS));
        assertEquals(Outcome.DRAW, rpsEvalService.evalMove(Move.ROCK, Move.ROCK));
        assertEquals(Outcome.LOSS, rpsEvalService.evalMove(Move.ROCK, Move.PAPER));

        assertEquals(Outcome.LOSS, rpsEvalService.evalMove(Move.PAPER, Move.SCISSORS));
        assertEquals(Outcome.WIN, rpsEvalService.evalMove(Move.PAPER, Move.ROCK));
        assertEquals(Outcome.DRAW, rpsEvalService.evalMove(Move.PAPER, Move.PAPER));

        assertEquals(Outcome.DRAW, rpsEvalService.evalMove(Move.SCISSORS, Move.SCISSORS));
        assertEquals(Outcome.LOSS, rpsEvalService.evalMove(Move.SCISSORS, Move.ROCK));
        assertEquals(Outcome.WIN, rpsEvalService.evalMove(Move.SCISSORS, Move.PAPER));
    }
}