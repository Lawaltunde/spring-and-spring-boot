package com.amigoscode.card;

import com.amigoscode.student.Student;

// TODO: 12 - Create a StudentIdCard entity:
//  - Add @Entity annotation
//  - Add @Id and @GeneratedValue(strategy = GenerationType.IDENTITY) to id field
//  - Add @OneToOne on the student field
//  - Add @JoinColumn(name = "student_id", referencedColumnName = "id")
//  - Add @ForeignKey(name = "student_id_card_student_fk") inside @JoinColumn

// TODO: 13 - Update the relationship:
//  - Add cascade = CascadeType.ALL to @OneToOne
//  - Add fetch = FetchType.LAZY to @OneToOne
public class StudentIdCard {

    private Long id;
    private String cardNumber;
    private Student student;

    public StudentIdCard() {
    }

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
