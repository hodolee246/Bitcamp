package dto;

public class MemberDto {
	private String message;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MemberDto [message=" + message + "]";
	}
	
}
