package lk.coop.repository.authentication;

import lk.coop.entity.authentication.AuMenuItems;
import lk.coop.enums.Deleted;
import lk.coop.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuMenuItemsRepository extends JpaRepository<AuMenuItems, String> {
    List<AuMenuItems> findByStatusAndIsDeletedOrderByIdAsc(Status status, Deleted idDeleted);

    List<AuMenuItems> findByIsDeletedOrderByIdAsc(Deleted idDeleted);

    List<AuMenuItems> findByAlias(String alias);

    List<AuMenuItems> findByParentIdAndStatusAndIsDeletedOrderByIdAsc(String parentId, Status status, Deleted isDeleted);

    List<AuMenuItems> findByParentIdIsNullAndStatusAndIsDeletedOrderByIdAsc(Status status, Deleted isDeleted);

    AuMenuItems findByIdAndIsDeleted(Integer id, Deleted isDeleted);

}
