package com.api.questtech.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.questtech.models.AnswerModel;
import com.api.questtech.models.GameModeModel;
import com.api.questtech.models.GameModel;
import com.api.questtech.models.GameQuestionModel;
import com.api.questtech.models.PlayerAnswerModel;
import com.api.questtech.models.PlayerModel;
import com.api.questtech.models.QuestionAreaModel;
import com.api.questtech.models.QuestionModel;
import com.api.questtech.models.RoleModel;
import com.api.questtech.models.QuestionThemeModel;
import com.api.questtech.models.UserModel;
import com.api.questtech.models.enums.RoleName;
import com.api.questtech.repositories.AnswerRepository;
import com.api.questtech.repositories.GameModeRepository;
import com.api.questtech.repositories.GameQuestionRepository;
import com.api.questtech.repositories.GameRepository;
import com.api.questtech.repositories.PlayerAnswerRepository;
import com.api.questtech.repositories.PlayerRepository;
import com.api.questtech.repositories.QuestionAreaRepository;
import com.api.questtech.repositories.QuestionRepository;
import com.api.questtech.repositories.RoleRepository;
import com.api.questtech.repositories.QuestionThemeRepository;
import com.api.questtech.repositories.UserRepository;

@Configuration
@Profile("dev")
public class DevInstantiation implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameModeRepository gameModeRepository;
	
	@Autowired
	private QuestionAreaRepository questionAreaRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private PlayerAnswerRepository playerAnswerRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private QuestionThemeRepository themeRepository;
	
	@Autowired
	private GameQuestionRepository gameQuestionRepository;

	@Override
	public void run(String... args) throws Exception {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
		
		playerAnswerRepository.deleteAll();
		gameQuestionRepository.deleteAll();
		gameRepository.deleteAll();
		gameModeRepository.deleteAll();
		questionRepository.deleteAll();
		answerRepository.deleteAll();
		playerRepository.deleteAll();
		userRepository.deleteAll();
		roleRepository.deleteAll();
		themeRepository.deleteAll();
		questionAreaRepository.deleteAll();
		
		RoleModel role1 = new RoleModel(null, RoleName.USER);
		roleRepository.save(role1);
		
		UserModel user1 = new UserModel(null, "Bryan Santos", "sp.bryansantos@gmail.com", "Bryan", passwordEncoder.encode("123"));
		user1.getRoles().add(role1);
		
		PlayerModel player1 = new PlayerModel(null, user1, 1, 0);
		user1.setPlayer(player1);
		userRepository.save(user1);
		
		QuestionAreaModel questionArea1 = new QuestionAreaModel(null, "Front-end");
		questionAreaRepository.save(questionArea1);
		
		QuestionThemeModel questionTheme1 = new QuestionThemeModel(null, "Javascript", questionArea1);
		themeRepository.save(questionTheme1);
		
		GameModeModel gameMode1 = new GameModeModel(null, "Singleplayer", true);
		gameModeRepository.save(gameMode1);
		
		AnswerModel answer1 = new AnswerModel(null, "HyperText Markup Language");
		answerRepository.save(answer1);
		
		QuestionModel question1 = new QuestionModel(null, "O que significa HTML?", questionTheme1, answer1);
		question1.getAlternatives().add(answer1);
		question1.getPlayersAnswers().add(null);
		questionRepository.save(question1);
		
		PlayerAnswerModel playerAnswer1 = new PlayerAnswerModel(null, player1, question1, answer1);
		playerAnswerRepository.save(playerAnswer1);
		
		
		GameModel game1 = new GameModel(null, false, gameMode1);
		GameQuestionModel gameQuestion1 = new GameQuestionModel(game1, question1, Instant.parse("2023-03-06T21:53:07Z"));
		
		game1.getPlayers().add(player1);
		game1.getQuestions().add(gameQuestion1);
		gameRepository.save(game1);
	}

}
