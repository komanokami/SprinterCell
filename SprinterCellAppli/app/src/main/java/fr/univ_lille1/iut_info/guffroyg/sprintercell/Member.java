package fr.univ_lille1.iut_info.guffroyg.sprintercell;

import java.util.ArrayList;


public class Member {
    private String mdp;
    private String email;
    private String pseudo;

    public Member(String pseudo, String email, String password) {
        this.pseudo = pseudo;
        this.email = email;
        this.mdp = password;
    }

    public Member() {
    }

    public String toString() {
        String print;
        print = " user :" + pseudo + "\nmdp :" + mdp + "\nemail :" + email;
        return print;
    }



    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}