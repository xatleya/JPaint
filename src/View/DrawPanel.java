package View;
import Modele.MainModele;
import Modele.MyShape;
import Observe.Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class DrawPanel extends JPanel implements Observer{  //panel central qui permettra de dessiner 
    private MainModele modele;
    private MainFrame mainFrame;
    
    //contructeur du panel principal
    public DrawPanel(MainModele modele, MainFrame mainFrame) {
        this.modele = modele;
        this.mainFrame = mainFrame;
        this.setLayout(null);   //pas de layout (on veut positioner une forme n'importe où)
        this.setBackground(Color.white);    //blanc comme une feuille de dessin
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //CREATION DES RACOURCIES CLAVIERS
        
        //DELETE une shape
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete");
        this.getActionMap().put("delete", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {   //quand on clique sur suppr
                ArrayList<MyShape> shapesTab = modele.getShapesTab();   
                for(int i=0;i<=shapesTab.size()-1;i++) {  //on parcourt la liste de shape du JPaint
                    if(shapesTab.get(i).isSelected()) { //si une forme est sélectionné
                        remove(shapesTab.get(i));   //on supprime cette forme du JPanel
                        modele.getShapesTab().remove(i);    //on supprime cette forme du tableau
                    }
                }
                modele.notifyObserver();    //mise à jour de JPaint
            }    
        });
        
        //COPY d'une shape
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control C"), "copy");
        this.getActionMap().put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {   //quand on clique sur ctrl+C
                ArrayList<MyShape> shapesTab = modele.getShapesTab();
                for(int i=0;i<=shapesTab.size()-1;i++) {    //on parcourt la liste de shape du JPaint
                    if(shapesTab.get(i).isSelected()) { //si une forme est sélectionnée
                        modele.setCopyShape(shapesTab.get(i));  //on la copie dans la variable CopyShape
                    }
                }
                System.out.println("copy");
            }    
        });
        
        //COLLER une shape
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control V"), "coller");
        this.getActionMap().put("coller", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {   //si on clique sur ctrl+V
                MyShape copyShape = modele.getCopyShape();
                if(copyShape != null) { //si une shape a été copiée
                    if(copyShape.getType().equals("Ellipse")) { //si c'est une éllipse on créee une copie de cette éllipse
                        Shape shapeBackground = new Ellipse2D.Float((int)copyShape.getShapeBackground().getBounds2D().getX(),(int)copyShape.getShapeBackground().getBounds2D().getY(),(int)copyShape.getShapeBackground().getBounds2D().getWidth(),(int)copyShape.getShapeBackground().getBounds2D().getHeight());
                        Shape shapeForeground = new Ellipse2D.Float((int)copyShape.getShapeForeground().getBounds2D().getX(),(int)copyShape.getShapeForeground().getBounds2D().getY(),(int)copyShape.getShapeForeground().getBounds2D().getWidth(),(int)copyShape.getShapeForeground().getBounds2D().getHeight());
                        MyShape newShape = new MyShape(modele, shapeForeground, shapeBackground, copyShape.getForegroundColor(), copyShape.getBackgroundColor(), "Ellipse");
                        newShape.addMouseListener(copyShape.getMouseListeners()[0]);
                        newShape.addMouseMotionListener(copyShape.getMouseMotionListeners()[0]);
                        modele.getShapesTab().add(newShape);
                        System.out.println("coller");
                    }
                    if(copyShape.getType().equals("Rectangle")) {   //si c'est un rectangle on céee une copie de ce rectangle
                        Shape shapeBackground = new Rectangle2D.Float((int)copyShape.getShapeBackground().getBounds2D().getX(),(int)copyShape.getShapeBackground().getBounds2D().getY(),(int)copyShape.getShapeBackground().getBounds2D().getWidth(),(int)copyShape.getShapeBackground().getBounds2D().getHeight());
                        Shape shapeForeground = new Rectangle2D.Float((int)copyShape.getShapeForeground().getBounds2D().getX(),(int)copyShape.getShapeForeground().getBounds2D().getY(),(int)copyShape.getShapeForeground().getBounds2D().getWidth(),(int)copyShape.getShapeForeground().getBounds2D().getHeight());
                        MyShape newShape = new MyShape(modele, shapeForeground, shapeBackground, copyShape.getForegroundColor(), copyShape.getBackgroundColor(), "Rectangle");
                        newShape.addMouseListener(copyShape.getMouseListeners()[0]);
                        newShape.addMouseMotionListener(copyShape.getMouseMotionListeners()[0]);
                        modele.getShapesTab().add(newShape);
                        System.out.println("coller");
                    }
                }
                modele.notifyObserver();    //mise à jour
                
            }    
        });
    }
    
    @Override
    public void paintComponent(Graphics g){ //dessine sur le JPanel principal
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        //ajout des panels de nos shapes au JPanel principal
        int i = this.modele.getShapesTab().size()-1;
        while(i!=-1) {  //on ajoute les JPanel dans le désordre car le 1er panel ajouté est celui pris en compte en cas de collision
            MyShape current = this.modele.getShapesTab().get(i);
            if(!current.getType().equals("Line_D") || !current.getType().equals("Line_M")) {    //on ajoute les lignes après les autres formes car les lignes sont petites (moins prioritaires)
                if(current.isSelected()) {  //si une forme est sélectionnée, on vérifie si elle a bougée
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                    current.setBackground(new Color(0,0,0,0));
                }
                else {
                    this.remove(current);   //si elle n'est pas séléctionnée, on la supprime est la recrée
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        i=this.modele.getShapesTab().size()-1;
        while(i!=-1) {  //on ajoute ici les panels de lignes (non prioritaires)
            MyShape current = this.modele.getShapesTab().get(i);
            if(current.getType().equals("Line_D") || current.getType().equals("Line_M")) {
                if(current.isSelected()) {
                    current.setLocation(new Point(current.getxOrigin(), current.getyOrigin()));
                    current.setBackground(new Color(0,0,0,0));
                }
                else {
                    current.setBounds(current.getxOrigin(), current.getyOrigin(), (int)current.getShapeForeground().getBounds2D().getWidth(), (int)current.getShapeForeground().getBounds2D().getHeight());
                    this.add(current);
                }
            }
            i--;
        }
        
        //ajout de nos shapes
        for(MyShape current : this.modele.getShapesTab()) { //on ajoute nos shapes au JPanel principal
            if(current.getShapeBackground() != null) {  //on met la couleur correspondant au contour 
                g2d.setPaint(current.getBackgroundColor());
                g2d.fill(current.getShapeBackground()); 
                g2d.draw(current.getShapeBackground());
            }
            
            if(current.isSelected()) {  //si la shape est sélectionnée, on change sa couleur en dark (l'intérieur)
                Color selectedColor = current.getForegroundColor();
                selectedColor = selectedColor.brighter();
                g2d.setPaint(current.getForegroundColor().darker());
            }
            else {
                g2d.setPaint(current.getForegroundColor());
            }
            g2d.fill(current.getShapeForeground());
            g2d.draw(current.getShapeForeground());
        }
    }

    public MainModele getModele() {
        return modele;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public void removeListeners() { //fonction qui permet de supprimer les listeners d'un JPanel
        for(MouseListener current : this.getMouseListeners()) { //supprime les mouseListeners du JPanel principal
            this.removeMouseListener(current);
        }
        for(MyShape current : this.getModele().getShapesTab()) {    //supprime les MouseListeners des JPanel associés aux shapes
                JPanel panel = (JPanel)current;
                for(MouseListener ml : panel.getMouseListeners()) {
                    panel.removeMouseListener(ml);
                }
                for(MouseMotionListener mml : panel.getMouseMotionListeners()) {    //supprime les MouseMotionListeners des JPanel associés aux shapes
                    panel.removeMouseMotionListener(mml);
                }
                current.setSelected(false);
            }
    }

    @Override
    public void update() {  //update le JPaint
        this.revalidate();
        this.repaint();
    }
}
