package cs4760progassign

class Book {
    String title
    int publishYear
    static belongsTo = [author: Author]
}
