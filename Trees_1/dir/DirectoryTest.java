package dir;


public class DirectoryTest implements Dir{
	
	@Override
	public File[] files() {
		return new File[0];
	}

	@Override
	public Dir[] subdirs() {
		// TODO Auto-generated method stub
		return new Dir[0];
	}

	@Override
	public Dir parentDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void remove(String nam) {
		
		// TODO Auto-generated method stub
		
	}

	//new method
	static void removeAll(Dir d) {
		
		delete(d);
	
		System.out.println("released totally " + size + "KBytes in " + 
	filesCount + " files and " + dirCount + " subdirectories");
	}

	static int dirCount = 0;
	static int filesCount = 0;
	static int size = 0;
	
	static void delete(Dir d) {
		
		Dir[] dir = d.subdirs();
		File[] file = d.files();
		
		if (dir.length > 0) {
			for (int i = 0; i < dir.length; i++) {
				delete(dir[i]);
				d.remove(dir[i].name());
				dirCount++;
			}
		}
		
		if (file.length > 0) {
			for (int i = 0; i < file.length; i++) {
				size += file[i].size();
				d.remove(file[i].name());
				filesCount++;
			}
		}
	}
	
	public static void main(String[] args) {

	}
}
