import domain.*;
import service.TetrisSimplificatAI;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tetris simplificat");

        // crearea pieselor
        Piesă p1 = new Piesă(3,1, Căsuță.A);
        Piesă p2 = new Piesă(2,2, Căsuță.B);
        Piesă p3 = new Piesă(new int[][]{{1}}, Căsuță.C);
        Piesă p4 = new Piesă(new int[][]{{0,1},{1,1}}, Căsuță.D);

        Piesă p5 = new Piesă(1, 4, Căsuță.E);
        Piesă p6 = new Piesă(new int[][]{{1,0,1},{1,1,1}}, Căsuță.F);
        Piesă p7 = new Piesă(new int[][]{{1,0,0},{1,1,1}}, Căsuță.G);
        Piesă p8 = new Piesă(new int[][]{{1,1,1},{0,0,1}}, Căsuță.H);
        Piesă p9 = new Piesă(new int[][]{{0,1,0},{1,1,1}}, Căsuță.I);

        // adăugarea pieselor într-un vector
        Vector<Piesă> piese = new Vector<>();
//        piese.add(p1);
//        piese.add(p2);
//        piese.add(p3);
//        piese.add(p4);
        piese.add(p5);
        piese.add(p6);
        piese.add(p7);
        piese.add(p8);
//        piese.add(p9);

        // crearea tablei de joc
        Tablă tablă = new Tablă(5,4);

        // pornirea interfeței
        System.out.println("1. DFS");
        System.out.println("2. GreedyBFS");
        System.out.print("Opțiunea dvs: ");
        Scanner scanner = new Scanner(System.in);
        String opțiune = scanner.next();

        switch (opțiune) {
            case "1":
                startDFS(piese, tablă);
                break;
            case "2":
                startGreedyBFS(piese, tablă);
                break;
            default:
                System.out.println("Opțiune invalidă.");
                break;
        }


    }

    private static void startGreedyBFS(Vector<Piesă> piese, Tablă tablă) {
        // pornirea algoritmului GreedyBFS
        System.out.println("------------------------------");
        TetrisSimplificatAI tetrisGBFS = new TetrisSimplificatAI(tablă,piese);
        Vector<Tablă> soluțiiGBFS = tetrisGBFS.startGBFS();
        System.out.println("GreedyBFS: Cea mai bună soluție găsită: \n");
        soluțiiGBFS.forEach(System.out::println);
    }

    private static void startDFS(Vector<Piesă> piese, Tablă tablă) {
        // pornirea algoritmului DFS
        System.out.println("------------------------------");
        TetrisSimplificatAI tetrisDFS = new TetrisSimplificatAI(tablă,piese);
        Vector<Tablă> soluțiiDFS = tetrisDFS.startDFS();
        System.out.println("DFS: Am găsit " + soluțiiDFS.size() + " soluții: \n");
        soluțiiDFS.forEach(System.out::println);
    }
}
