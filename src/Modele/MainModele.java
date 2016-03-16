package Modele;
import Observe.Observable;
import Observe.Observer;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MainModele implements Observable{
    private ArrayList<Graphics2D> shapesTab = new ArrayList<Graphics2D>();
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    public MainModele() {
        
    }

    public ArrayList<Graphics2D> getShapesTab() {
        return shapesTab;
    }

    public void setShapesTab(ArrayList<Graphics2D> shapesTab) {
        this.shapesTab = shapesTab;
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    @Override
    public void removeObserver() {
        this.listObserver = new ArrayList<Observer>();
    }

    @Override
    public void notifyObserver() {
        for(Observer obs : this.listObserver){
            obs.update();
        }
    }
}
