package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gsb.modele.Visiteur;
import gsb.modele.dao.LocaliteDao;
import gsb.service.VisiteurService;

public class JIFVisiteurAdd extends JInternalFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	protected JPanel p;
	protected JPanel pSaisie;
	protected JPanel pBouton;
	
	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;
	protected JLabel JLlogin;
	protected JLabel JLmdp;
	protected JLabel JLadresse;
	protected JLabel JLcodePostal;
	protected JLabel JLdateEntree;
	protected JLabel JLprime;
	protected JLabel JLcodeUnite;
	protected JLabel JLnomUnite;
	
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	protected JTextField JTlogin;
	protected JPasswordField JTmdp;
	protected JTextField JTadresse;
	protected JTextField JTcodePostal;
	protected JTextField JTdateEntree;
	protected JTextField JTprime;
	protected JTextField JTcodeUnite;
	protected JTextField JTnomUnite;
	
	protected JButton JBajouterVisiteur;
	protected MenuPrincipal fenetreContainer;
	
	public JIFVisiteurAdd(MenuPrincipal uneFenetreContainer)
	{
		fenetreContainer = uneFenetreContainer;
		
		JLmatricule = new JLabel("Matricule :");
		JLnom = new JLabel("Nom :");
		JLprenom = new JLabel("Prenom :");
		JLlogin = new JLabel("Login :");
		JLmdp = new JLabel("Mot De Passe :");
		JLadresse = new JLabel("Adresse :");
		JLcodePostal = new JLabel("Code Postal :");
		JLdateEntree = new JLabel("Date Entree :");
		JLprime = new JLabel("Prime :");
		JLcodeUnite = new JLabel("Code Unite :");
		JLnomUnite = new JLabel("Nom Unite :");
		
		p = new JPanel();
		pSaisie = new JPanel(new GridLayout(13,2));
		pBouton = new JPanel(new GridLayout(1, 1));
		
		JTmatricule = new JTextField(20);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTnom = new JTextField(20);
		JTnom.setMaximumSize(JTnom.getPreferredSize());
		JTprenom = new JTextField(20);
		JTprenom.setMaximumSize(JTprenom.getPreferredSize());
		JTlogin = new JTextField(20);
		JTlogin.setMaximumSize(JTlogin.getPreferredSize());
		JTmdp = new JPasswordField(20);
		JTmdp.setMaximumSize(JTmdp.getPreferredSize());
		JTadresse = new JTextField(20);
		JTadresse.setMaximumSize(JTadresse.getPreferredSize());
		JTcodePostal = new JTextField(20);
		JTcodePostal.setMaximumSize(JTcodePostal.getPreferredSize());
		JTdateEntree = new JTextField(20);
		JTdateEntree.setMaximumSize(JTdateEntree.getPreferredSize());
		JTprime = new JTextField(20);
		JTprime.setMaximumSize(JTprime.getPreferredSize());
		JTcodeUnite = new JTextField(20);
		JTcodeUnite.setMaximumSize(JTcodeUnite.getPreferredSize());
		JTnomUnite = new JTextField(20);
		JTnomUnite.setMaximumSize(JTnomUnite.getPreferredSize());
		JBajouterVisiteur = new JButton("Ajouter Visiteur");
		JBajouterVisiteur.addActionListener(this);
		
		pSaisie.add(JLmatricule);
		pSaisie.add(JTmatricule);
		pSaisie.add(JLnom);
		pSaisie.add(JTnom);
		pSaisie.add(JLprenom);
		pSaisie.add(JTprenom);
		pSaisie.add(JLlogin);
		pSaisie.add(JTlogin);
		pSaisie.add(JLmdp);
		pSaisie.add(JTmdp);
		pSaisie.add(JLadresse);
		pSaisie.add(JTadresse);
		pSaisie.add(JLcodePostal);
		pSaisie.add(JTcodePostal);
		pSaisie.add(JLdateEntree);
		pSaisie.add(JTdateEntree);
		pSaisie.add(JLprime);
		pSaisie.add(JTprime);
		pSaisie.add(JLcodeUnite);
		pSaisie.add(JTcodeUnite);
		pSaisie.add(JLnomUnite);
		pSaisie.add(JTnomUnite);
		
		pBouton.add(JBajouterVisiteur);
		p.add(pSaisie);
		p.add(pBouton);
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object source = arg0.getSource();
			if (source == JBajouterVisiteur)
			{
				try {
			
				Visiteur unVisiteur = new Visiteur(JTmatricule.getText(), JTnom.getText(), JTprenom.getText(), JTlogin.getText(), JTmdp.getPassword().toString(), JTadresse.getText(), LocaliteDao.rechercher(JTcodePostal.getText()), JTdateEntree.getText(), Integer.valueOf(JTprime.getText()), JTcodeUnite.getText(), JTnomUnite.getText());
				VisiteurService.ajouterVisiteur(unVisiteur);
				this.viderText();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			}
		}
		
		public void viderText()
		{
				JTmatricule.setText("");
				JTnom.setText("");
				JTprenom.setText("");
				JTlogin.setText("");
				JTmdp.setText("");
				JTadresse.setText("");
				JTcodePostal.setText("");
				JTdateEntree.setText("");
				JTprime.setText("");
				JTcodeUnite.setText("");
				JTnomUnite.setText("");
			}
}
	
