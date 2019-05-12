package series.serie2.parte2.ex1JavaUtils;

import series.serie2.parte2.ResultSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class RankBySimilarities {
    private static int MAX_LENGTH = 50;
    private static HashAnimals[] hashAnimalsArray = new HashAnimals[MAX_LENGTH];
    private static HashAnimals[] queryArray = new HashAnimals[MAX_LENGTH];
    private static LinkedList<String> stopWordsList;
    private static int hashAnimalsArraySize = 0, queryArraySize = 0;

    public static void main(String[] args) {
        Scanner in;
        String receiveFromTxt;
        String[] parts;
        initStopWordList(args[0]);


        //Carregar para a DB todos os dados dos .txt

        for (int i = 1; i < args.length; i++) {
            try {
                in = new Scanner(new File(args[i]));
                while (in.hasNextLine()) {
                    HashAnimals animalsTable = new HashAnimals();
                    receiveFromTxt = in.nextLine();
                    parts = receiveFromTxt.split(" ");
                    for (int j = 0; j < parts.length; j++) {
                        String aux = parts[j];
                        if (!stopWordsList.contains(aux))
                            animalsTable.addAnimalFromQuery(aux);
                    }
                    hashAnimalsArray[hashAnimalsArraySize++] = animalsTable;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        //Preparação para execução do comando

        System.out.println("Supported commands ranking + query_file.txt");
        System.out.print("Insert Command -> ");

        in = new Scanner(System.in);
        File queryFile = new File(in.nextLine().replace("ranking ", ""));
        try {
            in = new Scanner(queryFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNextLine()) {
            HashAnimals query = new HashAnimals();
            receiveFromTxt = in.nextLine();
            receiveFromTxt = receiveFromTxt.replace("(", "");
            receiveFromTxt = receiveFromTxt.replace(")", "");

            parts = receiveFromTxt.split(",");

            for (int i = 0, j = 1; j < parts.length; i += 2, j += 2) {
                query.addAnimalFromQuery(parts[i], Integer.parseInt(parts[j]));
            }
            queryArray[queryArraySize++] = query;
        }

        //Processar array de querys e mostrar o resultados obtidos

        for (HashAnimals query : queryArray) {
            if (query == null) break;
            int counter = 1;
            LinkedList<ResultSet> results = new LinkedList<>();
            System.out.println("q " + query.getKeys());

            for (HashAnimals animals : hashAnimalsArray) {
                if (animals == null) break;
                double sim = animals.getSimilarity(query);
                results.add(new ResultSet("d" + counter, (Math.round(sim * 100.0) / 100.0)));
                counter++;
            }
            results.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
            System.out.println(results);
            System.out.println(" ");

        }

    }

    private static void initStopWordList(String listFile) {
        Scanner in = null;
        String[] words;
        String receiveFromTxt;
        try {
            in = new Scanner(new File(listFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (in.hasNextLine()) {
            receiveFromTxt = in.nextLine();
            words = receiveFromTxt.split(" ");
            stopWordsList = new LinkedList<>();
            for (int i = 0; i < words.length; i++) {
                addStopWord(words[i]);
            }
        }
    }

    public static void addStopWord(String word) {
        stopWordsList.add(word);
    }
}
