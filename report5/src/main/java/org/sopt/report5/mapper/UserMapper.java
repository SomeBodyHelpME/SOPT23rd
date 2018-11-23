package org.sopt.report5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.report5.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    //모든 회원 리스트 조회
    @Select("SELECT * FROM user2")
    List<User> findAll();

    //회원 이름으로 조회
    @Select("SELECT * FROM user2 WHERE name = #{name}")
    User findByName(@Param("name") final String name);

    //회원 파트로 조회
    @Select("SELECT * FROM user2 WHERE part = #{part}")
    User findByPart(@Param("part") final String part);

    //회원 고유 번호로 조회
    @Select("SELECT * FROM user2 WHERE user_idx = #{user_idx}")
    User findByUserIdx(@Param("user_idx") final int user_idx);

    //회원 등록, Auto Increment는 회원 고유 번호
    //Auto Increment 값을 받아오고 싶으면 리턴 타입을 int(Auto Increment 컬럼 타입)으로 하면 된다.
    @Insert("INSERT INTO user2(name, part, profileUrl) VALUES(#{user.name}, #{user.part}, #{user.profileUrl})")
    @Options(useGeneratedKeys = true, keyColumn = "user.user_idx")
    int save(@Param("user") final User user);

//    //Auto Increment 값을 받아오고 싶지 않다면 필요 없다.
//    @Insert("INSERT INTO user2(name, part) VALUES(#{user.name}, #{user.part})")
//    void save2(@Param("user") final User user);

    //회원 정보 수정
    @Update("UPDATE user2 SET name = #{user.name}, part = #{user.part} WHERE user_idx = #{user_idx}")
    void update(@Param("user_idx") final int user_idx, @Param("user") final User user);

    //회원 삭제
    @Delete("DELETE FROM user2 where user_idx = #{user_idx}")
    void deleteByUserIdx(@Param("user_idx") final int user_idx);

}