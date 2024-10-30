/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Persona;


import election.Admin.Election;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CandidateDirectory {

    Election election;
    ArrayList<CandidateProfile> candidatelist;

    public CandidateDirectory(Election e) {

        election = e;
        candidatelist = new ArrayList();

    }
    public ArrayList<CandidateProfile> getCandidateList(){
        return candidatelist;
    }
    public CandidateProfile newCandidateProfile(Person p) {
        for(CandidateProfile cp: candidatelist) if(cp.isMatch(p)) return cp; 
        CandidateProfile sp = new CandidateProfile(p);
        candidatelist.add(sp);
        return sp;
    }

    public CandidateProfile findCandidate(String id) {

        for (CandidateProfile sp : candidatelist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
