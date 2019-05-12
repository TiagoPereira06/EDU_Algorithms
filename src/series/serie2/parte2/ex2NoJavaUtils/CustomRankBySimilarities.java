package series.serie2.parte2.ex2NoJavaUtils;

import series.serie2.parte2.LinkedList;
import series.serie2.parte2.ResultSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class CustomRankBySimilarities {
    private static int MAX_LENGTH = 50;
    private static CustomHashAnimals[] customHashAnimalsArray = new CustomHashAnimals[MAX_LENGTH];
    private static CustomHashAnimals[] queryArray = new CustomHashAnimals[MAX_LENGTH];
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
                    CustomHashAnimals animalsTable = new CustomHashAnimals();
                    receiveFromTxt = in.nextLine();
                    parts = receiveFromTxt.split(" ");
                    for (int j = 0; j < parts.length; j++) {
                        String aux = parts[j];
                        if (stopWordsList.contains(aux) < 0)
                            animalsTable.addAnimalFromQuery(aux);
                    }
                    customHashAnimalsArray[hashAnimalsArraySize++] = animalsTable;
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
            CustomHashAnimals query = new CustomHashAnimals();
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

        for (CustomHashAnimals query : queryArray) {
            if (query == null) break;
            int counter = 1;
            LinkedList<ResultSet> results = new LinkedList<>();
            System.out.println("q " + query.getKeys());

            for (CustomHashAnimals animals : customHashAnimalsArray) {
                if (animals == null) break;
                double sim = animals.getSimilarity(query);
                results.addFirst(new ResultSet("d" + counter, (Math.round(sim * 100.0) / 100.0)));
                counter++;
            }
            results.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
            for (ResultSet rs : results) {
                System.out.println(rs.toString());

            }
            // System.out.println(results);
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
        stopWordsList.addFirst(word);
    }
}
