package site.morn.services.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.morn.services.base.domain.Notice;

/**
 * 新闻Restful数据访问对象
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}