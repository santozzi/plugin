package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.CalculadoraSimple;
import Logica.PluginFunction;
import Observer.Observador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
/**
 * CalculadoraSimpleGUI
 * Es un contenedor de plugins, dependiendo de la cantidad de parámetros del mismo
 * genera los JTextFiel y los JLabel necesarios, implementa a Observador ya que observa
 * a CalculadoraSimple, quien le dice que hubo cambios en el directorio de archivos y
 * el plugin correspondiente 
 * 
 */
public class CalculadoraSimpleGUI extends JFrame implements Observador{


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JComboBox<PluginFunction> cmbPlugins;
	protected CalculadoraSimple demo;
	protected JTextArea txtDescripcion;
	protected JPanel pnlEtiquetaCampo;
	protected JPanel pnlEntradas;
	protected Map<Integer,JTextField> mapeoDeEntradas;
	protected PluginFunction seleccion;
	protected JTextArea txtResultado;
	protected boolean cmbPluginsVacia;
	private static Logger Logger;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraSimpleGUI frame = new CalculadoraSimpleGUI();
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
	@SuppressWarnings("static-access")
	public CalculadoraSimpleGUI() {
		
		if(Logger==null) {
			Logger = Logger.getLogger(CalculadoraSimpleGUI.class.getName());
			Handler hnd = new ConsoleHandler();

			hnd.setLevel(Level.FINE);
			Logger.addHandler(hnd);
			Logger.setLevel(Level.FINE);
			Logger rootLogger = Logger.getParent();
			for(Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
		cmbPluginsVacia = false;
		mapeoDeEntradas = new HashMap<Integer, JTextField>();
		demo = new CalculadoraSimple();
		demo.agregarObservador(this);

		//demo.runPlugins();


		setTitle("CalculadoraSimple");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 586, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		cmbPlugins = new JComboBox<PluginFunction>();
		cmbPlugins.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				limpiar();

				cargarPlugin();
			}
		});
		cmbPlugins.setBounds(316, 0, 173, 22);
		panel.add(cmbPlugins);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 34, 586, 83);
		panel.add(scrollPane);

		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		
		pnlEntradas = new JPanel();
		pnlEntradas.setBounds(10, 132, 383, 56);
		contentPane.add(pnlEntradas);

       




		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 269, 586, 181);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 566, 159);
		panel_3.add(scrollPane_1);

		txtResultado = new JTextArea();
		scrollPane_1.setViewportView(txtResultado);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(466, 165, 89, 23);
		contentPane.add(btnNewButton);
		try {
			demo.getPlugins();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			dispose();
		}
	}
   
	@Override
	public void updateListaAdd(PluginFunction item) {
		cmbPlugins.addItem(item);
		Logger.fine("El item "+item+" fue agregado a la lista");
		
		pnlEntradas.updateUI();

	}
    /**
     * cargarPlugin
     * Carga el plugin seleccionado en panel pnlEtiquetaCampo
     */
	private void cargarPlugin() {

		if(cmbPlugins.getSelectedItem()!=null)
			seleccion = (PluginFunction) cmbPlugins.getSelectedItem();
	  
		   

       try {
		if(seleccion!=null) {
			int cantidadDeParametros= seleccion.getCantDeParametros();
			txtDescripcion.setText(seleccion.getDescripcion());
			pnlEntradas.setLayout(new GridLayout(1, cantidadDeParametros, 0, 0));

			for(int i= 0; i<cantidadDeParametros;i++) {
				//panel de etiqueta y campos
				pnlEtiquetaCampo = new JPanel();
				pnlEntradas.add(pnlEtiquetaCampo);
				pnlEtiquetaCampo.setLayout(new GridLayout(2, 1, 0, 0));
				//etiqetas y campos
				JLabel nuevaEtiqueta = new JLabel(seleccion.getNombreDeParametro(i+1));
				nuevaEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
				pnlEtiquetaCampo.add(nuevaEtiqueta);

				JTextField nuevaEntrada = new JTextField();

				pnlEtiquetaCampo.add(nuevaEntrada);

				mapeoDeEntradas.put(i+1,nuevaEntrada);
			}
		}
       }catch(Exception e) {
    	   Logger.warning(e.getMessage());
       }
       
	}
    /**
     * calcular
     * llama al método getResultado del plugin una vez cargados los parámetros
     */
	private void calcular() {
		if(seleccion!=null) {
			for(int i= 0;i<seleccion.getCantDeParametros();i++) {
				JTextField txtEntrada = mapeoDeEntradas.get(i+1);
				if(txtEntrada!= null) {
					try {
						seleccion.setParametro(i+1,txtEntrada.getText());
						txtResultado.setText(seleccion.getResultado());
					} catch (Exception e) {
						txtResultado.setText(e.getMessage());
						Logger.warning(e.getMessage());
						
					}
				}else {
					txtResultado.setText("Hay un campo de entrada vacio");
					Logger.warning("Hay un campo de entrada vacio");
				}
				}
		
			
		
		}
	}

    /**
     * limpiar
     * Limipa el panel del plugin anterior
     */
	private void limpiar() {
		mapeoDeEntradas.clear();
		pnlEntradas.removeAll();
		txtResultado.setText(null);
		txtDescripcion.setText(null);
		pnlEntradas.updateUI();


	}

	@Override
	public void updateListaRem(PluginFunction item) {
		cmbPlugins.removeItem(item);
		Logger.fine("El item "+item+" fue eliminado de la lista");

		if(cmbPlugins.getItemCount()==0) {
			seleccion= null;
			limpiar();
		}
		 

	}

}
