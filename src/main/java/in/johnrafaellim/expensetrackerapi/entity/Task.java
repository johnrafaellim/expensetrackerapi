package in.johnrafaellim.expensetrackerapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import in.johnrafaellim.expensetrackerapi.enums.TaskEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskEnum status;

    private LocalDate dueDate;

}
