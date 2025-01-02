package project.core;

import project.core.user.*;

public class UserApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        UserService userService = appConfig.userService();
        User user = new User(1L, "userA", Grade.VIP);
        userService.join(user);

        User findUser = userService.findUser(user.getId());

        System.out.println("new user = " + user.getName());
        System.out.println("find user = " + findUser.getName());
    }
}
