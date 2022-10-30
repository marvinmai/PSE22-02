package de.unistuttgart.iste.sqa.pse.sheet02.homework;

/**
 * Describe the class HomeworkHamsterGame here.
 *
 * @author (Your name)
 * @version (a version number or a date)
 */
public class HomeworkHamsterGame extends InternalHomeworkHamsterGame {

    /*
     * Confused Paule! Help Paule to walk through the territory and to bring all the
     * grains into his cave. In the process Paule should collect all grains on the
     * field and deposit them in his cave (lower left corner - row 4 * column 1 and
     * indexing starts with 0).
     */
    @Override
    protected void hamsterRun() {
        // EXERCISE 2:
        // Help Paule to walk through the territory and to bring all the grains
        // into his cave.

        // Walk to the first grain
        move(5);

        // Pick up the first grain
        pickGrainAndLog();

        // Turn in the direction of the second grain
        turnRight();

        // Move to the second grain
        move(5);

        // Pick up the second grain
        pickGrainAndLog();

        // Move to the third grain
        turnAround();
        move(3);
        paule.turnLeft();
        move(3);

        // Pick up the third grain
        pickGrainAndLog();

        // Move to the fourth grain field
        turnAround();
        move(1);
        turnRight();
        move(3);
        turnRight();
        move(3);

        // Pick up all the grains at this field
        while (paule.grainAvailable()) {
            pickGrainAndLog();
        }

        // Move to the cave
        turnAround();
        move(3);
        paule.turnLeft();
        move(2);
        paule.turnLeft();
        move(3);

        // Put down all grains in the cave
        while (!paule.mouthEmpty()) {
            putGrainAndLog();
        }
    }

    private void move(int count) {
        for (int i = 0; i < count; i++) {
            paule.move();
        }
    }

    private void turnRight() {
        paule.turnLeft();
        paule.turnLeft();
        paule.turnLeft();
    }

    private void turnAround() {
        paule.turnLeft();
        paule.turnLeft();
    }

    private void pickGrainAndLog() {
        paule.pickGrain();
        logNumberOfGrainsOnField();
    }

    private void putGrainAndLog() {
        paule.putGrain();
        logNumberOfGrainsOnField();
    }

    private void logNumberOfGrainsOnField() {
        paule.write("Grains on field: "
                + game.getTerritory().getTotalGrainCount());
    }
}
