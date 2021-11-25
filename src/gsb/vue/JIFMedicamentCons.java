package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;

public abstract class JIFMedicamentCons extends JIFMedicament  implements ActionListener {
	
 private JButton fermer;
 private ArrayList<Medicament> lesMedicament;
	
	public class JIFMedicamentCons extends JInternalFrame implements ActionListener {
		  super();
		  fermer = new JButton("Fermer");
	      pBoutons.add(fermer);
	      fermer.addActionListener(this);
	      setDefaultCloseOperation(HIDE_ON_CLOSE);
	      setTitle("Consultation données Medicament");
	      
	      lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
	      indiceEnCours = 0;
	      
	      if (lesMedecins.size()!=0){
	    	  Medecin leMedecin = lesMedecins.get(0);
		    	remplirText(leMedecin);
		    	}
	      addInternalFrameListener(new InternalFrameAdapter(){
	      public void  internalFrameClosing(InternalFrameEvent e) {
	            
	            }
	
	      });
	}
	
	      
	      public void actionPerformed(ActionEvent evt) { 
	  		Object source = evt.getSource();
	     		if (source == fermer){
	  				indiceEnCours = 0;
	  				Medicament leMedicament = lesMedicaments.get(indiceEnCours);
	  		    	remplirText(leMedicament);				}
	  		
	   }
   }
}
