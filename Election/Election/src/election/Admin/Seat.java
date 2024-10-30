/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Admin;

import election.Persona.CandidateProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Seat {

    String name;
    Election election;
    ArrayList<CandidateRunning4Seat> candidatelistrunning4seat;

    public Seat(Election e, String name) {
        election = e;

        this.name = name;
        candidatelistrunning4seat = new ArrayList();

    }

    public void addCandidate4Seat(CandidateRunning4Seat csa) {

//links seatassignment to seat
        if (!candidatelistrunning4seat.contains(csa)) {
            candidatelistrunning4seat.add(csa);
        }

    }

    public CandidateRunning4Seat newCandidate4Seat(CandidateProfile cf) {

        CandidateRunning4Seat csa = new CandidateRunning4Seat(cf, this); //links seatassignment to seat
        candidatelistrunning4seat.add(csa);
        return csa;

    }

    public ArrayList<CandidateRunning4Seat> getCandidates4Running4Seat() {

        return candidatelistrunning4seat;

    }

    public ArrayList<CandidateProfile> getCandidatesProfiles4Seat() {

        ArrayList<CandidateProfile> cps = new ArrayList();
        for (CandidateRunning4Seat csa : candidatelistrunning4seat) {
            CandidateProfile cp = csa.getCandidateProfile();
            cps.add(cp);
        }
        return cps;
    }

    public CandidateRunning4Seat getCandidateByNameRunning4Seat(String name) {

        for (CandidateRunning4Seat csa : candidatelistrunning4seat) {
            CandidateProfile cp = csa.getCandidateProfile();
            if (cp.isMatch(name)) {
                return csa;
            }

        }
        return null;
    }
}
