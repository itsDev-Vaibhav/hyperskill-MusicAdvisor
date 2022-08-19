package org.hyperskill.projects.Music_Advisor.Stage_2_Rocking_OAuth;

import java.util.Scanner;

public class MusicAdvisor {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        takeInputFromUser();
    }
    private boolean authFlag = false;
    private void takeInputFromUser() {
        while (true) {
            String str = scanner.next();
            switch(str) {
                case "new": {
                    if (authFlag) {
                        createNewPlaylist();
                    } else {
                        askForAccess();
                    }
                    break;
                }
                case "featured" : {
                    if (authFlag) {
                        createFeaturedPlaylist();
                    } else {
                        askForAccess();
                    }
                    break;
                }
                case "categories" : {
                    if (authFlag) {
                        createCatagories();
                    } else {
                        askForAccess();
                    }
                    break;
                }
                case "playlists Mood" : {
                    if (authFlag) {
                        createMoodPlaylist();
                    } else {
                        askForAccess();
                    }
                    break;
                }
                case "auth" : {
                    authFlag = true;
                    createAuthPlaylist();
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

    private void askForAccess() {
        System.out.println("Please, provide access for application.");
    }

    private void createAuthPlaylist() {
        final String CLIENT_ID = "0e65daed4aa543eb9f3a37d20bd511a1";
        final String url = "https://accounts.spotify.com/authorize?client_id=" + CLIENT_ID +"&redirect_uri=http://localhost:8080&response_type=code";
        System.out.println(url);
        System.out.println("---SUCCESS---");
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
