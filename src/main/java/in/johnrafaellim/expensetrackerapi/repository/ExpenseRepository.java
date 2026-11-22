package in.johnrafaellim.expensetrackerapi.repository;

import in.johnrafaellim.expensetrackerapi.entity.Expense;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // SELECT * FROM tbl_expenses WHERE category=?
    Page<Expense> findByCategory(String category, Pageable page);
    // SELECT * FROM tbl_expense WHERE name LIKE '%keyword'
    Page<Expense> findByNameContaining(String name, Pageable page);
    // SELECT * FROM tbl_expense WHERE date BETWEEN 'startDate' AND 'endDate'
    Page<Expense> findByDateBetween(LocalDate date, LocalDate date2, Pageable pageable);
}
