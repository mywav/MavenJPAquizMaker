package com.thevisualcommunicationguy.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thevisualcommunicationguy.models.Quiz;
import com.thevisualcommunicationguy.repositories.QuizRepository;

@RestController
@RequestMapping("/api/v1/quizes")
public class QuizesController {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private QuizRepository quizRepository;

	@GetMapping
	public List<Quiz> list() {
		return quizRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Quiz quiz) {
		quizRepository.save(quiz);
	}

	@GetMapping("/{id}")
	public Quiz get(@PathVariable("id") long id) {
		return quizRepository.getOne(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK) 
	public Quiz merge(@RequestBody Quiz quiz, @PathVariable("id") long id) {
		if (quiz.getQuestion03() != null)
			try {
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"UPDATE quiz SET question03 = " +
						quiz.getQuestion03() + " WHERE id = " +
						quiz.getId()
					);
				statement.close();
				connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (quiz.getQuestion04() != null)
				try {
					Connection connection = dataSource.getConnection();
					Statement statement = connection.createStatement();
					statement.executeUpdate(
							"UPDATE quiz SET question04 = " +
							quiz.getQuestion04() + " WHERE id = " +
							quiz.getId()
						);
					statement.close();
					connection.close();
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return quiz;
	}
}
