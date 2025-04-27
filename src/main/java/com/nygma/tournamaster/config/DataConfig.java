package com.nygma.tournamaster.config;

import com.nygma.tournamaster.BeltRankingEnum;
import com.nygma.tournamaster.RoleEnum;
import com.nygma.tournamaster.model.*;
import com.nygma.tournamaster.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Profile("dev")
public class DataConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TournamentRepository tournamentRepository;
    private final PlayerRepository playerRepository;
    private final CategoryRepository categoryRepository;
    private final BracketRepository bracketRepository;
    private final MatchRepository matchRepository;
    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    public DataConfig(UserRepository userRepository,
                      TournamentRepository tournamentRepository,
                      PlayerRepository playerRepository,
                      CategoryRepository categoryRepository,
                      BracketRepository bracketRepository,
                      MatchRepository matchRepository,
                      RegistrationRepository registrationRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
        this.categoryRepository = categoryRepository;
        this.bracketRepository = bracketRepository;
        this.matchRepository = matchRepository;
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Création des utilisateurs si nécessaire
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setEmail("user@tournamaster.fr");
            user1.setRole(RoleEnum.ROLE_USER);
            user1.setPassword(passwordEncoder.encode("xxx"));

            User user2 = new User();
            user2.setEmail("admin@tournamaster.fr");
            user2.setRole(RoleEnum.ROLE_ADMIN);
            user2.setPassword(passwordEncoder.encode("xxx"));

            List<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);

            // Création d'utilisateurs additionnels pour les joueurs
            for (int i = 1; i <= 16; i++) {
                User playerUser = new User();
                playerUser.setEmail("player" + i + "@tournamaster.fr");
                playerUser.setRole(RoleEnum.ROLE_USER);
                playerUser.setPassword(passwordEncoder.encode("xxx"));
                users.add(playerUser);
            }

            userRepository.saveAll(users);
        }

        User user = userRepository.findOneByEmail("user@tournamaster.fr").orElseThrow();
        User admin = userRepository.findOneByEmail("admin@tournamaster.fr").orElseThrow();

        // Création des tournois si nécessaire
        List<Tournament> tournaments = new ArrayList<>();
        if (tournamentRepository.count() == 0) {
            Tournament tournament1 = new Tournament();
            tournament1.setName("Championnat de France CFJJB");
            tournament1.setCity("Paris");
            tournament1.setState("Ile de France");
            tournament1.setCountry("France");
            tournament1.setDate(LocalDate.now());
            tournament1.setOwner(user);
            tournaments.add(tournament1);

            Tournament tournament2 = new Tournament();
            tournament2.setName("Stairs of Money");
            tournament2.setCity("Creil");
            tournament2.setState("Oise");
            tournament2.setCountry("France");
            tournament2.setDate(LocalDate.now().plusDays(65));
            tournament2.setOwner(admin);
            tournaments.add(tournament2);

            tournamentRepository.saveAll(tournaments);
        } else {
            tournaments.addAll(tournamentRepository.findAll());
        }

        // Création des joueurs si nécessaire
        if (playerRepository.count() == 0) {
            List<Player> players = new ArrayList<>();
            List<User> playerUsers = userRepository.findAllByEmailIn(
                    Arrays.asList(
                            "player1@tournamaster.fr", "player2@tournamaster.fr",
                            "player3@tournamaster.fr", "player4@tournamaster.fr",
                            "player5@tournamaster.fr", "player6@tournamaster.fr",
                            "player7@tournamaster.fr", "player8@tournamaster.fr",
                            "player9@tournamaster.fr", "player10@tournamaster.fr",
                            "player11@tournamaster.fr", "player12@tournamaster.fr",
                            "player13@tournamaster.fr", "player14@tournamaster.fr",
                            "player15@tournamaster.fr", "player16@tournamaster.fr"
                    )
            );

            String[] firstNames = {"Jean", "Pierre", "Michel", "David", "Thomas", "Alexandre", "Nicolas", "Antoine",
                    "Lucas", "Hugo", "Maxime", "Kevin", "Raphael", "Mathieu", "Julien", "Vincent"};

            String[] lastNames = {"Dupont", "Martin", "Dubois", "Moreau", "Laurent", "Simon", "Leroy", "Roux",
                    "Fournier", "Girard", "Bonnet", "Mercier", "Blanc", "Guerin", "Boyer", "Garnier"};

            for (int i = 0; i < playerUsers.size(); i++) {
                Player player = new Player();
                player.setFirstName(firstNames[i]);
                player.setLastName(lastNames[i]);
                player.setBirthDate(LocalDate.now().minusYears(20 + i % 10));
                player.setUser(playerUsers.get(i));
                players.add(player);
            }

            playerRepository.saveAll(players);
        }

        List<Player> allPlayers = new ArrayList<>(playerRepository.findAll());

        if (categoryRepository.count() == 0) {
            Tournament tournament1 = tournaments.getFirst();

            List<Category> categories = new ArrayList<>();

            Category adultMaleBlueLight = new Category();
            adultMaleBlueLight.setName("Adulte Homme Bleu -70kg");
            adultMaleBlueLight.setGender("MALE");
            adultMaleBlueLight.setMinWeight(0.0);
            adultMaleBlueLight.setMaxWeight(70.0);
            adultMaleBlueLight.setBeltLevel(BeltRankingEnum.Blue);
            adultMaleBlueLight.setMinAge(18);
            adultMaleBlueLight.setMaxAge(99);
            adultMaleBlueLight.setTournament(tournament1);
            categories.add(adultMaleBlueLight);

            Category adultMalePurpleMiddle = new Category();
            adultMalePurpleMiddle.setName("Adulte Homme Violette -80kg");
            adultMalePurpleMiddle.setGender("MALE");
            adultMalePurpleMiddle.setMinWeight(70.1);
            adultMalePurpleMiddle.setMaxWeight(80.0);
            adultMalePurpleMiddle.setBeltLevel(BeltRankingEnum.Purple);
            adultMalePurpleMiddle.setMinAge(18);
            adultMalePurpleMiddle.setMaxAge(99);
            adultMalePurpleMiddle.setTournament(tournament1);
            categories.add(adultMalePurpleMiddle);

            categoryRepository.saveAll(categories);

            // Création des inscriptions pour la première catégorie
            List<Registration> registrations = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                Registration registration = new Registration();
                registration.setPlayer(allPlayers.get(i));
                registration.setCategory(adultMaleBlueLight);
                registration.setRegistrationDate(LocalDateTime.now().minusDays(10).plusHours(i));
                registration.setWeightConfirmed(true);
                registration.setActualWeight(65.0 + i);
                registration.setStatus("CONFIRMED");
                registrations.add(registration);
            }

            registrationRepository.saveAll(registrations);

            // Création d'un bracket pour la première catégorie
            Bracket bracket = new Bracket();
            bracket.setCategory(adultMaleBlueLight);
            bracket.setGeneratedAt(LocalDateTime.now().minusDays(2));
            bracket.setStatus("IN_PROGRESS");
            bracket.setSeedingMethod("RANDOM");
            bracket.setRoundsCount(3); // Log2(8) = 3 rounds pour 8 joueurs

            bracketRepository.save(bracket);

            List<Match> matches = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                Match match = new Match();
                match.setBracket(bracket);
                match.setRoundNumber(1);
                match.setMatchNumber(i + 1);
                match.setPlayer1(allPlayers.get(i * 2));
                match.setPlayer2(allPlayers.get(i * 2 + 1));
                match.setStatus("SCHEDULED");
                match.setScheduledTime(LocalDateTime.now().plusHours(i));
                matches.add(match);
            }

            matchRepository.saveAll(matches);

            List<Match> secondRoundMatches = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Match match = new Match();
                match.setBracket(bracket);
                match.setRoundNumber(2);
                match.setMatchNumber(i + 1);
                match.setStatus("SCHEDULED");
                match.setScheduledTime(LocalDateTime.now().plusDays(1).plusHours(i));
                secondRoundMatches.add(match);
            }

            matchRepository.saveAll(secondRoundMatches);

            Match finalMatch = new Match();
            finalMatch.setBracket(bracket);
            finalMatch.setRoundNumber(3);
            finalMatch.setMatchNumber(1);
            finalMatch.setStatus("SCHEDULED");
            finalMatch.setScheduledTime(LocalDateTime.now().plusDays(1).plusHours(3));

            matchRepository.save(finalMatch);

            for (int i = 0; i < 4; i++) {
                Match firstRoundMatch = matches.get(i);
                Match secondRoundMatch = secondRoundMatches.get(i / 2);

                firstRoundMatch.setNextMatch(secondRoundMatch);
                firstRoundMatch.setNextMatchPosition(i % 2 + 1); // Alternance entre position 1 et 2

                matchRepository.save(firstRoundMatch);
            }

            for (int i = 0; i < 2; i++) {
                Match secondRoundMatch = secondRoundMatches.get(i);
                secondRoundMatch.setNextMatch(finalMatch);
                secondRoundMatch.setNextMatchPosition(i + 1);

                matchRepository.save(secondRoundMatch);
            }

            for (int i = 0; i < 2; i++) {
                Match match = matches.get(i);
                match.setStatus("COMPLETED");
                match.setActualStartTime(LocalDateTime.now().minusHours(4 - i));
                match.setActualEndTime(LocalDateTime.now().minusHours(3 - i));
                match.setPointsPlayer1(i == 0 ? 15 : 0);
                match.setPointsPlayer2(i == 0 ? 8 : 4);
                match.setWinner(i == 0 ? match.getPlayer1() : match.getPlayer2());
                match.setWinMethod(i == 0 ? "POINTS" : "SUBMISSION");

                if (match.getNextMatchPosition() == 1) {
                    match.getNextMatch().setPlayer1(match.getWinner());
                } else {
                    match.getNextMatch().setPlayer2(match.getWinner());
                }

                matchRepository.save(match);
                matchRepository.save(match.getNextMatch());
            }
        }
    }
}
