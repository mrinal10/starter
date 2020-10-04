import java.util.*;

class PlayersStatistics {
    String playername;
    List<Integer> runsList;
    int inningsCount;
    
    PlayersStatistics(String pname){
        playername = pname;
        runsList = new ArrayList();
        inningsCount = 0;
    }

    public String getPlayername() {
		return playername;
	}
	
	public void addRunsList(int run) {
		runsList.add(run);
	}
	public double getTotalRunScored() {
		double totalRun = 0.0;
        for(int i=0; i<runsList.size(); i++){
            totalRun += runsList.get(i);
        }
        return totalRun;
	}
	public void incrInningsCount() {
		inningsCount += 1;
	}
	public int getInningsCount() {
		return inningsCount;
	}
}



class abcd {
    public static class PlayerStatisticsCollectorImpl implements PlayerStatisticsCollector {
        List<PlayersStatistics> stats = new ArrayList<PlayersStatistics>();

        @Override
        public void putNewInnings(String player, int runs){
            boolean isFound = false;
            for(int i=0; i<stats.size(); i++){
                PlayersStatistics pStats = stats.get(i);
                if(player.equals(pStats.getPlayername())){
                    isFound = true;
                    pStats.incrInningsCount();
                    pStats.addRunsList(runs);
                    break;
                }
            }    
            if(!isFound){
                PlayersStatistics p = new PlayersStatistics(player);
                p.incrInningsCount();
                p.addRunsList(runs);
                stats.add(p);
            }
        }

        @Override
        public double getAverageRuns(String player){
            for(int i=0; i<stats.size(); i++){
                PlayersStatistics pStats = stats.get(i);
                if(player.equals(pStats.getPlayername())){
                    return pStats.getTotalRunScored()/pStats.getInningsCount();
                }
            }
            return 0;
        }

        @Override
        public int getInningsCount(String player){
            for(int i=0; i<stats.size(); i++){
                PlayersStatistics pStats = stats.get(i);
                if(player.equals(pStats.getPlayername())){
                    return pStats.getInningsCount();
                }
            }
            return 0;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface PlayerStatisticsCollector {
        // This is an input. Make note of this player inning.  Runs is a non negative integer.
        void putNewInnings(String player, int runs);

        // Get the runs average(mathematical average) for a player
        double getAverageRuns(String player);

        // Get the total number of innings for the player
        int getInningsCount(String player);
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final PlayerStatisticsCollector stats = new PlayerStatisticsCollectorImpl();
            final Set<String> players = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String player = tokens[0];
                players.add(player);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewInnings(player, runs);

            }

            for (String player : players) {
                System.out.println(
                        String.format("%s %.4f %d", player, stats.getAverageRuns(player), stats.getInningsCount(player)));
            }

        }
        scanner.close();

    }
}
