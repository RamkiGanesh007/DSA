import java.util.*;

public class nearestlocations {

    // Time Complexity of this Problem is O(N) where N is the number of locations .

    public static double finddistance(int x, int y) {
        return Math.sqrt(x * x + y * y); // finding the distance of the points
    }

    public static List<List<Integer>> findRestaurants(List<List<Integer>> allLocations, int numRestaurants) {
        Map<Double, List<Integer>> arr = new HashMap<>();

        for (int i = 0; i < allLocations.size(); i++) {
            double s = finddistance(allLocations.get(i).get(0), allLocations.get(i).get(1));
            List<Integer> k = new ArrayList<>();
            if (arr.get(s) != null)
                k.addAll(arr.get(s));
            k.add(i);
            arr.put(s, k);
        }
        Set set = arr.entrySet();

        List<List<Integer>> ret = new ArrayList<>();
        Iterator it = set.iterator();

        for (int i = 0; i < numRestaurants; i++) {
            if (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                ArrayList<Integer> k = new ArrayList<>();
                k.addAll(allLocations.get((int) me.getValue()));
                for (Integer l : k) {
                    ret.add(allLocations.get(l));
                }
            } else {
                ret.add(Arrays.asList());
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        arr.add(Arrays.asList(1, 2));
        arr.add(Arrays.asList(3, 4));
        arr.add(Arrays.asList(1, -1));
        arr.add(Arrays.asList(1, -1));
        arr.add(Arrays.asList(1, -1));
        arr.add(Arrays.asList(1, -1));

        System.out.println(findRestaurants(arr, 4));
    }
}
