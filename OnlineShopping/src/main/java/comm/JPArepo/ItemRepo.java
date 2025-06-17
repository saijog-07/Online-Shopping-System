package comm.JPArepo;

import comm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, String> {

    
	
	
    @Query("select i from Item i where i.code = :code")
	Item findByCode(@Param("code") String code);

    
    @Modifying
    @Transactional
    @Query("update Item i set i.price = :price where i.code = :code")
    public int updateItemPrice(@Param("code") String code, @Param("price") double price);


    
    
}
