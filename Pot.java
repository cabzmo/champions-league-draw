import java.util.ArrayList;

public class Pot {

    private String name = "";
    private ArrayList<Team> teams = new ArrayList<>();

    public Pot(String name, ArrayList<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pot canPlay(Team opponent) {
        ArrayList<Team> canPlayAgainstArray = new ArrayList<Team>();
        for (Team team : teams) {
            if (team.canPlay(opponent)) {
                canPlayAgainstArray.add(team);
            }
        }
        if (canPlayAgainstArray.size() > 0) {
            Pot selection = new Pot(opponent.getName(), canPlayAgainstArray);
            selection.sortByGroup();
            return selection;
        }
        return null;
    }

    public Team checkNoForces(Pot otherPot) {
        for (Team teamA : teams) {
            // ArrayList<Team> opponents = new ArrayList<Team>();
            System.out.println("Checking forces for: " + teamA + " ...");
            if (otherPot.canPlay(teamA).size() == 1) {
                System.out.println("There is a force for " + teamA);
                return teamA;
            }
            // Pot opponents = new Pot(teamA, )
        }
        System.out.println("No forces yet");
        return null;
    }

    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    public Team getTeam(String name) {
        for (Team team : teams) {
            if (team.getName() == name) {
                return team;
            }
        }
        return null;
    }

    public void sortByGroup() {
        ArrayList<Team> sortedTeams = new ArrayList<Team>();
        char[] groups = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
        for (char group : groups) {
            for (Team team : teams) {
                if (team.getGroup() == group) {
                    sortedTeams.add(team);
                }
            }
        }
        this.teams = sortedTeams;
    }

    public void removeTeam(Team team) {
        this.teams.remove(this.getTeam(team.getName()));
    }

    public int size() {
        return this.teams.size();
    }

    @Override
    public String toString() {
        String statement = "Teams in the " + this.getName() + " pot: \n\n";
        for (Team team : teams) {
            statement += team + "\n";
        }
        return statement;
    }
}
