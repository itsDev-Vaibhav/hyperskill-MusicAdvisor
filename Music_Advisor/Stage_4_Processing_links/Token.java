package org.hyperskill.projects.Music_Advisor.Stage_4_Processing_links;

public class Token {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token='" + access_token + '\'' +
                '}';
    }
}
