package bit.com.bbs.model;

public class BbsParam {
	
	private String keyword;	// 검색어
	private String content;
	private String s_category;	// 제목, 내용, 아이디...
	private int num;
	private int num2;
	
	public BbsParam() {
		// TODO Auto-generated constructor stub
	}

	public BbsParam(String keyword, String content, String s_category, int num, int num2) {
		super();
		this.keyword = keyword;
		this.content = content;
		this.s_category = s_category;
		this.num = num;
		this.num2 = num2;
	}
	
	public int getNum2() {
		return num2;
	}
	
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	@Override
	public String toString() {
		return "BbsParam [keyword=" + keyword + ", content=" + content + ", s_category=" + s_category + ", num=" + num
				+ ", num2=" + num2 + "]";
	}

}
