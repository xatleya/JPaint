package Modele;
import Observe.Observable;
import Observe.Observer;
import java.util.ArrayList;

public class MainModele implements Observable{  //principal modèle de notre application
    private ArrayList<MyShape> shapesTab = new ArrayList<MyShape>();    //contient la liste de shape du JPaint
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();   //contient les observers
    private MyShape copyShape = null;   //contient la shape qu'on aura copié avec ctrl+C
    
    public MainModele() {
        
    }

    public ArrayList<MyShape> getShapesTab() {
        return shapesTab;
    }

    public void setShapesTab(ArrayList<MyShape> shapesTab) {
        this.shapesTab = shapesTab;
    }

    public MyShape getCopyShape() {
        return copyShape;
    }

    public void setCopyShape(MyShape copyShape) {
        this.copyShape = copyShape;
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
