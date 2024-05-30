
public class Photoshop {
	void open(File f) {
		System.out.println("File Name:" + f.filename);
		System.out.println("File Extn:" + f.extension);
		if(f instanceof JpegFile) {
			JpegFile j = (JpegFile) f;
			j.brightness();
		}
		else {
			PsdFile j = (PsdFile) f;
			j.layerStyle();
		}
		f.behave();
	}
}

abstract class File{
	String filename;
	String extension;
	abstract void behave();
}

class JpegFile extends File{
	
	public JpegFile(String fname, String extn) {
		this.filename = fname;
		this.extension = extn;
	}
	@Override
	void behave() {
		System.out.println("Opened as Flat File");
	}
	
	void brightness() {
		System.out.println("Enhanced Brightness");
	}
}

class PsdFile extends File{
	
	public PsdFile(String fname, String extn) {
		this.filename = fname;
		this.extension = extn;
	}
	@Override
	void behave() {
		System.out.println("Opened as Layered File");
	}
	
	void layerStyle() {
		System.out.println("Applied Layer Style");
	}
}