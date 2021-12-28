/**
 * Team
 */
public class Team {

    private String name = "";
    private String country = "";
    private String countryAbbr = "";
    private char group = 'z';
    private int position = 0;

    public Team(String name, String country, String countryAbbr, char group, int position) {
        this.setName(name);
        this.setCountry(country);
        this.setCountryAbbr(countryAbbr);
        this.setGroup(group);
        this.setPosition(position);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getGroup() {
        return this.group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setCountryAbbr(String countryAbbr) {
        this.countryAbbr = countryAbbr;
    }

    public String getCountryAbbr() {
        return "(" + this.countryAbbr.toUpperCase() + ")";
    }

    public boolean canPlay(Team opponent) {
        if (opponent.getGroup() != this.getGroup()) {
            if (opponent.getCountry() != this.getCountry()) {
                return true;
            }
        }
        return false;
    }

    public Team hasToPlay(Pot pot) {
        if (pot.canPlay(this).size() == 1) {
            for (Team team : pot.getTeams()) {
                if (this.canPlay(team)) {
                    return team;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String statement = this.getName() +
                " " + this.getCountryAbbr();
        return statement;
    }
}