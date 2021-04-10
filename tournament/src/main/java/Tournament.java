import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Tournament {
    private final Map<String, Team> teams;

    public Tournament() {
        this.teams = new HashMap<>();
    }

    public String printTable() {
        StringBuilder result = new StringBuilder("Team                           | MP |  W |  D |  L |  P\n");

        Collection<Team> sortedTeams = teams.values().stream().sorted((t1, t2) -> {
            if (t1.getPoint() == t2.getPoint()) {
                return t1.getName().compareTo(t2.getName());
            }
            return t2.getPoint() - t1.getPoint();
        }).collect(Collectors.toList());

        sortedTeams.forEach(team -> {
            result.append(team).append("\n");
        });

        return result.toString();
    }

    public void applyResults(String matches) {
        Arrays.asList(matches.split("\n")).forEach(match -> {
            String[] data = match.split(";");
            String result = data[2];
            if (!teams.containsKey(data[0])) {
                teams.put(data[0], new Team(data[0]));
            }
            if (!teams.containsKey(data[1])) {
                teams.put(data[1], new Team(data[1]));
            }

            if ("win".equals(result)) {
                teams.get(data[0]).setWon();
                teams.get(data[1]).setLost();
            } else if ("loss".equals(result)) {
                teams.get(data[1]).setWon();
                teams.get(data[0]).setLost();
            } else {
                teams.get(data[0]).setDrawn();
                teams.get(data[1]).setDrawn();
            }
        });
    }
}

class Team {
    private final String name;

    // Match Played
    private int MP;

    // Win
    private int W;

    // Drawn
    private int D;

    // Lost
    private int L;

    // Point
    private int P;

    public Team(String name) {
        this.name = name;
        this.MP = 0;
        this.W = 0;
        this.D = 0;
        this.L = 0;
        this.P = 0;
    }

    public void setWon() {
        this.MP += 1;
        this.W += 1;
        this.P += 3;
    }

    public void setLost() {
        this.MP += 1;
        this.L += 1;
    }

    public void setDrawn() {
        this.MP += 1;
        this.D += 1;
        this.P += 1;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return P;
    }

    public String toString() {
        return String.format("%-31s|  %d |  %d |  %d |  %d |  %d", name, MP, W, D, L, P);
    }
}