package com.app.web.ags.colombiaelige.POJOS;

public class VotesResults {

    private String name;
    private int votes;

    public VotesResults(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
