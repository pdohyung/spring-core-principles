package project.core;

import project.core.user.Grade;
import project.core.user.User;
import project.core.user.UserService;
import project.core.user.UserServiceImpl;

public class UserApp {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User(1L, "userA", Grade.VIP);
        userService.join(user);

        User findUser = userService.findUser(user.getId());

        System.out.println("new user = " + user.getName());
        System.out.println("find user = " + findUser.getName());
    }
}
