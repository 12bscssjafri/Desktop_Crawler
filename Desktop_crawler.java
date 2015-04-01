package filesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class FileSearch extends Thread {
	static private Thread t;
	static private String fileNameToSearch;
	static private List<String> result;
	static private HashMap<String,List<String>> mymap;
	static private String threadName;
	FileSearch( String name){
		this.mymap = new HashMap();
		this.result = new ArrayList<>();
		threadName = name;
		System.out.println("Creating yessss " +  threadName );
		
	}
        
        public boolean file_exists(String fname){
            if(mymap.containsKey(fname)){
                System.out.println(fname +"'s path is " + mymap.get(fname));
                return true;
            }
            return true;
        } 
        
	@Override
	public void start ()
	{
		System.out.println("Starting " +  threadName );
		
		if(t==null){
			t = new Thread (this, threadName);
			t.start ();
			
		}
	}
	
	@Override
	public void run() {
		
		while(true){
			System.out.println("Running " +  threadName );
			
			FileSearch fileSearch = new FileSearch("deamon thread");
			
			//try different directory and filename :)
			fileSearch.searchDirectory(new File("G:\\moosa"), "");
			System.out.println("key value " + mymap.isEmpty());
			for (Map.Entry mapEntry : mymap.entrySet()) {
				System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
			}
			
			int count = fileSearch.getResult().size();
			if(count ==0){
				System.out.println("\nNo result found!");
			}else{
				
				System.out.println( "haha.txt" +"has path " +mymap.isEmpty());
				//System.out.println(" yes oiii!! \nFound " + count + " results!\n");
				for (String matched : fileSearch.getResult()){
					System.out.println("Found : " + matched);
					//if file with the same name already present,add to existing list!!
					if(fileSearch.mymap.containsKey(fileSearch.getFileNameToSearch())){
						fileSearch.mymap.get(fileSearch.getFileNameToSearch()).add(matched);
					}
					//else create,new temp list,and add that list to mymap.
					else{
						List<String> temp = new ArrayList<>();
						temp.add(matched);
						fileSearch.mymap.put(fileSearch.getFileNameToSearch(),temp);
					}
					
				}
			}
			System.out.println("going to sleep !!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(FileSearch.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
	}
	
	
	
	
	public String getFileNameToSearch() {
		return fileNameToSearch;
	}
	
	public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	}
	
	public List<String> getResult() {
		return result;
	}
	
	public void searchDirectory(File directory, String fileNameToSearch){
		
		setFileNameToSearch(fileNameToSearch);
		
		if (directory.isDirectory()) {
			search(directory);
			
		} else {
			System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}
		System.out.println("after search");
		System.out.println( fileNameToSearch +" value " +mymap.get(fileNameToSearch));
	}
	
	private void search(File file) {
		
		if (file.isDirectory()) {
			
			System.out.println("Searching directory ... " + file.getAbsoluteFile());
			
			//do you have permission to read this directory?
			if (file.canRead()) {
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp);
					} else {
						if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {
							
							result.add(temp.getAbsoluteFile().toString());
						}
						
						//mymap.put(temp.getName(), result);
						
						if(mymap.containsKey(temp.getName())){
							mymap.get(temp.getName()).add(temp.getAbsoluteFile().toString());
						}
						//else create,new temp list,and add that list to mymap.
						else{
							List<String> tempo = new ArrayList<>();
							tempo.add(temp.getAbsoluteFile().toString());
							mymap.put(temp.getName(),tempo);
						}
						
					}
				}
				
			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}
		
	}
	
}

public class Desktop_crawler {
	public static void main(String args[]) {
		
		FileSearch T1 = new FileSearch( "d t");
                
                
		T1.start();
                for(int i=0;i<1000000;i++){}
                if(T1.file_exists("haha.txt")){
                System.out.println("mubarak ho mil gayeeeee!!!!");
                }
                
                System.out.println("main ending!!!!");
	}
}
