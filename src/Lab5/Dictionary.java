package Lab5;

public class Dictionary {
	private String wordEnglish;
	private String wordVietnamese;
	public Dictionary() {
		super();
	}
	public Dictionary(String wordEnglish, String wordVietnamese) {
		super();
		this.wordEnglish = wordEnglish;
		this.wordVietnamese = wordVietnamese;
	}
	public String getWordEnglish() {
		return wordEnglish;
	}
	public void setWordEnglish(String wordEnglish) {
		this.wordEnglish = wordEnglish;
	}
	public String getWordVietnamese() {
		return wordVietnamese;
	}
	public void setWordVietnamese(String wordVietnamese) {
		this.wordVietnamese = wordVietnamese;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.wordEnglish +"\t"+this.wordVietnamese;
	}
	

}
