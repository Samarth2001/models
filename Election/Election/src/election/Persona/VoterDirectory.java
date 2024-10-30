/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Persona;

import election.Admin.Election;
import election.VoteSelection.VoterProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class VoterDirectory {

    Election election;
    ArrayList<VoterProfile> voterlist;

    public VoterDirectory(Election e) {

        election = e;
        voterlist = new ArrayList();

    }

    public VoterProfile newVoterProfile(Person p) {
        VoterProfile vp = findVoter(p); //dooes the voter already resigstered
        if (vp != null) return vp;        
        vp = new VoterProfile(p, election); //pass the election oject to help find the seat
        voterlist.add(vp);
        return vp;
    }

    public VoterProfile findVoter(String id) {

        for (VoterProfile vp : voterlist) {

            if (vp.getPerson().isMatch(id)) {
                return vp;
            }
        }
        return null; //not found after going through the whole list
    }

    public VoterProfile findVoter(Person p) {

        for (VoterProfile vp : voterlist) {

            if (vp.getPerson() == p) {
                return vp;
            }
        }
        return null; //not found after going through the whole list
    }
}
