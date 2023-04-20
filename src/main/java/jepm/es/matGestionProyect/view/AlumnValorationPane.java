package jepm.es.matGestionProyect.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import jepm.es.matGestionProyect.controller.ValoracionMateriaController;
import jepm.es.matGestionProyect.model.Estudiante;
import jepm.es.matGestionProyect.model.Valoracionmateria;

import java.awt.Insets;
import java.awt.Color;

public class AlumnValorationPane extends JPanel {
	private JTextField calification;
	private Estudiante student;

	/**
	 * Create the panel.
	 */
	public AlumnValorationPane(Estudiante student) {
		setBackground(new Color(255, 255, 128));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 150};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel(student.toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		calification = new JTextField();
		GridBagConstraints gbc_calification = new GridBagConstraints();
		gbc_calification.fill = GridBagConstraints.HORIZONTAL;
		gbc_calification.gridx = 1;
		gbc_calification.gridy = 0;
		add(calification, gbc_calification);
		calification.setColumns(10);
		
		this.student = student;

	}
	
	
	/**
	 * Metod to charge the califications from the database to the jtextfields
	 * @param t
	 * @param idProf
	 * @param idMat
	 */
	public void setCalifications(int idProf, int idMat) {
		Valoracionmateria vm = ValoracionMateriaController.findCalification(idProf, idMat, this.student.getId());
		if(vm != null) {
			this.calification.setText(vm.getValoracion() + "");
		}
		else {
			this.calification.setText("");
		}
	}
	
	/**
	 * Metod to update or insert values to the database depeding of the existence of them.
	 * @param idProf
	 * @param idMat
	 */
	public void updateOrInsertValorations(int idProf, int idMat) {
		Valoracionmateria vm = ValoracionMateriaController.findCalification(idProf, idMat, this.student.getId());
		
		if (vm != null) {
			updateStudent(vm);
		}
		else {
			//Create insert metod
		}

	}


	/**
	 * Allow you to update the califications from the database.
	 * @param vm
	 */
	private void updateStudent(Valoracionmateria vm) {
		vm.setValoracion(Float.parseFloat(calification.getText()));
		ValoracionMateriaController.realizeUpdate(vm);
		this.student.toString();
	}
	
	

}
