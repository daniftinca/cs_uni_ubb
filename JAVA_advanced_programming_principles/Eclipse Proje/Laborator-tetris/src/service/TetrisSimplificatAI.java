package service;

import domain.Căsuță;
import domain.Piesă;
import domain.Tablă;
import domain.TablăException;

import java.util.NoSuchElementException;
import java.util.Vector;

public class TetrisSimplificatAI {
    private Tablă tablă;
    private Vector<Piesă> piese;
    private Vector<Tablă> soluții;


    public TetrisSimplificatAI(Tablă tablă, Vector<Piesă> piese) {
        this.tablă = tablă;
        this.piese = piese;
        soluții = new Vector<>();
    }

    /**
     * Funcția publică, principală care returnează soluțiile generate prin DFS.
     */
    public Vector<Tablă> startDFS() {
        Tablă tablă = new Tablă(this.tablă.getNrLinii(), this.tablă.getNrColoane());
        Vector<Piesă> piese = new Vector<>(this.piese);
        dfsRecursiv(tablă, piese);
        return soluții;
    }
    /**
     * Funcția recursivă care generează soluțiile prin DFS.
     */
    private void dfsRecursiv(Tablă tablă, Vector<Piesă> pieseDisponibile) {
        // luăm („cut-paste”) prima piesă disponibilă
        try {
            Piesă piesă = pieseDisponibile.firstElement();
            pieseDisponibile.remove(piesă);

            // plasăm piesa pe toate pozițiile valide
            for (int i = 0; i < tablă.getNrLinii(); i++) {
                for (int j = 0; j < tablă.getNrColoane(); j++) {
                    try {
                        Tablă tablăNouă = new Tablă(tablă);
                        tablăNouă.addPiesă(piesă, i+1, j+1);
                        // continuăm să adăugăm piese noi peste piesa curentă
                        dfsRecursiv(tablăNouă, new Vector<Piesă>(pieseDisponibile));
                    }
                    catch (TablăException ignored) {
                        // piesa nu a putut fi așezată pe coordonatele i,j
                    }
                }
            }
        }
        catch (NoSuchElementException e) {
            // am pus toate piesele pe tablă
            soluții.add(tablă);
        }
    }


    /**
     * Funcția publică, principală care returnează soluțiile generate prin GreedyBFS.
     */
    public Vector<Tablă> startGBFS() {
        Tablă tablă = new Tablă(this.tablă.getNrLinii(), this.tablă.getNrColoane());
        Vector<Piesă> piese = new Vector<>(this.piese);
        gbfsRecursiv(tablă, piese);
        return soluții;
    }
    /**
     * Funcția recursivă care generează soluțiile prin GreedyBFS.
     */
    private void gbfsRecursiv(Tablă tablă, Vector<Piesă> pieseDisponibile) {
        // luăm („cut-paste”) prima piesă disponibilă
        try {
            Piesă piesă = pieseDisponibile.firstElement();
            pieseDisponibile.remove(piesă);

            // plasăm piesa pe cea mai bună poziție validă
            try {
                tablă = adăugareIdeală(tablă, piesă);
                gbfsRecursiv(tablă, pieseDisponibile);
            } catch (TablăException ignored) {
                // piesa nu poate fi așezată pe tablă
            }
        }
        catch (NoSuchElementException e) {
            // am pus toate piesele pe tablă
            soluții.add(tablă);
        }
    }
    /**
     * Se adaugă piesa pe tablă a.î. piesele să fie aranjate cât mai uniform.
     * @return TablăException dacă piesa nu poate fi așezată pe tablă.
     */
    private Tablă adăugareIdeală(Tablă tablă, Piesă piesă) throws TablăException {
        int nrLinii = tablă.getNrLinii();
        int nrColoane = tablă.getNrColoane();
        int minCăsuțeNeuniforme = nrLinii * nrColoane;
        int bestX = -1;
        int bestY = -1;

        // detectăm cea mai bună poziție de așezare a piesei
        for (int x = 0; x < nrLinii; x++) {
            for (int y = 0; y < nrColoane; y++) {
                Tablă tablăNouă = new Tablă(tablă);
                try {
                    tablăNouă.addPiesă(piesă, x, y);
                    int căsuțeNeuniforme = calculareGradNeuniformitate(tablăNouă);
                    if (minCăsuțeNeuniforme > căsuțeNeuniforme) {
                        minCăsuțeNeuniforme = căsuțeNeuniforme;
                        bestX = x;
                        bestY = y;
                        // dacă tabla e perfectă, atunci nu are rost să căutăm o poziție mai bună
                        if (minCăsuțeNeuniforme == 0)
                            return tablăNouă;
                    }
                }
                catch (TablăException ignored) {
                    // piesa nu a putut fi așezată pe tablă pe poziția x,y
                }
            }
        }

        // așezăm piesa pe cea mai bună poziție
        tablă.addPiesă(piesă, bestX, bestY);
        return tablă;
    }
    /**
     * @param tablă de joc cu piese
     * @return numărul de căsuțe goale aflate neuniform pe tablă
     * o căsuță goală neuniformă are ca vecini 3 sau 4 căsuțe-completate sau căsuțe-zid
     */
    private int calculareCăsuțeNeuniforme(Tablă tablă) {
        int nrLinii = tablă.getNrLinii();
        int nrColoane = tablă.getNrColoane();
        int nrCăsuțeNeuniforme = 0;

        for (int i = 0; i < nrLinii; i++) {
            for (int j = 0; j < nrColoane; j++) {
                if (tablă.getTablă()[i][j] == Căsuță.goală) {
                    int veciniSolizi = calculareVeciniSolizi(tablă, i, j);
                    if (veciniSolizi > 1) {
                        nrCăsuțeNeuniforme++;
                    }
                }
            }
        }
        return nrCăsuțeNeuniforme;
    }
    /**
     * @param tablă de joc cu piese
     * @return un scor care indică gradul de neuniformitate al căsuțelor goale
     * O căsuță goală neuniformă are ca vecini 3 sau 4 căsuțe-completate sau căsuțe-zid.
     * Gradul de neuniformitate se calculează ca sumă de veciniSolizi ai unei căsuțe neuniforme.
     */
    private int calculareGradNeuniformitate(Tablă tablă) {
        int nrLinii = tablă.getNrLinii();
        int nrColoane = tablă.getNrColoane();
        int gradNeuniformitate = 0;

        for (int i = 0; i < nrLinii; i++) {
            for (int j = 0; j < nrColoane; j++) {
                if (tablă.getTablă()[i][j] == Căsuță.goală) {
                    int veciniSolizi = calculareVeciniSolizi(tablă, i, j);
                    if (veciniSolizi > 1) {
                        gradNeuniformitate += veciniSolizi;
                    }
                }
            }
        }
        return gradNeuniformitate;
    }
    /**
     * @return numărul de căsuțe negoale vecine căsuței de pe poziția x,y
     * peretele se consideră căsuță negoală
     */
    private int calculareVeciniSolizi(Tablă tablă, int x, int y) {
        int nrLinii = tablă.getNrLinii();
        int nrColoane = tablă.getNrColoane();
        int veciniSolizi = 0;

        // vecinul de sus
        if (x <= 0 || tablă.getTablă()[x-1][y] != Căsuță.goală)
            veciniSolizi++;

        // vecinul de jos
        if (x+1 >= tablă.getNrLinii() || tablă.getTablă()[x+1][y] != Căsuță.goală)
            veciniSolizi++;

        // vecinul din stânga
        if (y <= 0 || tablă.getTablă()[x][y-1] != Căsuță.goală)
            veciniSolizi++;

        // vecinul din dreapta
        if (y+1 >= tablă.getNrColoane() || tablă.getTablă()[x][y+1] != Căsuță.goală)
            veciniSolizi++;

        return veciniSolizi;
    }
}
