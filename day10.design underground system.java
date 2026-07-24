import java.util.*;

class UndergroundSystem {

    class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    Map<Integer, CheckInData> checkInMap;
    Map<String, int[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);

        String key = data.station + "-" + stationName;
        int travelTime = t - data.time;

        int[] record = travelMap.getOrDefault(key, new int[2]);

        record[0] += travelTime;
        record[1]++;

        travelMap.put(key, record);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] record = travelMap.get(key);

        return (double) record[0] / record[1];
    }
}
