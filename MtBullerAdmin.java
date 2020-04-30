package mtbuller;

public class MtBullerAdmin {
	
	public static void main(String[] args) {
		MtBullerResort mbr = new MtBullerResort();
		mbr.startup();
		mbr.run();
		mbr.close();
	}

}
