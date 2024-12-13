package org.example.springjdbc.repo;

import org.example.springjdbc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Users>getAllUsers(){
        String query = "SELECT * FROM table_jdbc";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Users users = new Users();
            users.setId(rs.getLong("id"));
            users.setName(rs.getString("name"));
            users.setSurname(rs.getString("surname"));
            users.setEmail(rs.getString("email"));
            return users;
        });
    }

    public void addUsers(Users users){
        String query = "INSERT INTO table_jdbc (name, surname, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, users.getName(), users.getSurname(), users.getEmail());
    }

    public void deleteById (Long id){
        String query = "DELETE FROM table_jdbc WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
