package org.example;


import service.ClientServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{

    private final ClientServiceImpl clientServiceImpl;
    public App() {
        this.clientServiceImpl = new ClientServiceImpl();
    }

    public void start() {
        clientServiceImpl.startGame();
    }
    public static void main( String[] args )
    {
        App game = new App();
        game.start();
    }

}
