package com.example.LT_Java_Tuan6.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên GV không được để trống")
    @Length(max = 100, message = "Tên GV tối đa 100 ký tự")
    private String teacherName;
    @NotBlank(message = " Địa điểm không được để trống")
    private String place;
    @FutureOrPresent(message = "Ngày khóa học phải lớn hơn thời điểm hiện tại")
    private LocalDate startDate;
}
