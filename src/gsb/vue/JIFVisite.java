package gsb.vue;

import gsb.modele.Visite;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisite extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JLabel JLreference;
	protected JLabel JLdateVisite;
	protected JLabel JLcommentaire;
	protected JLabel JLMatricule;
	protected JLabel JLcodeMed;
	
	protected JTextField JTreference;
	protected JTextField JTdateVisite;
	protected JTextField JTcommentaire;
	protected JTextField JTmatricule;
	protected JTextField JTcodeMed;
	
	public JIFVisiteur()
	{
		p = new JPanel();
		pBoutons = new JPanel();
		pTexte = new JPanel(new GridLayout(9,2));
		
		JLreference = new JLabel("Reference");
		JLdateVisite = new JLabel("Date Visite");
		JLcommentaire = new JLabel("Commentaire");
		JLMatricule = new JLabel("Matricule");
		JLcodeMed = new JLabel("Code Medecin");
		
		JTreference = new JTextField(20);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JTdateVisite = new JTextField();
		JTcommentaire = new JTextField();
		JTmatricule = new JTextField();
		JTcodeMed = new JTextField();
		
		
	}
}
