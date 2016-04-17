import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class font_to_image{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image;
		String font_set[] = {"Arial","Arialbd","Arialbi","ALGER","Cambria","Simkai",
				"Msjh","Mingliu","Kaiu","msgothic"};
		
		
			
		int count=0;
		while(count<font_set.length){
		
		
		
		
		
		
		
        /*
           Because font metrics is based on a graphics context, we need to create
           a small, temporary image so we can ascertain the width and height
           of the final image
         */
        BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font(font_set[count], Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = 320;
        int height = 200;
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	//Graphics g;
	//g.drawImage(img,50,50,null);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(args[0], 0, fm.getAscent());
        g2d.dispose();
        
	

        try {
        			
           ImageIO.write(img, "jpg", new File("Text_"+count+".jpg"));
	
		File origFile = new File("/Text_"+count+".jpg");//這裡是建立圖片的檔案路徑
 
         source = ImageIO.read(origFile);//這裡是把圖檔讀到source
 
 
        Graphics g = source.getGraphics();//所以這裡就是取得source圖檔的繪圖區
 
        g.drawImage(logo, 50, 50, null);//因為source是大圖，所以用source的繪圖區drawImage，就是在大圖上繪圖。
 	
            count++;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

		}		

	}

}

