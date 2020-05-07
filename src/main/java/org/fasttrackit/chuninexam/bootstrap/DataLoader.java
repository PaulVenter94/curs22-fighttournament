package org.fasttrackit.chuninexam.bootstrap;

import org.fasttrackit.chuninexam.domain.Fight;
import org.fasttrackit.chuninexam.domain.Fighter;
import org.fasttrackit.chuninexam.services.FightService;
import org.fasttrackit.chuninexam.services.FighterServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
   private final FighterServices fighterServices;
   private final FightService fightService;

    public DataLoader(FighterServices fighterServices, FightService fightService) {
        this.fighterServices = fighterServices;
        this.fightService = fightService;
    }

    @Override
    public void run(String... args) throws Exception {
        load();
    }

    private void load() {
        fighterServices.add(new Fighter(1, "Itachi", 10, 40));
        fighterServices.add(new Fighter(1, "Naruto", 3, 100));
        fighterServices.add(new Fighter(1, "Shikamaru", 1, 20));
        fighterServices.add(new Fighter(1, "Madara", 10, 80));
        fighterServices.add(new Fighter(1, "Sasuke", 8, 40));
        fighterServices.add(new Fighter(1, "Sakura", 5, 30));
        fighterServices.add(new Fighter(1, "Hashirama", 7, 120));
        fighterServices.add(new Fighter(1, "Nagato", 6, 50));
        fightService.add(new Fight(1,1,2));
        System.out.println("Heroes are loaded!");

    }

}
