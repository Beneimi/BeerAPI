package com.beneimi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByRatingGreaterThanOrderByRating(Double rating);
    List<Beer> findByNameOrderByName(String name);
    List<Beer> findByBreweryOrderByName(String brewery);
    List<Beer> findByTypeOrderByName(String type);
    List<Beer> findAllById(Long id);

}
