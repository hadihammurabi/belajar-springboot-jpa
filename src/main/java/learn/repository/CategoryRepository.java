package learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
