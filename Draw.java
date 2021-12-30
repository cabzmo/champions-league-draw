import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public Draw() {
        new Draw(askForTeams());
    }

    public Team[] askForTeams() {
        // loop to fill 16 teams
        char[] groups = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        Team[] inputTeams = new Team[16];

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (count < 16) {
            String name, country, countryAbbr;
            char group = groups[count / 2];
            int position;
            Team team;

            System.out.println("Group " + group + ":");
            System.out.println("    Winner:");
            System.out.print("        Team name:");
            name = scanner.nextLine();
            System.out.print("        Country:");
            country = scanner.nextLine();
            System.out.print("        Country Abbr:");
            countryAbbr = scanner.nextLine();
            position = 1;
            team = new Team(name, country, countryAbbr, group, position);
            // inputtedTeams.add(team);
            inputTeams[count] = team;

            System.out.println("");

            count++;

            System.out.println("    Runner up:");
            System.out.print("        Team name:");
            name = scanner.nextLine();
            System.out.print("        Country:");
            country = scanner.nextLine();
            System.out.print("        Country Abbr:");
            countryAbbr = scanner.nextLine();
            position = 2;
            team = new Team(name, country, countryAbbr, group, position);
            // inputtedTeams.add(team);
            inputTeams[count] = team;

            System.out.println("");

            count++;
        }
        scanner.close();
        return inputTeams;
    }

    public Pot getWinnersPot() {
        return winnersPot;
    }

    public Pot getRunnersUpPot() {
        return runnersUpPot;
    }

    private void addToDraw(Team winnersTeam, Team runnersUpTeam) {

        this.finalDraw.put(runnersUpTeam, winnersTeam);
        // System.out.println("Successfully registered matchup:\n"
        // + runnersUpTeam.getName().toUpperCase() + " " +
        // runnersUpTeam.getCountryAbbr() + " vs "
        // + winnersTeam.getName().toUpperCase() + " " + winnersTeam.getCountryAbbr());
    }

    public void findMatchup() {
        Team runnerUp;
        Team winner;

        // check forces either side
        // if force, matchup force
        // else

        // System.out.println("Checking for forces ... ");
        if (this.runnersUpPot.checkNoForces(winnersPot) != null) {
            runnerUp = this.runnersUpPot.checkNoForces(winnersPot);
            winner = runnerUp.hasToPlay(winnersPot);
        } else if (this.winnersPot.checkNoForces(runnersUpPot) != null) {
            winner = this.winnersPot.checkNoForces(runnersUpPot);
            runnerUp = winner.hasToPlay(runnersUpPot);
        } else {
            // Runners up pick at random
            runnerUp = this.runnersUpPot.getTeam(this.runnersUpPot.getRandomTeam().getName());
            // runnerUp = this.runnersUpPot.getTeam("Paris Saint Germain");
            // System.out.println(runnerUp);

            // prep teams they can play against

            Pot selectionPot = this.winnersPot.canPlay(runnerUp);
            // System.out.println();
            // System.out.println(selectionPot + "" + selectionPot.size());

            // Pick random from that pot
            winner = this.winnersPot.getTeam(selectionPot.getRandomTeam().getName());
        }

        // add to final draw
        if (checkMatchup(winner, runnerUp)) {
            this.addToDraw(winner, runnerUp);
        } else {
            // System.out.println("SOMEWHERE MAJOR ERROR: ");
            // System.out.println("!!!!! " + winner.getName().toUpperCase() + " " +
            // winner.getCountryAbbr() +
            // " vs " + runnerUp.getName().toUpperCase() + " " + runnerUp.getCountryAbbr() +
            // " NOTPOSSIBLE !!!!!\n");
        }

        this.winnersPot.removeTeam(winner);
        this.runnersUpPot.removeTeam(runnerUp);

        // System.out.println("\nSuccesfully removed teams from their respective
        // pots\n");
        // System.out.println(this.getWinnersPot() + " " + this.getWinnersPot().size());
        // System.out.println();
        // System.out.println(this.getRunnersUpPot() + " " +
        // this.getRunnersUpPot().size());

    }

    private boolean checkMatchup(Team winnersTeam, Team runnersUpTeam) {
        return winnersTeam.canPlay(runnersUpTeam);
    }

    @Override
    public String toString() {
        String statement = "\nUCL FINALS ROUND OF 16 DRAW: \n\n";

        for (Map.Entry<Team, Team> entry : finalDraw.entrySet()) {
            Team key = entry.getKey();
            Team value = entry.getValue();

            statement += key.getName().toUpperCase() + " " + key.getCountryAbbr();
            statement += " VS ";
            statement += value.getName().toUpperCase() + " " + value.getCountryAbbr() + "\n";
        }
        return statement;
    }
}
