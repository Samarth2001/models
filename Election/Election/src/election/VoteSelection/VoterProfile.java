/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.VoteSelection;

import election.Admin.CandidateRunning4Seat;
import election.Admin.Election;
import election.Admin.Seat;
import election.Persona.Person;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class VoterProfile {
    Person person;
    String party;
    Election election;
    HashMap<Seat, Vote> votes;
    public VoterProfile(Person p, Election e){
        person = p;
        election = e;
        votes = new HashMap<Seat, Vote>();
        
    }
    public Vote AssignRightToVoteTicket4Seat(String seatname){
        Seat seat = election.findSeat(seatname); //ask the election object to find you the seat by name;
        Vote v = new Vote(this, seat);
        votes.put(seat, v);
        return v;
        
    }
    // 1) find the candidate for the seat
    // 2) 
    public void castMyVoteForCandidate(String s, String c) {
    
        Seat seat = election.findSeat(s);
        CandidateRunning4Seat cr4s = seat.getCandidateByNameRunning4Seat(c);
        Vote voteforseat= (Vote)votes.get(seat);
        cr4s.castVoteForCandidate(voteforseat);
    }
    
   public Person getPerson(){
       return person;
   } 
    
    
}
