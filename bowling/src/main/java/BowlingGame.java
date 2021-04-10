class BowlingGame {

	private static final int LAST_FRAME = 10;
	private static final int TOTAL_PINS = 10;

	private enum GameStatus {
		START_GAME, SECOND_THROW, THROWING_AFTER_OPEN_FRAME, THROWING_AFTER_SPARE_FRAME, THROWING_AFTER_STRIKE, END_GAME
	}

	private int score = 0;
	private int pinsStanding = TOTAL_PINS;
	private int currentFrame = 1;
	private final int[] previousStrikes = {0, 0};

	private GameStatus gameStatus = GameStatus.START_GAME;

	void roll(final int pinsKnockedDown) {

		if (pinsKnockedDown < 0) {
			throw new IllegalStateException("Negative roll is invalid");
		}

		this.score += pinsKnockedDown;
		this.pinsStanding -= pinsKnockedDown;

		if (this.pinsStanding < 0) {
			throw new IllegalStateException("Pin count exceeds pins on the lane");
		}

		switch (this.gameStatus) {
			case START_GAME:
			case THROWING_AFTER_OPEN_FRAME:
				if (this.currentFrame <= LAST_FRAME) {
					this.score += pinsKnockedDown * (this.previousStrikes[0] + this.previousStrikes[1]);
				}
				this.gameStatus = (this.pinsStanding == 0) ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
				break;
			case SECOND_THROW:
				if (this.currentFrame <= LAST_FRAME) {
					this.score += pinsKnockedDown * (this.previousStrikes[0] + this.previousStrikes[1]);
				}
				if (this.pinsStanding == 0) {
					this.gameStatus = (this.currentFrame <= LAST_FRAME) ? GameStatus.THROWING_AFTER_SPARE_FRAME : GameStatus.END_GAME;
				} else {
					this.gameStatus = (this.currentFrame < LAST_FRAME) ? GameStatus.THROWING_AFTER_OPEN_FRAME : GameStatus.END_GAME;
				}
				this.pinsStanding = TOTAL_PINS;
				break;
			case THROWING_AFTER_SPARE_FRAME:
				if (this.currentFrame <= LAST_FRAME) {
					this.score += pinsKnockedDown;
					this.gameStatus = (this.pinsStanding == 0) ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
				} else  {
					this.gameStatus = GameStatus.END_GAME;
				}
				break;
			case THROWING_AFTER_STRIKE:
				this.score += pinsKnockedDown * (this.previousStrikes[0] + this.previousStrikes[1]);
				if (this.currentFrame < LAST_FRAME + 2) {
					this.gameStatus = (this.pinsStanding == 0) ? GameStatus.THROWING_AFTER_STRIKE : GameStatus.SECOND_THROW;
				} else {
					this.gameStatus = GameStatus.END_GAME;
				}
				break;
			case END_GAME:
				throw new IllegalStateException("Cannot roll after game is over");
		}

		this.previousStrikes[0] = this.previousStrikes[1];
		this.previousStrikes[1] = (pinsKnockedDown == TOTAL_PINS && this.currentFrame < LAST_FRAME) ? 1 : 0;
		if (this.pinsStanding == 0) {
			this.pinsStanding = TOTAL_PINS;
		}
		if (this.gameStatus != GameStatus.SECOND_THROW && this.gameStatus != GameStatus.END_GAME) {
			this.currentFrame++;
		}
	}

	int score() {
		if (this.gameStatus != GameStatus.END_GAME) {
			throw new IllegalStateException("Score cannot be taken until the end of the game");
		}
		return score;
	}

}