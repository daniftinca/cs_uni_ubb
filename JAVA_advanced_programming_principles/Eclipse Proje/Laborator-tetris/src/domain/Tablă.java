package domain;

public class Tablă {
    private int nrLinii;
    private int nrColoane;
    private Căsuță[][] tablă;


    public Tablă(int nrLinii, int nrColoane) {
        this.nrLinii = nrLinii;
        this.nrColoane = nrColoane;

        tablă = new Căsuță[nrLinii][nrColoane];
        for (int i = 0; i < nrLinii; i++)
            for (int j = 0; j < nrColoane; j++)
                tablă[i][j] = Căsuță.goală;
    }

    public Tablă(Tablă tablă) {
        nrLinii = tablă.getNrLinii();
        nrColoane = tablă.getNrColoane();
        this.tablă = new Căsuță[nrLinii][nrColoane];
        for (int i = 0; i < nrLinii; i++) {
            for (int j = 0; j < nrColoane; j++) {
                this.tablă[i][j] = tablă.tablă[i][j];
            }
        }
    }

    public int getNrLinii() {
        return nrLinii;
    }
    public int getNrColoane() {
        return nrColoane;
    }

    /**
     * Se adaugă piesa primită pe tabla de joc.
     * Se menționează coordonatele pe tablă unde va fi colțul de sus-stânga al piesei.
     * Coordonatele încep de la 1, nu de la 0 !
     * @throws TablăException dacă piesa se suprapune peste o altă piesă deja existentă pe tablă.
     * Know issue: nu e tratat cazul în care tabla sau piesa conține elemente null.
     */
    public void addPiesă(Piesă piesă, int linie, int coloană) throws TablăException {
        // 1. verificăm dacă linia și coloana sunt strict pozitive
        linie--;
        coloană--;
        if (linie < 0 || coloană < 0)
            throw new TablăException("Linia sau coloana invalide.");

        // 2. verificăm dacă piesa încape pe tablă
        if (nrLinii < linie + piesă.getNrLinii() || nrColoane < coloană + piesă.getNrColoane())
            throw new TablăException("Piesa nu încape pe tablă.");

        // 3. verificăm dacă piesa nu se suprapune cu alte piese existente deja pe tablă
        for (int i = linie; i < linie + piesă.getNrLinii(); i++) {
            for (int j = coloană; j < coloană + piesă.getNrColoane(); j++) {
                if (tablă[i][j] != Căsuță.goală && piesă.getPiesă()[i-linie][j-coloană] != Căsuță.goală) {          // ar trebui goală || null
                    throw new TablăException("Piesa se suprapune cu altă piesă pe poziția " + i + ":" + j + ".");
                }
            }
        }

        // 4. așezăm piesa pe tablă
        for (int i = linie; i < linie + piesă.getNrLinii(); i++) {
            for (int j = coloană; j < coloană + piesă.getNrColoane(); j++) {
                if (tablă[i][j] == Căsuță.goală && piesă.getPiesă()[i-linie][j-coloană] != Căsuță.goală) {
                    tablă[i][j] = piesă.getPiesă()[i-linie][j-coloană];
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Căsuță[] căsuțe : tablă) {
            for (Căsuță c : căsuțe) {
                if (c != Căsuță.goală)
                    string.append(c).append(" ");
                else
                    string.append(". ");
            }
            string.append("\n");
        }
        return String.valueOf(string);
    }


    public Căsuță[][] getTablă() {
        return tablă;
    }
}
