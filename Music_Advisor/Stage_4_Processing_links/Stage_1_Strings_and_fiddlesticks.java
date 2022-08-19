package org.hyperskill.projects.Music_Advisor.Stage_4_Processing_links;

public class Stage_1_Strings_and_fiddlesticks {
    public static void main(String[] args) {

        if(args.length > 1 && args[0].equals("-access")) {
            Server.SERVER_PATH = args[1];
        }
        MusicAdvisor musicAdvisor = new MusicAdvisor();
        musicAdvisor.takeInputFromUser();
    }
}
