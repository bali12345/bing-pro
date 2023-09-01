package com.bing.dao;


import com.bing.entity.Info;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<Info, Integer>, JpaSpecificationExecutor<Info>, CrudRepository<Info,Integer> {

    @Override
    Optional<Info> findById(Integer integer);

    @Override
    <S extends Info> S save(S entity);


    @Query("select u from Info u order by u.id asc ")
    List<Info> getInfoListBySort(String sort);
}
//@Service
//public class UserService {
//    public List<Info> findUsersByNameAndOrderByAge(String name) {
//        Specification<Info> spec = Specification.where(UserSpecification.withName(name)).and(UserSpecification.orderByAge());
//        return userRepository.findAll(spec);
//    }
//}

//public class UserSpecification {
//    public static Specification<Info> withName(String name) {
//        return StringUtils.isEmpty(name) ? null : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
//    }
//
//    public static Specification<Info> orderByAge() {
//        return (root, query, criteriaBuilder) -> {
//            query.orderBy(criteriaBuilder.asc(root.get("age")));
//            return query.getRestriction();
//        };
//    }
//}
