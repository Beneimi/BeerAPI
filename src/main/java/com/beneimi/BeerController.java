package com.beneimi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerRepository repository;

    //
    // GET
    //

    // All
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers")
    List<Beer> findAll() {
        return repository.findAll();
    }

    // By Id
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers/id={id}")
    List<Beer> findOne(@PathVariable Long id) {
        return repository.findAllById(id);
    }

    // By Name
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers/name={name}")
    List<Beer> findByName(@PathVariable String name) {
        return repository.findByNameOrderByName(name);
    }

    // By Type
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers/type={type}")
    List<Beer> findByType(@PathVariable String type) {
        return repository.findByTypeOrderByName(type);
    }

    // By Brewery
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers/brewery={brewery}")
    List<Beer> findByBrewery(@PathVariable String brewery) {
        return repository.findByBreweryOrderByName(brewery);
    }

    // By Rating
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @GetMapping("/beers/rating={rating}")
    List<Beer> findRatingHigher(@PathVariable Double rating) {
        return repository.findByRatingGreaterThanOrderByRating(rating);
    }


    //
    // POST
    //

    // Create
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @PostMapping("/beers")
    @ResponseStatus(HttpStatus.CREATED)
    Beer newBeer(@RequestBody Beer newBeer) {
        return repository.save(newBeer);
    }


    // Create with id / Update
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @PutMapping("/beers/id={id}")
    Beer saveOrUpdate(@RequestBody Beer newBeer, @PathVariable Long id) {
        return repository.findById(id)
                .map(x -> {
                    x.setName(newBeer.getName());
                    x.setBrewery(newBeer.getBrewery());
                    x.setType(newBeer.getType());
                    x.setRating(newBeer.getRating());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newBeer.setId(id);
                    return repository.save(newBeer);
                });
    }

    //
    // DELETE
    //

    // All
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @DeleteMapping("/beers")
    void deleteAll() {
        repository.deleteAll();
    }

    // By Id
    @CrossOrigin(origins = "https://beer-frontend-2020.herokuapp.com/")
    @DeleteMapping("/beers/id={id}")
    void deleteBeer(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
