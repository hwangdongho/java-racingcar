package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void constructor(String namesOfCarsText, int numberOfAttempts) {
        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);
        assertThat(racingGame.getNumberOfCars()).isEqualTo(namesOfCarsText.split(",").length);
        assertThat(racingGame.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void hasNextRace(String namesOfCarsText, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;
        }

        assertThat(numberOfAttempts).isEqualTo(whileCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void racing(String namesOfCarsText, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;

            assertThat(racingGame.getRound()).isEqualTo(whileCount);
        }
    }
}