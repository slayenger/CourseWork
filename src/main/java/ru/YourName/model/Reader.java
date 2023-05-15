package ru.YourName.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "reader")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "readerId")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reader {
    @Id
    @Column(name = "readerid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int readerId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reader")
    @JoinColumn(name = "readerid")
    @JsonBackReference
    @JsonIgnore
    private ReaderTicketUser readerTicketUser;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "secondname")
    private String secondName;
    @Column(name = "thirdname")
    private String thirdName;
    @Column(name = "ticketnumber")
    private String ticketNumber;

    public ReaderTicketUser getReaderTicketUser() {
        return readerTicketUser;
    }

    public void setReaderTicketUser(ReaderTicketUser readerTicketUser) {
        this.readerTicketUser = readerTicketUser;
    }

    public Reader() {}

    public Reader(ReaderTicketUser readerTicketUser, String firstName,
                  String secondName, String thirdName, String ticketNumber) {
        this.readerTicketUser = readerTicketUser;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.ticketNumber = ticketNumber;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
