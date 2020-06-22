package com.rookie.hcsapi.model

import javax.persistence.*

@Entity
@Table(name = "test")
class Test(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long = 0,
        @Column(name = "title")
        var title: String? = null,
        @Column(name = "image_url")
        var imageUrl: String? = null

)
{

        override fun toString(): String {
                return "Banner(id=$id, title=$title, imageUrl=$imageUrl)"
        }
}