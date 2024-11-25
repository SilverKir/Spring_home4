package com.example.sem4home.repository;

import com.example.sem4home.configuration.RepositoryConfiguration;
import com.example.sem4home.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private RepositoryConfiguration configuration;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAddress(r.getString("address"));
            return rowObject;
        };
        return jdbc.query(configuration.getFindAll(), userRowMapper);
    }
    public User findUserById(int id) {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setAddress(r.getString("address"));
            return rowObject;
        };
        return jdbc.query(configuration.getFindUserById(),new Object[]{id}, userRowMapper).stream().findFirst().orElse(null
        );
    }

    public void save(User user) {
        jdbc.update(configuration.getSave(), user.getName(),user.getAddress());
    }

    public void deleteById(int id) {
        jdbc.update(configuration.getDeleteById(), id);
    }

    public void update(User user) {
        jdbc.update(configuration.getUpdate(), user.getName(), user.getAddress(), user.getId());
    }

}
