package lombok;

@Getter
@Setter
@ToString
@NoArgsConstructor	// 생성자 ( 매게변수 없는 생성자 )
@AllArgsConstructor	// 생성자 ( 매게변수 다 있는 생성자 )
public class DataLombok {

	private int seq;
	private String name;
	private String id;
	private String pw;
	
	
	
}
