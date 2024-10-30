/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.VoteSelection;

import election.Admin.CandidateRunning4Seat;
import election.Admin.Seat;

/**
 *
 * @author kal bugrara
 */
public class Vote {
    VoterProfile voterprofile;
    Seat seat;
    CandidateRunning4Seat selectedcandidate;
    
    public Vote(VoterProfile vp, Seat s){
        voterprofile = vp;
        seat = s;
    }
    public void assignCandidateToVote( CandidateRunning4Seat c){
        selectedcandidate = c;
    }
    
}
