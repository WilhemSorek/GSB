/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle 22 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;
	protected JMenu mVisiteurs;
	protected JMenu mVisites;

	
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame � la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(500, 400);

		// Ajout d'une barre de menus � la fen�tre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un �couteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un �couteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicament");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);
		JMenuItem mE3 = new JMenuItem("Medicament par Famille");
		mE3.addActionListener(this);
		mMedicaments.add(mE3);

		mVisiteurs = new JMenu("Visiteur");
		JMenuItem mA1 = new JMenuItem("Consultation Visiteur");
		mA1.addActionListener(this); // installation d'un �couteur d'action
		mVisiteurs.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout Visiteur");
		mA2.addActionListener(this);
		mVisiteurs.add(mA2);
		
		mVisites = new JMenu("Visite");
		JMenuItem mV1 = new JMenuItem("Ajout Visite");
		mV1.addActionListener(this);
		mVisites.add(mV1);
		JMenuItem mV2 = new JMenuItem("Mise � jour Visite");
		mV2.addActionListener(this);
		mVisites.add(mV2);
		JMenuItem mV3 = new JMenuItem("Liste Visite");
		mV3.addActionListener(this);
		mVisites.add(mV3);
		

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisiteurs);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de m�thode auto-g�n�r�
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fen�tre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeDic(this));
			} 
			
			else if (ChoixOption.equals("Consultation Medicament"))
			{
				ouvrirFenetre(new JIFMedicamentCons(this));
			} 
			
			else if (ChoixOption.equals("Ajout Medicament"))
			{
				ouvrirFenetre(new JIFMedicamentAdd(this));
			}
			else if (ChoixOption.equals("Medicament par Famille"))
			{
				//ouvrirFenetre(new JIFMedicamentFam(this));
			}
			
			else if (ChoixOption.equals("Consultation Visiteur"))
			{
				ouvrirFenetre(new JIFVisiteurConsulterArrayList(this));
			}
			
			else if (ChoixOption.equals("Ajout Visiteur")) 
			{
					ouvrirFenetre(new JIFVisiteurAdd(this));
			}
			
			else if (ChoixOption.equals("Ajout Visite"))
			{
				//ouvrirFenetre(new JIFVisiteAdd(this));
			}
			
			else if (ChoixOption.equals("Mise � jour Visite"))
			{
				//ouvrirFenetre(new JIFVisiteMaj(this));
			}
			else if (ChoixOption.equals("Liste Visite"))
			{
				ouvrirFenetre(new JIFVisiteList(this));
			}
		}

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fen�tre �tait dej� affich�e, elle
									// est lib�r�e
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}

}
