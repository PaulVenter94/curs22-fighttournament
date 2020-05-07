package org.fasttrackit.chuninexam.domain;

public class FightResult {
    private String winner;
    private String loser;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    @Override
    public String toString() {
        return "FightResult{" +
                "winner='" + winner + '\'' +
                ", loser='" + loser + '\'' +
                '}';
    }
}
