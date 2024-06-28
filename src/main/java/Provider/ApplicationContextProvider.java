package Provider;

import service.GameServiceImpl;
import service.UserService;

public class ApplicationContextProvider {
    public static UserService getUserService() {
        return ApplicationContext.getUserService();
    }
    public static GameServiceImpl getGameService() {
        return ApplicationContext.getGameService();
    }
}
