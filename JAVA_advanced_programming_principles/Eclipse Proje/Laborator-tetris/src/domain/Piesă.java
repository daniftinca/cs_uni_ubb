package domain;

public class Piesă {
    private int nrLinii;
    private int nrColoane;
    private Căsuță[][] piesă;

    /**
     * Creare o piesă complet acoperită.
     */
    public Piesă(int nrLinii, int nrColoane) {
        this.nrLinii = nrLinii;
        this.nrColoane = nrColoane;

        piesă = new Căsuță[nrLinii][nrColoane];
        for (int i = 0; i < nrLinii; i++)
            for (int j = 0; j < nrColoane; j++)
                piesă[i][j] = Căsuță.acoperită;
    }

    /**
     * Creare o piesă complet acoperită cu simbolul dat.
     */
    public Piesă(int nrLinii, int nrColoane, Căsuță simbol) {
        this.nrLinii = nrLinii;
        this.nrColoane = nrColoane;

        piesă = new Căsuță[nrLinii][nrColoane];
        for (int i = 0; i < nrLinii; i++)
            for (int j = 0; j < nrColoane; j++)
                piesă[i][j] = simbol;
    }

    /**
     * Creare o piesă custom neuniformă.
     * @param piesă - o matrice de numere: 0 = căsuță goală, 1 = căsuță ocupată (sau orice altceva înafară de 0)
     * @param simbol - simbolul piesei
     */
    public Piesă(int[][] piesă, Căsuță simbol) {
        // 1. determinare nrLinii și nrColoane maxime
        nrLinii = nrColoane = 0;
        for (int i = 0; i < piesă.length; i++) {
            if (nrLinii <= i)
                nrLinii = i + 1;
            for (int j = 0; j < piesă[i].length; j++) {
                if (nrColoane <= j)
                    nrColoane = j + 1;
            }
        }

        // 2. crearea piesei actuale și „astuparea” găurilor din piesă
        this.piesă = new Căsuță[nrLinii][nrColoane];
        for (int i = 0; i < nrLinii; i++) {
            for (int j = 0; j < nrColoane; j++) {
                if (piesă[i].length > j && piesă[i][j] != 0) {
                    this.piesă[i][j] = simbol;
                }
                else {
                    this.piesă[i][j] = Căsuță.goală;
                }
            }

        }
    }

    public int getNrLinii() {
        return nrLinii;
    }
    public int getNrColoane() {
        return nrColoane;
    }
    public Căsuță[][] getPiesă() {
        return piesă;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Căsuță[] căsuțe : piesă) {
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
}
