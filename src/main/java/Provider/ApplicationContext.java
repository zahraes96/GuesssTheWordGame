package Provider;

import service.GameServiceImpl;
import service.UserService;

public class ApplicationContext {
    private static final UserService userService = new UserService();
    private static final GameServiceImpl GameService = new GameServiceImpl();

    public static UserService getUserService() {
        return userService;
    }
    public static GameServiceImpl getGameService() {
        return GameService;
    }
}
