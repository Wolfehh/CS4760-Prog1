package cs4760progassign

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AuthorsControllerSpec extends Specification implements ControllerUnitTest <AuthorsController>, DataTest {
    void setupSpec(){
        mockDomains Author, Book
    }
    def 'Test the index method returns the correct model'(){
        given:
        new Author(name:"Author A")
                .addToBooks(new Book(title:"Title A", publishYear:1978))
                .addToBooks(new Book(title:"Title B", publishYear:2000))
                .save(flush: true, failOnError: true)
        new Author(name:"Author B")
                .addToBooks(new Book(title:"Title C", publishYear:1876))
                .addToBooks(new Book(title:"Title D", publishYear:1890))
                .save(flush: true, failOnError: true)
        new Author(name:"Author C")
                .addToBooks(new Book(title:"Title E", publishYear:1800))
                .addToBooks(new Book(title:"Title F", publishYear:1877))
                .save(flush: true, failOnError: true)

        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        model.bkList
        model.bkList.size == 3
        model.bkList == [
                [author: "Author A", books:[title1: "Title A", title2: "Title B"]],
                [author: "Author B", books:[title1: "Title C", title2: "Title D"]],
                [author: "Author C", books:[title1: "Title E", title2: "Title F"]]
        ]
    } // End 'Test the index method returns the correct model'
}
