/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package election.Admin;

import election.Area.District;
import election.Persona.CandidateDirectory;
import election.Persona.CandidateProfile;
import election.Persona.Person;
import election.Persona.PersonDirectory;
import election.Persona.VoterDirectory;
import election.VoteSelection.VoterProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Election {

    PersonDirectory persondirectory;
    CandidateDirectory candidatedirectory;
    VoterDirectory voterdirectory;
    ArrayList<Seat> seatlist;
    District district;

    public Election(District d) {

        persondirectory = new PersonDirectory();
        candidatedirectory = new CandidateDirectory(this);
        voterdirectory = new VoterDirectory(this);
        seatlist = new ArrayList();
        district = d;
    }

    public Seat newSeat(String name) {

        Seat s = new Seat(this, name);
        seatlist.add(s);
        return s;
    }

    public Person RegisterAsPerson(String name) {

        Person p = persondirectory.newPerson(name);

        return p;
    }

    public VoterProfile RegisterAsVoter(Person p) {

        VoterProfile vp = voterdirectory.newVoterProfile(p);

        return vp;
    }

    public CandidateProfile registerPersonAsCandidate(Person p) {
        if (p == null) {
            return null;
        }
        Person person = persondirectory.findPerson(p.getPersonByName());
        if (person == null) {
            return null;
        }
        CandidateProfile cp = candidatedirectory.newCandidateProfile(person);
        return cp;

    }

    public CandidateProfile registerPersonByNameAsCandidate(String name) {

        Person p = persondirectory.findPerson(name);
        CandidateProfile cp = candidatedirectory.newCandidateProfile(p);
        return cp;

    }

    public void assignCandidateToASeat(String name, CandidateProfile cp) {

        Seat seat = findSeat(name);
        CandidateRunning4Seat cr4s = seat.newCandidate4Seat(cp);
        cp.assigncandidacy(cr4s);
    }

    public ArrayList<CandidateProfile> getRunningCandidatesForSeat(String n, int c) {

        Seat seat = findSeat(n);
        return seat.getCandidatesProfiles4Seat();
    }

    public Seat findSeat(String n) {

        for (Seat s : seatlist) {
            if (s.name.equals(n)) {
                return s;
            }
        }
        return null;
    }

    public CandidateDirectory getCandidateDirectory() {
        return candidatedirectory;
    }

}
