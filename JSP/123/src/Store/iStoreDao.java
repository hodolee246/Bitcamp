package Store;

import java.util.List;

public interface iStoreDao {
	
	public boolean addProduct(StoreDto dto);
	public List<StoreDto> getProduct(int pCount);
	public StoreDto detailProduct(int seq);
	public boolean updateProduct(StoreDto dto);
	public boolean deleteProduct(int seq);
	public String findImg(int seq);
	public int countProduct();
	public List<StoreDto> findProduct(String sel,String fText,int pCount);
}
