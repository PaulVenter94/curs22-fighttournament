package org.fasttrackit.chuninexam.services;

import org.fasttrackit.chuninexam.domain.Fight;
import org.fasttrackit.chuninexam.domain.FightResult;
import org.fasttrackit.chuninexam.domain.Fighter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@Service
public class FightService {
    private final List<Fight> fights = new ArrayList<>();
    private final FighterServices fighterServices;

    public FightService(FighterServices fighterServices) {
        this.fighterServices = fighterServices;
    }

    public FightResult fight(Fight fight) {
        Fighter firstFighter = fighterServices.getHero(fight.getFirstFighter());
        Fighter secondFighter = fighterServices.getHero(fight.getSecondFighter());
        FightResult result = battleDeployment(firstFighter, secondFighter);
        addToList(fight, result);
        return result;
    }

    private void addToList(Fight fight, FightResult result) {
        Fight newFight = new Fight(fights.size() + 1, fight.getFirstFighter(), fight.getSecondFighter());
        newFight.getFightResult().setWinner(result.getWinner());
        newFight.getFightResult().setLoser(result.getLoser());
        fights.add(newFight);
    }

    private FightResult battleDeployment(Fighter firstFighter, Fighter secondFighter) {
        FightResult fightResult = new FightResult();
        int firstStamina = firstFighter.getStamina();
        int secondStamina = secondFighter.getStamina();
        Random random = new Random();

        while (firstStamina > 0 && secondStamina > 0) {
            int hit = random.nextInt(2);
            firstStamina = firstStamina - (hit * secondFighter.getSkill());

            if (firstStamina <= 0) {
                break;
            }
            hit = random.nextInt(2);
            secondStamina = secondStamina - (hit * firstFighter.getSkill());
        }
        if (firstStamina <= 0) {
            fightResult.setWinner(secondFighter.getName());
            fightResult.setLoser(firstFighter.getName());
        } else {
            fightResult.setWinner(firstFighter.getName());
            fightResult.setLoser(secondFighter.getName());
        }
        return fightResult;
    }

    public Fight getFight(int id) {
        return fights.get(id - 1);
    }

    public void add(Fight fight) {
        fights.add(fight);
    }

    public List<Fight> getFights() {
        return Collections.unmodifiableList(fights);
    }

    public List<Fight> getFight(String name) {
        int id = fighterServices.getHero(name).getId();
        return fights.stream()
                .filter(fight -> fight.getFirstFighter() == id || fight.getSecondFighter() == id)
                .collect(toList());
    }
}
