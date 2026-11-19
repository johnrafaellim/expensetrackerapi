package in.johnrafaellim.expensetrackerapi.controller;

import in.johnrafaellim.expensetrackerapi.entity.Expense;
import in.johnrafaellim.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    // ?size=10&page=0
    // ?sort=amount,desc
    // ?size=10&page=0&sort=amount,desc
    public Page<Expense> getAllExpenses(Pageable page) {
        int number = 1;
        calculateFactorial(number);
        return expenseService.getAllExpenses(page);
    }
    /**
     * To return only the list of elements do this below
     *
     * public List<Expense> getAllExpenses(Pageable page) {
     *    return expenseService.getAllExpenses(page).toList();
     * }
     *
     **/


    @GetMapping("/expenses/{id}")
    // public Expense getExpenseById(@PathVariable("id") Long id) {
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    // public String deleteExpenseById(@RequestParam("id) Long id) {
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense) {
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
        return expenseService.updateExpenseDetails(id, expense);
    }

    public int calculateFactorial(int number) {
        return number * calculateFactorial(number -1);
    }
}
