package interface_noyau_fonctionnel;

import java.time.LocalDate;

public class InterfaceNoyauFonctionnel {
    
    LocalDate DateReservation;
    int JourReservation;
    int MoisReservation;
    String HeureReservation;
    int nbPersonnesReservation;
    String[] TablesReservation;
    int nbTableReservation;

    public String[] trouverTableDisponible(int jour, int mois, int nombrePersonnes, String time) {
        String[] Tables = new String[]{"Table 1", "Table 2", "Table 3", "Table 4", "Table 5", "Table 6"};
        String[] TablesDispo = new String[Tables.length];
        int j=0;
        if ((nombrePersonnes>2)&&(nombrePersonnes<=4)) {
            for (int i=0;i<Tables.length;i++) {
                if (!"Table 1".equals(Tables[i])) {
                    TablesDispo[j]=Tables[i];
                    j+=1;
                }
            }
        } else if ((nombrePersonnes>4)&&(nombrePersonnes<=8)) {
            for (int i=0;i<Tables.length;i++) {
                if ("Table 6".equals(Tables[i])) {
                    TablesDispo[j]=Tables[i];
                    j+=1;
                }
            }
        } else {
            TablesReservation=Tables;
            return Tables;
        }
        TablesReservation=TablesDispo;
        return TablesDispo;
    }
    
    public void Date(LocalDate date) {
        this.DateReservation = date;
        this.JourReservation = date.getDayOfMonth();
        this.MoisReservation = date.getMonthValue();
    }
    
    public LocalDate getDate() {
        return DateReservation;
    }
    
    public int getJour() {
        return JourReservation;
    }
    
    public int getMois() {
        return MoisReservation;
    }
    
    public void Heure(String time) {
        this.HeureReservation = time;
    }
    
    public String getHeure() {
        return HeureReservation;
    }
    
    public void NbPersonnes(int nbPersons) {
        this.nbPersonnesReservation = nbPersons;
    }
    
    public int getNbPersonnes() {
        return nbPersonnesReservation;
    }
    
    public void NbTable(int nbTable) {
        this.nbTableReservation = nbTable;
    }
    
    public int getNbTable() {
        return nbTableReservation;
    }
    
    public String MessageValidation(LocalDate Date, String Time, int NbPersons, int NbTable) {
        String msg = "Réservation validée pour le " + Date.toString() + " à " + Time + " pour " + NbPersons + " personnes à la " + TablesReservation[NbTable] + ".";
        return msg;
    }

}
