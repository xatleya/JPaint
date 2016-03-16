package Controler;
import Modele.MainModele;
import View.MainFrame;

public class main {

    public static void main(String[] args) {
        MainModele modele = new MainModele();
        MainFrame frame = new MainFrame();
        modele.addObserver(frame.getDrawPanel());
    }
    
}
