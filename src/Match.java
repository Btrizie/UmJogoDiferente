import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Match {

    public static Match match = new Match();
    private List<Team> lTeams; 
    private List<String> lTeamsNames, lMatches, lRemover;
    private List<String> lWinners;
    private int count;
    private String teamA, teamB;

    public Match() {
        lTeams = new ArrayList<>();
        lTeamsNames = new ArrayList<>();
        lMatches = new ArrayList<>();
        lRemover = new ArrayList<>();
        lWinners = new ArrayList<>();
        count = 0;
        teamA = " ";
        teamB = " ";
    }

    public void add(Team t){
        lTeams.add(t);
        count++;
    }

    public int getId(){
        return count;
    }

    public void setTeams(String axb){
        String[] times = axb.split(" x ");
        teamA = times[0];
        teamB = times[1];
    }

    public String getTeamA(){
        return teamA;
    }

    public int getIdA(String a) {
        for (int i = 0; i < lTeams.size(); i++) {
            if (lTeams.get(i).getName().equals(a)) {
                return i;
            }
        }
        return -1;
    }

    public String getTeamB(){
        return teamB;
    }
    
    public int getIdB(String b) {
        for (int i = 0; i < lTeams.size(); i++) {
            if (lTeams.get(i).getName().equals(b)) {
                return i;
            }
        }
        return -1;
    }

    public List<Team> getLTeams() {
        return lTeams;
    }

    public List<String> getLTeamsNames() {
        lTeamsNames.clear();
        for (Team t : lTeams) {
            lTeamsNames.add(t.getName());
        }
        return lTeamsNames;
    }

    //arranja as partida de forma aleatória
    public List<String> getLMatches(){
        lMatches.clear();
        List<String> lAux;
        lAux = new ArrayList<>(getLTeamsNames());
        lAux.removeAll(lRemover);

        if(lAux.isEmpty() && lWinners.size() == 1){
            return null;
        }
        else if(lAux.isEmpty()){
            lAux = new ArrayList<>(lWinners);
            lRemover.removeAll(lWinners);
            lWinners.clear();
        }

        Random random = new Random();
        while (lAux.size() > 1) {
            int rnd = random.nextInt(lAux.size());
            String a = lAux.get(rnd);
            lAux.remove(rnd);
            int rnd2 = random.nextInt(lAux.size());
            String b = lAux.get(rnd2);
            lAux.remove(rnd2);
            lMatches.add(a + " x " + b);
        }
        return lMatches;
    }

    //add na lista para remover os times que já foram, e add na lista de ganhadores o vencedor da partida
    public void setLEnding(String x, String y, String a) {
        sortByPoints();
        lRemover.add(x);
        lRemover.add(y);
        lWinners.add(a);
    }

    public void sortByPoints() {
        Collections.sort(lTeams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                return Integer.compare(t2.getTotal(), t1.getTotal());
            }
        });
    }
}
