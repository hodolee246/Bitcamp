package Store;

import java.io.Serializable;

/*
CREATE TABLE SHOP(		��ǰ ���̺� 
	SEQ NUMBER(5) PRIMARY KEY,	like SEQ 
	CODENUMBER NUMBER(3) NOT NULL,	��з� ex) �Ƿ�:01, �Ǽ��縮:02, CD:03 ... 
	PRODUCTNAME VARCHAR2(100) NOT NULL,
	STOCKCOUNT NUMBER(5) NOT NULL,	���� 
	PRICE NUMBER(8) NOT NULL,
	PRODUCTEXPLAIN VARCHAR2(4000) NOT NULL,
	PRODUCTIMAGE VARCHAR2(4000) NOT NULL,
	PRODUCTSIZE VARHCR2(20)   �Ƿ��� ��쿡�� ���� NULL ���� 
);
*/

public class StoreDto implements Serializable {
	
	private int seq;	//seq
	private String code;	//�з���ȣ
	private String productName;	//��ǰ��
	private int stockCount;	//����
	private int price;	//����
	private String productExplain;	//��ǰ����
	private String productImage;	//��ǰ�̹���
	private String productSize;		//������(�Ƿ��ΰ�쿡�� ����)
	
	public StoreDto() {
	
	}

	public StoreDto(int seq, String code, String productName, int stockCount, int price, String productExplain,
			String productImage, String productSize) {
		super();
		this.seq = seq;
		this.code = code;
		this.productName = productName;
		this.stockCount = stockCount;
		this.price = price;
		this.productExplain = productExplain;
		this.productImage = productImage;
		this.productSize = productSize;
	}

	public StoreDto(String code, String productName, int stockCount, int price, String productExplain,
			String productImage, String productSize) {
		super();
		this.code = code;
		this.productName = productName;
		this.stockCount = stockCount;
		this.price = price;
		this.productExplain = productExplain;
		this.productImage = productImage;
		this.productSize = productSize;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	@Override
	public String toString() {
		return "StoreDto [seq=" + seq + ", code=" + code + ", productName=" + productName + ", stockCount=" + stockCount
				+ ", price=" + price + ", productExplain=" + productExplain + ", productImage=" + productImage
				+ ", productSize=" + productSize + "]";
	}
	
	

	

	

	
	
}
