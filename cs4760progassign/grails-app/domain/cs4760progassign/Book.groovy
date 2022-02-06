package cs4760progassign

class Book {
    String title
    int publishYear
    static belongsTo = [author: Author]
    byte[] cover
    static constraints = {
        title nullable: false, blank: false
        author nullable: false, blank: false
        publishYear nullable: false
        cover nullable: true, maxSize: 1024*1024*2
    }
}
