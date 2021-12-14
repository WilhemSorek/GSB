package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import gsb.modele.Localite;
import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteurService;

public class JIFVisiteurConsulterArrayList extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Visiteur> dicVisiteur;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTmatriculeVisiteur;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;
	
	public JIFVisiteurConsulterArrayList(MenuPrincipal uneFenetreContainer)
	{
		fenetreContainer = uneFenetreContainer;
		
		dicVisiteur = VisiteurService.retournerCollectionVisiteur();
		int nbLignes = dicVisiteur.size();
		
		p = new JPanel();
		
		int i=0;
		String [][] data = new String[nbLignes][3];
		
		for(Map.Entry<String, Visiteur> unVisiteur : dicVisiteur.entrySet())
		{
			data[i][0] = unVisiteur.getValue().getMatricule();
			data[i][1] = unVisiteur.getValue().getNom();
			data[i][2] = unVisiteur.getValue().getPrenom();
			i++;
		}
		String[] columnNames = {"Matricule", "Nom", "Prenom"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTmatriculeVisiteur = new JTextField(20);
		JTmatriculeVisiteur.setMaximumSize(JTmatriculeVisiteur.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Visiteur");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTmatriculeVisiteur);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object source = arg0.getSource();
			if (source == JBafficherFiche)
			{
				if (dicVisiteur.containsKey(JTmatriculeVisiteur.getText())){
					Visiteur unVisiteur = dicVisiteur.get(JTmatriculeVisiteur.getText());
					fenetreContainer.ouvrirFenetre(new JIFVisiteurFiche(unVisiteur));
				}
			}
			if (source == table)
			{
				JTmatriculeVisiteur.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
			}
		}
	}
