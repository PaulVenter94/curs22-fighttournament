package org.fasttrackit.chuninexam.controllers;

import org.fasttrackit.chuninexam.domain.Fighter;
import org.fasttrackit.chuninexam.services.FighterServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fighters")
public class FighterController {
    public FighterServices fighterService;

    public FighterController(FighterServices fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping({"", "/"})
    public List<Fighter> getFighters() {
        return fighterService.getAll();
    }

    @GetMapping({"/{id}"})
    public Fighter getById(@PathVariable int id) {
        return fighterService.getHero(id);
    }

    @PostMapping
    public Fighter addFighter(@RequestBody Fighter fighter) {
        return fighterService.add(fighter);
    }

    @PutMapping("/{id}")
    public Fighter replaceFighter(@PathVariable int id, @RequestBody Fighter fighter) {
        return fighterService.updateHero(id, fighter);
    }

    @DeleteMapping("/{id}")
    public void deleteFighter(@PathVariable int id) {
        fighterService.delete(id);
    }

}
