package com.jca.eurocoincol.repositories;

import com.jca.eurocoincol.model.Coin;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoinRepository extends PagingAndSortingRepository<Coin,Integer> {
}
