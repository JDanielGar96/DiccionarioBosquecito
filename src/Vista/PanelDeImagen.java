package Vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelDeImagen extends JLabel {
	/**
	 * Es el panel de la ventana principal donde el usuario vera una imagen alusiva
	 * a la aplicacion o programa Diccionario El Bosquecito
	 */
	public static String path; // Es la ruta donde esta la imagen de tipo PNG guardada
	private ImageIcon icono;
	private Image img;
	private Image nuevaImg;
	private ImageIcon imagen;

	/**
	 * Constructor que inicializa las variables de la clase ajustando la imagen al
	 * panel
	 */
	public PanelDeImagen() {

		setBounds(10, 11, 895, 189);
		path = "./Assets/Icono.png";
		icono = new ImageIcon(path);
		img = icono.getImage();
		nuevaImg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		imagen = new ImageIcon(nuevaImg);
		setIcon(imagen);

		setVisible(true);
	}

}
