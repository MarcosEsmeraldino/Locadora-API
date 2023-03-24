package com.locadora.mock;

import com.locadora.model.User;

import static com.locadora.mock.ConstantsMock.*;

public class UserMock {

    public static User getMock() {
        User user = new User();
        user.setPass(USER_PASS);
        user.setEmail(USER_EMAIL);
        user.setId(USER_ID);
        user.setName(USER_NAME);
        return user;
    }
}
