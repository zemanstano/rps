package com.zeman.rps.domain.aiplayers;

import com.zeman.rps.domain.Move;

public interface AIPlayer {

    /**
     * @return @{@link Move}
     */
    Move playMove();
}
