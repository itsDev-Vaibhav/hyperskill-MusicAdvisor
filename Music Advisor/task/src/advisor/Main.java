package advisor;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        if(args.length > 1 && args[0].equals("-access")) {
            Server.SERVER_PATH = args[1];
        }
        MusicAdvisor musicAdvisor = new MusicAdvisor();
        musicAdvisor.takeInputFromUser();
    }
}
