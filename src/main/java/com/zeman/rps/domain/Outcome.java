package com.zeman.rps.domain;

import com.zeman.rps.util.Utils;

public enum Outcome {
    WIN {
        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.win");
        }
    }, DRAW {
        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.draw");
        }
    }, LOSS {
        @Override
        public String toString() {
            return Utils.BUNDLE.getString("rps.defeat");
        }
    };

    @Override
    public abstract String toString();
}
