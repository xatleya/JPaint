package Controler;
import Modele.MainModele;
import View.MainFrame;

public class main {

    public static void main(String[] args) {
        MainModele modele = new MainModele();       //on crée un modèle
        MainFrame frame = new MainFrame(modele);    //on crée notre frame
        modele.addObserver(frame.getDrawPanel());   //on ajoute les observers au modèle
    }  
}
