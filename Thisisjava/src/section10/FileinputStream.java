package section10;

public class FileinputStream implements AutoCloseable{
	private String file;
	
	public FileinputStream(String file) {
		super();
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "읽기");
	}

	@Override
	public void close() throws Exception {
		
	}
}
