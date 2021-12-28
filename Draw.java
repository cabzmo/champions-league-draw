import java.util.ArrayList;
import java.util.HashMap;

public class Draw {

    Pot winnersPot;
    Pot runnersUpPot;
    HashMap<Team, Team> finalDraw = new HashMap<Team, Team>();

    public Draw(Team[] teams) {
        ArrayList<Team> winners = new ArrayList<Team>();
        ArrayList<Team> runnersUp = new ArrayList<Team>();
        for (Team team : teams) {
            if (team.getPosition() == 1) {
                winners.add(team);
            } else {
                runnersUp.add(team);
            }
        }
        winnersPot = new Pot("Winners", winners);
        runnersUpPot = new Pot("Runners-up", runnersUp);
    }

    public void addToDraw(Pot winnersPot, Pot runnersUpPot, Team winnersTeam, Team runnersUpTeam) {
        winnersPot.removeTeam(winnersTeam);
        runnersUpPot.removeTeam(runnersUpTeam);
        if (checkMatchup(winnersTeam, runnersUpTeam)) {
            finalDraw.put(winnersTeam, runnersUpTeam);
            System.out.println("Successfully registered matchup:\n"
                    + runnersUpTeam.getName().toUpperCase() + " " + runnersUpTeam.getCountryAbbr() + " vs "
                    + winnersTeam.getName().toUpperCase() + " " + winnersTeam.getCountryAbbr());
        }
    }

    public boolean checkMatchup(Team winnersTeam, Team runnersUpTeam) {
        return winnersTeam.canPlay(runnersUpTeam);
    }
}
