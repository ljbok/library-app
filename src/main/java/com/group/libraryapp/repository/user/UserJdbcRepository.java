package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // request를 통쨰로 넘기지 않고 id만 넘겨줌으로써 메모리 낭비 방지
    public boolean isUserNotExist(long id){
        String readSql = "SELECT * FROM user WHERE id = ?";
        // 조회했을 때 결과가 있으면 0 반환하고(비어있지 않고) 없으면 비어있음, ?에 넣을 Id 값 가져오기
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(String name, long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean isUserNotExist(String name) {
        String readSql = "SELECT * FROM user WHERE name = ?";
        // 조회했을 때 결과가 있으면 0 반환하고(비어있지 않고) 없으면 비어있음, ?에 넣을 Id 값 가져오기
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void deleteUser(String name) {
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user (name, age) VALUES(?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override // 아래 mapRow 는 user 정보를 userResponse 타입으로 바꿔주는 함수 오버라이드 단축기 컨트롤 + o
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
    }
}
