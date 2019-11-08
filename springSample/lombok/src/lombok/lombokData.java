package lombok;

@Getter
@Setter
@ToString
//@AllArgsConstructor	// 왠만하면 사용하지마라 (보안성문제)
//@NoArgsConstructor	// 왠만하면 사용하지마라 (보안성문제)
//@Data				// 모든 기능을 다해주는 에노테이션 (단 팀프로젝트에서 거의 안씀)
public class lombokData {

	private int seq;
	private String name;
	
	public lombokData() {
		// TODO Auto-generated constructor stub
	}

	@Builder
	public lombokData(int seq, String name) {
		super();
		this.seq = seq;
		this.name = name;
	}
	
	
	
}
