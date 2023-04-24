package jepm.es.matGestionProyect.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jepm.es.matGestionProyect.controller.EstudianteController;
import jepm.es.matGestionProyect.controller.MateriaController;
import jepm.es.matGestionProyect.controller.ProfesorController;
import jepm.es.matGestionProyect.model.Estudiante;
import jepm.es.matGestionProyect.model.Materia;
import jepm.es.matGestionProyect.model.Profesor;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JComboBox jcb_matChooser;
	private JComboBox jcb_professorChooser;
	private JPanel validationPane;
	List<AlumnValorationPane> valorations = new ArrayList<AlumnValorationPane>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Valoracion Materia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{87, 82, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(158, 192, 207));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
//		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcb_matChooser = new JComboBox();
		GridBagConstraints gbc_jcb_matChooser = new GridBagConstraints();
		gbc_jcb_matChooser.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_matChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_matChooser.gridx = 1;
		gbc_jcb_matChooser.gridy = 0;
		panel.add(jcb_matChooser, gbc_jcb_matChooser);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcb_professorChooser = new JComboBox();
		jcb_professorChooser.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_jcb_professorChooser = new GridBagConstraints();
		gbc_jcb_professorChooser.insets = new Insets(0, 0, 0, 5);
		gbc_jcb_professorChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_professorChooser.gridx = 1;
		gbc_jcb_professorChooser.gridy = 1;
		panel.add(jcb_professorChooser, gbc_jcb_professorChooser);
		
		JButton alumnGeneratorButton = new JButton("Botón refrescar alumnado");
		chargeStudentValorations(alumnGeneratorButton);
		GridBagConstraints gbc_alumnGeneratorButton = new GridBagConstraints();
		gbc_alumnGeneratorButton.gridx = 2;
		gbc_alumnGeneratorButton.gridy = 1;
		panel.add(alumnGeneratorButton, gbc_alumnGeneratorButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.columnWeights = new double[]{1.0};
//		gbl_panel_1.columnWidths = new int[]{0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
//		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A continuación deben aparecer todos los estudiantes con un elemento ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("para que puedas introducir su nota, para el profesor y la materia determinada");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		validationPane = new JPanel();
		validationPane.setBackground(new Color(255, 255, 128));
		GridBagConstraints gbc_validationPane = new GridBagConstraints();
		gbc_validationPane.insets = new Insets(0, 0, 5, 0);
		gbc_validationPane.fill = GridBagConstraints.VERTICAL;
		gbc_validationPane.gridx = 0;
		gbc_validationPane.gridy = 2;
		panel_1.add(validationPane, gbc_validationPane);
		GridBagLayout gbl_validationPane = new GridBagLayout();
		gbl_validationPane.columnWidths = new int[]{0, 0};
		gbl_validationPane.rowHeights = new int[]{0, 0, 0};
		gbl_validationPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_validationPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		validationPane.setLayout(gbl_validationPane);
		
		JButton saveButton = new JButton("Guardar las notas de todos los alumnos");
		updateTheStudentsValues(saveButton);
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 3;
		panel_1.add(saveButton, gbc_saveButton);
		setValuesToCombos(jcb_matChooser, jcb_professorChooser);
		setValuesToValidationPane();
	}

	
	/**
	 * Update or insert the values from the program to the database.
	 * @param saveButton
	 */
	private void updateTheStudentsValues(JButton saveButton) {
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor p = (Profesor) jcb_professorChooser.getSelectedItem();
				Materia m = (Materia) jcb_matChooser.getSelectedItem();
				
				for (AlumnValorationPane alumnValorationPane : valorations) {
					alumnValorationPane.updateOrInsertValorations(p, m);
				}
			}
		});
	}

	
	/**
	 * Charge the calification of the students to the database
	 * @param alumnGeneratorButton
	 */
	private void chargeStudentValorations(JButton alumnGeneratorButton) {
		alumnGeneratorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor p = (Profesor) jcb_professorChooser.getSelectedItem();
				Materia m = (Materia) jcb_matChooser.getSelectedItem();

				for (AlumnValorationPane alumnValorationPane : valorations) {
					alumnValorationPane.setCalifications(p.getId(), m.getId());
				}
			}
		});
	}
	
	
	/**
	 * Add numeric values to combos.
	 */
	public static void setValuesToCombos(JComboBox comboMat, JComboBox comboProf) {
		setMatValues(comboMat);
		setProfValues(comboProf);
	}
	
	
	/**
	 * Add all Materias to JComboBox.
	 */
	public static void setMatValues(JComboBox comboMat) {
		List<Materia> matList = MateriaController.findAll();
		
		for (Materia materia : matList) {
			comboMat.addItem(materia);
		}
	}
	

	/**
	 * Add all Professors to JComboBox.
	 */
	public static void setProfValues(JComboBox comboProf) {
		List<Profesor> profList = ProfesorController.findAll();
		
		for (Profesor prof : profList) {
			comboProf.addItem(prof);
		}
	}
	
	
	/**
	 * Generate automatucally all the Student data.
	 * @param panel
	 */
	public void setValuesToValidationPane() {
		int cont = 0;
		List<Estudiante> students = EstudianteController.findAll();

		for (Estudiante estudiante : students) {
			AlumnValorationPane alumnPanel = new AlumnValorationPane(estudiante) ;
			valorations.add(alumnPanel);
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		for (AlumnValorationPane valoration : valorations) {
		    gbc.weightx = 1;
		    gbc.gridy = cont;
		    this.validationPane.add(valoration, gbc);
		    cont++;
		}
	}

}
