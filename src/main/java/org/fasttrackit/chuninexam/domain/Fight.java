package org.fasttrackit.chuninexam.domain;

public class Fight {
    private int id;
    private final int firstFighter;
    private final int secondFighter;
    private final FightResult fightResult;

    public Fight(int id, int firstFighter, int secondFighter) {
        this.id = id;
        this.firstFighter = firstFighter;
        this.secondFighter = secondFighter;
        this.fightResult = new FightResult();
    }


    public int getId() {
        return id;
    }

    public int getFirstFighter() {
        return firstFighter;
    }

    public int getSecondFighter() {
        return secondFighter;
    }

    public FightResult getFightResult() {
        return fightResult;
    }
}
