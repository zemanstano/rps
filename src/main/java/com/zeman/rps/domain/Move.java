package com.zeman.rps.domain;

import com.zeman.rps.util.Utils;

import java.util.Set;

public enum Move {

    ROCK {
        @Override
        public Set<Move> beats() {
            return Set.of(Move.SCISSORS);
        }

        @Override
        public Set<Move> draws() {
            return Set.of(Move.ROCK);
        }

        @Override
        public Set<Move> loses() {
            return Set.of(Move.PAPER);
        }

        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.rock");
        }
    },

    PAPER {
        @Override
        public Set<Move> beats() {
            return Set.of(Move.ROCK);
        }

        @Override
        public Set<Move> draws() {
            return Set.of(Move.PAPER);
        }

        @Override
        public Set<Move> loses() {
            return Set.of(Move.SCISSORS);
        }

        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.paper");
        }
    },

    SCISSORS {
        @Override
        public Set<Move> beats() {
            return Set.of(Move.PAPER);
        }

        @Override
        public Set<Move> draws() {
            return Set.of(Move.SCISSORS);
        }

        @Override
        public Set<Move> loses() {
            return Set.of(Move.ROCK);
        }

        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.scissors");
        }
    };

    public abstract Set<Move> beats();
    public abstract Set<Move> draws();
    public abstract Set<Move> loses();
    @Override
    public abstract String toString();


}
