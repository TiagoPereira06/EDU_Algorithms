package series.serie2.parte2.ex2NoJavaUtils;

import java.util.Iterator;

@SuppressWarnings("Duplicates")
public class CustomHashAnimals {
    private CustomHashMap<String, Integer> table;

    public CustomHashAnimals() {
        table = new CustomHashMap<>();
    }

    public void addAnimalFromQuery(String key) {
        if (table.containsKey(key)) {
            Integer count = table.get(key);
            table.remove(key);
            table.put(key, ++count);
        } else table.put(key, 1);
    }

    public double getDimension() {
        double sum = 0;
        for (Integer value : table.values())
            sum += value * value;
        return Math.sqrt(sum);
    }

    public double getSimilarity(CustomHashAnimals query) {
        Iterator<Object> queryIterator = query.getKeysIterator(query);
        double numerator = 0;
        double denominator = query.getDimension() * this.getDimension();

        while (queryIterator.hasNext()) {
            String curr = (String) queryIterator.next();
            if (table.containsKey(curr))
                numerator += table.get(curr);
        }
        return numerator / denominator;
    }

    void addAnimalFromQuery(String key, Integer value) {
        table.put(key, value);
    }

    public Iterator<Object> getKeysIterator(CustomHashAnimals map) {
        return map.table.keySet().iterator();
    }

    public String getKeys() {
        String count = "";
        for (Object s : table.keySet()) {
            count += " " + s;
        }
        return count;
    }
}

