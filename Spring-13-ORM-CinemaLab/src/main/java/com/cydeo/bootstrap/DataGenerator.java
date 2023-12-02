package com.cydeo.bootstrap;

import com.cydeo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {


    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    /**
    public DataGenerator(AccountRepository accountRepository,
     CinemaRepository cinemaRepository,
     MovieRepository movieRepository,
     MovieCinemaRepository movieCinemaRepository,
     TicketRepository ticketRepository,
     GenreRepository genreRepository,
     UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;

    }
     */

    @Override
    public void run(String... args) throws Exception {

        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountRepository.getAllAdminAccounts());
        System.out.println(cinemaRepository.getAllNonDuplicatedCinemaBySponsoredName());
        System.out.println(movieRepository.getAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.retrieveAllMovieCinemaByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsByUserAccount(4L));
        System.out.println(ticketRepository.fetchAllTicketsBetweenRangeOfTime(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllTicketBySearchCriteria("it"));
        System.out.println(genreRepository.fetchAllGenres());
        System.out.println(userRepository.getAllUsers());

    }

}
