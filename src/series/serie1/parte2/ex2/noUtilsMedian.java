package series.serie1.parte2.ex2;

import java.io.*;


public class noUtilsMedian {

    public static void main(String[] args) {
        String[] parts;
        final int INITIAL_HEAP_SIZE=10;
        Heap heap = new Heap(INITIAL_HEAP_SIZE);
        int[] userInputInt;
        if (args.length == 0) {
            showMenu(heap);
        } else {
            try {
                BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
                String userInput;
                while ((userInput = in.readLine()) != null) {
                    parts = userInput.split(" ");
                    userInputInt = new int[parts.length];
                    arrayToInt(parts, userInputInt);
                    heap = new Heap(parts.length);
                    heap.updateSet(userInputInt);
                    System.out.println("Ficheiro carregado");
                    showMenu(heap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showMenu(Heap heap) {
        int userOption = 0;
        for(;;) {
            System.out.println("\nList of available commands:");
            System.out.print(" | Update Set - 1 | ");
            System.out.print(" | Get Median - 2 | ");
            System.out.println(" | Exit - 3 | ");
            System.out.print("\nChoose Command Number -> ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                userOption = Integer.parseInt(br.readLine());

                switch (userOption) {
                    case 1:
                        System.out.print("Valor a inserir -> ");
                        int user = Integer.parseInt(br.readLine());
                        heap.updateSet(new int[]{user});
                        System.out.println("Inserção Completa!");
                        break;
                    case 2:
                        heap.getMedian();
                        System.out.println("A mediana é -> " + heap.median);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Introduza opção válida!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void arrayToInt(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);

        }


    }
}
