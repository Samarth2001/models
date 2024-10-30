/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Persona;

import election.Admin.CandidateRunning4Seat;

/**
 *
 * @author kal bugrara
 */
public class CandidateProfile {

    Person person;
    String partyaffiliation;
    CandidateRunning4Seat cr4seat;

    public CandidateProfile(Person p) {

        person = p;

    }
    public String getPersonName(){
        return person.getPersonByName();
    }
    public void assigncandidacy(CandidateRunning4Seat cr4s) {
        cr4seat = cr4s;
       

    }

    public CandidateRunning4Seat getCandidacy() {
        return cr4seat;
    }

    public int countTheVote4Candidate() {
        return cr4seat.getVoteCount();
    }

    public boolean isMatch(String id) {
        if (person.getPersonByName().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean isMatch(Person p) {
        if (person.getPersonByName().equals(p.getPersonByName())) {
            return true;
        }
        return false;
    }

}
