package com.theneopix.spring.data.jpa.learn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
//For FetchType=EAGER -> @ToString [Without exclude]
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            sequenceName = "course_material_sequence",
            name="course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    //Fetch type- eager -> It will bring course data also.
    //Fetch type - lazy -> It will bring course data until and unless you specify it.

    //If FetchType = Lazy -> [CourseMaterial(courseMaterialId=1, url=www.google.com)]
    //If FetchType = EAGER ->[CourseMaterial(courseMaterialId=1, url=www.google.com, course=Course(courseId=1, title=DSA, credit=6))]
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
