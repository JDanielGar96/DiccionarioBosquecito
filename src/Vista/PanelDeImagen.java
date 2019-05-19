package Vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelDeImagen extends JLabel {

	private static  ImageIcon imagen;

	public PanelDeImagen() {
		imagen = new ImageIcon("./Assets/Icono.png");

		Initialize();
		setVisible(true);
	}

	private void Initialize() {
		setBounds(10, 11, 895, 189);
		imagen.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
		this.setIcon(imagen);
		this.repaint();

	}

}
