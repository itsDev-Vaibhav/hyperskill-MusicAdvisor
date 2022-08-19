package org.hyperskill.projects.Music_Advisor.Stage_1_Strings_and_fiddlesticks;

import java.util.Scanner;

public class MusicAdvisor {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        takeInputFromUser();
    }

    private void takeInputFromUser() {
        while (true) {
            String str = scanner.next();
            switch(str) {
                case "new": {
                    createNewPlaylist();
                    break;
                }
                case "featured" : {
                    createFeaturedPlaylist();
                    break;
                }
                case "categories" : {
                    createCatagories();
                    break;
                }
                case "playlists Mood" : {
                    createMoodPlaylist();
                    break;
                }
                default:
                    break;
            }
            if("exit".equals(str)) {
                System.out.println("---GOODBYE!---");
                return;
            }
        }
    }

    private void createMoodPlaylist() {
        String moodPlaylist = String.format("---MOOD PLAYLISTS---" +
                "\n" + "Walk Like A Badass" +
                "\n" + "Rage Beats" +
                "\n" + "Arab Mood Booster" +
                "\n" + "Sunday Stroll");
        System.out.println(moodPlaylist);

    }

    private void createCatagories() {
        String catagories = String.format("---CATEGORIES---" +
                "\n" + "Top Lists" +
                "\n" + "Pop" +
                "\n" + "Mood" +
                "\n" + "Latin");
        System.out.println(catagories);
    }

    private void createFeaturedPlaylist() {

        String featuredPlaylist = String.format("---FEATURED---" +
                "\n" + "Mellow Morning" +
                "\n" + "Wake Up and Smell the Coffee" +
                "\n" + "Monday Motivation" +
                "\n" + "Songs to Sing in the Shower");
        System.out.println(featuredPlaylist);
    }

    private void createNewPlaylist() {
        String newPlaylist = String.format("---NEW RELEASES---" +
                "\n" + "Mountains [Sia, Diplo, Labrinth]" +
                "\n" + "Runaway [Lil Peep]" +
                "\n" + "The Greatest Show [Panic! At The Disco]" +
                "\n" + "All Out Life [Slipknot]");
        System.out.println(newPlaylist);
    }
}
