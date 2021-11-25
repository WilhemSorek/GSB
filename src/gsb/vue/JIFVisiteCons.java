package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Visite;

public class JIFVisiteCons extends JIFVisite implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton premier;
	private JButton precedent;
	private JButton suivant;
	private JButton dernier;
	private ArrayList<Visite> lesVisites;
	private int indiceEnCours;
	
	public JIFVisiteCons()
	{
		super();
		premier = new JButton("Premier");
		pBoutons.add(premier);
	}

}
