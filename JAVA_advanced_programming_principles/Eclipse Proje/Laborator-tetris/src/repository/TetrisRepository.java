package repository;

import domain.Piesă;
import domain.Tablă;

import java.util.Vector;

public class TetrisRepository {
    private Tablă tablă;
    private Vector<Piesă> piese;
    private String fileName;


    public TetrisRepository(String fileName) {
        this.fileName = fileName;
        readFromFile();
    }

    private void readFromFile() {
//        Path fullPath = Paths.get(fileName);
//        Stream<String> linii = null;
//
//        // 1. citim tabla (nrLinii și nrColoane)
//
//        // 2. citim piesele
//        try {
//            linii = Files.lines(fullPath);
//
//            linii.forEach(linie -> {
//                // identificăm câmpurile piesei
//                String[] câmpuri = linie.split("█");
//                String id = câmpuri[0];
//                String nume = câmpuri[1];
//                String prenume = câmpuri[2];
//                String telefon = câmpuri[3];
//                String e_mail = câmpuri[4];
//
//                // creăm piesa
//                Piesă piesă = new Piesă(id, nume, prenume, telefon, e_mail);
//
//                // salvăm piesa
//                piese.add(piesă);
//            });
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//        }
//
//        if (linii != null)
//            linii.close();
    }

    public Vector<Piesă> getPiese() {
        return piese;
    }
}
