package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorServiceSpec extends Specification {

    AuthorService authorService
    SessionFactory sessionFactory

    private Long setupData() {
        // Need to remove all data from tables just in case hibernate is already running.
        // https://stackoverflow.com/questions/8160296/grails-delete-all-data-from-table-domain-class-i-e-deleteall
        // Note even the deletes will be rolled backed.
        Book.executeUpdate('delete from Book')
        Author.executeUpdate('delete from Author')

        // Add to the tables
        Author testAuthor = new Author(name: "Test Author 0").save(flush: true, failOnError: true)
        new Author(name: "Test Author 1").save(flush: true, failOnError: true)
        new Author(name: "Test Author 2").save(flush: true, failOnError: true)
        new Author(name: "Test Author 3").save(flush: true, failOnError: true)
        new Author(name: "Test Author 4").save(flush: true, failOnError: true)
        testAuthor.id
    }

    void "test get"() {
        Long authorId = setupData()

        expect:
        authorService.get(authorId) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Author> authorList = authorService.list(max: 2, offset: 2)

        then:
        authorList.size() == 2
        // assert false, "TODO: Verify the correct instances are returned"
        authorList[0].name.contains("Test Author")
        authorList[1].name.contains("Test Author")
    }

    void "test count"() {
        setupData()

        expect:
        authorService.count() == 5
    }

    void "test delete"() {
        Long authorId = setupData()

        expect:
        authorService.count() == 5

        when:
        authorService.delete(authorId)
        sessionFactory.currentSession.flush()

        then:
        authorService.count() == 4
    }

    void "test save"() {
        when:
        // assert false, "TODO: Provide a valid instance to save"
        Author author = new Author(name: "Author").save(flush: true, failOnError: true)
        authorService.save(author)

        then:
        author.id != null
    }
}
