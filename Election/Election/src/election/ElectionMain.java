/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election;

import election.Admin.Election;
import election.Area.District;
import election.Persona.CandidateDirectory;
import election.Persona.CandidateProfile;
import election.Persona.Person;
import election.VoteSelection.VoterProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class ElectionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create a district
        District district = new District("Boston");
        // create an election
        Election election = new Election(district);

        //There are 2 spots for the election. We can add more
        election.newSeat("President");
        election.newSeat("Vice President");

        Person person = election.RegisterAsPerson("Tump");
        CandidateProfile candidateProfile = election.registerPersonAsCandidate(person);
        election.assignCandidateToASeat("President", candidateProfile);

        person = election.RegisterAsPerson("Harris");
        candidateProfile = election.registerPersonAsCandidate(person);
        election.assignCandidateToASeat("President", candidateProfile);

        //One voter prep
        person = election.RegisterAsPerson("John Smith");
        VoterProfile voter = election.RegisterAsVoter(person);
        voter.AssignRightToVoteTicket4Seat("President"); //giving voter right to vote

        //Voter makes decision and casts thei vote
        voter.castMyVoteForCandidate("President", "Tump");

        //Second voter prep
        person = election.RegisterAsPerson("Anna Scott");
        voter = election.RegisterAsVoter(person);
        voter.AssignRightToVoteTicket4Seat("President"); //giving voter right to vote

        //Scond voter makes decision and casts thei vote
        voter.castMyVoteForCandidate("President", "Harris");

        //Third voter prep
        person = election.RegisterAsPerson("Susan Winston");
        voter = election.RegisterAsVoter(person);
        voter.AssignRightToVoteTicket4Seat("President"); //giving voter right to vote

        //Scond voter makes decision and casts thei vote
        voter.castMyVoteForCandidate("President", "Harris");
        //Count the vote for candidates
        CandidateDirectory cdir = election.getCandidateDirectory();
        ArrayList<CandidateProfile> cands = cdir.getCandidateList();
        for (CandidateProfile cp : cands) {
            System.out.println("Candidate:  " + cp.getPersonName() + " Vote Count : " + Integer.toString(cp.countTheVote4Candidate()));
        }
    }

}
