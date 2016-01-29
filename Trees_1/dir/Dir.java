package dir;


public interface Dir {
	
	public File[] files();
	
	public Dir[] subdirs();
	
	public Dir parentDir();
	
	public String name();
	
	public void remove(String nam);
}
