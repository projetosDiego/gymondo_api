package com.gymondo.api.service;

import java.util.List;

import com.gymondo.api.model.UserApi;

public interface IUserService {

	List<UserApi> findAllUsers();

}
