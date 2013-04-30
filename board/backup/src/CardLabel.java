import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardLabel extends JLabel {
	
	private ImageIcon icon;
	private String code;
	
	public CardLabel(ImageIcon ic, String cd){
		icon= ic;
		code= cd;
		
	}
	
	public CardLabel(){
		
	}

	
	public Image getImage() {  //returns Image
		Image image_form_icon = icon.getImage();
		return   image_form_icon;
	}

	public void print_icon_on_label () {
		this.setIcon(icon);
	}
	
	
	public void setIcn(ImageIcon icon) {
		
		this.icon = icon;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
