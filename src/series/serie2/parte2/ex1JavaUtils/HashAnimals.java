package series.serie2.parte2.ex1JavaUtils;

import java.util.HashMap;
import java.util.Iterator;

public class HashAnimals {
    private HashMap<String, Integer> table;

    public HashAnimals() {
        table = new HashMap();
    }

    public void addAnimalFromQuery(String key) {
        if (table.containsKey(key)) {
            Integer count = table.get(key);
            table.replace(key, ++count);
        } else table.put(key, 1);
    }

    public double getDimension() {
        double sum = 0;
        for (Integer value : table.values())
            sum += value * value;
        return Math.sqrt(sum);
    }

    public double getSimilarity(HashAnimals query) {
        Iterator<String> queryIterator = query.getKeysIterator(query);
        double numerator = 0;
        double denominator = query.getDimension() * this.getDimension();

        while (queryIterator.hasNext()) {
            String curr = queryIterator.next();
            if (table.containsKey(curr))
                numerator += table.get(curr);
        }
        return numerator / denominator;
    }

    void addAnimalFromQuery(String key, Integer value) {
        table.put(key, value);
    }

    public Iterator<String> getKeysIterator(HashAnimals map) {
        return map.table.keySet().iterator();
    }

    public String getKeys() {
        String count = "";
        for (String s : table.keySet()) {
            count += " " + s;
        }
        return count;
    }
}
