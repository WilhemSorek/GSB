package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.service.VisiteService;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFVisiteList extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Visite> dicVisite;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTCodeVisite;
	protected JTextField JTDateVisite;
	protected JTextField JTReference;
	protected JTable table;
	protected JButton JBVisiteDetaillee;
	protected MenuPrincipal fenetreContainer;
	
	public JIFVisiteList(MenuPrincipal uneFenetreContainer)
	{
		fenetreContainer = uneFenetreContainer;
		
		dicVisite = VisiteService.retournerCollectionVisites();
		int nbLignes = dicVisite.size();
		
		p = new JPanel();
		
		int i = 0;
		String [][] data = new String [nbLignes][3];
		for(Map.Entry<String, Visite> uneVisite : dicVisite.entrySet())
		{
			data[i][0] = uneVisite.getValue().getReference();
			data[i][1] = uneVisite.getValue().getUnMedecin().getCodeMed();
			data[i][2] = uneVisite.getValue().getUnMedecin().getAdresse();
			i++;
		}
		String[] columnNames = {"Reference", "Code Medecin", "Lieu"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTReference = new JTextField(20);
		JTReference.setMaximumSize(JTReference.getPreferredSize());
		JBVisiteDetaillee = new JButton("Visite detaillee");
		JBVisiteDetaillee.addActionListener(this);
		pSaisie.add(JTReference);
		pSaisie.add(JBVisiteDetaillee);
		p.add(pSaisie);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}
	
}
