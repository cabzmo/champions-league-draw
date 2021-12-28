import java.util.ArrayList;

public class cld {

    public static void main(String[] args) {
        Team[] teams = {
                new Team("FC Salzburg", "Austria", "AUT", 'G', 2),
                new Team("FC Bayern Munchen", "Germany", "GER", 'E', 1),
                new Team("Sporting Clube De Portugal", "Portugal", "POR", 'C', 2),
                new Team("SL Benfica", "Portugal", "POR", 'E', 2),
                new Team("Manchester City FC", "England", "ENG", 'A', 1),
                new Team("Manchester United", "England", "ENG", 'F', 1),
                new Team("Chelsea FC", "England", "ENG", 'H', 2),
                new Team("Liverpool FC", "England", "ENG", 'B', 1),
                new Team("AFC Ajax", "Netherlands", "NED", 'C', 1),
                new Team("Paris Saint Germain", "France", "FRA", 'A', 2),
                new Team("LOSC Lille", "France", "FRA", 'G', 1),
                new Team("Juventus", "Italy", "ITA", 'H', 1),
                new Team("FC Internazionale", "Italy", "ITA", 'D', 2),
                new Team("Club Atletico De Madrid", "Spain", "ESP", 'B', 2),
                new Team("Real Madrid CF", "Spain", "ESP", 'D', 1),
                new Team("Villareal CF", "Spain", "ESP", 'F', 2)
        };

        Team[] teamsWithForce = {
                new Team("Liverpool FC", "England", "ENG", 'B', 1),
                new Team("Paris Saint Germain", "France", "FRA", 'A', 2),
                new Team("Juventus", "Italy", "ITA", 'H', 1),
                new Team("FC Internazionale", "Italy", "ITA", 'D', 2),
                new Team("Real Madrid CF", "Spain", "ESP", 'D', 1),
                new Team("Villareal CF", "Spain", "ESP", 'F', 2)
        };

        // ArrayList<Team> winners = new ArrayList<Team>();
        // ArrayList<Team> runnersUp = new ArrayList<Team>();
        // for (Team team : teams) {
        // if (team.getPosition() == 1) {
        // winners.add(team);
        // } else {
        // runnersUp.add(team);
        // }
        // }
        // Pot winnersPot = new Pot("Winners", winners);
        // Pot runnersUpPot = new Pot("Runners-up", runnersUp);

        // Pot selectionPot = winnersPot.canPlay(runnersUpPot.getTeam("FC Salzburg"));
        // System.out.println();
        // System.out.println(selectionPot + "" + selectionPot.size());

        // Check Force

        // Team forced = runnersUpPot.checkNoForces(winnersPot);
        // if (forced != null) {
        // System.out.println(forced);

        // Team opponent = forced.hasToPlay(winnersPot);
        // System.out.println(forced + " has to play " + opponent);
        // }

        // Draw draw = new Draw();
        // Team winnersTeam = winnersPot.getTeam("FC Bayern Munchen");
        // Team runnersUpTeam = runnersUpPot.getTeam("FC Salzburg");
        // draw.addToDraw(winnersPot, runnersUpPot, winnersTeam, runnersUpTeam);

        // System.out.println();
        // System.out.println(winnersPot + "" + winnersPot.size());
        // System.out.println();
        // System.out.println(runnersUpPot + "" + runnersUp.size());

        /////////////////////////////////////////////////////////////////////////////////////////////
        Draw draw = new Draw(teams);

        System.out.println(draw.getWinnersPot() + "" + draw.getWinnersPot().size());
        System.out.println();
        System.out.println(draw.getRunnersUpPot() + "" + draw.getRunnersUpPot().size());
        while (draw.getWinnersPot().size() > 0) {
            draw.findMatchup();
        }

        System.out.println(draw);
    }

}
