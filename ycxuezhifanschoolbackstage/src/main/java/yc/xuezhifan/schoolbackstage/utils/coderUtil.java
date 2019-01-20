package yc.xuezhifan.schoolbackstage.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 * @author liuke
 * @date   2018年8月4日
 *
 */
public class coderUtil {
	private static final int BLACK=0xFF000000;//设置图案的 黑色
	private static final int WHITH=0xFFFFFFFF;//背景色
	/**
	 *生成二维码
	 * @param content 二维码 内容
	 * @param width 宽度
	 * @param height 高度
	 * @param prePath 二维码保存的路径
	 * @param qrCodeName 二维码保存的名称
	 * @return 二维码的名称
	 */
	public static String Encoder(String content,Integer width,Integer height,String prePath,String qrCodeName) {
		Hashtable<EncodeHintType, String> hints=new Hashtable<>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix matrix=null;
		try {
			matrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path path = Paths.get(prePath, qrCodeName);
		//File file=new File("D://qrcodeImage.png");
		try {
			MatrixToImageWriter.writeToPath(matrix, "png", path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qrCodeName;
	}
	/**
	 * 二维码解析
	 * @param imgagePath 
	 * @return
	 */
	public static String  Decoder(String imgagePath) {
		File file = new File(imgagePath);
		BufferedImage bufferedImage=null;
		try {
			bufferedImage=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LuminanceSource source=new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(source));
		Hashtable<DecodeHintType, String> hints=new Hashtable<>();
		hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
		Result result=null;
		try {
			result=new MultiFormatReader().decode(bitmap, hints);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.toString();
	}
	/**
	 * 模仿微信自动生成二维码效果，有圆角边框，logo和二维码间有空白区，logo带有灰色边框 
	 * @param matrixImage 原二维码图片
	 * @param logoPath logo的路径
	 * @return BufferedImage 带有图片的二维码图片
	 * @throws IOException
	 */
	public static BufferedImage LogoMatrix(BufferedImage matrixImage, String logoPath) throws IOException {
		//读取二维码图片，并构建绘图对象
		Graphics2D g2=matrixImage.createGraphics();
		//读取二维码图片的高 宽
		int matrixWidth=matrixImage.getWidth();
		int matrixheight=matrixImage.getHeight();
		//读取logo图片信息
		BufferedImage logo=ImageIO.read(new File(logoPath));
		//开始绘制图片
		g2.drawImage(logo, matrixWidth/5*2, matrixheight/5*2,matrixWidth/5,matrixheight/5, null);
		//设置画笔对象
		BasicStroke stroke=new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke);
		//指定弧度的圆角矩形
		RoundRectangle2D.Float round=new RoundRectangle2D.Float(matrixWidth/5*2, matrixheight/5*2, matrixWidth/5, matrixheight/5, 20, 20);
		g2.setColor(Color.WHITE);
		g2.draw(round);
		//设置logo 的边框
		//设置画笔对象 设置logo边框的画笔
		BasicStroke stroke2=new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke2);
		//设置边框的圆角矩形
		RoundRectangle2D.Float round2=new RoundRectangle2D.Float(matrixWidth/5*2+2, matrixheight/5*2+2, matrixWidth/5-4, matrixheight/5-4, 20, 20);
		g2.setColor(new Color(128,128,128));
		g2.draw(round2);
		
		g2.dispose();
		matrixImage.flush();
		return matrixImage;
	}
	
	
	 public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width=matrix.getWidth();
		int height=matrix.getHeight();
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, (matrix.get(x, y)? BLACK:WHITH));
			}
		}
		 return image;  
	 }
	 /**
	  * 根据条件生成带有logo的二维码图片
	  * @param content 二维码内容
	  * @param width 二维码的宽
	  * @param height 二维码的高
	  * @param logoPath logo的路径
	  * @param prePath 二维码保存的路径
	  * @param qrCodeName 二维码的名称
	  * @return 二维码的保存路径
	  * @throws IOException
	  */
	 public static String  encodeLogoQrCode(String content, int width, int height, String logoPath, String prePath, String qrCodeName) throws IOException{
		 Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();  
		 hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
		 hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		  hints.put(EncodeHintType.MARGIN, 1);
			BitMatrix matrix=null;
			try {
				//matrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			 matrix = new MultiFormatWriter().encode(content,//要编码的内容  
			                //编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,  
			                //Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,  
			                //MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION  
			                BarcodeFormat.QR_CODE,  
			                width, //二维码的宽度  
			                height, //二维码的高度  
			                hints);//生成二维码时的一些配置,此项可选  
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 File file = new File(prePath + File.separator + qrCodeName);//指定输出路径  
			 BufferedImage image= toBufferedImage(matrix); 
			 String format="png";
		        //设置logo图标  
		        image = LogoMatrix(image,logoPath);  
		          
		        if (!ImageIO.write(image, format, file)) {  
		            throw new IOException("Could not write an image of format " + format + " to " + file);  
		        }else{  
		            System.out.println("图片生成成功！");  
		        } 
		        return file.getPath();
			/*writeToFile(matrix, format, file, logoPath); */ 
	 }
}
