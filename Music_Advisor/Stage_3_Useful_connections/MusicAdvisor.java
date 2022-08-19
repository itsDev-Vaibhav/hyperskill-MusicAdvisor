package org.hyperskill.projects.Music_Advisor.Stage_3_Useful_connections;

import java.io.IOException;
import java.util.Scanner;

public class MusicAdvisor {
    Scanner scanner = new Scanner(System.in);

    private boolean authFlag = false;
    public void takeInputFromUser() {
        while (true) {
            String str = scanner.next();
            switch(str) {
                case "new":
                    createNewPlaylist();
                    break;
                case "featured" :
                    createFeaturedPlaylist();
                    break;
                case "categories" :
                    createCatagories();
                    break;
                case "playlists Mood":
                    createMoodPlaylist();
                    break;
                case "auth" :
                    createAuthorization();
                    break;
                default:
                    break;
            }
            if("exit".equals(str)) {
                System.out.println("---GOODBYE!---");
                return;
            }
        }
    }

    private void askForAccess() {
        System.out.println("Please, provide access for application.");
    }

    private void createAuthorization(){
        Server server = new Server();
        server.createServer();
        server.getToken();
        authFlag = true;
        System.out.println("---SUCCESS---");

    }

    private void createMoodPlaylist() {
        String moodPlaylist = String.format("---MOOD PLAYLISTS---" +
                "\n" + "Walk Like A Badass" +
                "\n" + "Rage Beats" +
                "\n" + "Arab Mood Booster" +
                "\n" + "Sunday Stroll");
        if(authFlag) {
            System.out.println(moodPlaylist);
        } else {
            askForAccess();
        }
    }

    private void createCatagories() {
        String catagories = String.format("---CATEGORIES---" +
                "\n" + "Top Lists" +
                "\n" + "Pop" +
                "\n" + "Mood" +
                "\n" + "Latin");
        if(authFlag) {
            System.out.println(catagories);
        } else {
            askForAccess();
        }
    }

    private void createFeaturedPlaylist() {
        String featuredPlaylist = String.format("---FEATURED---" +
                "\n" + "Mellow Morning" +
                "\n" + "Wake Up and Smell the Coffee" +
                "\n" + "Monday Motivation" +
                "\n" + "Songs to Sing in the Shower");
        if(authFlag) {
            System.out.println(featuredPlaylist);
        } else {
            askForAccess();
        }
    }

    private void createNewPlaylist() {
        String newPlaylist = String.format("---NEW RELEASES---" +
                "\n" + "Mountains [Sia, Diplo, Labrinth]" +
                "\n" + "Runaway [Lil Peep]" +
                "\n" + "The Greatest Show [Panic! At The Disco]" +
                "\n" + "All Out Life [Slipknot]");
        if(authFlag) {
            System.out.println(newPlaylist);
        } else {
            askForAccess();
        }
    }
}
