package org.fasttrackit.chuninexam.controllers;

import org.fasttrackit.chuninexam.domain.Fight;
import org.fasttrackit.chuninexam.domain.FightResult;
import org.fasttrackit.chuninexam.domain.Fighter;
import org.fasttrackit.chuninexam.services.FightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fight")
public class FightController {
    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping({"", "/"})
    public List<Fight> getFights(@RequestParam(required = false) String name) {

        return name==null? fightService.getFights():fightService.getFight(name);
    }

    @PostMapping({"", "/"})
    public FightResult fight(@RequestBody Fight fight) {
        return fightService.fight(fight);
    }

    @GetMapping({"/{id}"})
    public Fight getById(@PathVariable int id) {
        return fightService.getFight(id);
    }
}
