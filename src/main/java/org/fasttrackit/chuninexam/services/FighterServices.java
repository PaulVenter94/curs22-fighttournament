package org.fasttrackit.chuninexam.services;

import org.fasttrackit.chuninexam.domain.Fight;
import org.fasttrackit.chuninexam.domain.Fighter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FighterServices {
    private final List<Fighter> fighters = new ArrayList<>();

    public Fighter add(Fighter fighter) {
        Fighter newFighter = new Fighter(findId(), fighter.getName(), fighter.getSkill(),
                fighter.getStamina());
        fighters.add(newFighter);
        return newFighter;
    }

    public List<Fighter> getAll() {
        return Collections.unmodifiableList(fighters);
    }

    public Fighter getHero(int id) {
        return fighters.stream()
                .filter(fighter -> fighter.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Here with id:" + id + " does not exist!"));
    }

    public Fighter updateHero(int id, Fighter fighter) {
        Fighter newFighter = new Fighter(id, fighter.getName(), fighter.getSkill(),
                fighter.getStamina());
        newFighter.setWins(getHero(id).getWins());
        this.fighters.set(id - 1, newFighter);
        return newFighter;
    }

    public void delete(int id) {
        fighters.remove(id - 1);
    }

    private int findId() {
        if (fighters.size() == 0) return 1;
        int counter = 1;
        for (int i = 0; i < fighters.size(); i++) {
            if (fighters.get(i).getId() != counter) {
                return counter;
            } else {
                counter++;
            }
        }
        return fighters.size() + 1;
    }

    public Fighter getHero(String name) {
        return fighters.stream()
                .filter(fighter -> fighter.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Here with name:" + name + " does not exist!"));
    }
}
