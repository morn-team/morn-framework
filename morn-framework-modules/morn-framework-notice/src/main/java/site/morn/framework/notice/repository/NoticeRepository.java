package site.morn.framework.notice.repository;

import org.springframework.stereotype.Repository;
import site.morn.boot.data.jpa.JpaRepository;
import site.morn.framework.notice.entity.Notice;

/**
 * 新闻Restful数据访问对象
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
