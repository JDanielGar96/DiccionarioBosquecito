package Vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelDeImagen extends JLabel {

	public static String path;
	private ImageIcon icono;
	private Image img;
	private Image nuevaImg;
	private ImageIcon imagen;

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
