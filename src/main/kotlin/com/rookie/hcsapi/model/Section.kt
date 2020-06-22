package com.rookie.hcsapi.model



import javax.persistence.*


@Entity
@Table(name = "section")
class Section(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id:Long=0,
        @Column(name = "title")
        var title :String?=null,


        @ManyToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinTable(name = "section_book",
                joinColumns = arrayOf(JoinColumn(name = "section_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "book_id", referencedColumnName = "id")))
        var book: List<Book> = mutableListOf<Book>()


){

//    override fun toString(): String{
//        return "{section: ${this.title}, subjects: ${book.map { it->it.title }}}";
//    }

    override fun toString(): String {
        return "Section(id=$id, title=$title)"
    }
}