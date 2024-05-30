
public class Windows {
public static void main(String[] args) {
	Photoshop ps = new Photoshop();
	JpegFile jpg = new JpegFile("mypic",".jpg");
	PsdFile psd = new PsdFile("banner",".psd");
	ps.open(jpg);	
	ps.open(psd);
}
}
