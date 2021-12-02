package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import gsb.modele.Visite;

public class JIFVisiteurCons extends JIFVisiteur implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton premier;
	private JButton precedent;
	private JButton suivant;
	private JButton dernier;
	private ArrayList<Visite> lesVisites;
	private int indiceEnCours;
	
	public JIFVisiteurCons()
	{
		super();
		premier = new JButton("Premier");
		pBoutons.add(premier);
		precedent =new JButton("Precedent");
		pBoutons.add(precedent);
		suivant = new JButton("Suivant");
		pBoutons.add(suivant);
		dernier = new JButton("Dernier");
		pBoutons.add(dernier);
		
		premier.addActionListener(this);
		suivant.addActionListener(this);
		precedent.addActionListener(this);
		dernier.addActionListener(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Consultation données Visite");
		
		lesVisites = VisiteDao.retournerCollectionDesVisites();
		indiceEnCours = 0;
		
		if(lesVisites.size()!=0)
		{
			Visite laVisite = lesVisites.get(0);
			remplirText(laVisite);
		}
		
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e)
			{
				
			}
		});
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		Object source = evt.getSource();
		if (source == premier)
		{
			indiceEnCours = 0;
			Visite laVisite = lesVisites.get(indiceEnCours);
			remplirText(laVisite);
		}
		else if (source == dernier)
		{
			indiceEnCours = lesVisites.size() -1;
			Visite laVisite = lesVisites.get(indiceEnCours);
			remplirText(laVisite);
		}
		else if (source == precedent)
		{
			if (indiceEnCours > 0)
			{
				indiceEnCours--;
				Visite laVisite = lesVisites.get(indiceEnCours);
				remplirText(laVisite);
			}
		}
			else if (source == suivant)
			{
				if (indiceEnCours < (lesVisites.size() -1))
				{
					indiceEnCours++;
					Visite laVisite = lesVisites.get(indiceEnCours);
					remplirText(laVisite);
				}
			}
		}
	}