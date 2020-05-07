package org.fasttrackit.chuninexam.domain;

public class Fighter {
    private final int id;
    private final String name;
    private final int skill;
    private final int stamina;
    private  int wins;

    public Fighter(int id, String name, int skill, int stamina) {
        this.id = id;
        this.name = name;
        this.skill = skill;
        this.stamina = stamina;
        this.wins = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public int getStamina() {
        return stamina;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fighter fighter = (Fighter) o;

        if (id != fighter.id) return false;
        if (skill != fighter.skill) return false;
        if (stamina != fighter.stamina) return false;
        if (wins != fighter.wins) return false;
        return name != null ? name.equals(fighter.name) : fighter.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + skill;
        result = 31 * result + stamina;
        result = 31 * result + wins;
        return result;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skill=" + skill +
                ", stamina=" + stamina +
                ", wins=" + wins +
                '}';
    }
}
