package com.bussiness.webapp.admin.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bussiness.webapp.user.entity.UserEntity;

public interface AdminUsersDTO extends JpaRepository<UserEntity,Long> {
	@Query(value = "select * from bussiness_users where upper(username) like %?1% or upper(first_name) like %?1% or upper(last_name) like %?1% or upper(email) like %?1% or upper(something_about_you) like %?1% or upper(created_by) like %?1% or upper(updated_by) like %?1% order by user_id", nativeQuery = true)
	List<UserEntity> findAllBySearch(@Param("search") String search);	
	
	
	// Find One By Username
	@Query(value = "select * from bussiness_users where user_id = ?1", nativeQuery = true)
	UserEntity  findOneByUser_Id(@Param("user_id") Long user_id);
}
