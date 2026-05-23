package pl.pjatk.rentalservice.controller;

import pl.pjatk.rentalservice.model.Movie;
import pl.pjatk.rentalservice.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return rentalService.getMovie(id);
    }

    @PutMapping("/return/{id}")
    public Movie returnMovie(@PathVariable Long id) {
        return rentalService.returnMovie(id);
    }
}