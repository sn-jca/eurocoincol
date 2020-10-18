package com.jca.eurocoincol.controllers;

import com.jca.eurocoincol.model.Coin;
import com.jca.eurocoincol.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoinRestController {

    @Autowired
    private CoinRepository coinRepository;

    @GetMapping("coin/{id}")
    public Optional<Coin> getCoinById(@PathVariable int id){
        if (coinRepository.findById(id).isPresent()){
            return coinRepository.findById(id);
        }

        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "no coin has been found for id :" + id
        );
    }

    @GetMapping("/coins")
    public Iterable<Coin> getAllCoins(){
        return coinRepository.findAll();
    }

    @PostMapping("/coin/add")
    public Coin addCoin(@RequestBody Coin coin){
            return coinRepository.save(coin);

    }

    @PutMapping("/coin/{id}")
    public Coin updateCoin(@PathVariable int id, @RequestBody Coin newCoin){
        Optional<Coin> coin = coinRepository.findById(id);
        if (coin.isPresent()){
            return coinRepository.save(coin.get());
        }

        else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "no coin has been found for id :" + id
        );
    }

    @DeleteMapping("/coin/{id}")
    void deleteCoin(@PathVariable int id) {
        coinRepository.deleteById(id);
    }

}
