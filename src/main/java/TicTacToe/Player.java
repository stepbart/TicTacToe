package TicTacToe;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> results = new ArrayList<>();
    private String name;
    private boolean isEasy = true;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private int rounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEasy() {
        return isEasy;
    }

    public void setEasy(boolean easy) {
        isEasy = easy;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        this.wins = wins + 1;
        this.rounds = rounds - 1;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses() {
        this.losses = losses + 1;
        this.rounds = rounds - 1;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws() {
        this.draws = draws + 1;
        this.rounds = rounds - 1;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setResult(int result) {
        this.results.add(result);
    }

    public int getLastResults() {
        int lastResults = this.results.get(this.results.size() - 1);
        return lastResults;
    }

    public int howManyRounds() {
        int howManyRounds = this.results.size();
        return howManyRounds;
    }

}
