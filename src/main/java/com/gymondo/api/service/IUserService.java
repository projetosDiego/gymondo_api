package com.gymondo.api.service;

import com.gymondo.api.model.UserSubscription;

public interface IUserService {

	UserSubscription findUserInformations(Long userId);

}
