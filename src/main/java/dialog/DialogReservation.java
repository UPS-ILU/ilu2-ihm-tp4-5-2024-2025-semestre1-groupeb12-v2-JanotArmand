/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import interface_noyau_fonctionnel.InterfaceNoyauFonctionnel;
import java.awt.EventQueue;
import java.time.LocalDate;
import presentation.FrameReservation;

public class DialogReservation {

    private FrameReservation frameReservation;
    private InterfaceNoyauFonctionnel inf;

    public DialogReservation(InterfaceNoyauFonctionnel inf) {
        this.inf = inf;
    }

    public void initDialog() {
        frameReservation = new FrameReservation();
        frameReservation.initFrame();
        frameReservation.setDialog(this);
        frameReservation.setVisible(true);
    }

    public void handleDateSelectedEvent(LocalDate date) {
        inf.Date(date);
    }

    public void handleTimeSelectedEvent(String time) {
        if (!"...".equals(time)) {
            frameReservation.disableNbPersonnes();
            frameReservation.enableNbPersonnes();
            inf.Heure(time);
        } else {
            frameReservation.disableNbPersonnes();
        }
    }

    public void handleNumOfPersonsSelectedEvent(int nbPersons) {
        frameReservation.enableTables();
        inf.NbPersonnes(nbPersons);
        String[] Tables = inf.trouverTableDisponible(inf.getJour(), inf.getMois(), inf.getNbPersonnes(), inf.getHeure());
        frameReservation.initTables(Tables);
    }

    public void handleTableSelectedEvent(int numTable) {
        inf.NbTable(numTable);
        frameReservation.initValider();
    }

    public void handleCancelEvent() {
        frameReservation.disableDate();
        
    }

    public void handleValidationEvent() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void main(String[] args) {
        DialogReservation dialog = new DialogReservation(new InterfaceNoyauFonctionnel());
        EventQueue.invokeLater(() -> {
            dialog.initDialog();
        });
    }

}
