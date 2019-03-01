//Nicholas Schroeder
//nis102

//String Existence Table Structure
public class StringTable{
	public final int TABLE_SIZE = 5000;		//default size 10k, can change later
	private int size; 						//number of elements in table
	private String[] strings;				//string elements in the table

	/******CONSTRUCTOR******/
	public StringTable(){
		this.size = 0;
		this.strings = new String[TABLE_SIZE];
	}

	//insert method uses linear probing
	public void insert(String s){
		if(this.contains(s))
			return;
		int hash = computeHash(s);

		if(size == TABLE_SIZE)
			return;

		if(strings[hash]==null){
			strings[hash] = s;
			size++;
			return;
		}

		int index = hash;
		while(strings[index] != null){
			index++;	
			
			if(index == TABLE_SIZE)
				index = 0;
		}

		strings[index] = s;
		size++;
	}

	//get method... returns string at specified index
	public String get(int index){ return strings[index]; }

	//contains method... since just existence table, no need to scan through every element
	public boolean contains(String s){
		int hash = computeHash(s);

		if(strings[hash]==null)
			return false;

		int index = hash;
		int count = 0;

		while(strings[index] != null && count <= TABLE_SIZE+1){
			if(strings[index].equals(s))
				return true;
			index++;

			if(index == TABLE_SIZE)
				index = 0;			
			count++;
		}
		return false;
	}

	//private method to compute hash key integer value
	private int computeHash(String s){
		int hash=0;
		for(int i=0;i<s.length();i++)
			hash = (hash*31 + s.charAt(i)) % TABLE_SIZE;
		return hash;
	}
}