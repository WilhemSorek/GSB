package gsb.vue;

import gsb.modele.Visiteur;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JIFVisiteur extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLadresse;
	protected JLabel JLdateEntree;
	protected JLabel JLcodeUnite;
	protected JLabel JLnomUnite;
	
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTadresse;
	protected JTextField JTdateEntree;
	protected JTextField JTcodeUnite;
	protected JTextField JTnomUnite;
	
	public JIFVisiteur()
	{
		p = new JPanel();
		pBoutons = new JPanel();
		pTexte = new JPanel(new GridLayout(7,2));
		
		
		JLmatricule = new JLabel("Matricule");
		JLnom = new JLabel("Nom");
		JLprenom = new JLabel("Prenom");
		JLadresse = new JLabel("Adresse");
		JLdateEntree = new JLabel("Date Entree");
		JLcodeUnite = new JLabel("Code Unite");
		JLnomUnite = new JLabel("Nom Unite");
		
		JTmatricule = new JTextField(20);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTnom = new JTextField();
		JTprenom = new JTextField();
		JTadresse = new JTextField();
		JTdateEntree = new JTextField();
		JTcodeUnite = new JTextField();
		JTnomUnite = new JTextField();
		
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		pTexte.add(JLnom);
		pTexte.add(JTnom);
		pTexte.add(JLprenom);
		pTexte.add(JTprenom);
		pTexte.add(JLadresse);
		pTexte.add(JTadresse);
		pTexte.add(JLdateEntree);
		pTexte.add(JTdateEntree);
		pTexte.add(JLcodeUnite);
		pTexte.add(JTcodeUnite);
		pTexte.add(JLnomUnite);
		pTexte.add(JTnomUnite);
		p.add(pTexte);
		p.add(pBoutons);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
		
	}
	
	public void remplirText(Visiteur unVisiteur)
	{
		JTmatricule.setText(unVisiteur.getMatricule());
		JTnom.setText(unVisiteur.getNom());
		JTprenom.setText(unVisiteur.getPrenom());
		JTadresse.setText(unVisiteur.getAdresse());
		JTdateEntree.setText(unVisiteur.getDateEntree());
		JTcodeUnite.setText(unVisiteur.getCodeUnite());
		JTnomUnite.setText(unVisiteur.getNomUnite());
	}
	
	public void viderText()
	{
		JTmatricule.setText("");
		JTnom.setText("");
		JTprenom.setText("");
		JTadresse.setText("");
		JTdateEntree.setText("");
		JTcodeUnite.setText("");
		JTnomUnite.setText("");
	}
}
