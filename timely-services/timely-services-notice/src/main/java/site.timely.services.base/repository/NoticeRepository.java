package site.timely.services.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import site.timely.services.base.domain.Notice;

/**
 * 新闻Restful数据访问对象
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/10
 * @since 1.8
 */
@RepositoryRestResource
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
