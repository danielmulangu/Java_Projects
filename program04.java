import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LRUCacheSimulation {
    public static int totalHits = 0;

    public static void LRU(Queue<Integer> framesQ, int maxFrames, int frameRequest) {
        if (!framesQ.contains(frameRequest)) {
            if (framesQ.size() >= maxFrames) {
                framesQ.poll();
            }
        } else {
            totalHits++;
            framesQ.remove(frameRequest);
        }
        framesQ.add(frameRequest);
    }

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Usage: java LRUCacheSimulation <datafile> <frames_1> <frames_2> <frames_3> <frames_4>");
            System.exit(1);
        }

        String dataFile = args[0];
        int[] maxFrames = new int[4];
        for (int i = 0; i < 4; i++) {
            maxFrames[i] = Integer.parseInt(args[i + 1]);
        }

        int[] totalFrameRequests = new int[4];

        List<Queue<Integer>> caches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            caches.add(new LinkedList<>());
        }

        try (BufferedReader buff = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = buff.readLine()) != null) {
                String[] tokens = line.split(" ");
                int processNumber = Integer.parseInt(tokens[0]);
                int frameRequest = Integer.parseInt(tokens[1]);
                totalFrameRequests[processNumber - 1]++;
                totalHits=0;
                LRU(caches.get(processNumber - 1), maxFrames[processNumber - 1], frameRequest);
            }
        } catch (IOException e) {
            System.err.println("Error reading the data file: " + e.getMessage());
            System.exit(1);
        }

        double totalHitRate = (double) totalHits / Arrays.stream(totalFrameRequests).sum() * 100;
        for (int i = 0; i < 4; i++) {
            float hitRate = (float) (totalHits * 100.0) / totalFrameRequests[i];
            System.out.printf("Process %d Hit Rate: %.2f%%\n", i + 1, hitRate);
        }

        System.out.printf("Total Hit Rate: %.2f%%\n", totalHitRate);
    }
}
